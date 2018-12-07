package aei.textual.tombola;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aei.textual.AEITextual;
import aei.textual.Json;
import aei.textual.scanner.ListChoser;

public class TombolaMain {
	private static List<String> textual = new ArrayList<String>();
	private static Scanner scan = new Scanner(System.in);
	
	public static void initializeTomb() {
		textual.clear();
		textual.add(">> Ajouter un nouveau participant");
		textual.add(">> Ajouter de nouveaux participants");
		textual.add(">> Chercher un participant");
		textual.add(">> Montrer les participants");
		textual.add(">> Ajouter un lot");
		textual.add(">> Ajouter de nouveaux lots");
		textual.add(">> Afficher les lots");
		textual.add(">> Tirage");	
		textual.add(">> Supprimer un participant");
		textual.add(">> Supprimer un lot");
		textual.add(">> Retour");
	}
	
	public static void main(String[] args) {
		ListChoser lc = new ListChoser();
		initializeTomb();
		String s = lc.chose("Quelle option voulez vous utiliser :", textual);
		Json<Lots> jsonL = new Json<Lots>();
		Json<Participants> jsonP = new Json<Participants>();
		Lots lots = jsonL.load(new File("./file/lots.json"), "Lots");
		Participants participants = jsonP.load(new File("./file/participants.json"), "Participants");
		Tombola tombola = new Tombola();
		tombola.setLots(lots);
		tombola.setParticipants(participants);
		int i = 0;
		Participant participant = new Participant();
		switch(s) {
			case ">> Ajouter un nouveau participant":
				tombola.addParticipant();
				TombolaMain.main(null);
				break;
			case ">> Ajouter de nouveaux participants":
				System.out.print("Nombre de participants :");
				i = scan.nextInt();
				tombola.addParticipants(i);
				TombolaMain.main(null);
				break;
			case ">> Chercher un participant":
				participant = tombola.getParticipants().identif(Participant.class);
				tombola.getParticipants().search(participant);
				TombolaMain.main(null);
				break;
			case ">> Montrer les participants":
				tombola.displayParticipant();
				TombolaMain.main(null);
				break;
			case ">> Ajouter un lot":
				tombola.addLot();
				TombolaMain.main(null);
				break;
			case ">> Ajouter de nouveaux lots":
				i = scan.nextInt();
				tombola.addLots(i);
				TombolaMain.main(null);
				break;
			case ">> Afficher les lots":
				tombola.displayLot();
				TombolaMain.main(null);
				break;
			case ">> Tirage":
				tombola.tombola();
				TombolaMain.main(null);
				break;
			case ">> Supprimer un participant":
				System.out.println("> Nom du participan :");
				String nom = scan.nextLine();
				System.out.println("> Prenom du participant :");
				String prenom = scan.nextLine();
				participant = new Participant(nom, prenom);
				tombola.removeParticipant(participant);
				TombolaMain.main(null);
				break;
			case ">> Supprimer un lot":
				System.out.println("> Nom du lot :");
				nom = scan.nextLine();
				System.out.println("> Place du lot :");
				prenom = scan.nextLine();
				Lot lot = new Lot(nom, prenom);
				tombola.removeLot(lot);
				TombolaMain.main(null);
				break;
			case ">> Retour":
				AEITextual.main(null);
				break;
		}
	}
}
