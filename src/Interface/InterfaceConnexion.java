package Interface;
import javax.swing.*;

import POJO.Role;
import POJO.Utilisateur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceConnexion extends JFrame {

	private JTextField txtEntrezVotreLogin;
	private JPasswordField txtEntrezVotreMot;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblLogin;
	private JLabel lblNewLabel_1;

	

	public InterfaceConnexion() {

		setLayout(null);
		add(getTxtEntrezVotreLogin());
		add(getTxtEntrezVotreMot());
		add(getBtnNewButton());
		add(getLblNewLabel());
		add(getLblLogin());
		add(getLblNewLabel_1());
	}

	public JTextField getTxtEntrezVotreLogin() {
		if (txtEntrezVotreLogin == null) {
			txtEntrezVotreLogin = new JTextField();
			txtEntrezVotreLogin.setBounds(138, 166, 139, 20);
			txtEntrezVotreLogin.setColumns(10);
		}
		return txtEntrezVotreLogin;
	}

	public JPasswordField getTxtEntrezVotreMot() {
		if (txtEntrezVotreMot == null) {
			txtEntrezVotreMot = new JPasswordField();
			txtEntrezVotreMot.setColumns(10);
			txtEntrezVotreMot.setBounds(138, 210, 139, 20);
		}
		return txtEntrezVotreMot;
	}

	public JButton getBtnNewButton() {
	    if (btnNewButton == null) {
	        btnNewButton = new JButton("Connexion");
	        btnNewButton.setBounds(338, 274, 89, 23);
	        btnNewButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String login = txtEntrezVotreLogin.getText().trim();
	                String motDePasse = new String(txtEntrezVotreMot.getPassword()).trim();

	                if (login.isEmpty() || motDePasse.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.",
	                            "Champs manquants", JOptionPane.WARNING_MESSAGE);
	                    return;
	                }

	                String mdpEnBase = DAO.UtilisateurDAO.recupMdpByLogin(login);

	                if (mdpEnBase == null) {
	                    JOptionPane.showMessageDialog(null, "Login introuvable.",
	                            "Erreur", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                if (!mdpEnBase.equals(motDePasse)) {
	                    JOptionPane.showMessageDialog(null, "Mot de passe incorrect.",
	                            "Erreur", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                Utilisateur user = DAO.UtilisateurDAO.recupUserByLogin(login);
	                Role role = user.getRole();

	                JOptionPane.showMessageDialog(null, "Bienvenue " + user.getPrenom() + " !",
	                        "Connexion réussie", JOptionPane.INFORMATION_MESSAGE);
	                
	                // Récupère la fenêtre parente pour pouvoir la fermer
	                JFrame fenetreActuelle = (JFrame) SwingUtilities.getWindowAncestor(InterfaceConnexion.this);

	                if (role.equals("S")) {
	                    InterfaceMenu fenetreMenu = new InterfaceMenu();
	                    fenetreMenu.setVisible(true);
	                    fenetreActuelle.dispose();
	                } else if (role.equals("D")) {
	                    InterfaceJoueur fenetreJoueur = new InterfaceJoueur();
	                    fenetreJoueur.setVisible(true);
	                    fenetreActuelle.dispose();
	                }else if (role.equals("R")) {
	                    InterfaceJoueur fenetreJoueur = new InterfaceJoueur();
	                    fenetreJoueur.setVisible(true);
	                    fenetreActuelle.dispose();}
	                else {
	                    JOptionPane.showMessageDialog(null, "Rôle inconnu, contactez un administrateur.",
	                            "Erreur", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	    }
	    return btnNewButton;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Mot de passe :");
			lblNewLabel.setBounds(138, 196, 139, 14);
		}
		return lblNewLabel;
	}

	public JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login :");
			lblLogin.setBounds(138, 151, 139, 14);
		}
		return lblLogin;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Connexion");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 68));
			lblNewLabel_1.setBounds(111, 40, 363, 59);
		}
		return lblNewLabel_1;
	}
}