package aei.textual.calendrierAvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import aei.textual.membre.Membre;
import aei.textual.membre.Membres;

public class CalendrierAvent{
	
	// ATTRIBUTS
	private CalendrierMembres calMembres = new CalendrierMembres();
	private Membres membres = new Membres();
	private Winner winner = new Winner();
	
	private static ObjectMapper map = new ObjectMapper();
	private static Scanner scan = new Scanner(System.in);
	
	private int nbOfWinner = 2;
	
	// CONSTRUCTOR
	public CalendrierAvent() {
		
	}
	
	// GETTER AND SETTER
	public CalendrierMembres getCalMembres() {
		return this.calMembres;
	}
	
	public void setCalMembres(CalendrierMembres m) {
		this.calMembres = m;
	}
	
	/**
	 * @return the membres
	 */
	public Membres getMembres() {
		return membres;
	}

	/**
	 * @param membres the membres to set
	 */
	public void setMembres(Membres membres) {
		this.membres = membres;
	}

	public Winner getWinner(){
		return this.winner;
	}
	
	public void setWinner(Winner w) {
		this.winner = w;
	}
	
	public int getNbOfWinner() {
		return this.nbOfWinner;
	}
	
	public void setbOfWinner(int n) {
		this.nbOfWinner = n;
	}	
		
	// METHODS
	/**
	 * Affiche les instrcutions
	 */
	public void instruction() {
		System.out.println("*   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   *");
		System.out.println("|           Lancement du programme : Calendrier de l'Avent          |");
		System.out.println("|                                                                   |");
		System.out.println("| Chaque jour, 2 membres sont tires au sort et sont stockes dans un |");
		System.out.println("| fichier.                                                          |");
		System.out.println("|                                                                   |");
		System.out.println("| Les participants doivent etre obligatoirement membre de l'AEI,    |");
		System.out.println("| les participants seront identifie grace a leur nom et prenom,     |");
		System.out.println("| indiquant s'il gagne un lot ou non.                               |");
		System.out.println("|                                                                   |");
		System.out.println("| Le nom et le prenom du participant devront etre ecrit sans        |");
		System.out.println("| majuscules et accent !                                            |");
		System.out.println("|                                                                   |");
		System.out.println("|                            Bon jeu !                              |");
		System.out.println("|                                                                   |");
		System.out.println("|                           Joyeux Noel                             |");
		System.out.println("*   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   *");
	}
			
	public void winnerJson() {
		File winnerFile = new File("./file/winner.json");
		Date aujourdhui = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		String date = formater.format(aujourdhui).toString();
		if(winnerFile.exists()) {
			if(!this.winner.getDate().equals(date)) {
				this.winner(winnerFile, date);
			}
		}else {
			try {
				winnerFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.winner(winnerFile, date);
		}
	}
	
	public void winner(File file, String date) {
		FileWriter f;
		try {
			f = new FileWriter("./file/calendrier.txt",true);
			f.write("Date : "+date+"\n");
			f.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.tirageWinner(file, date);
	}
	
	public void tirageWinner(File json, String date) {
		Random rand = new Random();
		int nombreAleatoire = 0;
		CalendrierMembres winner = new CalendrierMembres();
		CalendrierMembres pasMbWin = new CalendrierMembres();
		FileWriter f;
		for(int i = 0; i < this.nbOfWinner; i++) {
			nombreAleatoire = rand.nextInt(this.calMembres.size()-1);
			CalendrierMembre calMb = calMembres.getList().get(nombreAleatoire);
			while(!membres.contains(new Membre(calMb.getNom(), calMb.getPrenom()))) {
				try {
					f = new FileWriter("./file/calendrier.txt",true);
					f.write(calMb.toString()+" pas membre asso !");
					f.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				pasMbWin.add(calMb);
				calMembres.getList().remove(nombreAleatoire);
				nombreAleatoire = rand.nextInt(this.calMembres.size()-1);
				calMb = calMembres.getList().get(nombreAleatoire);
			}
			winner.add(calMb);
			pasMbWin.add(calMb);
			calMembres.getList().remove(nombreAleatoire);
			try {
				f = new FileWriter("./file/calendrier.txt",true);
				f.write(calMb.toString()+" pas membre asso !");
				f.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.resetMembres(pasMbWin);
		this.winner.setDate(date);
		this.winner.getWin().put(date, winner);
		try {
			map.writeValue(json, this.winner);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Tirage des gagnants !");
	}
	
	public void resetMembres(CalendrierMembres reset) {
		for(CalendrierMembre m : reset.getList()) {
			if(!this.calMembres.contains(m)) {
				this.calMembres.add(m);
			}
		}
	}
		
	public CalendrierMembre identif() {
		System.out.println("Identifiant :");
		System.out.println("> Nom [sans majuscule ni accents] ");
		String nom = scan.nextLine();
		System.out.println("> Prenom [sans majuscule ni accents] ");
		String prenom = scan.nextLine();
		CalendrierMembre membre = new CalendrierMembre();
		membre.setNom(nom);
		membre.setPrenom(prenom);
		return membre;
	}
	
	public void tirage() {
		CalendrierMembre calM = this.identif();
		Membre membre = new Membre(calM.getNom(),calM.getPrenom());
		if(this.membres.contains(membre)) {
			if(this.calMembres.contains(calM)) {
				if(this.winner.contains(calM)) {
					System.out.println(calM.toString()+" WINNER !");
				}else {
					System.out.println(calM.toString()+" LOOSER !");
				}
			}else {
				System.out.println(calM.toString()+" ne fait pas parti des participants !");
			}
		}else {
			System.out.println(calM.toString()+" n'est pas membre de l'association !");
		}	
	}
	
	public void tirages(int nb) {
		for(int i = 0; i < nb; i++) {
			this.tirage();
		}
	}
	
	public void afficherGagnants() {
		System.out.println("Gagnants du Calendrier de l'Avent :");
		HashMap<String, CalendrierMembres> win = this.winner.getWin();
		for(String key : win.keySet()) {
			System.out.println("Date : "+key);
			win.get(key).display();
		}
	}
}
