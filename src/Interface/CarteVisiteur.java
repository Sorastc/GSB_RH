package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import POJO.Role;
import POJO.Utilisateur;

public class CarteVisiteur extends JFrame {

    private final Utilisateur visiteur;
    private final String      idRoleConnecte;   // rôle de l'utilisateur actuellement connecté

    private JLabel lblNomPrenom;
    private JLabel lblIdVal, lblEmailVal, lblAdresseVal;
    private JLabel lblVilleVal, lblMobileVal, lblFixeVal;
    private JLabel lblRegionVal, lblRoleVal;

    /**
     * @param parent          fenêtre parente (pour le centrage)
     * @param visiteur        le visiteur dont on affiche la fiche
     * @param userConnecte    l'utilisateur actuellement connecté (pour les droits)
     */
    public CarteVisiteur(JFrame parent, Utilisateur visiteur, Utilisateur userConnecte) {
        this.visiteur       = visiteur;
        this.idRoleConnecte = (userConnecte != null && userConnecte.getRole() != null)
                              ? userConnecte.getRole().getIdRole()
                              : "";

        construireUI();
        remplirChamps();

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    // -------------------------------------------------------------------------
    // Construction de l'interface
    // -------------------------------------------------------------------------

    private void construireUI() {
        setTitle("Fiche Visiteur");
        setSize(490, 458);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);

        getContentPane().add(creerPanelEntete());
        getContentPane().add(creerPanelCorps());
        getContentPane().add(creerPanelPied());
        getContentPane().add(creerBoutonFermer());
    }

    private JPanel creerPanelEntete() {
        lblNomPrenom = new JLabel("", SwingConstants.CENTER);
        lblNomPrenom.setFont(new Font("Arial", Font.BOLD, 20));
        lblNomPrenom.setForeground(Color.WHITE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(0, 0, 474, 54);
        panel.setBackground(new Color(52, 73, 94));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        panel.add(lblNomPrenom, BorderLayout.CENTER);
        return panel;
    }

    private JPanel creerPanelCorps() {
        lblIdVal      = creerValeur();
        lblEmailVal   = creerValeur();
        lblAdresseVal = creerValeur();
        lblVilleVal   = creerValeur();
        lblMobileVal  = creerValeur();
        lblFixeVal    = creerValeur();
        lblRegionVal  = creerValeur();
        lblRoleVal    = creerValeur();

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBounds(0, 64, 464, 241);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(20, 25, 20, 25));

        panel.add(creerTitre("ID"));       panel.add(lblIdVal);
        panel.add(creerTitre("Email"));    panel.add(lblEmailVal);
        panel.add(creerTitre("Adresse"));  panel.add(lblAdresseVal);
        panel.add(creerTitre("Ville"));    panel.add(lblVilleVal);
        panel.add(creerTitre("Mobile"));   panel.add(lblMobileVal);
        panel.add(creerTitre("Fixe"));     panel.add(lblFixeVal);
        panel.add(creerTitre("Région"));   panel.add(lblRegionVal);
        panel.add(creerTitre("Rôle"));     panel.add(lblRoleVal);

        return panel;
    }

    private JPanel creerPanelPied() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 354, 474, 54);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel.setLayout(null);

        // Les boutons CRUD ne sont visibles que pour le rôle "S" (secrétaire / admin)
        if ("S".equals(idRoleConnecte)) {
//            JButton btnAjouter = new JButton("Ajouter");
//            btnAjouter.setBounds(10, 20, 110, 23);
//            btnAjouter.addActionListener(e -> {
//                // TODO : action ajout
//            });

            JButton btnModifier = new JButton("Modification");
            btnModifier.setBounds(10, 20, 110, 23);
            btnModifier.addActionListener(e -> {
                // TODO : action modification
            });

            JButton btnSupprimer = new JButton("Suppression");
            btnSupprimer.setBounds(354, 20, 110, 23);
            btnSupprimer.addActionListener(e -> {
                // TODO : action suppression
            });

//            panel.add(btnAjouter);
            panel.add(btnModifier);
            panel.add(btnSupprimer);
        }

        return panel;
    }

    private JButton creerBoutonFermer() {
        JButton btn = new JButton("Fermer");
        btn.setBounds(186, 329, 100, 24);
        btn.setBackground(new Color(52, 73, 94));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.addActionListener(e -> dispose());
        return btn;
    }

    // -------------------------------------------------------------------------
    // Remplissage des données
    // -------------------------------------------------------------------------

    private void remplirChamps() {
        lblNomPrenom.setText(visiteur.getNom() + " " + visiteur.getPrenom());
        lblIdVal.setText(valeurOuTiret(visiteur.getIdUtilisateur()));
        lblEmailVal.setText(valeurOuTiret(visiteur.getEmail()));
        lblAdresseVal.setText(valeurOuTiret(visiteur.getAdressePo()));
        lblMobileVal.setText(valeurOuTiret(visiteur.getNumTel()));
        lblFixeVal.setText(valeurOuTiret(visiteur.getNumTelFixe()));

        lblVilleVal.setText(visiteur.getVille() != null
            ? visiteur.getVille() + " " + visiteur.getCp() : "—");

        lblRegionVal.setText(visiteur.getRegion() != null
            ? visiteur.getRegion().getNomRegion() : "—");

        lblRoleVal.setText(visiteur.getRole() != null
            ? visiteur.getRole().getLibelleRole() : "—");
    }

    // -------------------------------------------------------------------------
    // Utilitaires UI
    // -------------------------------------------------------------------------

    private JLabel creerTitre(String texte) {
        JLabel lbl = new JLabel(texte);
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        lbl.setForeground(new Color(52, 73, 94));
        return lbl;
    }

    private JLabel creerValeur() {
        JLabel lbl = new JLabel();
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
        return lbl;
    }

    private String valeurOuTiret(String valeur) {
        return (valeur != null && !valeur.isEmpty()) ? valeur : "—";
    }
}