package GSB_RH;

import java.util.Scanner;

import DAO.UtilisateurDAO;

public class Program {
	public static void main(String[] args) {
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
}
