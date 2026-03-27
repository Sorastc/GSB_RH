package ConnexionSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// TODO: Auto-generated Javadoc
/**
 * The Class Connexion.
 */
public class Connexion {
	
	/** The Constant URL. */
	private static final String URL = "jdbc:mysql://10.29.4.18:3306/gsb_frais2025?useSSL=false";
	
	/** The Constant UTILISATEUR. */
	private static final String UTILISATEUR = "myroot";
	
	/** The Constant MOT_DE_PASSE. */
	private static final String MOT_DE_PASSE = "root123*";
	
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