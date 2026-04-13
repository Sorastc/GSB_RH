package ConnexionSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// TODO: Auto-generated Javadoc
/**
 * The Class Connexion.
 * @author harich-s
 */
public class Connexion {
	
	/** The Constant URL. */
	private static final String URL = "jdbc:mysql:http://localhost/phpmyadmin5.2.3/";
	
	/** The Constant UTILISATEUR. */
	private static final String UTILISATEUR = "root";
	
	/** The Constant MOT_DE_PASSE. */
	private static final String MOT_DE_PASSE = "";
	
	/** The con. */
	private static Connection con = null;
	
	/**
	 * Gets the single instance of Connexion.
	 *
	 * @return single instance of Connexion
	 */
	public static Connection getInstance() {
		try {
			con=DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * Close.
	 */
	public static void close() {
		try {
			con.close();
		} catch (Exception e) {e.printStackTrace();
			// TODO: handle exception*
		System.out.println("problème lors de la fermeture");
		}
		
	}

}