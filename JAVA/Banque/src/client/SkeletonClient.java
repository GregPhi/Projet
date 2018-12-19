package client;

import compte.SkeletonCompte;
import compte.SkeletonComptes;

public class SkeletonClient {
/**
 * -> nom / prenom
 * -> id client
 * -> liste des comptes
 * -> 
 */
	// ATTRIBUTS
	private String nom = "";
	private String prenom = "";
	private int age = 0;
	
	private String id = "";
	
	private SkeletonComptes comptes = new SkeletonComptes();
	
	// CONSTRUCTOR
	public SkeletonClient() {
	}
	
	public SkeletonClient(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public SkeletonClient(String nom, String prenom, String id) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
	}
	
	public SkeletonClient(String nom, String prenom, String id, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
		this.age = age;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the comptes
	 */
	public SkeletonComptes getComptes() {
		return this.comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(SkeletonComptes comptes) {
		this.comptes = comptes;
	}
	
	// METHODS
	@Override
	public String toString() {
		return "Informations client : Nom -> "+this.nom+" | Prenom -> "+this.prenom+" | ID -> "+this.id;
	}
	
	public void add(SkeletonCompte compte) {
		this.comptes.add(compte);
		
	}
}
