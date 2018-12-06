package aei.textual.membre;

import aei.textual.skeleton.SkeletonMembre;

public class Membre extends SkeletonMembre{	
	// ATTRIBUTS
	/* adresse mail du membre */
	private String adresse_mail=null;
	/* formation du membre */
	private String formation=null;
	/* cotisation du membre */
	private float cotisation=0;

	
	// CONSTRUCTOR
	/**
	 * Creer un membre de l'association
	 */
	public Membre() {
	}
	
	/**
	 * Creer un membre de l'association avec un nom et prenom defini
	 * @param n : (type-String) nom
	 * @param p : (type-String) prenom
	 */
	public Membre(String n, String p) {
		super(n,p);
	}
	
	/**
	 * Creer un membre de l'association avec ses informatiosn definies
	 * @param n : (type-String) nom
	 * @param p : (type-String) prenom
	 * @param adresse_mail : (type-String) adresse mail 
	 * @param formation : (type-String) formation
	 * @param cotisation : (type-String) cotisation
	 */
	public Membre(String nom, String prenom, String adresse_mail, String formation, float cotisation) {
		super(nom, prenom);
		this.adresse_mail = adresse_mail;
		this.formation = formation;
		this.cotisation = cotisation;
	}
	
	// GETTER AND SETTER
	/**
	 * @return : (type-String) the adresse_mail
	 */
	public String getAdresse_mail() {
		return adresse_mail;
	}

	/**
	 * @param adresse_mail : (type-String) the adresse_mail to set
	 */
	public void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}

	/**
	 * @return : (type-String) the formation
	 */
	public String getFormation() {
		return formation;
	}

	/**
	 * @param formation : (type-String) the formation to set
	 */
	public void setFormation(String formation) {
		this.formation = formation;
	}

	/**
	 * @return : (type-float) the cotisation
	 */
	public float getCotisation() {
		return cotisation;
	}

	/**
	 * @param cotisation : (type-float) the cotisation to set
	 */
	public void setCotisation(float cotisation) {
		this.cotisation = cotisation;
	}
}
