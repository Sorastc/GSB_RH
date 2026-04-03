package ConnexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static final String URL        = "jdbc:mysql://10.29.4.18:3306/gsb_frais2025?useSSL=false";
    private static final String UTILISATEUR = "myroot";
    private static final String MOT_DE_PASSE = "root123*";

    private static Connection con = null;

    /** Singleton : retourne toujours la même connexion (la recrée si fermée). */
    public static Connection getInstance() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
            }
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base : " + e.getMessage());
        }
        return con;
    }

    public static void close() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture : " + e.getMessage());
            } finally {
                con = null;
            }
        }
    }
}