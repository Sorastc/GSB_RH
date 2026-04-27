package POJO;

import java.time.LocalDate;

public class Utilisateur {
	private String idUtilisateur;
	private String nom;
	private String prenom;
	private Role role;
	private String adressePo;
	private String cp;
	private String ville;
	private String numTel;
	private String numTelFixe;
	private String email;
	private Region region;
	// mdp volontairement absent : il ne doit jamais circuler hors du DAO
	private LocalDate dateEmbauche;

	/** Constructeur complet (utilisé par le DAO lors de la lecture en BDD) */
	public Utilisateur(String idUtilisateur, String nom, String prenom, Role role, String adressePo, String cp,
			String ville, String numTel, String numTelFixe, String email, Region region,
			LocalDate dateEmbauche) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.adressePo = adressePo;
		this.cp = cp;
		this.ville = ville;
		this.numTel = numTel;
		this.numTelFixe = numTelFixe;
		this.email = email;
		this.region = region;
		this.dateEmbauche = dateEmbauche;
	}

	/** Constructeur court : dateEmbauche à null (affichage seul, pas d'insertion) */
	public Utilisateur(String idUtilisateur, String nom, String prenom, Role role, String adressePo, String cp,
			String ville, String numTel, String numTelFixe, String email, Region region) {
		this(idUtilisateur, nom, prenom, role, adressePo, cp, ville, numTel, numTelFixe, email, region, null);
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAdressePo() {
		return adressePo;
	}

	public void setAdressePo(String adressePo) {
		this.adressePo = adressePo;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getNumTelFixe() {
		return numTelFixe;
	}

	public void setNumTelFixe(String numTelFixe) {
		this.numTelFixe = numTelFixe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public java.time.LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(java.time.LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role
				+ ", adressePo=" + adressePo + ", cp=" + cp + ", ville=" + ville + ", numTel=" + numTel
				+ ", numTelFixe=" + numTelFixe + ", email=" + email + ", region=" + region
				+ ", dateEmbauche=" + dateEmbauche + "]";
	}
	
}