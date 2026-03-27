package POJO;

// TODO: Auto-generated Javadoc
/**
 * The Class Role.
 * @author harich-s
 */
public class Role {
	
	/** The id role. */
	private String idRole;
	
	/** The libelle role. */
	private String libelleRole;
	
	/**
	 * Instantiates a new role.
	 *
	 * @param idRole the id role
	 * @param libelleRole the libelle role
	 */
	public Role(String idRole, String libelleRole) {
		super();
		this.idRole = idRole;
		this.libelleRole = libelleRole;
	}

	/**
	 * Gets the id role.
	 *
	 * @return the id role
	 */
	public String getIdRole() {
		return idRole;
	}

	/**
	 * Sets the id role.
	 *
	 * @param idRole the new id role
	 */
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	/**
	 * Gets the libelle role.
	 *
	 * @return the libelle role
	 */
	public String getLibelleRole() {
		return libelleRole;
	}

	/**
	 * Sets the libelle role.
	 *
	 * @param libelleRole the new libelle role
	 */
	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", libelleRole=" + libelleRole + "]";
	}
	

}
