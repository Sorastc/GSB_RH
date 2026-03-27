package Interface;

import java.util.Scanner;

import DAO.UtilisateurDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfaceConnexion.
 */
public class InterfaceConnexion {
	
	/**
	 * Connexion.
	 */
	public static void Connexion() {
		Scanner sc = new Scanner(System.in);
        UtilisateurDAO userDAO = new UtilisateurDAO();

        System.out.print("Login : ");
        String login = sc.nextLine();

        System.out.print("Mot de passe : ");
        String mdp = sc.nextLine();

        String mdpEnBase = userDAO.recupMdpByLogin(login);
        

        if (mdpEnBase != null && mdpEnBase.equals(mdp)) {
            System.out.println("Bienvenue " + login);
        } else {
            System.out.println("Login ou mot de passe incorrect.");
        }
        sc.close();
	}
	
	/**
	 * Consulter utilisateur.
	 */
	public static void ConsulterUtilisateur() {
		
	}
	
}
