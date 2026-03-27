package POJO;

// TODO: Auto-generated Javadoc
/**
 * The Class Departement.
 */
public class Departement {
	
	/** The id departement. */
	private int idDepartement;
	
	/** The code departement. */
	private int codeDepartement;
	
	/** The nom departement. */
	private String nomDepartement;
	
	/** The region. */
	private Region region;
	
	/**
	 * Instantiates a new departement.
	 *
	 * @param idDepartement the id departement
	 * @param codeDepartement the code departement
	 * @param nomDepartement the nom departement
	 * @param region the region
	 */
	public Departement(int idDepartement, int codeDepartement, String nomDepartement, Region region) {
		super();
		this.idDepartement = idDepartement;
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
		this.region = region;
	}

	/**
	 * Gets the id departement.
	 *
	 * @return the id departement
	 */
	public int getIdDepartement() {
		return idDepartement;
	}

	/**
	 * Sets the id departement.
	 *
	 * @param idDepartement the new id departement
	 */
	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}

	/**
	 * Gets the code departement.
	 *
	 * @return the code departement
	 */
	public int getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * Sets the code departement.
	 *
	 * @param codeDepartement the new code departement
	 */
	public void setCodeDepartement(int codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/**
	 * Gets the nom departement.
	 *
	 * @return the nom departement
	 */
	public String getNomDepartement() {
		return nomDepartement;
	}

	/**
	 * Sets the nom departement.
	 *
	 * @param nomDepartement the new nom departement
	 */
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
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
		return "Departement [idDepartement=" + idDepartement + ", codeDepartement=" + codeDepartement
				+ ", nomDepartement=" + nomDepartement + ", region=" + region + "]";
	}
	
	
}
