package aei.textual.membre;

import java.util.ArrayList;
import java.util.Scanner;

import aei.textual.skeleton.SkeletonListMembre;

public class Membres extends SkeletonListMembre<Membre>{
	// ATTRIBUTS
	/* total des cotisations */
	private float nbCotisation = 0;
	/* nombres de membres */
	private Integer nbMembre = 0;
	
	// CONSTRUCTOR
	/**
	 * Creer une liste de membres de l'association
	 */
	public Membres() {
	}
	
	/**
	 * Creer une liste de membres de l'assocaition depuis une liste deja definie
	 * @param membres : (type-ArrayList<Membre>) liste des membres
	 */
	public Membres(ArrayList<Membre> membres) {
		super(membres);	
	}

	// GETTER AND SETTER
	/**
	 * @return : (type-float) the nbCotisation
	 */
	public float getnbCotisation() {
		return this.nbCotisation;
	}

	/**
	 * Regenere le nombre de cotisations
	 */
	public void setTotal() {
		this.nbCotisation = 0;
		for(Membre m : this.getList()) {
			this.nbCotisation += m.getCotisation();
		}
	}
	
	/**
	 * @return : (type-Integer) the nbMembre
	 */
	public Integer getnbMembre() {
		return this.nbMembre;
	}
	
	/**
	 * Regenere le nombre de membres
	 */
	public void setNbMembre() {
		this.nbMembre = this.getList().size();
	}
	
	// METHODS
	/**
	 * Regenere les informations de l'association
	 */
	public void gestionMembres() {
		this.gestionMembre();
		this.gestionMail();
		this.setTotal();
		this.setNbMembre();
		System.out.println("Gestion des membres !");
	}
	
	/**
	 * Gere le nom et prenom des membres
	 */
	public void gestionMembre() {
		for(Membre m : this.getList()) {
			String nom = m.getNom();
			nom = nom.substring(0, 1).toUpperCase()+nom.substring(1).toLowerCase();
			String prenom = m.getPrenom();
			prenom = prenom.substring(0, 1).toUpperCase()+prenom.substring(1).toLowerCase();
			m.setNom(nom);
			m.setPrenom(prenom);
		}
	}
	
	/**
	 * Genere l'adresse mail pour tous les membres
	 */
	public void gestionMail() {
		for(Membre m : this.getList()) {
			String nom = m.getNom();
			String prenom = m.getPrenom();
			int idx;
			String mail;
			if(nom.contains("-")) {
				idx = nom.indexOf("-");
				nom = nom.substring(0, idx)+""+nom.substring(idx+1);
			}				
			if(nom.contains(" ")) {
				idx = nom.indexOf(" ");
				nom = nom.substring(0, idx)+""+nom.substring(idx+1);
			}
			if(nom.contains("' ")) {
				idx = nom.indexOf("' ");
				nom = nom.substring(0, idx)+""+nom.substring(idx+1);
			}			
			if(prenom.contains("-")) {
				idx = prenom.indexOf("-");
				prenom = prenom.substring(0, idx)+""+prenom.substring(idx+1);
			}				
			if(prenom.contains(" ")) {
				idx = prenom.indexOf(" ");
				prenom = prenom.substring(0, idx)+""+prenom.substring(idx+1);
			}
			if(prenom.contains("' ")) {
				idx = prenom.indexOf("' ");
				prenom = prenom.substring(0, idx)+""+prenom.substring(idx+1);
			}
			mail = prenom+"."+nom+".etu@univ-lille.fr";
			if(m.getFormation().equals("Prof")) {
				mail = prenom+"."+nom+"@univ-lille.fr";
			}
			if(m.getFormation().equals("Autre")) {
				mail = m.getAdresse_mail();
			}
			m.setAdresse_mail(mail.toLowerCase());
		}
	}
	
	@SuppressWarnings("resource")
	/**
	 * Ajoute un nouveau membre
	 */
	public void newMembre() {
		Scanner in = new Scanner(System.in);
		System.out.println("Nouveau membre :");
		System.out.println("> Nom [sans accent ni majuscule] :");
		String nom = in.nextLine();
		System.out.println("> Prénom [sans accent ni majuscule] :");
		String prenom = in.nextLine();
		System.out.println("> Formation : INFO - MIAGE - PROF - OTHER");
		String formation = in.nextLine();
		formation.toLowerCase();
		System.out.println("> Cotisation :");
		float cotisation = in.nextFloat();
		Membre membre = new Membre(nom, prenom, "", formation, cotisation);
		this.getList().add(membre);
		System.out.println("Nouveau Membre !");
	}
	
	/**
	 * Ajoute autant de membre que <code>i</code> membres a ajouter
	 * @param i : (type-Integer) nombre de membres a ajouter
	 */
	public void newMembres(int i) {
		for(int j = 0; j < i; j++) {
			this.newMembre();
		}
	}
	
	@Override
	/**
	 * Affiche les informations de l'association
	 */
	public String toString() {
		this.display();
		return "Cotisations : "+this.nbCotisation+" - Nombre de membres : "+this.nbMembre;
	}	
}
