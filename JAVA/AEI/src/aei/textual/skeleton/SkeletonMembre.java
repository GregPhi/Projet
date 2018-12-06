package aei.textual.skeleton;

public class SkeletonMembre {
	
	// ATTRIBUTS
	/* nom d'un membre */
	private String nom;
	/* prenom d'un membre */
	private String prenom;
	
	// CONSTRUCTOR
	/**
	 * Creer un membre
	 */
	public SkeletonMembre() {
	}
	
	/**
	 * Creer un membre avec un nom et prenom défini
	 * @param n : (type-String) nom
	 * @param p : (type-String) prenom 
	 */
	public SkeletonMembre(String n, String p) {
		this.nom = n;
		this.prenom = p;
	}

	// GETTER AND SETTTER
	/**
	 * @return : (type-String) the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom : (type-String) the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return : (type-String) the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom : (type-String) the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// METHODS
	@Override
	public String toString() {
		return "Nom : "+this.getNom()+" - Prenom : "+this.getPrenom();
	}
}
