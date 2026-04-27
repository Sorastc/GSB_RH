package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.ListeVisiteurController;
import POJO.Utilisateur;

public class ListeVisteur extends JFrame {

    private JList<Utilisateur> listeVisiteurs;
    private DefaultListModel<Utilisateur> listModel;
    private JButton btnAjouter;
    private JButton btnSupprimer;
    private JButton btnDeconnexion;

    private final ListeVisiteurController controller;
    private final Utilisateur userConnecte;

    public ListeVisteur(Utilisateur userConnecte) {
        this.userConnecte = userConnecte;
        this.controller   = new ListeVisiteurController();
        this.listModel    = new DefaultListModel<>();
        initComponents();
        chargerVisiteurs();
    }

    private void initComponents() {
        setTitle("Liste des visiteurs");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblTitre = new JLabel("Liste des visiteurs", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitre.setBounds(0, 10, 450, 30);
        getContentPane().add(lblTitre);

        listeVisiteurs = new JList<>(listModel);
        listeVisiteurs.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Utilisateur u) {
                    setText(u.getPrenom() + " " + u.getNom());
                }
                return this;
            }
        });
        listeVisiteurs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ouvrirCarteVisiteur();
            }
        });

        JScrollPane scroll = new JScrollPane(listeVisiteurs);
        scroll.setBounds(30, 55, 390, 360);
        getContentPane().add(scroll);

        boolean estSecretaire = "S".equals(getRoleId());

        if (estSecretaire) {
            btnAjouter = new JButton("Ajouter");
            btnAjouter.setBounds(30, 430, 110, 25);
            btnAjouter.addActionListener(e -> ouvrirFormulaireAjout());
            getContentPane().add(btnAjouter);

            btnSupprimer = new JButton("Supprimer");
            btnSupprimer.setBounds(150, 430, 110, 25);
            btnSupprimer.addActionListener(e -> supprimerVisiteurSelectionne());
            getContentPane().add(btnSupprimer);
        }

        btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.setBounds(310, 430, 110, 25);
        btnDeconnexion.addActionListener(e -> {
            controller.deconnecter();
            dispose();
        });
        getContentPane().add(btnDeconnexion);
    }

    // -------------------------------------------------------------------------

    void chargerVisiteurs() {
        listModel.clear();
        for (Utilisateur v : controller.getVisiteurs()) {
            listModel.addElement(v);
        }
    }

    private void ouvrirCarteVisiteur() {
        Utilisateur selectionne = listeVisiteurs.getSelectedValue();
        if (selectionne != null) {
            new CarteVisiteur(this, selectionne, userConnecte);
        }
    }

    private void ouvrirFormulaireAjout() {
        new AjoutVisiteur(this).setVisible(true);
    }

    private void supprimerVisiteurSelectionne() {
        Utilisateur selectionne = listeVisiteurs.getSelectedValue();

        if (selectionne == null) {
            JOptionPane.showMessageDialog(this,
                "Veuillez sélectionner un visiteur.",
                "Aucune sélection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!controller.peutEtreSupprime(selectionne.getIdUtilisateur())) {
            JOptionPane.showMessageDialog(this,
                "Impossible de supprimer " + selectionne.getPrenom() + " " + selectionne.getNom()
                + ".\nDes fiches de frais ne sont pas encore remboursées.",
                "Suppression impossible", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int choix = JOptionPane.showConfirmDialog(this,
            "Supprimer " + selectionne.getPrenom() + " " + selectionne.getNom() + " ?",
            "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choix == JOptionPane.YES_OPTION) {
            if (controller.supprimerVisiteur(selectionne)) {
                chargerVisiteurs();
                JOptionPane.showMessageDialog(this, "Visiteur supprimé.");
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de la suppression.",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String getRoleId() {
        return (userConnecte.getRole() != null) ? userConnecte.getRole().getIdRole() : "";
    }
}