package POJO;

// TODO: Auto-generated Javadoc
/**
 * The Class EtatFrais.
 * @author harich-s
 */
public class EtatFrais {
	
	/** The id etat. */
	private String idEtat;
	
	/** The libelle etat. */
	private String libelleEtat;
	
	/**
	 * Instantiates a new etat frais.
	 *
	 * @param idEtat the id etat
	 * @param libelleEtat the libelle etat
	 */
	public EtatFrais(String idEtat, String libelleEtat) {
		super();
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
	}

	/**
	 * Gets the id etat.
	 *
	 * @return the id etat
	 */
	public String getIdEtat() {
		return idEtat;
	}

	/**
	 * Sets the id etat.
	 *
	 * @param idEtat the new id etat
	 */
	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}

	/**
	 * Gets the libelle etat.
	 *
	 * @return the libelle etat
	 */
	public String getLibelleEtat() {
		return libelleEtat;
	}

	/**
	 * Sets the libelle etat.
	 *
	 * @param libelleEtat the new libelle etat
	 */
	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EtatFrais [idEtat=" + idEtat + ", libelleEtat=" + libelleEtat + "]";
	}
	
}
