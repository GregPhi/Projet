package compte;

import java.util.ArrayList;
import java.util.List;

public class SkeletonComptes {
	// ATTRIBUTS
	private List<SkeletonCompte> comptes = new ArrayList<SkeletonCompte>();
	
	// CONSTRUCTOR
	public SkeletonComptes() {
		
	}

	// GETTER AND SETTER
	/**
	 * @return the comptes
	 */
	public List<SkeletonCompte> getComptes() {
		return comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(List<SkeletonCompte> comptes) {
		this.comptes = comptes;
	}
	
	// METHODS
	public void add(SkeletonCompte compte) {
		if(!this.contain(compte)) {
			this.comptes.add(compte);
		}
	}
	
	public boolean contain(SkeletonCompte compte) {
		for(SkeletonCompte c : this.comptes) {
			if(c.getId().equals(compte.getId()) && c.getType().equals(compte.getType())){
				return true;
			}
		}
		return false;
	}
}
