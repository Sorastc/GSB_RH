package Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UtilisateurDAO;
import POJO.Utilisateur;

public class InterfaceConnexion extends JFrame {

    private JTextField     txtLogin;
    private JPasswordField txtMotDePasse;
    private JButton        btnConnexion;
    private JLabel         lblTitre;
    private JLabel         lblLogin;
    private JLabel         lblMotDePasse;

    public InterfaceConnexion() {
        setTitle("Connexion");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        getContentPane().add(getTxtLogin());
        getContentPane().add(getTxtMotDePasse());
        getContentPane().add(getBtnConnexion());
        getContentPane().add(getLblTitre());
        getContentPane().add(getLblLogin());
        getContentPane().add(getLblMotDePasse());
    }

    // -------------------------------------------------------------------------
    // Composants
    // -------------------------------------------------------------------------

    private JLabel getLblTitre() {
        if (lblTitre == null) {
            lblTitre = new JLabel("Connexion");
            lblTitre.setFont(new Font("Tahoma", Font.BOLD, 68));
            lblTitre.setBounds(123, 41, 363, 59);
        }
        return lblTitre;
    }

    private JLabel getLblLogin() {
        if (lblLogin == null) {
            lblLogin = new JLabel("Login :");
            lblLogin.setBounds(138, 151, 139, 14);
        }
        return lblLogin;
    }

    private JLabel getLblMotDePasse() {
        if (lblMotDePasse == null) {
            lblMotDePasse = new JLabel("Mot de passe :");
            lblMotDePasse.setBounds(138, 196, 139, 14);
        }
        return lblMotDePasse;
    }

    private JTextField getTxtLogin() {
        if (txtLogin == null) {
            txtLogin = new JTextField();
            txtLogin.setBounds(138, 166, 139, 20);
            txtLogin.setColumns(10);
        }
        return txtLogin;
    }

    private JPasswordField getTxtMotDePasse() {
        if (txtMotDePasse == null) {
            txtMotDePasse = new JPasswordField();
            txtMotDePasse.setColumns(10);
            txtMotDePasse.setBounds(138, 210, 139, 20);
        }
        return txtMotDePasse;
    }

    private JButton getBtnConnexion() {
        if (btnConnexion == null) {
            btnConnexion = new JButton("Connexion");
            btnConnexion.setBounds(329, 276, 122, 23);
            btnConnexion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tenterConnexion();
                }
            });
        }
        return btnConnexion;
    }

    // -------------------------------------------------------------------------
    // Logique de connexion
    // -------------------------------------------------------------------------

    private void tenterConnexion() {
        String login      = txtLogin.getText().trim();
        String motDePasse = new String(txtMotDePasse.getPassword()).trim();

        if (login.isEmpty() || motDePasse.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Veuillez remplir tous les champs.",
                "Champs manquants", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String mdpEnBase = UtilisateurDAO.recupMdpByLogin(login);
        if (mdpEnBase == null) {
            JOptionPane.showMessageDialog(this,
                "Login introuvable.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!mdpEnBase.equals(motDePasse)) {
            JOptionPane.showMessageDialog(this,
                "Mot de passe incorrect.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Utilisateur user = UtilisateurDAO.recupUserByLogin(login);
        if (user == null) {
            JOptionPane.showMessageDialog(this,
                "Impossible de charger les données utilisateur.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
            "Bienvenue " + user.getPrenom() + " !",
            "Connexion réussie", JOptionPane.INFORMATION_MESSAGE);

        this.dispose();
        ouvrirFenetrePourRole(user);   // ← on passe user, pas juste le rôle
    }

    // user est transmis à chaque fenêtre pour gérer les droits d'affichage
    private void ouvrirFenetrePourRole(Utilisateur user) {
        String idRole = user.getRole().getIdRole();
        switch (idRole) {
            case "S":
            case "D":
                new ListeVisteur(user).setVisible(true);
                break;
            case "R":
                new MenuResponsableSuiviFrais(user).setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this,
                    "Rôle inconnu, contactez un administrateur.",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}