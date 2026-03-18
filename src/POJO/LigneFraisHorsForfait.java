package POJO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LigneFraisHorsForfait {
	private int idLigneFHF;
	private FicheFrais ficheFrais;
	private LocalDate dateLigneFHF;
	private BigDecimal montant;
	
	public LigneFraisHorsForfait(int idLigneFHF, FicheFrais ficheFrais, LocalDate dateLigneFHF, BigDecimal montant) {
		super();
		this.idLigneFHF = idLigneFHF;
		this.ficheFrais = ficheFrais;
		this.dateLigneFHF = dateLigneFHF;
		this.montant = montant;
	}

	public int getIdLigneFHF() {
		return idLigneFHF;
	}

	public void setIdLigneFHF(int idLigneFHF) {
		this.idLigneFHF = idLigneFHF;
	}

	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}

	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}

	public LocalDate getDateLigneFHF() {
		return dateLigneFHF;
	}

	public void setDateLigneFHF(LocalDate dateLigneFHF) {
		this.dateLigneFHF = dateLigneFHF;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "LigneFraisHorsForfait [idLigneFHF=" + idLigneFHF + ", ficheFrais=" + ficheFrais + ", dateLigneFHF="
				+ dateLigneFHF + ", montant=" + montant + "]";
	}
	
}
