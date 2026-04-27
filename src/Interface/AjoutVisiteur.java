package Interface;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.*;
import Controller.ListeVisiteurController;
import DAO.UtilisateurDAO;
import POJO.Region;
import POJO.Role;
import POJO.Utilisateur;

public class AjoutVisiteur extends JDialog {

    private final ListeVisteur parentListe;
    private final UtilisateurDAO utilisateurDAO    = new UtilisateurDAO();
    private final ListeVisiteurController controller = new ListeVisiteurController();

    private JTextField txtId, txtNom, txtPrenom;
    private JPasswordField txtMdp;
    private JTextField txtAdresse, txtCp, txtVille;
    private JTextField txtNumTel, txtNumTelFixe, txtDateEmbauche;
    private JComboBox<Region> cboRegion;
    private JComboBox<Role>   cboRole;

    public AjoutVisiteur(ListeVisteur parent) {
        super(parent, "Ajouter un visiteur", true);
        this.parentListe = parent;
        initComponents();
        setSize(420, 460);
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        getContentPane().setLayout(null);

        JLabel lblTitre = new JLabel("Ajouter un visiteur", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitre.setBounds(0, 10, 420, 25);
        getContentPane().add(lblTitre);

        // Champs et libellés
        String[] libelles = {
            "Identifiant * :", "Nom * :", "Prénom * :", "Mot de passe * :",
            "Adresse :", "Code postal :", "Ville :", "Tél. mobile :",
            "Tél. fixe :", "Date embauche :", "Région * :", "Rôle * :"
        };

        txtId           = new JTextField();
        txtNom          = new JTextField();
        txtPrenom       = new JTextField();
        txtMdp          = new JPasswordField();
        txtAdresse      = new JTextField();
        txtCp           = new JTextField();
        txtVille        = new JTextField();
        txtNumTel       = new JTextField();
        txtNumTelFixe   = new JTextField();
        txtDateEmbauche = new JTextField();
        txtDateEmbauche.setToolTipText("Format : AAAA-MM-JJ");

        cboRegion = new JComboBox<>();
        for (Region r : controller.getRegions()) cboRegion.addItem(r);
        cboRegion.setRenderer(rendererRegion());

        cboRole = new JComboBox<>(new Role[]{
            new Role("V", "Visiteur"), new Role("S", "Secrétaire"),
            new Role("D", "Directeur"), new Role("R", "Responsable"),
            new Role("C", "Comptable")
        });
        cboRole.setRenderer(rendererRole());

        JComponent[] champs = {
            txtId, txtNom, txtPrenom, txtMdp, txtAdresse, txtCp,
            txtVille, txtNumTel, txtNumTelFixe, txtDateEmbauche, cboRegion, cboRole
        };

        int y = 50;
        for (int i = 0; i < libelles.length; i++) {
            JLabel lbl = new JLabel(libelles[i]);
            lbl.setBounds(15, y, 130, 22);
            getContentPane().add(lbl);

            champs[i].setBounds(150, y, 240, 22);
            getContentPane().add(champs[i]);

            y += 30;
        }

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBounds(130, y + 5, 90, 25);
        btnAnnuler.addActionListener(e -> dispose());
        getContentPane().add(btnAnnuler);

        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.setBounds(235, y + 5, 110, 25);
        btnEnregistrer.addActionListener(e -> enregistrer());
        getContentPane().add(btnEnregistrer);
    }

    private void enregistrer() {
        String id     = txtId.getText().trim();
        String nom    = txtNom.getText().trim();
        String prenom = txtPrenom.getText().trim();
        String mdp    = new String(txtMdp.getPassword()).trim();

        if (id.isEmpty() || nom.isEmpty() || prenom.isEmpty() || mdp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Les champs * sont obligatoires.",
                "Champs manquants", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LocalDate dateEmbauche = null;
        if (!txtDateEmbauche.getText().trim().isEmpty()) {
            try {
                dateEmbauche = LocalDate.parse(txtDateEmbauche.getText().trim());
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this,
                    "Format de date invalide (AAAA-MM-JJ).",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Utilisateur nouv = new Utilisateur(
            id, nom, prenom,
            (Role)   cboRole.getSelectedItem(),
            txtAdresse.getText().trim(),
            txtCp.getText().trim(),
            txtVille.getText().trim(),
            txtNumTel.getText().trim(),
            txtNumTelFixe.getText().trim(),
            "",
            (Region) cboRegion.getSelectedItem(),
            dateEmbauche
        );

        if (utilisateurDAO.creerUtilisateur(nouv, mdp)) {
            parentListe.chargerVisiteurs();
            JOptionPane.showMessageDialog(this, "Visiteur ajouté avec succès.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                "Erreur lors de l'ajout. L'identifiant est peut-être déjà utilisé.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private DefaultListCellRenderer rendererRegion() {
        return new DefaultListCellRenderer() {
            @Override public Component getListCellRendererComponent(
                    JList<?> list, Object value, int idx, boolean sel, boolean focus) {
                super.getListCellRendererComponent(list, value, idx, sel, focus);
                if (value instanceof Region r) setText(r.getNomRegion());
                return this;
            }
        };
    }

    private DefaultListCellRenderer rendererRole() {
        return new DefaultListCellRenderer() {
            @Override public Component getListCellRendererComponent(
                    JList<?> list, Object value, int idx, boolean sel, boolean focus) {
                super.getListCellRendererComponent(list, value, idx, sel, focus);
                if (value instanceof Role r) setText(r.getLibelleRole());
                return this;
            }
        };
    }
}