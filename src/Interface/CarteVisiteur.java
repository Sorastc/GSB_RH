package Interface;

import java.awt.*;
import javax.swing.*;
import POJO.Utilisateur;

public class CarteVisiteur extends JFrame {

    private Utilisateur visiteur;
    private final ListeVisteur parentListe;
    private final String idRoleConnecte;

    private JLabel lblNomPrenom;
    private JLabel lblIdVal, lblEmailVal, lblAdresseVal;
    private JLabel lblVilleVal, lblMobileVal, lblFixeVal;
    private JLabel lblRegionVal, lblRoleVal, lblEmbaucheVal;

    public CarteVisiteur(ListeVisteur parentListe, Utilisateur visiteur, Utilisateur userConnecte) {
        this.parentListe    = parentListe;
        this.visiteur       = visiteur;
        this.idRoleConnecte = (userConnecte != null && userConnecte.getRole() != null)
                              ? userConnecte.getRole().getIdRole() : "";
        initComponents();
        remplirChamps();
        setLocationRelativeTo(parentListe);
        setVisible(true);
    }

    private void initComponents() {
        setTitle("Fiche visiteur");
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        lblNomPrenom = new JLabel("", SwingConstants.CENTER);
        lblNomPrenom.setFont(new Font("Arial", Font.BOLD, 16));
        lblNomPrenom.setBounds(0, 10, 420, 25);
        getContentPane().add(lblNomPrenom);

        JSeparator sep = new JSeparator();
        sep.setBounds(20, 40, 380, 2);
        getContentPane().add(sep);

        // Grille de labels : libellé à gauche, valeur à droite
        String[] libelles = {"ID :", "Email :", "Adresse :", "Ville / CP :",
                             "Mobile :", "Fixe :", "Région :", "Rôle :", "Embauche :"};
        JLabel[] valeurs  = new JLabel[libelles.length];

        int y = 55;
        for (int i = 0; i < libelles.length; i++) {
            JLabel lbl = new JLabel(libelles[i]);
            lbl.setFont(new Font("Arial", Font.BOLD, 12));
            lbl.setBounds(20, y, 110, 20);
            getContentPane().add(lbl);

            valeurs[i] = new JLabel();
            valeurs[i].setFont(new Font("Arial", Font.PLAIN, 12));
            valeurs[i].setBounds(135, y, 265, 20);
            getContentPane().add(valeurs[i]);

            y += 28;
        }

        lblIdVal       = valeurs[0];
        lblEmailVal    = valeurs[1];
        lblAdresseVal  = valeurs[2];
        lblVilleVal    = valeurs[3];
        lblMobileVal   = valeurs[4];
        lblFixeVal     = valeurs[5];
        lblRegionVal   = valeurs[6];
        lblRoleVal     = valeurs[7];
        lblEmbaucheVal = valeurs[8];

        if ("S".equals(idRoleConnecte)) {
            JButton btnModifier = new JButton("Modifier");
            btnModifier.setBounds(130, 365, 90, 25);
            btnModifier.addActionListener(e ->
                new ModifVisiteur(this, parentListe, visiteur).setVisible(true));
            getContentPane().add(btnModifier);
        }

        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBounds(240, 365, 90, 25);
        btnFermer.addActionListener(e -> dispose());
        getContentPane().add(btnFermer);
    }

    private void remplirChamps() {
        setTitle("Fiche — " + visiteur.getPrenom() + " " + visiteur.getNom());
        lblNomPrenom.setText(visiteur.getPrenom() + " " + visiteur.getNom());
        lblIdVal.setText(ou(visiteur.getIdUtilisateur()));
        lblEmailVal.setText(ou(visiteur.getEmail()));
        lblAdresseVal.setText(ou(visiteur.getAdressePo()));
        lblMobileVal.setText(ou(visiteur.getNumTel()));
        lblFixeVal.setText(ou(visiteur.getNumTelFixe()));
        lblVilleVal.setText(ou(visiteur.getVille()) + " " + ou(visiteur.getCp()));
        lblRegionVal.setText(visiteur.getRegion() != null ? visiteur.getRegion().getNomRegion() : "—");
        lblRoleVal.setText(visiteur.getRole() != null ? visiteur.getRole().getLibelleRole() : "—");
        lblEmbaucheVal.setText(visiteur.getDateEmbauche() != null
                ? visiteur.getDateEmbauche().toString() : "—");
    }

    /** Appelé par ModifVisiteur après sauvegarde pour mettre à jour l'affichage. */
    public void rafraichir(Utilisateur visiteurMisAJour) {
        this.visiteur = visiteurMisAJour;
        remplirChamps();
    }

    private String ou(String val) {
        return (val != null && !val.isBlank()) ? val : "—";
    }
}