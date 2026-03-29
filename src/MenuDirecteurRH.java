import javax.swing.*;
import DAO.UtilisateurDAO;
import POJO.Utilisateur;
import java.awt.*;
import java.util.ArrayList;

public class MenuDirecteurRH extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> listeVisiteurs;
    private UtilisateurDAO utilisateurDAO;

    public MenuDirecteurRH() {
        utilisateurDAO = new UtilisateurDAO();

        listModel = new DefaultListModel<>();
        listeVisiteurs = new JList<>(listModel);


        chargerVisiteurs();

        add(new JScrollPane(listeVisiteurs), BorderLayout.CENTER);

        setTitle("Liste des Visiteurs");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void chargerVisiteurs() {
        listModel.clear();
        ArrayList<Utilisateur> visiteurs = utilisateurDAO.RecupTousLesVisiteurs();

        if (visiteurs != null) {
            for (Utilisateur visiteur : visiteurs) {
                listModel.addElement(visiteur.getNom() + " " + visiteur.getPrenom());
            }
        }
    }
}