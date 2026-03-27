package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuSecretaireRH extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSecretaireRH frame = new MenuSecretaireRH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuSecretaireRH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Secretaire");
		lblNewLabel.setBounds(368, 72, 85, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnAjoutVisiteur = new JButton("Ajout Visiteur");
		btnAjoutVisiteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjoutVisiteur.setBounds(10, 162, 140, 23);
		contentPane.add(btnAjoutVisiteur);
		
		JButton btnModifVisiteur = new JButton("Modif Visiteur");
		btnModifVisiteur.setBounds(10, 218, 140, 23);
		contentPane.add(btnModifVisiteur);
		
		JButton btnSuppressionVisiteur = new JButton("Suppression Visiteur");
		btnSuppressionVisiteur.setBounds(10, 273, 140, 23);
		contentPane.add(btnSuppressionVisiteur);
	}
}
