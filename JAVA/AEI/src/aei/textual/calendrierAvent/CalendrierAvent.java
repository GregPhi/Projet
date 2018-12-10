package aei.textual.calendrierAvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import aei.textual.Json;
import aei.textual.membre.Membre;
import aei.textual.membre.Membres;

public class CalendrierAvent{
	
	// ATTRIBUTS
	private CalendrierMembres calMembres = new CalendrierMembres();
	private Membres membres = new Membres();
	private Winner winner = new Winner();
		
	private static Date aujourdhui = new Date();
	private static SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
	private static String date = formater.format(aujourdhui).toString();
	
	private static File winnerFile = new File("./file/winner.json");
	private static Json<CalendrierMembres> json = new Json<CalendrierMembres>();
	
	private int nbOfWinner = 2;
	
	// CONSTRUCTOR
	public CalendrierAvent() {
	}
	
	// GETTER AND SETTER
	/**
	 * @return the calMembres
	 */
	public CalendrierMembres getCalMembres() {
		return this.calMembres;
	}
	
	/**
	 * @param m the calMembres to set
	 */
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

	/**
	 * @return the winners
	 */
	public Winner getWinner(){
		return this.winner;
	}
	
	/**
	 * @param w the winner to set
	 */
	public void setWinner(Winner w) {
		this.winner = w;
	}
	
	/**
	 * @return the nbOfWinner
	 */
	public int getNbOfWinner() {
		return this.nbOfWinner;
	}
	
	/**
	 * @param n the nbOfWinner to set
	 */
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
	
	/**
	 * Charge les gagnants du jour ou lance le tirage
	 */
	public void winnerJson() {
		if(winnerFile.exists()) {
			if(!this.winner.getDate().equals(date)) {
				this.winner(); // le tirage n'a pas ete effectue aujourd'hui
			}
		}else {
			// creer le fichier contenant les infos des gagnants 
			try {
				winnerFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.winner();
		}
	}
	
	/**
	 * Creer le fichier contenant les non membres gagnants puis lancer le tirage des gagnants
	 */
	public void winner() {
		FileWriter f; // fichier contenant les gagnants n'appartenant pas a l'asso
		try {
			f = new FileWriter("./file/calendrier.txt",true);
			f.write("Date : "+date+"\n");
			f.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.tirageWinner();
	}
	
	/**
	 * Lance le tirage des gagnants
	 */
	public void tirageWinner() {
		Random rand = new Random();
		int nombreAleatoire = 0;
		CalendrierMembres winner = new CalendrierMembres(); // gagnants
		CalendrierMembres pasMbWin = new CalendrierMembres(); // gagnants deja tire et gagnants non membre
		FileWriter f;
		for(int i = 0; i < this.nbOfWinner; i++) {
			nombreAleatoire = rand.nextInt(this.calMembres.size()-1);
			CalendrierMembre calMb = calMembres.getList().get(nombreAleatoire); // recupere le gagnant
			while(!membres.contains(new Membre(calMb.getNom(), calMb.getPrenom()))) { // tant que le gagnant tire n'est pas membre {
				try {
					f = new FileWriter("./file/calendrier.txt",true);
					f.write(calMb.toString()+" pas membre asso !\n"); // on écrit ses infos dans un fichier, pour un suivi
					f.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				pasMbWin.add(calMb); // ajoute le non membre
				calMembres.getList().remove(nombreAleatoire); // suppression du non membre
				nombreAleatoire = rand.nextInt(this.calMembres.size()-1); // retire un membre au hasard
				calMb = calMembres.getList().get(nombreAleatoire); // recupere le nouveau gagnant
			}
			winner.add(calMb); // ajout du gagnant à la liste des gagnants
			pasMbWin.add(calMb); // ajout du gagnant à la liste auxiliaire
			calMembres.getList().remove(nombreAleatoire); // suppression du gagnant
		}
		this.calMembres = json.load(new File("./file/calendrier.json"), CalendrierMembres.class);
		this.winner.setDate(date);
		this.winner.getWin().put(date, winner);
		json.writeWinner(winnerFile, this.winner);
		System.out.println("Tirage des gagnants !");
	}
	
	public void resetMembres(CalendrierMembres reset) {
		for(CalendrierMembre m : reset.getList()) {
			if(!this.calMembres.contains(m)) {
				this.calMembres.add(m);
			}
		}
	}
			
	public void tirage() {
		CalendrierMembre calM = this.calMembres.identif(CalendrierMembre.class);
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
