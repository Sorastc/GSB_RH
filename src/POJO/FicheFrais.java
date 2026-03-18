package POJO;

import java.util.ArrayList;

public class FicheFrais {
	private int idFiche;
	private Utilisateur utilisateur;
	private int annee;
	private int mois;
	private int nbJustif;
	private int montantValide;
	private EtatFrais etatFrais;
	private ArrayList<LigneFraisForfait> ligneFraisForfait;
	private ArrayList<LigneFraisHorsForfait>ligneFraisHorsForfait;
	
	public FicheFrais(int idFiche, Utilisateur utilisateur, int annee, int mois, int nbJustif, int montantValide,
			EtatFrais etatFrais, ArrayList<LigneFraisForfait> ligneFraisForfait,
			ArrayList<LigneFraisHorsForfait> ligneFraisHorsForfait) {
		super();
		this.idFiche = idFiche;
		this.utilisateur = utilisateur;
		this.annee = annee;
		this.mois = mois;
		this.nbJustif = nbJustif;
		this.montantValide = montantValide;
		this.etatFrais = etatFrais;
		this.ligneFraisForfait = ligneFraisForfait;
		this.ligneFraisHorsForfait = ligneFraisHorsForfait;
	}

	public int getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getNbJustif() {
		return nbJustif;
	}

	public void setNbJustif(int nbJustif) {
		this.nbJustif = nbJustif;
	}

	public int getMontantValide() {
		return montantValide;
	}

	public void setMontantValide(int montantValide) {
		this.montantValide = montantValide;
	}

	public EtatFrais getEtatFrais() {
		return etatFrais;
	}

	public void setEtatFrais(EtatFrais etatFrais) {
		this.etatFrais = etatFrais;
	}

	public ArrayList<LigneFraisForfait> getLigneFraisForfait() {
		return ligneFraisForfait;
	}

	public void setLigneFraisForfait(ArrayList<LigneFraisForfait> ligneFraisForfait) {
		this.ligneFraisForfait = ligneFraisForfait;
	}

	public ArrayList<LigneFraisHorsForfait> getLigneFraisHorsForfait() {
		return ligneFraisHorsForfait;
	}

	public void setLigneFraisHorsForfait(ArrayList<LigneFraisHorsForfait> ligneFraisHorsForfait) {
		this.ligneFraisHorsForfait = ligneFraisHorsForfait;
	}

	
	@Override
	public String toString() {
		return "FicheFrais [idFiche=" + idFiche + ", utilisateur=" + utilisateur + ", annee=" + annee + ", mois=" + mois
				+ ", nbJustif=" + nbJustif + ", montantValide=" + montantValide + ", etatFrais=" + etatFrais
				+ ", ligneFraisForfait=" + ligneFraisForfait + ", ligneFraisHorsForfait=" + ligneFraisHorsForfait + "]";
	}
	
	

}
