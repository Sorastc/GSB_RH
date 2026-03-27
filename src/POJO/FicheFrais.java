package POJO;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class FicheFrais.
 * @author harich-s
 */
public class FicheFrais {
	
	/** The id fiche. */
	private int idFiche;
	
	/** The utilisateur. */
	private Utilisateur utilisateur;
	
	/** The annee. */
	private int annee;
	
	/** The mois. */
	private int mois;
	
	/** The nb justif. */
	private int nbJustif;
	
	/** The montant valide. */
	private int montantValide;
	
	/** The etat frais. */
	private EtatFrais etatFrais;
	
	/** The ligne frais forfait. */
	private ArrayList<LigneFraisForfait> ligneFraisForfait;
	
	/** The ligne frais hors forfait. */
	private ArrayList<LigneFraisHorsForfait>ligneFraisHorsForfait;
	
	/**
	 * Instantiates a new fiche frais.
	 *
	 * @param idFiche the id fiche
	 * @param utilisateur the utilisateur
	 * @param annee the annee
	 * @param mois the mois
	 * @param nbJustif the nb justif
	 * @param montantValide the montant valide
	 * @param etatFrais the etat frais
	 * @param ligneFraisForfait the ligne frais forfait
	 * @param ligneFraisHorsForfait the ligne frais hors forfait
	 */
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

	/**
	 * Gets the id fiche.
	 *
	 * @return the id fiche
	 */
	public int getIdFiche() {
		return idFiche;
	}

	/**
	 * Sets the id fiche.
	 *
	 * @param idFiche the new id fiche
	 */
	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	/**
	 * Gets the utilisateur.
	 *
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * Sets the utilisateur.
	 *
	 * @param utilisateur the new utilisateur
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * Gets the annee.
	 *
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * Sets the annee.
	 *
	 * @param annee the new annee
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * Gets the mois.
	 *
	 * @return the mois
	 */
	public int getMois() {
		return mois;
	}

	/**
	 * Sets the mois.
	 *
	 * @param mois the new mois
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}

	/**
	 * Gets the nb justif.
	 *
	 * @return the nb justif
	 */
	public int getNbJustif() {
		return nbJustif;
	}

	/**
	 * Sets the nb justif.
	 *
	 * @param nbJustif the new nb justif
	 */
	public void setNbJustif(int nbJustif) {
		this.nbJustif = nbJustif;
	}

	/**
	 * Gets the montant valide.
	 *
	 * @return the montant valide
	 */
	public int getMontantValide() {
		return montantValide;
	}

	/**
	 * Sets the montant valide.
	 *
	 * @param montantValide the new montant valide
	 */
	public void setMontantValide(int montantValide) {
		this.montantValide = montantValide;
	}

	/**
	 * Gets the etat frais.
	 *
	 * @return the etat frais
	 */
	public EtatFrais getEtatFrais() {
		return etatFrais;
	}

	/**
	 * Sets the etat frais.
	 *
	 * @param etatFrais the new etat frais
	 */
	public void setEtatFrais(EtatFrais etatFrais) {
		this.etatFrais = etatFrais;
	}

	/**
	 * Gets the ligne frais forfait.
	 *
	 * @return the ligne frais forfait
	 */
	public ArrayList<LigneFraisForfait> getLigneFraisForfait() {
		return ligneFraisForfait;
	}

	/**
	 * Sets the ligne frais forfait.
	 *
	 * @param ligneFraisForfait the new ligne frais forfait
	 */
	public void setLigneFraisForfait(ArrayList<LigneFraisForfait> ligneFraisForfait) {
		this.ligneFraisForfait = ligneFraisForfait;
	}

	/**
	 * Gets the ligne frais hors forfait.
	 *
	 * @return the ligne frais hors forfait
	 */
	public ArrayList<LigneFraisHorsForfait> getLigneFraisHorsForfait() {
		return ligneFraisHorsForfait;
	}

	/**
	 * Sets the ligne frais hors forfait.
	 *
	 * @param ligneFraisHorsForfait the new ligne frais hors forfait
	 */
	public void setLigneFraisHorsForfait(ArrayList<LigneFraisHorsForfait> ligneFraisHorsForfait) {
		this.ligneFraisHorsForfait = ligneFraisHorsForfait;
	}

	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "FicheFrais [idFiche=" + idFiche + ", utilisateur=" + utilisateur + ", annee=" + annee + ", mois=" + mois
				+ ", nbJustif=" + nbJustif + ", montantValide=" + montantValide + ", etatFrais=" + etatFrais
				+ ", ligneFraisForfait=" + ligneFraisForfait + ", ligneFraisHorsForfait=" + ligneFraisHorsForfait + "]";
	}
	
	

}
