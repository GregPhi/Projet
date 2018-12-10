package actions;

import client.SkeletonClient;

public abstract class SkeletonAction {
/**
 * -> débit
 * -> crédit
 * -> taux
 * -> 
 */
	
	// ATTRIBUTS
	/* nom de l'action */
	private String action;
	
	// CONSTRUCTOR
	/**
	 * Cree une action
	 * @param a : (type-String) nom de l'action
	 */
	public SkeletonAction(String a) {
		this.setAction(a);
	}

	// GET AND SET
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	// METHODS
	@Override
	public String toString() {
		return "Action realisee : "+this.action;
	}
	
	/**
	 * Execute le type de l'action, sur le <code>client</code> mis en parametre
	 * @param client : (type-String) client 
	 */
	abstract void action(SkeletonClient client);
}
