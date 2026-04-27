package Interface;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DAO.StatDAO;

/**
 * Fenêtre de base pour les stats qui filtrent par région ET mois.
 * Stats 1, 2 et 3 héritent de cette classe.
 */
public abstract class StatBaseRegionMois extends JFrame {

    protected StatDAO statDAO = new StatDAO();

    private JComboBox<String[]> cboRegion;
    private JComboBox<Integer>  cboMois;
    private JComboBox<Integer>  cboAnnee;
    private JTable              tableau;
    private DefaultTableModel   modele;

    public StatBaseRegionMois(String titre, String[] colonnes) {
        setTitle(titre);
        setSize(550, 430);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblTitre = new JLabel(titre, SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitre.setBounds(0, 10, 550, 25);
        getContentPane().add(lblTitre);

        // --- Région ---
        JLabel lblRegion = new JLabel("Région :");
        lblRegion.setBounds(15, 50, 60, 22);
        getContentPane().add(lblRegion);

        cboRegion = new JComboBox<>();
        for (String[] r : statDAO.getRegions()) cboRegion.addItem(r);
        cboRegion.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof String[] r) setText(r[1]);
                return this;
            }
        });
        cboRegion.setBounds(80, 50, 230, 22);
        getContentPane().add(cboRegion);

        // --- Mois ---
        JLabel lblMois = new JLabel("Mois :");
        lblMois.setBounds(325, 50, 40, 22);
        getContentPane().add(lblMois);

        String[] nomsMois = {"Janvier","Février","Mars","Avril","Mai","Juin",
                             "Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
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
        cboMois.setBounds(370, 50, 90, 22);
        getContentPane().add(cboMois);

        // --- Année ---
        JLabel lblAnnee = new JLabel("Année :");
        lblAnnee.setBounds(15, 80, 60, 22);
        getContentPane().add(lblAnnee);

        cboAnnee = new JComboBox<>();
        for (Integer a : statDAO.getAnneesDispo()) cboAnnee.addItem(a);
        cboAnnee.setBounds(80, 80, 90, 22);
        getContentPane().add(cboAnnee);

        // --- Bouton rechercher ---
        JButton btnRechercher = new JButton("Rechercher");
        btnRechercher.setBounds(185, 80, 110, 22);
        btnRechercher.addActionListener(e -> lancerRecherche());
        getContentPane().add(btnRechercher);

        // --- Tableau ---
        modele = new DefaultTableModel(colonnes, 0) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        tableau = new JTable(modele);
        tableau.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(tableau);
        scroll.setBounds(15, 120, 520, 260);
        getContentPane().add(scroll);

        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBounds(220, 390, 100, 25);
        btnFermer.addActionListener(e -> dispose());
        getContentPane().add(btnFermer);
    }

    private void lancerRecherche() {
        String[] region = (String[]) cboRegion.getSelectedItem();
        int mois  = (Integer) cboMois.getSelectedItem();
        int annee = (Integer) cboAnnee.getSelectedItem();

        if (region == null || cboAnnee.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une région et une année.");
            return;
        }

        int idRegion = Integer.parseInt(region[0]);
        ArrayList<String[]> resultats = getResultats(idRegion, mois, annee);

        modele.setRowCount(0);
        if (resultats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun résultat pour cette sélection.");
        } else {
            for (String[] ligne : resultats) modele.addRow(ligne);
        }
    }

    /** Chaque sous-classe appelle la bonne méthode du DAO. */
    protected abstract ArrayList<String[]> getResultats(int idRegion, int mois, int annee);
}
