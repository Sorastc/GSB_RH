package Interface;
import javax.swing.*;
import DAO.UtilisateurDAO;
import POJO.Utilisateur;
import java.awt.*;
import java.util.ArrayList;

public class MenuDirecteurRH extends JFrame {

    private DefaultListModel<Utilisateur> listModel;
    private JList<Utilisateur> listeVisiteurs;
    private UtilisateurDAO utilisateurDAO;

    public MenuDirecteurRH() {
        utilisateurDAO = new UtilisateurDAO();
        listModel = new DefaultListModel<>();
        listeVisiteurs = new JList<>(listModel);

        chargerVisiteurs();
        listeVisiteurs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                Utilisateur visiteurSelectionne = listeVisiteurs.getSelectedValue();
                if (visiteurSelectionne != null) {
                    new CarteVisiteur(MenuDirecteurRH.this, visiteurSelectionne);
                }
            }
        });

        add(new JScrollPane(listeVisiteurs), BorderLayout.CENTER);
        setTitle("Liste des Visiteurs");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void chargerVisiteurs() {
        listModel.clear();
        ArrayList<Utilisateur> liste = utilisateurDAO.RecupTousLesVisiteurs();
        if (liste != null) {
            for (Utilisateur v : liste) {
                listModel.addElement(v);
            }
        }
    }
}