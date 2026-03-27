package POJO;

import java.math.BigDecimal;
import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class LigneFraisHorsForfait.
 */
public class LigneFraisHorsForfait {
	
	/** The id ligne FHF. */
	private int idLigneFHF;
	
	/** The fiche frais. */
	private FicheFrais ficheFrais;
	
	/** The date ligne FHF. */
	private LocalDate dateLigneFHF;
	
	/** The montant. */
	private BigDecimal montant;
	
	/**
	 * Instantiates a new ligne frais hors forfait.
	 *
	 * @param idLigneFHF the id ligne FHF
	 * @param ficheFrais the fiche frais
	 * @param dateLigneFHF the date ligne FHF
	 * @param montant the montant
	 */
	public LigneFraisHorsForfait(int idLigneFHF, FicheFrais ficheFrais, LocalDate dateLigneFHF, BigDecimal montant) {
		super();
		this.idLigneFHF = idLigneFHF;
		this.ficheFrais = ficheFrais;
		this.dateLigneFHF = dateLigneFHF;
		this.montant = montant;
	}

	/**
	 * Gets the id ligne FHF.
	 *
	 * @return the id ligne FHF
	 */
	public int getIdLigneFHF() {
		return idLigneFHF;
	}

	/**
	 * Sets the id ligne FHF.
	 *
	 * @param idLigneFHF the new id ligne FHF
	 */
	public void setIdLigneFHF(int idLigneFHF) {
		this.idLigneFHF = idLigneFHF;
	}

	/**
	 * Gets the fiche frais.
	 *
	 * @return the fiche frais
	 */
	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}

	/**
	 * Sets the fiche frais.
	 *
	 * @param ficheFrais the new fiche frais
	 */
	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}

	/**
	 * Gets the date ligne FHF.
	 *
	 * @return the date ligne FHF
	 */
	public LocalDate getDateLigneFHF() {
		return dateLigneFHF;
	}

	/**
	 * Sets the date ligne FHF.
	 *
	 * @param dateLigneFHF the new date ligne FHF
	 */
	public void setDateLigneFHF(LocalDate dateLigneFHF) {
		this.dateLigneFHF = dateLigneFHF;
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
		return "LigneFraisHorsForfait [idLigneFHF=" + idLigneFHF + ", ficheFrais=" + ficheFrais + ", dateLigneFHF="
				+ dateLigneFHF + ", montant=" + montant + "]";
	}
	
}
