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
        String sql = "INSERT INTO utilisateur VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,  user.getIdUtilisateur());
            ps.setString(2,  user.getNom());
            ps.setString(3,  user.getPrenom());
            ps.setString(4,  user.getRole().getIdRole());
            ps.setString(5,  user.getAdressePo());
            ps.setString(6,  user.getCp());
            ps.setString(7,  user.getVille());
            ps.setString(8,  user.getNumTel());
            ps.setString(9,  user.getNumTelFixe());
            ps.setString(10, user.getEmail());
            ps.setString(11, user.getRegion().getNomRegion());
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
        String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, adresse = ?, "
                   + "cp = ?, ville = ?, idRegion = ?, NumTel = ?, NumTelFixe = ?, "
                   + "email = ? WHERE idUtilisateur = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,  user.getNom());
            ps.setString(2,  user.getPrenom());
            ps.setString(3,  user.getAdressePo());
            ps.setString(4,  user.getCp());
            ps.setString(5,  user.getVille());
            ps.setInt(6,     user.getRegion().getIdRegion());
            ps.setString(7,  user.getNumTel());
            ps.setString(8,  user.getNumTelFixe());
            ps.setString(9,  user.getEmail());
            ps.setString(10, user.getIdUtilisateur());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Utilisateur find(int id) {
        String sql = "SELECT * FROM utilisateur WHERE idUtilisateur = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construireUtilisateur(rs);
            }
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
            if (rs.next()) {
                return rs.getString("mdp");
            }
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
            if (rs.next()) {
                return construireUtilisateur(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Utilisateur> recupTousLesUsers() {
        String sql = "SELECT * FROM utilisateur";
        return executerListeUtilisateurs(sql, null);
    }

    public ArrayList<Utilisateur> recupTousLesVisiteurs() {
        String sql = "SELECT * FROM utilisateur WHERE idRole = ?";
        return executerListeUtilisateurs(sql, "V");
    }

    // -------------------------------------------------------------------------
    // Méthodes utilitaires privées
    // -------------------------------------------------------------------------

    /** Construit un objet Utilisateur à partir d'un ResultSet positionné. */
    private static Utilisateur construireUtilisateur(ResultSet rs) throws SQLException {
        RoleDAO   roleDAO   = new RoleDAO();
        RegionDAO regionDAO = new RegionDAO();
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
            regionDAO.find(rs.getInt("idRegion"))
        );
    }

    /** Exécute une requête SELECT et retourne la liste d'utilisateurs correspondante. */
    private ArrayList<Utilisateur> executerListeUtilisateurs(String sql, String parametre) {
        ArrayList<Utilisateur> liste = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            if (parametre != null) {
                ps.setString(1, parametre);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                liste.add(construireUtilisateur(rs));
            }
        } catch (SQLException e) {
            System.err.println("Problème d'accès à la base : " + e.getMessage());
            e.printStackTrace();
        }
        return liste;
    }
}