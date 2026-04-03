package Interface;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import POJO.Utilisateur;

public class MenuResponsableSuiviFrais extends JFrame {

    private JPanel      contentPane;
    private Utilisateur userConnecte;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new MenuResponsableSuiviFrais(null).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructeur sans paramètre (redirige vers le principal)
    public MenuResponsableSuiviFrais() {
        this(null);
    }

    // Constructeur principal — reçoit l'utilisateur connecté
    public MenuResponsableSuiviFrais(Utilisateur userConnecte) {
        this.userConnecte = userConnecte;

        setTitle("Menu Responsable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 870, 501);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitre = new JLabel("Menu Responsable");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setBounds(0, 30, 854, 40);
        contentPane.add(lblTitre);

        // Affiche le nom de l'utilisateur connecté si disponible
        if (userConnecte != null) {
            JLabel lblBienvenue = new JLabel("Connecté : " + userConnecte.getPrenom() + " " + userConnecte.getNom());
            lblBienvenue.setFont(new Font("Arial", Font.PLAIN, 12));
            lblBienvenue.setBounds(10, 5, 400, 20);
            contentPane.add(lblBienvenue);
        }
    }
}