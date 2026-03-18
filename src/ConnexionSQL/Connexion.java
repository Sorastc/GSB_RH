package ConnexionSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
	private static final String URL = "jdbc:mysql://10.29.4.18:3306/gsb_frais2025?useSSL=false";
	private static final String UTILISATEUR = "myroot";
	private static final String MOT_DE_PASSE = "root123*";
	
	private static Connection con = null;
	
	public static Connection getInstance() {
		try {
			con=DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	public static void close() {
		try {
			con.close();
		} catch (Exception e) {e.printStackTrace();
			// TODO: handle exception*
		System.out.println("problème lors de la fermeture");
		}
		
	}

}