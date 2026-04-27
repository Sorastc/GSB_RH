package Interface;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DAO.StatDAO;

/**
 * Fenêtre de base pour les stats qui filtrent par mois uniquement.
 * Stats 4 et 5 héritent de cette classe.
 */
public abstract class StatBaseMois extends JFrame {

    protected StatDAO statDAO = new StatDAO();

    private JComboBox<Integer>  cboMois;
    private JComboBox<Integer>  cboAnnee;
    private JTable              tableau;
    private DefaultTableModel   modele;

    public StatBaseMois(String titre, String[] colonnes) {
        setTitle(titre);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblTitre = new JLabel(titre, SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitre.setBounds(0, 10, 500, 25);
        getContentPane().add(lblTitre);

        String[] nomsMois = {"Janvier","Février","Mars","Avril","Mai","Juin",
                             "Juillet","Août","Septembre","Octobre","Novembre","Décembre"};

        JLabel lblMois = new JLabel("Mois :");
        lblMois.setBounds(15, 50, 50, 22);
        getContentPane().add(lblMois);

        cboMois = new JComboBox<>();
        for (int i = 1; i <= 12; i++) cboMois.addItem(i);
        cboMois.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Integer m) setText(nomsMois[m - 1]);
                return this;
            }
        });
        cboMois.setBounds(70, 50, 120, 22);
        getContentPane().add(cboMois);

        JLabel lblAnnee = new JLabel("Année :");
        lblAnnee.setBounds(210, 50, 55, 22);
        getContentPane().add(lblAnnee);

        cboAnnee = new JComboBox<>();
        for (Integer a : statDAO.getAnneesDispo()) cboAnnee.addItem(a);
        cboAnnee.setBounds(270, 50, 80, 22);
        getContentPane().add(cboAnnee);

        JButton btnRechercher = new JButton("Rechercher");
        btnRechercher.setBounds(365, 50, 110, 22);
        btnRechercher.addActionListener(e -> lancerRecherche());
        getContentPane().add(btnRechercher);

        modele = new DefaultTableModel(colonnes, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        tableau = new JTable(modele);
        tableau.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(tableau);
        scroll.setBounds(15, 90, 470, 260);
        getContentPane().add(scroll);

        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBounds(195, 360, 100, 25);
        btnFermer.addActionListener(e -> dispose());
        getContentPane().add(btnFermer);
    }

    private void lancerRecherche() {
        if (cboAnnee.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Aucune donnée disponible.");
            return;
        }
        int mois  = (Integer) cboMois.getSelectedItem();
        int annee = (Integer) cboAnnee.getSelectedItem();

        ArrayList<String[]> resultats = getResultats(mois, annee);

        modele.setRowCount(0);
        if (resultats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun résultat pour cette sélection.");
        } else {
            for (String[] ligne : resultats) modele.addRow(ligne);
        }
    }

    protected abstract ArrayList<String[]> getResultats(int mois, int annee);
}
