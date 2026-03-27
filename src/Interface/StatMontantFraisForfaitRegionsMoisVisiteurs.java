package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class StatMontantFraisForfaitRegionsMoisVisiteurs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatMontantFraisForfaitRegionsMoisVisiteurs frame = new StatMontantFraisForfaitRegionsMoisVisiteurs();
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
	public StatMontantFraisForfaitRegionsMoisVisiteurs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stat Montant Frais Forfait Par Regions Par Mois Par Visiteurs");
		lblNewLabel.setBounds(75, 35, 298, 14);
		contentPane.add(lblNewLabel);
	}

}
