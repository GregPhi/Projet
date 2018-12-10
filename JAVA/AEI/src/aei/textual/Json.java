package aei.textual;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import aei.textual.calendrierAvent.Winner;
import aei.textual.skeleton.SkeletonListMembre;

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
	public S load(File json, Class<S> clas) {
		try {
			return map.readValue(json, clas);
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
	
	public void writeWinner(File json, Winner list) {
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
