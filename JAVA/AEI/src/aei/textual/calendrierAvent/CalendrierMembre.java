package aei.textual.calendrierAvent;

import aei.textual.skeleton.SkeletonMembre;

public class CalendrierMembre extends SkeletonMembre{
	private String formation = "";
	
	public CalendrierMembre() {
	}
	
	public CalendrierMembre(String n, String p) {
		super(n,p);
	}
	
	public CalendrierMembre(String n, String p , String f) {
		super(n,p);
		this.formation = f;
	}

	/**
	 * @return the formation
	 */
	public String getFormation() {
		return formation;
	}

	/**
	 * @param formation the formation to set
	 */
	public void setFormation(String formation) {
		this.formation = formation;
	}
}
