package gestionnaire.profil;

public class Site {
	// ATTRIBUTS
	private String nom = "";
	private String lien = "";
	
	// CONSTRUCTOR
	public Site() {
	}
	
	public Site(String n, String l) {
		this.nom = n;
		this.lien = l;
	}

	// GETTER AND SETTER
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the lien
	 */
	public String getLien() {
		return lien;
	}

	/**
	 * @param lien the lien to set
	 */
	public void setLien(String lien) {
		this.lien = lien;
	}
}
