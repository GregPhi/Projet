package compte;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public abstract class SkeletonCompte {
/**
 * -> argent actuel
 * -> actions réalisables ?
 * -> taux ?
 * -> type de compte
 * -> id compte
 * -> 
 */
	
	// ATTRIBUTS
	private float argent = 0;
	private String id = "";
	
	private TypeCompte type= TypeCompte.ND;
		
	private HashMap<String,ArrayList<String>> actions = new HashMap<String, ArrayList<String>>();
	private static ArrayList<String> act = new ArrayList<String>();
	
	// -- STATIC
	private static Date aujourdhui = new Date();
	private static SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
	private static String date = formater.format(aujourdhui).toString();
	
	// CONSTRUCTOR
	public SkeletonCompte() {	
	}
	
	public SkeletonCompte(TypeCompte t) {
		this.type = t;
	}
	
	public SkeletonCompte(float a, TypeCompte t, String i) {
		this.argent = a;
		this.type = t;
		this.id = i;
		this.actions.put(date, act);
	}

	// GETTER AND SETTER
	/**
	 * @return the argent
	 */
	public float getArgent() {
		return argent;
	}

	/**
	 * @param argent the argent to set
	 */
	public void setArgent(float argent) {
		this.argent = argent;
	}

	/**
	 * @return the type
	 */
	public TypeCompte getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeCompte type) {
		this.type = type;
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
	 * @return the actions
	 */
	public HashMap<String,ArrayList<String>> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(HashMap<String,ArrayList<String>> actions) {
		this.actions = actions;
	}

	// METHODS
	public void depot(float depot) {
		if(this.actions.get(date)!=null) {
			act = this.actions.get(date);
		}
		act.add("Depot de "+depot);
		this.actions.put(date, act);
		this.argent += depot;
	}
	
	public void debit(float debit) {
		float deb = this.argent-debit;
		if(deb<0) {
			
		}else {
			this.argent = deb;
		}
	}
	
	abstract void taux();
}