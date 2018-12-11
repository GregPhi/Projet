package compte;

public class SkeletonCompte {
/**
 * -> argent actuel
 * -> actions réalisables ?
 * -> taux ?
 * -> type de compte
 * -> id compte
 * -> 
 */
	
	// ATTRIBUTS
	private float argent;
		
	private TypeCompte type;
	
	private String id;
	
	// CONSTRUCTOR
	public SkeletonCompte() {
		
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
	
	
}
