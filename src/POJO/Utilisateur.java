package POJO;

// TODO: Auto-generated Javadoc
/**
 * The Class Utilisateur.
 */
public class Utilisateur {
	
	/** The id utilisateur. */
	private String idUtilisateur;
	
	/** The nom. */
	private String nom;
	
	/** The prenom. */
	private String prenom;
	
	/** The role. */
	private Role role;
	
	/** The adresse po. */
	private String adressePo;
	
	/** The cp. */
	private String cp;
	
	/** The ville. */
	private String ville;
	
	/** The num tel. */
	private String numTel;
	
	/** The num tel fixe. */
	private String numTelFixe;
	
	/** The email. */
	private String email;
	
	/** The region. */
	private Region region;
	
	/**
	 * Instantiates a new utilisateur.
	 *
	 * @param idUtilisateur the id utilisateur
	 * @param nom the nom
	 * @param prenom the prenom
	 * @param role the role
	 * @param adressePo the adresse po
	 * @param cp the cp
	 * @param ville the ville
	 * @param numTel the num tel
	 * @param numTelFixe the num tel fixe
	 * @param email the email
	 * @param region the region
	 */
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

	/**
	 * Gets the id utilisateur.
	 *
	 * @return the id utilisateur
	 */
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * Sets the id utilisateur.
	 *
	 * @param idUtilisateur the new id utilisateur
	 */
	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Sets the prenom.
	 *
	 * @param prenom the new prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the adresse po.
	 *
	 * @return the adresse po
	 */
	public String getAdressePo() {
		return adressePo;
	}

	/**
	 * Sets the adresse po.
	 *
	 * @param adressePo the new adresse po
	 */
	public void setAdressePo(String adressePo) {
		this.adressePo = adressePo;
	}

	/**
	 * Gets the cp.
	 *
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Sets the cp.
	 *
	 * @param cp the new cp
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * Gets the ville.
	 *
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Sets the ville.
	 *
	 * @param ville the new ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Gets the num tel.
	 *
	 * @return the num tel
	 */
	public String getNumTel() {
		return numTel;
	}

	/**
	 * Sets the num tel.
	 *
	 * @param numTel the new num tel
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	/**
	 * Gets the num tel fixe.
	 *
	 * @return the num tel fixe
	 */
	public String getNumTelFixe() {
		return numTelFixe;
	}

	/**
	 * Sets the num tel fixe.
	 *
	 * @param numTelFixe the new num tel fixe
	 */
	public void setNumTelFixe(String numTelFixe) {
		this.numTelFixe = numTelFixe;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Sets the region.
	 *
	 * @param region the new region
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role
				+ ", adressePo=" + adressePo + ", cp=" + cp + ", ville=" + ville + ", numTel=" + numTel
				+ ", numTelFixe=" + numTelFixe + ", email=" + email + ", region=" + region + "]";
	}
	
}
