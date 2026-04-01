package Controller;

import java.util.ArrayList;
import DAO.UtilisateurDAO;
import Interface.InterfaceConnexion;
import POJO.Utilisateur;

/**
 * Contrôleur du Directeur RH.
 * Fait le lien entre la vue (MenuDirecteurRH) et la couche DAO.
 * La vue ne connaît pas le DAO — elle passe uniquement par ce contrôleur.
 */
public class DirecteurRHController {

    private UtilisateurDAO utilisateurDAO;

    public DirecteurRHController() {
        this.utilisateurDAO = new UtilisateurDAO();
    }

    /**
     * Retourne la liste de tous les visiteurs.
     * Garantit que la vue reçoit toujours une liste non nulle.
     */
    public ArrayList<Utilisateur> getVisiteurs() {
        ArrayList<Utilisateur> liste = utilisateurDAO.RecupTousLesVisiteurs();
        return liste != null ? liste : new ArrayList<>();
    }

    /**
     * Logique de déconnexion.
     * Pour l'instant ferme la session — à adapter selon ton système d'auth.
     */
    public void deconnecter() {
        // ex: SessionManager.getInstance().clear();
    	
        System.out.println("Déconnexion effectuée.");
        InterfaceConnexion frame = new InterfaceConnexion();	
		frame.setSize(700,500);
		frame.setVisible(true);
    }
}