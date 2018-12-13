package client;

import java.util.ArrayList;
import java.util.List;

import compte.SkeletonCompte;

public class SkeletonClient {
/**
 * -> nom / prenom
 * -> id client
 * -> liste des comptes
 * -> 
 */
	// ATTRIBUTS
	private String nom;
	private String prenom;
	
	private String id;
	
	private List<SkeletonCompte> comptes = new ArrayList<SkeletonCompte>();
	
	// CONSTRUCTOR
	public SkeletonClient() {
	}
	
	public SkeletonClient(String nom, String prenom) {
		
	}
	
	public SkeletonClient(String nom, String prenom, String id) {
	
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
	public List<SkeletonCompte> getComptes() {
		return this.comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(ArrayList<SkeletonCompte> comptes) {
		this.comptes = comptes;
	}
	
	// METHODS
	@Override
	public String toString() {
		return "Informations client : Nom -> "+this.nom+" | Prenom -> "+this.prenom+" | ID -> "+this.id;
	}
	
	public void test() {
		
	}
}
