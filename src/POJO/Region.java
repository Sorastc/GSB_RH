package POJO;

// TODO: Auto-generated Javadoc
/**
 * The Class Region.
 */
public class Region {
	
	/** The id region. */
	private int idRegion;
	
	/** The nom region. */
	private String nomRegion;
	
	/**
	 * Instantiates a new region.
	 *
	 * @param idRegion the id region
	 * @param nomRegion the nom region
	 */
	public Region(int idRegion, String nomRegion) {
		super();
		this.idRegion = idRegion;
		this.nomRegion = nomRegion;
	}
	
	/**
	 * Gets the id region.
	 *
	 * @return the id region
	 */
	public int getIdRegion() {
		return idRegion;
	}
	
	/**
	 * Sets the id region.
	 *
	 * @param idRegion the new id region
	 */
	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}
	
	/**
	 * Gets the nom region.
	 *
	 * @return the nom region
	 */
	public String getNomRegion() {
		return nomRegion;
	}
	
	/**
	 * Sets the nom region.
	 *
	 * @param nomRegion the new nom region
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Region [idRegion=" + idRegion + ", nomRegion=" + nomRegion + "]";
	}
	
}
