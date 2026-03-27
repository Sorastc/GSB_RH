package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class StatMontantFraisHorsForfaitRegionsMoisVisiteurs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatMontantFraisHorsForfaitRegionsMoisVisiteurs frame = new StatMontantFraisHorsForfaitRegionsMoisVisiteurs();
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
	public StatMontantFraisHorsForfaitRegionsMoisVisiteurs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stat Montant Frais Hors Forfait Par Regions Par Mois Par Visiteurs");
		lblNewLabel.setBounds(214, 65, 320, 14);
		contentPane.add(lblNewLabel);
	}

}
