package aei.textual;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import aei.textual.calendrierAvent.CalendrierMembres;
import aei.textual.calendrierAvent.Winner;
import aei.textual.membre.Membres;
import aei.textual.skeleton.SkeletonListMembre;
import aei.textual.tombola.Lots;
import aei.textual.tombola.Participants;

public class Json<S extends SkeletonListMembre<?>> {	
	// ATTRIBUTS
	private ObjectMapper map = new ObjectMapper();
	
	// CONSTRUCTOR
	/**
	 * Cree JSON
	 */
	public Json() {
	}
	
	// METHODS
	@SuppressWarnings("unchecked")
	public S load(File json, String clas) {
		try {
			if(clas.equals("Membres")) {
				return (S) map.readValue(json, Membres.class);	
			}
			if(clas.equals("CalendrierMembres")) {
				return (S) map.readValue(json, CalendrierMembres.class);
			}
			if(clas.equals("Lots")) {
				return (S) map.readValue(json, Lots.class);
			}
			if(clas.equals("Participants")) {
				return (S) map.readValue(json, Participants.class);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void write(File json, S list) {
		try {
			map.writeValue(json, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Winner loadWinner() {
		try {
			return map.readValue(new File("./file/winner.json"), Winner.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 	public void loadTombola(File json) {
		if(json.exists()) {
			ObjectMapper map = new ObjectMapper();
			try {
				this.tombola = map.readValue(json, Tombola.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			this.tombola = new Tombola();
		}
	}
	
	public void writeTombola(File json) {
		ObjectMapper map = new ObjectMapper();
		try {
			map.writeValue(json, this.tombola);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 */
}
