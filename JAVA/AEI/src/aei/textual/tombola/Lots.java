package aei.textual.tombola;

import java.util.ArrayList;

import aei.textual.skeleton.SkeletonListMembre;

public class Lots extends SkeletonListMembre<Lot>{
	// CONSTRUCTOR
	/**
	 * Creer la liste des lots pour la tombola
	 */
	public Lots() {
		
	}
	
	/**
	 * Creer la liste des <code>lots</code> pour la tombola depuis une liste
	 * @param lots : (type-ArrayList<Lot>) liste de lots
	 */
	public Lots(ArrayList<Lot> lots) {
		super(lots);
	}
	
	// GETTER AND SETTER
	
	// METHODS
	@Override
	/**
	 * Affiche les lots de la tombola
	 */
	public String toString() {
		System.out.println("Lots : ");
		for(int i = 0; i < this.getList().size(); i++) {
			System.out.println(" - "+this.getList().get(i).toString());
		}
		return "";
	}
}
