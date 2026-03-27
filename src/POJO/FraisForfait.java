package POJO;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class FraisForfait.
 */
public class FraisForfait {
	
	/** The id frais forfait. */
	private String idFraisForfait;
	
	/** The libelle frais forfait. */
	private String libelleFraisForfait;
	
	/** The montant. */
	private BigDecimal montant;
	
	/**
	 * Instantiates a new frais forfait.
	 *
	 * @param idFraisForfait the id frais forfait
	 * @param libelleFraisForfait the libelle frais forfait
	 * @param montant the montant
	 */
	public FraisForfait(String idFraisForfait, String libelleFraisForfait, BigDecimal montant) {
		super();
		this.idFraisForfait = idFraisForfait;
		this.libelleFraisForfait = libelleFraisForfait;
		this.montant = montant;
	}

	/**
	 * Gets the id frais forfait.
	 *
	 * @return the id frais forfait
	 */
	public String getIdFraisForfait() {
		return idFraisForfait;
	}

	/**
	 * Sets the id frais forfait.
	 *
	 * @param idFraisForfait the new id frais forfait
	 */
	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}

	/**
	 * Gets the libelle frais forfait.
	 *
	 * @return the libelle frais forfait
	 */
	public String getLibelleFraisForfait() {
		return libelleFraisForfait;
	}

	/**
	 * Sets the libelle frais forfait.
	 *
	 * @param libelleFraisForfait the new libelle frais forfait
	 */
	public void setLibelleFraisForfait(String libelleFraisForfait) {
		this.libelleFraisForfait = libelleFraisForfait;
	}

	/**
	 * Gets the montant.
	 *
	 * @return the montant
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * Sets the montant.
	 *
	 * @param montant the new montant
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "FraisForfait [idFraisForfait=" + idFraisForfait + ", libelleFraisForfait=" + libelleFraisForfait
				+ ", montant=" + montant + "]";
	}
}
