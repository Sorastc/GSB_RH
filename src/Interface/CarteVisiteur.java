package Interface;

import javax.swing.*;
import javax.swing.border.*;
import POJO.Utilisateur;
import java.awt.*;

public class CarteVisiteur extends JDialog {

    public CarteVisiteur(JFrame parent, Utilisateur visiteur) {
        super(parent, "Fiche Visiteur", true);

        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        
        JPanel entete = new JPanel();
        entete.setBackground(new Color(52, 73, 94));
        entete.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel nomLabel = new JLabel(visiteur.getNom() + " " + visiteur.getPrenom());
        nomLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nomLabel.setForeground(Color.WHITE);
        entete.add(nomLabel);

        
        JPanel corps = new JPanel(new GridLayout(0, 2, 10, 8));
        corps.setBorder(new EmptyBorder(15, 20, 15, 20));
        corps.setBackground(Color.WHITE);

        ajouterChamp(corps, "ID",          visiteur.getIdUtilisateur());
        ajouterChamp(corps, "Email",        visiteur.getEmail());
        ajouterChamp(corps, "Adresse",      visiteur.getAdressePo());
        ajouterChamp(corps, "Ville",        visiteur.getVille() + " " + visiteur.getCp());
        ajouterChamp(corps, "Mobile",       visiteur.getNumTel());
        ajouterChamp(corps, "Fixe",          visiteur.getNumTelFixe());
        ajouterChamp(corps, "Région",       visiteur.getRegion().getNomRegion());
        ajouterChamp(corps, "Rôle",         visiteur.getRole().getLibelleRole());

        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBackground(new Color(52, 73, 94));
        btnFermer.setForeground(Color.WHITE);
        btnFermer.setFocusPainted(false);
        btnFermer.addActionListener(e -> dispose());

        JPanel piedPage = new JPanel();
        piedPage.setBackground(Color.WHITE);
        piedPage.setBorder(new EmptyBorder(0, 0, 10, 0));
        piedPage.add(btnFermer);

        // ── Assemblage ────────────────────────────────────────
        add(entete, BorderLayout.NORTH);
        add(corps,  BorderLayout.CENTER);
        add(piedPage, BorderLayout.SOUTH);

        setSize(420, 350);
        setLocationRelativeTo(parent);
        setResizable(false);
        setVisible(true);
    }

    private void ajouterChamp(JPanel panel, String label, String valeur) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Arial", Font.BOLD, 13));
        lbl.setForeground(new Color(52, 73, 94));

        JLabel val = new JLabel(valeur != null ? valeur : "—");
        val.setFont(new Font("Arial", Font.PLAIN, 13));

        panel.add(lbl);
        panel.add(val);
    }
}