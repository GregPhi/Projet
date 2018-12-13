package aei.textual.calendrierAvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aei.textual.AEITextual;
import aei.textual.Json;
import aei.textual.membre.Membres;
import aei.textual.scanner.ListChoser;

public class CalendrierAventMain {
	private static List<String> textual = new ArrayList<String>();
	private static Scanner scan = new Scanner(System.in);
	
	public static void initializeCal() {
		textual.clear();
		textual.add(">> Chercher un participant");
		textual.add(">> Tirage");
		textual.add(">> Tirage pour une personne");
		textual.add(">> Tirage pour n personnes");
		textual.add(">> Afficher les gagnants");
		textual.add(">> Retour");
	}
	
	public static void main(String[] args) {
		ListChoser lc = new ListChoser();
		initializeCal();
		String s = lc.chose("Quelle option voulez vous utiliser :", textual);
		CalendrierAvent calendrier = new CalendrierAvent();
		Json<CalendrierMembres> jsonCal = new Json<CalendrierMembres>();
		Json<Membres> jsonMembres = new Json<Membres>();
		calendrier.setCalMembres(jsonCal.load(new File("./file/calendrier.json"), CalendrierMembres.class));
		calendrier.setMembres(jsonMembres.load(new File("./file/membres.json"), Membres.class));
		calendrier.setWinner(jsonMembres.loadWinner());
		calendrier.winnerJson();
		calendrier.instruction();
		switch(s) {
			case ">> Chercher un participant":
				CalendrierMembre membre = calendrier.getCalMembres().identif(CalendrierMembre.class);
				calendrier.getCalMembres().search(membre);
				CalendrierAventMain.main(null);
				break;
			case ">> Tirage":
				calendrier.winnerJson();
				CalendrierAventMain.main(null);
				break;
			case ">> Tirage pour une personne":
				calendrier.tirage();
				CalendrierAventMain.main(null);
				break;
			case ">> Tirage pour n personnes":
				System.out.print("Nombre de tirage :");
				int i = scan.nextInt();
				calendrier.tirages(i);					
				CalendrierAventMain.main(null);
				break;
			case ">> Afficher les gagnants":
				calendrier.afficherGagnants();
				CalendrierAventMain.main(null);
				break;
			case ">> Retour":
				AEITextual.main(null);
				break;
		}
	}
}
