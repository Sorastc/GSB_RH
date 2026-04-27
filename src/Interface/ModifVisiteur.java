package Interface;

import java.awt.*;
import javax.swing.*;
import Controller.ListeVisiteurController;
import DAO.UtilisateurDAO;
import POJO.Region;
import POJO.Utilisateur;

public class ModifVisiteur extends JDialog {

    private final Utilisateur visiteur;
    private final ListeVisteur parentListe;
    private final CarteVisiteur parentCarte;

    private final UtilisateurDAO utilisateurDAO     = new UtilisateurDAO();
    private final ListeVisiteurController controller = new ListeVisiteurController();

    private JTextField txtNom, txtPrenom, txtAdresse, txtCp, txtVille;
    private JTextField txtNumTel, txtNumTelFixe;
    private JComboBox<Region> cboRegion;

    public ModifVisiteur(CarteVisiteur parentCarte, ListeVisteur parentListe, Utilisateur visiteur) {
        super(parentCarte, "Modifier un visiteur", true);
        this.parentCarte  = parentCarte;
        this.parentListe  = parentListe;
        this.visiteur     = visiteur;
        initComponents();
        remplirChamps();
        setSize(400, 360);
        setResizable(false);
        setLocationRelativeTo(parentCarte);
    }

    private void initComponents() {
        getContentPane().setLayout(null);

        JLabel lblTitre = new JLabel(
            "Modifier : " + visiteur.getPrenom() + " " + visiteur.getNom(),
            SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitre.setBounds(0, 10, 400, 22);
        getContentPane().add(lblTitre);

        // Identifiant non modifiable
        JLabel lblId = new JLabel("Identifiant :");
        lblId.setBounds(15, 45, 110, 22);
        getContentPane().add(lblId);

        JTextField txtIdReadOnly = new JTextField(visiteur.getIdUtilisateur());
        txtIdReadOnly.setEditable(false);
        txtIdReadOnly.setBackground(new Color(220, 220, 220));
        txtIdReadOnly.setBounds(130, 45, 240, 22);
        getContentPane().add(txtIdReadOnly);

        String[] libelles = {
            "Nom * :", "Prénom * :", "Adresse :", "Code postal :",
            "Ville :", "Tél. mobile :", "Tél. fixe :", "Région * :"
        };

        txtNom        = new JTextField();
        txtPrenom     = new JTextField();
        txtAdresse    = new JTextField();
        txtCp         = new JTextField();
        txtVille      = new JTextField();
        txtNumTel     = new JTextField();
        txtNumTelFixe = new JTextField();

        cboRegion = new JComboBox<>();
        for (Region r : controller.getRegions()) cboRegion.addItem(r);
        cboRegion.setRenderer(new DefaultListCellRenderer() {
            @Override public Component getListCellRendererComponent(
                    JList<?> list, Object value, int idx, boolean sel, boolean focus) {
                super.getListCellRendererComponent(list, value, idx, sel, focus);
                if (value instanceof Region r) setText(r.getNomRegion());
                return this;
            }
        });

        JComponent[] champs = {
            txtNom, txtPrenom, txtAdresse, txtCp,
            txtVille, txtNumTel, txtNumTelFixe, cboRegion
        };

        int y = 75;
        for (int i = 0; i < libelles.length; i++) {
            JLabel lbl = new JLabel(libelles[i]);
            lbl.setBounds(15, y, 110, 22);
            getContentPane().add(lbl);

            champs[i].setBounds(130, y, 240, 22);
            getContentPane().add(champs[i]);

            y += 28;
        }

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBounds(115, y + 5, 90, 25);
        btnAnnuler.addActionListener(e -> dispose());
        getContentPane().add(btnAnnuler);

        JButton btnSauvegarder = new JButton("Sauvegarder");
        btnSauvegarder.setBounds(215, y + 5, 110, 25);
        btnSauvegarder.addActionListener(e -> sauvegarder());
        getContentPane().add(btnSauvegarder);
    }

    private void remplirChamps() {
        txtNom.setText(visiteur.getNom());
        txtPrenom.setText(visiteur.getPrenom());
        txtAdresse.setText(valOu(visiteur.getAdressePo()));
        txtCp.setText(valOu(visiteur.getCp()));
        txtVille.setText(valOu(visiteur.getVille()));
        txtNumTel.setText(valOu(visiteur.getNumTel()));
        txtNumTelFixe.setText(valOu(visiteur.getNumTelFixe()));

        if (visiteur.getRegion() != null) {
            for (int i = 0; i < cboRegion.getItemCount(); i++) {
                if (cboRegion.getItemAt(i).getIdRegion() == visiteur.getRegion().getIdRegion()) {
                    cboRegion.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    private void sauvegarder() {
        String nom    = txtNom.getText().trim();
        String prenom = txtPrenom.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le nom et le prénom sont obligatoires.",
                "Champs manquants", JOptionPane.WARNING_MESSAGE);
            return;
        }

        visiteur.setNom(nom);
        visiteur.setPrenom(prenom);
        visiteur.setAdressePo(txtAdresse.getText().trim());
        visiteur.setCp(txtCp.getText().trim());
        visiteur.setVille(txtVille.getText().trim());
        visiteur.setNumTel(txtNumTel.getText().trim());
        visiteur.setNumTelFixe(txtNumTelFixe.getText().trim());
        visiteur.setRegion((Region) cboRegion.getSelectedItem());

        if (utilisateurDAO.update(visiteur)) {
            parentCarte.rafraichir(visiteur);
            parentListe.chargerVisiteurs();
            JOptionPane.showMessageDialog(this, "Modifications enregistrées.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur lors de la sauvegarde.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String valOu(String val) {
        return (val != null) ? val : "";
    }
}