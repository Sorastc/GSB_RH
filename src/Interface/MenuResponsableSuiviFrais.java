package Interface;

import java.awt.*;
import javax.swing.*;
import POJO.Utilisateur;

public class MenuResponsableSuiviFrais extends JFrame {

    private Utilisateur userConnecte;

    public MenuResponsableSuiviFrais() {
        this(null);
    }

    public MenuResponsableSuiviFrais(Utilisateur userConnecte) {
        this.userConnecte = userConnecte;
        initComponents();
    }

    private void initComponents() {
        setTitle("Menu Responsable");
        setSize(400, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblTitre = new JLabel("Statistiques des frais", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitre.setBounds(0, 15, 400, 30);
        getContentPane().add(lblTitre);

        if (userConnecte != null) {
            JLabel lblUser = new JLabel("Connecté : " + userConnecte.getPrenom()
                + " " + userConnecte.getNom());
            lblUser.setBounds(10, 50, 380, 20);
            getContentPane().add(lblUser);
        }

        // --- Les 5 boutons de statistiques ---
        String[] libelles = {
            "Nb fiches hors forfait / visiteur",
            "Montant hors forfait / visiteur",
            "Montant forfait / visiteur",
            "Moyenne hors forfait / région",
            "Moyenne forfait / région"
        };

        int y = 85;
        for (int i = 0; i < libelles.length; i++) {
            final int index = i;
            JButton btn = new JButton(libelles[i]);
            btn.setBounds(60, y, 280, 30);
            btn.addActionListener(e -> ouvrirStat(index));
            getContentPane().add(btn);
            y += 40;
        }

        JButton btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.setBounds(140, y + 5, 120, 25);
        btnDeconnexion.addActionListener(e -> {
            InterfaceConnexion frame = new InterfaceConnexion();
            frame.setSize(700, 500);
            frame.setVisible(true);
            dispose();
        });
        getContentPane().add(btnDeconnexion);
    }

    private void ouvrirStat(int index) {
        switch (index) {
            case 0 -> new StatNombreFicheFraisHorsForfaitRegionsMoisVisiteurs().setVisible(true);
            case 1 -> new StatMontantFraisHorsForfaitRegionsMoisVisiteurs().setVisible(true);
            case 2 -> new StatMontantFraisForfaitRegionsMoisVisiteurs().setVisible(true);
            case 3 -> new StatMoyenneMontantFraisHorsForfaitMoisRegions().setVisible(true);
            case 4 -> new StatMoyenneMontantFraisForfaitMoisRegions().setVisible(true);
        }
    }
}
