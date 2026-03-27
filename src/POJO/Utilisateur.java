package POJO;

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
	
	public Utilisateur(String idUtilisateur, String nom, String prenom, Role role, String adressePo, String cp,
			String ville, String numTel, String numTelFixe, String email, Region region) {
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

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role
				+ ", adressePo=" + adressePo + ", cp=" + cp + ", ville=" + ville + ", numTel=" + numTel
				+ ", numTelFixe=" + numTelFixe + ", email=" + email + ", region=" + region + "]";
	}
	
}
