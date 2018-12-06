package aei.textual.tombola;

import aei.textual.skeleton.SkeletonMembre;

public class Lot extends SkeletonMembre{
	// ATTRIBUTS
	/* prenom -> place */
	
	// CONSTRUCTOR
	/**
	 * Creer un lot pour une tombola
	 */
	public Lot() {
		
	}
	
	/**
	 * Creer un lot pour une tombola
	 * @param n : (type-String) nom
	 * @param p : (type-String) place
	 */
	public Lot(String n, String p) {
		super(n,p);
	}

	// GETTER AND SETTER	
		
	// METHODS
	@Override
	/**
	 * Affiche le lot
	 */
	public String toString() {
		return "Lot : "+this.getNom();
	}
}
