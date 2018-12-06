package aei.textual.tombola;

import aei.textual.skeleton.SkeletonMembre;

public class Participant extends SkeletonMembre{
	// ATTRIBUTS
	/* case du participant */
	private String cas = "";
	
	// CONSTRUCTEUR
	/**
	 * Creer un participant pour la tombola
	 */
	public Participant() {
		
	}
	
	/**
	 * Creer un participant pour la tombola depusi un nom et prenom
	 * @param name : (type-String) nom
	 * @param prenom : (type-String) prenom
	 */
	public Participant(String name, String prenom) {
		super(name, prenom);
	}
	
	/**
	 * Creer un participant pour la tombola depusi un nom, prenom et une case
	 * @param name : (type-String) nom
	 * @param prenom : (type-String) prenom
	 * @param c : (type-String) case
	 */
	public Participant(String name, String prenom, String c) {
		super(name, prenom);
		this.cas = c;
	}

	// GETTER AND SETTER	
	/**
	 * @return : (type-String) the cas
	 */
	public String getCas() {
		return cas;
	}

	/**
	 * @param cas : (type-String) the cas to set
	 */
	public void setCas(String cas) {
		this.cas = cas;
	}
}
