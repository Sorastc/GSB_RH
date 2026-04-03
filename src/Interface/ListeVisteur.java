package Interface;

import java.awt.Component;
import java.awt.Font;

import javax.swing.*;

import Controller.ListeVisiteurController;
import POJO.Utilisateur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListeVisteur extends JFrame {

	private JScrollPane jScrollPane1;
	private JList<Utilisateur> listeVisiteurs;
	private JLabel titreLabel;
	private JButton btnDeconnexion;
	private DefaultListModel<Utilisateur> listModel;

	private final ListeVisiteurController controller;
	private final Utilisateur userConnecte; // ← stocké ici

	// Constructeur avec l'utilisateur connecté (depuis InterfaceConnexion)
	public ListeVisteur(Utilisateur userConnecte) {
		this.userConnecte = userConnecte;
		this.controller = new ListeVisiteurController();
		this.listModel = new DefaultListModel<>();
		initComponents();
		chargerVisiteurs();
	}

	private void initComponents() {
		setTitle("Menu Directeur RH");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		titreLabel = new JLabel("Liste des Visiteurs");
		titreLabel.setBounds(0, 20, 484, 40);
		titreLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titreLabel);

		listeVisiteurs = new JList<>(listModel);
		listeVisiteurs.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof Utilisateur u) {
					setText(u.getPrenom() + " " + u.getNom());
				}
				return this;
			}
		});

		listeVisiteurs.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ouvrirCarteVisiteur();
			}
		});

		jScrollPane1 = new JScrollPane(listeVisiteurs);
		jScrollPane1.setBounds(75, 80, 350, 300);
		getContentPane().add(jScrollPane1);

		btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.setBounds(195, 410, 115, 23);
		btnDeconnexion.addActionListener(e -> {
			controller.deconnecter();
			dispose();
		});
		getContentPane().add(btnDeconnexion);

		JButton btnAjoutVisiteur = new JButton("Ajout Visiteur");
		btnAjoutVisiteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjoutVisiteur.setBounds(70, 391, 115, 23);
		getContentPane().add(btnAjoutVisiteur);
	}

	private void chargerVisiteurs() {
		listModel.clear();
		for (Utilisateur v : controller.getVisiteurs()) {
			listModel.addElement(v);
		}
	}

	private void ouvrirCarteVisiteur() {
		Utilisateur selectionne = listeVisiteurs.getSelectedValue();
		if (selectionne != null) {
			new CarteVisiteur(this, selectionne, userConnecte); // ← noms corrects
		}
	}
}