package Interface;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import POJO.Utilisateur;

public class CarteVisiteur extends JFrame {

    private Utilisateur visiteur;


    private JLabel lblNomPrenom;
    private JLabel lblIdVal, lblEmailVal, lblAdresseVal;
    private JLabel lblVilleVal, lblMobileVal, lblFixeVal;
    private JLabel lblRegionVal, lblRoleVal;

    public CarteVisiteur(JFrame parent, Utilisateur visiteur) {
        this.visiteur = visiteur;

        construireUI();
        remplirChamps();

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void construireUI() {


        lblNomPrenom = new JLabel("", SwingConstants.CENTER);
        lblNomPrenom.setFont(new Font("Arial", Font.BOLD, 20));
        lblNomPrenom.setForeground(Color.WHITE);

        JPanel panelEntete = new JPanel(new BorderLayout());
        panelEntete.setBounds(0, 0, 474, 54);
        panelEntete.setBackground(new Color(52, 73, 94));
        panelEntete.setBorder(new EmptyBorder(15, 15, 15, 15));
        panelEntete.add(lblNomPrenom, BorderLayout.CENTER);


        JPanel panelCorps = new JPanel(new GridLayout(0, 2, 10, 10));
        panelCorps.setBounds(0, 64, 464, 241);
        panelCorps.setBackground(Color.WHITE);
        panelCorps.setBorder(new EmptyBorder(20, 25, 20, 25));

        lblIdVal      = new JLabel();
        lblIdVal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblEmailVal   = new JLabel();
        lblEmailVal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblAdresseVal = new JLabel();
        lblAdresseVal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblVilleVal   = new JLabel();
        lblVilleVal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblMobileVal  = new JLabel();
        lblMobileVal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblFixeVal    = new JLabel();
        lblFixeVal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblRegionVal  = new JLabel();
        lblRegionVal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblRoleVal    = new JLabel();
        lblRoleVal.setFont(new Font("Tahoma", Font.PLAIN, 10));

        panelCorps.add(creerTitre("ID"));           panelCorps.add(lblIdVal);
        panelCorps.add(creerTitre("Email"));        panelCorps.add(lblEmailVal);
        panelCorps.add(creerTitre("Adresse"));      panelCorps.add(lblAdresseVal);
        panelCorps.add(creerTitre("Ville"));        panelCorps.add(lblVilleVal);
        panelCorps.add(creerTitre("Mobile"));       panelCorps.add(lblMobileVal);
        panelCorps.add(creerTitre("Fixe"));         panelCorps.add(lblFixeVal);
        panelCorps.add(creerTitre("Région"));       panelCorps.add(lblRegionVal);
        panelCorps.add(creerTitre("Rôle"));         panelCorps.add(lblRoleVal);


        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBackground(new Color(52, 73, 94));
        btnFermer.setForeground(Color.WHITE);
        btnFermer.setFocusPainted(false);
        btnFermer.setFont(new Font("Arial", Font.BOLD, 13));
        btnFermer.addActionListener(e -> dispose());

        JPanel panelPied = new JPanel();
        panelPied.setBounds(0, 354, 474, 54);
        panelPied.setBackground(Color.WHITE);
        panelPied.setBorder(new EmptyBorder(0, 0, 10, 0));
        panelPied.add(btnFermer);


        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        getContentPane().add(panelEntete);
        getContentPane().add(panelCorps);
        getContentPane().add(panelPied);

        setTitle("Fiche Visiteur");
        setSize(490, 458);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    private void remplirChamps() {
        lblNomPrenom.setText(visiteur.getNom() + " " + visiteur.getPrenom());
        lblIdVal.setText(visiteur.getIdUtilisateur() != null ? visiteur.getIdUtilisateur() : "—");
        lblEmailVal.setText(visiteur.getEmail() != null ? visiteur.getEmail() : "—");
        lblAdresseVal.setText(visiteur.getAdressePo() != null ? visiteur.getAdressePo() : "—");
        lblVilleVal.setText(visiteur.getVille() != null ? visiteur.getVille() + " " + visiteur.getCp() : "—");
        lblMobileVal.setText(visiteur.getNumTel() != null ? visiteur.getNumTel() : "—");
        lblFixeVal.setText(visiteur.getNumTelFixe() != null ? visiteur.getNumTelFixe() : "—");
        lblRegionVal.setText(visiteur.getRegion() != null ? visiteur.getRegion().getNomRegion() : "—");
        lblRoleVal.setText(visiteur.getRole() != null ? visiteur.getRole().getLibelleRole() : "—");
    }

    private JLabel creerTitre(String texte) {
        JLabel lbl = new JLabel(texte);
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        lbl.setForeground(new Color(52, 73, 94));
        return lbl;
    }
}