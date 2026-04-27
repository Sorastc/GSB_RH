package Controller;

import java.util.ArrayList;
import DAO.RegionDAO;
import DAO.UtilisateurDAO;
import Interface.InterfaceConnexion;
import POJO.Region;
import POJO.Utilisateur;

/**
 * Contrôleur de la liste des visiteurs.
 * Fait le lien entre les vues et la couche DAO.
 * Les vues ne connaissent jamais le DAO directement.
 */
public class ListeVisiteurController {

    private final UtilisateurDAO utilisateurDAO;
    private final RegionDAO regionDAO;

    public ListeVisiteurController() {
        this.utilisateurDAO = new UtilisateurDAO();
        this.regionDAO      = new RegionDAO();
    }

    /** Retourne la liste de tous les visiteurs (rôle V). */
    public ArrayList<Utilisateur> getVisiteurs() {
        ArrayList<Utilisateur> liste = utilisateurDAO.recupTousLesVisiteurs();
        return liste != null ? liste : new ArrayList<>();
    }

    /** Retourne toutes les régions (pour les ComboBox). */
    public ArrayList<Region> getRegions() {
        return regionDAO.findAll();
    }

    /** Supprime un visiteur. Retourne true si succès. */
    public boolean supprimerVisiteur(Utilisateur visiteur) {
        return utilisateurDAO.delete(visiteur);
    }

    /**
     * Vérifie qu'un visiteur peut être supprimé :
     * toutes ses fiches de frais doivent être remboursées (état RB).
     */
    public boolean peutEtreSupprime(String idUtilisateur) {
        return utilisateurDAO.peutEtreSupprime(idUtilisateur);
    }

    /** Déconnecte l'utilisateur et revient à l'écran de connexion. */
    public void deconnecter() {
        System.out.println("Déconnexion effectuée.");
        InterfaceConnexion frame = new InterfaceConnexion();
        frame.setSize(700, 500);
        frame.setVisible(true);
    }
}