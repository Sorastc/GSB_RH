package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnexionSQL.Connexion;
import POJO.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {

    private static final Connection con = Connexion.getInstance();

    @Override
    public boolean create(Utilisateur user) {
        return creerUtilisateur(user, "");
    }

    /**
     * Crée un nouvel utilisateur en BDD.
     * Le mdp est passé séparément : il ne doit jamais être porté par le POJO.
     * Le login et l'email sont générés automatiquement par les triggers MySQL.
     */
    public boolean creerUtilisateur(Utilisateur user, String mdp) {
        String sql = "INSERT INTO utilisateur "
                   + "(idUtilisateur, nom, prenom, mdp, adresse, cp, ville, "
                   + " idRegion, dateEmbauche, idRole, DateModif, NumTel, NumTelFixe) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,  user.getIdUtilisateur());
            ps.setString(2,  user.getNom());
            ps.setString(3,  user.getPrenom());
            ps.setString(4,  mdp);
            ps.setString(5,  user.getAdressePo());
            ps.setString(6,  user.getCp());
            ps.setString(7,  user.getVille());
            ps.setInt(8,     user.getRegion().getIdRegion());
            if (user.getDateEmbauche() != null) {
                ps.setDate(9, java.sql.Date.valueOf(user.getDateEmbauche()));
            } else {
                ps.setNull(9, java.sql.Types.DATE);
            }
            ps.setString(10, user.getRole().getIdRole());
            ps.setDate(11,   java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setString(12, user.getNumTel());
            ps.setString(13, user.getNumTelFixe());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Utilisateur user) {
        String sql = "DELETE FROM utilisateur WHERE idUtilisateur = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getIdUtilisateur());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Utilisateur user) {
        // email est intentionnellement absent : le trigger avant_update_utilisateur
        // le regénère automatiquement sous la forme prenom.nom@gsb.fr
        String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, adresse = ?, "
                   + "cp = ?, ville = ?, idRegion = ?, NumTel = ?, NumTelFixe = ?, "
                   + "DateModif = ? WHERE idUtilisateur = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,  user.getNom());
            ps.setString(2,  user.getPrenom());
            ps.setString(3,  user.getAdressePo());
            ps.setString(4,  user.getCp());
            ps.setString(5,  user.getVille());
            ps.setInt(6,     user.getRegion().getIdRegion());
            ps.setString(7,  user.getNumTel());
            ps.setString(8,  user.getNumTelFixe());
            ps.setDate(9,    java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setString(10, user.getIdUtilisateur());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Utilisateur find(int id) {
        // idUtilisateur est VARCHAR — utiliser findById(String) à la place
        return null;
    }

    public Utilisateur findById(String id) {
        String sql = "SELECT * FROM utilisateur WHERE idUtilisateur = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return construireUtilisateur(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String recupMdpByLogin(String login) {
        String sql = "SELECT mdp FROM utilisateur WHERE login = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("mdp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Utilisateur recupUserByLogin(String login) {
        String sql = "SELECT * FROM utilisateur WHERE login = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return construireUtilisateur(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Utilisateur> recupTousLesUsers() {
        return executerListeUtilisateurs("SELECT * FROM utilisateur", null);
    }

    public ArrayList<Utilisateur> recupTousLesVisiteurs() {
        return executerListeUtilisateurs("SELECT * FROM utilisateur WHERE idRole = ?", "V");
    }

    /**
     * Vérifie qu'un visiteur peut être supprimé :
     * toutes ses fiches de frais doivent être à l'état 'RB' (remboursée).
     */
    public boolean peutEtreSupprime(String idVisiteur) {
        String sql = "SELECT COUNT(*) FROM fichefrais WHERE idVisiteur = ? AND idEtat != 'RB'";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, idVisiteur);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1) == 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // -------------------------------------------------------------------------
    // Méthodes utilitaires privées
    // -------------------------------------------------------------------------

    private static Utilisateur construireUtilisateur(ResultSet rs) throws SQLException {
        RoleDAO   roleDAO   = new RoleDAO();
        RegionDAO regionDAO = new RegionDAO();

        java.sql.Date dateSQL = rs.getDate("dateEmbauche");
        java.time.LocalDate dateEmbauche = (dateSQL != null) ? dateSQL.toLocalDate() : null;

        return new Utilisateur(
            rs.getString("idUtilisateur"),
            rs.getString("nom"),
            rs.getString("prenom"),
            roleDAO.findById(rs.getString("idRole")),
            rs.getString("adresse"),
            rs.getString("cp"),
            rs.getString("ville"),
            rs.getString("NumTel"),
            rs.getString("NumTelFixe"),
            rs.getString("email"),
            regionDAO.find(rs.getInt("idRegion")),
            dateEmbauche
        );
    }

    private ArrayList<Utilisateur> executerListeUtilisateurs(String sql, String parametre) {
        ArrayList<Utilisateur> liste = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            if (parametre != null) ps.setString(1, parametre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) liste.add(construireUtilisateur(rs));
        } catch (SQLException e) {
            System.err.println("Erreur accès BDD : " + e.getMessage());
        }
        return liste;
    }
}