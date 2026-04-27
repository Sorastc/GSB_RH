package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnexionSQL.Connexion;

/**
 * DAO dédié aux statistiques de frais.
 * Chaque méthode retourne une liste de tableaux de String
 * directement utilisable dans un JTable.
 */
public class StatDAO {

    private static final Connection con = Connexion.getInstance();

    // ------------------------------------------------------------------
    // Stat 1 : Nombre de fiches hors forfait par visiteur
    //          pour une région et un mois donnés
    // ------------------------------------------------------------------
    public ArrayList<String[]> getNbFichesHFParVisiteur(int idRegion, int mois, int annee) {
        ArrayList<String[]> liste = new ArrayList<>();
        String sql = "SELECT u.nom, u.prenom, COUNT(lhf.idLigneFHF) AS nbLignes "
                   + "FROM utilisateur u "
                   + "JOIN fichefrais ff ON u.idUtilisateur = ff.idVisiteur "
                   + "LEFT JOIN lignefraishorsforfait lhf ON ff.idFiche = lhf.idFiche "
                   + "WHERE u.idRegion = ? AND ff.mois = ? AND ff.annee = ? "
                   + "GROUP BY u.idUtilisateur, u.nom, u.prenom "
                   + "ORDER BY u.nom";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRegion);
            ps.setInt(2, mois);
            ps.setInt(3, annee);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new String[]{
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nbLignes")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    // ------------------------------------------------------------------
    // Stat 2 : Montant total hors forfait par visiteur
    //          pour une région et un mois donnés
    // ------------------------------------------------------------------
    public ArrayList<String[]> getMontantHFParVisiteur(int idRegion, int mois, int annee) {
        ArrayList<String[]> liste = new ArrayList<>();
        String sql = "SELECT u.nom, u.prenom, COALESCE(SUM(lhf.montant), 0) AS total "
                   + "FROM utilisateur u "
                   + "JOIN fichefrais ff ON u.idUtilisateur = ff.idVisiteur "
                   + "LEFT JOIN lignefraishorsforfait lhf ON ff.idFiche = lhf.idFiche "
                   + "WHERE u.idRegion = ? AND ff.mois = ? AND ff.annee = ? "
                   + "GROUP BY u.idUtilisateur, u.nom, u.prenom "
                   + "ORDER BY u.nom";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRegion);
            ps.setInt(2, mois);
            ps.setInt(3, annee);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new String[]{
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("total") + " €"
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    // ------------------------------------------------------------------
    // Stat 3 : Montant total forfait par visiteur
    //          pour une région et un mois donnés
    // ------------------------------------------------------------------
    public ArrayList<String[]> getMontantForfaitParVisiteur(int idRegion, int mois, int annee) {
        ArrayList<String[]> liste = new ArrayList<>();
        String sql = "SELECT u.nom, u.prenom, "
                   + "COALESCE(SUM(lff.quantite * ff2.montant), 0) AS total "
                   + "FROM utilisateur u "
                   + "JOIN fichefrais ff ON u.idUtilisateur = ff.idVisiteur "
                   + "LEFT JOIN lignefraisforfait lff ON ff.idFiche = lff.idFiche "
                   + "LEFT JOIN fraisforfait ff2 ON lff.idFraisForfait = ff2.idfraisforfait "
                   + "WHERE u.idRegion = ? AND ff.mois = ? AND ff.annee = ? "
                   + "GROUP BY u.idUtilisateur, u.nom, u.prenom "
                   + "ORDER BY u.nom";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRegion);
            ps.setInt(2, mois);
            ps.setInt(3, annee);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new String[]{
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("total") + " €"
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    // ------------------------------------------------------------------
    // Stat 4 : Moyenne montant hors forfait par région pour un mois
    // ------------------------------------------------------------------
    public ArrayList<String[]> getMoyenneHFParRegion(int mois, int annee) {
        ArrayList<String[]> liste = new ArrayList<>();
        String sql = "SELECT r.region_nom, "
                   + "COUNT(DISTINCT u.idUtilisateur) AS nbVisiteurs, "
                   + "COALESCE(AVG(totaux.total), 0) AS moyenne "
                   + "FROM region r "
                   + "JOIN utilisateur u ON u.idRegion = r.region_id "
                   + "JOIN fichefrais ff ON ff.idVisiteur = u.idUtilisateur "
                   + "    AND ff.mois = ? AND ff.annee = ? "
                   + "LEFT JOIN ( "
                   + "    SELECT ff2.idFiche, SUM(lhf.montant) AS total "
                   + "    FROM fichefrais ff2 "
                   + "    LEFT JOIN lignefraishorsforfait lhf ON ff2.idFiche = lhf.idFiche "
                   + "    GROUP BY ff2.idFiche "
                   + ") totaux ON totaux.idFiche = ff.idFiche "
                   + "GROUP BY r.region_id, r.region_nom "
                   + "ORDER BY r.region_nom";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mois);
            ps.setInt(2, annee);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new String[]{
                    rs.getString("region_nom"),
                    rs.getString("nbVisiteurs"),
                    String.format("%.2f €", rs.getDouble("moyenne"))
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    // ------------------------------------------------------------------
    // Stat 5 : Moyenne montant forfait par région pour un mois
    // ------------------------------------------------------------------
    public ArrayList<String[]> getMoyenneForfaitParRegion(int mois, int annee) {
        ArrayList<String[]> liste = new ArrayList<>();
        String sql = "SELECT r.region_nom, "
                   + "COUNT(DISTINCT u.idUtilisateur) AS nbVisiteurs, "
                   + "COALESCE(AVG(totaux.total), 0) AS moyenne "
                   + "FROM region r "
                   + "JOIN utilisateur u ON u.idRegion = r.region_id "
                   + "JOIN fichefrais ff ON ff.idVisiteur = u.idUtilisateur "
                   + "    AND ff.mois = ? AND ff.annee = ? "
                   + "LEFT JOIN ( "
                   + "    SELECT ff2.idFiche, SUM(lff.quantite * fra.montant) AS total "
                   + "    FROM fichefrais ff2 "
                   + "    LEFT JOIN lignefraisforfait lff ON ff2.idFiche = lff.idFiche "
                   + "    LEFT JOIN fraisforfait fra ON lff.idFraisForfait = fra.idfraisforfait "
                   + "    GROUP BY ff2.idFiche "
                   + ") totaux ON totaux.idFiche = ff.idFiche "
                   + "GROUP BY r.region_id, r.region_nom "
                   + "ORDER BY r.region_nom";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mois);
            ps.setInt(2, annee);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new String[]{
                    rs.getString("region_nom"),
                    rs.getString("nbVisiteurs"),
                    String.format("%.2f €", rs.getDouble("moyenne"))
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    // ------------------------------------------------------------------
    // Utilitaires : récupérer les mois/années disponibles en BDD
    // ------------------------------------------------------------------

    /** Retourne les années disponibles dans fichefrais (hors mois en cours). */
    public ArrayList<Integer> getAnneesDispo() {
        ArrayList<Integer> liste = new ArrayList<>();
        String sql = "SELECT DISTINCT annee FROM fichefrais "
                   + "WHERE NOT (annee = YEAR(NOW()) AND mois = MONTH(NOW())) "
                   + "ORDER BY annee DESC";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) liste.add(rs.getInt("annee"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    /** Retourne les régions disponibles : id + nom. */
    public ArrayList<String[]> getRegions() {
        ArrayList<String[]> liste = new ArrayList<>();
        String sql = "SELECT region_id, region_nom FROM region ORDER BY region_nom";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(new String[]{
                    rs.getString("region_id"),
                    rs.getString("region_nom")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }
}
