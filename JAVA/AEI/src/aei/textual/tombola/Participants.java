package aei.textual.tombola;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import aei.textual.Json;
import aei.textual.membre.Membre;
import aei.textual.membre.Membres;
import aei.textual.skeleton.SkeletonListMembre;

public class Participants extends SkeletonListMembre<Participant> {
	// ATTRIBUTS
	private List<String> casUse = new ArrayList<String>();
	
	// CONSTRUCTOR
	public Participants() {
		
	}
	
	public Participants(ArrayList<Participant> parti) {
		super(parti);
	}
	
	// GETTER AND SETTER
	/**
	 * @return the casUse
	 */
	public List<String> getCasUse() {
		return casUse;
	}

	/**
	 * @param casUse the casUse to set
	 */
	public void setCasUse(List<String> casUse) {
		this.casUse = casUse;
	}

	// METHODS
	@Override
	public void add(Participant par) {
		Json<Membres> json = new Json<Membres>();
		Membres membres = json.load(new File("./file/membres.json"), "Membres");
		if(!this.getList().contains(par)) {
			if(!this.checkParticipants(membres, par.getNom(), par.getPrenom())) {
				membres = this.newMembre(membres);
			}
			this.getList().add(par);
		}
	}
		
	public boolean checkAllParticipant() {
		boolean bool = true;
		Json<Membres> json = new Json<Membres>();
		Membres membres = json.load(new File("./file/membres.json"),"Membres");
		membres.gestionMembres();
		if(this.getList().size()>membres.getnbMembre()) {
			return false;
		}
		for(Participant p : this.getList()) {
			if(!this.checkParticipants(membres, p.getNom(), p.getPrenom())) {
				bool = false;
				continue;
			}
		}
		return bool;
	}
	
	public boolean checkParticipants(Membres membres, String nom, String prenom) {
		for(Membre m : membres.getList()) {
			System.out.println(nom+"-"+prenom+" ||| "+m.getNom()+"-"+m.getPrenom());
			if(nom.equals(m.getNom()) && prenom.equals(m.getPrenom())) {
				System.out.println("Le participant est bien membre de l'AEI !");
				return true;
			}else {
				System.out.println("Le participant n'est pas membre de l'AEI !");
			}
		}
		return false;
	}
	
	public Membres newMembre(Membres membres) {
		membres.newMembre();
		Json<Membres> json = new Json<Membres>();
		json.write(new File("./file/membres.json"),membres);
		return membres;
	}
	
	public void gestionCaseUse() {
		for(Participant p : this.getList()) {
			if(!this.casUse.contains(p.getCas())){
				this.casUse.add(p.getCas());
			}
		}
	}
}
