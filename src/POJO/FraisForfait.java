package POJO;

import java.math.BigDecimal;

public class FraisForfait {
	private String idFraisForfait;
	private String libelleFraisForfait;
	private BigDecimal montant;
	
	public FraisForfait(String idFraisForfait, String libelleFraisForfait, BigDecimal montant) {
		super();
		this.idFraisForfait = idFraisForfait;
		this.libelleFraisForfait = libelleFraisForfait;
		this.montant = montant;
	}

	public String getIdFraisForfait() {
		return idFraisForfait;
	}

	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}

	public String getLibelleFraisForfait() {
		return libelleFraisForfait;
	}

	public void setLibelleFraisForfait(String libelleFraisForfait) {
		this.libelleFraisForfait = libelleFraisForfait;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "FraisForfait [idFraisForfait=" + idFraisForfait + ", libelleFraisForfait=" + libelleFraisForfait
				+ ", montant=" + montant + "]";
	}
}
