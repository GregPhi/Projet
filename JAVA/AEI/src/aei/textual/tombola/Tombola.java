package aei.textual.tombola;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Tombola implements Serializable{
	private static final long serialVersionUID = -3732292813403476011L;
	private static Scanner in = new Scanner(System.in);
	private static ObjectMapper map = new ObjectMapper();

	// ATTRIBUTS
	private Lots lots;
	private Participants participants;
	private HashMap<Lot,Participant> tombola = new HashMap<Lot,Participant>();
	
	// CONSTRUCTOR
	public Tombola() {
	}
	
	public Tombola(Lots l, Participants p) {
		this.lots = l;
		this.participants = p;
	}

	// GETTER AND SETTER
	/**
	 * @return the lots
	 */
	public Lots getLots() {
		return lots;
	}

	/**
	 * @param lots the lots to set
	 */
	public void setLots(Lots lots) {
		this.lots = lots;
	}

	/**
	 * @return the participants
	 */
	public Participants getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(Participants participants) {
		this.participants = participants;
	}
	
	/**
	 * @return the tombola
	 */
	public HashMap<Lot,Participant> getTombola() {
		return tombola;
	}

	/**
	 * @param tombola the tombola to set
	 */
	public void setTombola(HashMap<Lot,Participant> tombola) {
		this.tombola = tombola;
	}

	// METHODS
	public void addParticipant() {
		System.out.println("Nouveau Participant");
		System.out.println("> Nom :");
		String nom = in.nextLine();
		System.out.println("> Prenom :");
		String prenom = in.nextLine();
		System.out.println("> Case :");
		String cas = in.nextLine();
		while(this.participants.getCasUse().contains(cas)) {
			System.out.println("> Case :");
			cas = in.nextLine();
		}
		Participant par = new Participant(nom, prenom,cas);
		this.participants.add(par);
		this.participants.getCasUse().add(cas);
		try {
			map.writeValue(new File("./file/participants.json"), this.participants);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addParticipants(int nb) {
		for(int i = 0; i < nb; i++) {
			this.addParticipant();
		}
	}
	
	public void removeParticipant(Participant par) {
		this.participants.remove(par);
	}
	
	public void removeLot(Lot lot) {
		this.lots.remove(lot);
	}
	
	/**
	 * Toujours ajouter un lot de la derniere place a la premiere
	 */
	public void addLot() {
		System.out.println("Nouveau Lot");
		System.out.println("> Nom :");
		String nom = in.nextLine();
		System.out.println("> Place :");
		String place = in.nextLine();
		Lot lot = new Lot(nom, place);
		this.lots.add(lot);
		try {
			map.writeValue(new File("./file/lots.json"), this.lots);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addLots(int nb) {
		for(int i = 0; i < nb; i++) {
			this.addLot();
		}
	}
	
	public void tirage(int index) {
		int nbParti = this.participants.getList().size();
		Random rand = new Random(); 
		int nombreAleatoire = rand.nextInt(nbParti - 1);
		Participant parti = this.participants.getList().get(nombreAleatoire);
		Lot lot = this.lots.getList().get(index);
		this.tombola.put(lot, parti);
		this.participants.remove(parti);
	}
	
	public void tombola() {
		if(!this.participants.checkAllParticipant()) {
			System.exit(0);
		}
		
		for(int i = 0; i <  this.lots.getList().size(); i++) {
			this.tirage(i);
		}
		
		System.out.println("Gagnants du tirage :");
		for(Lot lot : this.tombola.keySet()) {
			System.out.println("-> "+lot.getPrenom()+" } "+this.tombola.get(lot).toString()+" gagne : "+lot.getNom());
		}
	}
	
	public void displayParticipant() {
		this.participants.display();
	}
	
	public void displayLot() {
		this.lots.display();
	}
}
