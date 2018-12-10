package aei.textual.skeleton;

import java.util.ArrayList;
import java.util.Scanner;

public class SkeletonListMembre<S extends SkeletonMembre> {
	// ATTRIBUTS
	/* list de S*/
	private ArrayList<S> list = new ArrayList<S>();
	
	private static Scanner scan = new Scanner(System.in);
	
	// CONSTRUCTOR
	/**
	 * Creer la liste de S
	 */
	public SkeletonListMembre() {
		
	}
	
	/**
	 * Creer la liste de S deja defini par une liste <code>l</code> de S
	 * @param l : (type-ArrayList<S>) list
	 */
	public SkeletonListMembre(ArrayList<S> l) {
		this.list = l;
	}

	// GETTER AND SETTER
	/**
	 * @return: (type-ArrayList<S>)  the list
	 */
	public ArrayList<S> getList() {
		return list;
	}

	/**
	 * @param list : (type-ArrayList<S>) the list to set
	 */
	public void setList(ArrayList<S> list) {
		this.list = list;
	}
	
	// METHODS
	/**
	 * Taille de la liste
	 * @return : (type-Integer) taille
	 */
	public int size() {
		return this.list.size();
	}
	
	/**
	 * Verifie si la liste contient deja un <code>membre</code> S
	 * @param membre : (type-S) membre
	 * @return : (type-boolean) <code>true</code> si le membre est deja contenu dans la liste
	 */
	public boolean contains(S membre) {
		for(S m : this.list) {
			if(membre.getNom().toLowerCase().equals(m.getNom().toLowerCase())) {
				if(membre.getPrenom().toLowerCase().equals(m.getPrenom().toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Ajoute le nouveau <code>membre</code> S s'il n'appartient pas a la liste
	 * @param membre : (type-S) membre
	 */
	public void add(S membre) {
		if(!this.contains(membre)) {
			this.list.add(membre);
		}
	}
	
	/**
	 * Supprime un <code>membre</code> S grace a son nom et prenom 
	 * @param membre : (type-S) membre
	 */
	public void remove(S membre) {
		S m;
		for(int i = 0; i < this.list.size(); i++) {
			m = this.list.get(i);
			if(membre.getNom().equals(m.getNom()) && membre.getPrenom().equals(m.getPrenom())) {
				this.list.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Affiche la liste des membres
	 */
	public void display() {
		System.out.println("Liste des membres : ");
		for(S m : this.list) {
			System.out.println("- "+m.toString());
		}
	}
	
	/**
	 * Renvoi un membre de type SkeletonMembre afin d'effectuer des actions sur ce membre
	 * @return : (type-S) SkeletonMembre
	 */
	public S identif(Class<S> clazz) {
		S membre = null;
		System.out.println("Identifiant :");
		System.out.println("> Nom [sans majuscule ni accents] ");
		String nom = scan.nextLine();
		System.out.println("> Prenom [sans majuscule ni accents] ");
		String prenom = scan.nextLine();
	    try {
			membre = clazz.newInstance();
			membre.setNom(nom);
			membre.setPrenom(prenom);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	    return membre;
	}
	
	/**
	 * Cherche un membre et affiche ses informations
	 * @param membre : (type-S) membre
	 */
	public void search(S membre) {
		if(this.contains(membre)) {
			System.out.println(membre.toString());
		}else {
			System.out.println(membre.toString()+" n'existe pas !");
		}
	}
}
