package aei.textual.membre;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aei.textual.AEITextual;
import aei.textual.Json;
import aei.textual.scanner.ListChoser;

public class MembresMain {
	private static List<String> textual = new ArrayList<String>();
	private static Scanner scan = new Scanner(System.in);
	
	public static void initializeMemb() {
		textual.clear();
		textual.add(">> Inscrire un nouveau membre");
		textual.add(">> Inscrire de nouveaux membres");
		textual.add(">> Chercher un membre");
		textual.add(">> Montrer les membres");
		textual.add(">> Gestion membres");
		textual.add(">> Supprimer un membre");
		textual.add(">> Retour");
	}
	
	public static void main(String[] args) {
		ListChoser lc = new ListChoser();
		initializeMemb();
		String s = lc.chose("Quelle option voulez vous utiliser :", textual);
		Json<Membres> json = new Json<Membres>();
		Membres membres = json.load(new File("./file/membres.json"),"Membres");
		switch(s) {
		case ">> Inscrire un nouveau membre":
			membres.newMembre();
			membres.gestionMembres();
			System.out.println(membres.getnbCotisation());
			json.write(new File("./file/membres.json"), membres);
			MembresMain.main(null);
			break;
		case ">> Inscrire de nouveaux membres":
			System.out.print("Nombre de membres : ");
			int i = scan.nextInt();
			membres.newMembres(i);
			membres.gestionMembres();
			json.write(new File("./file/membres.json"), membres);
			MembresMain.main(null);
			break;
		case ">> Chercher un membre":
			Membre membre = membres.identif();
			membres.search(membre);
			MembresMain.main(null);
			break;
		case ">> Montrer les membres":
			System.out.println(membres.toString());
			MembresMain.main(null);
			break;
		case ">> Gestion membres":
			membres.gestionMembres();
			json.write(new File("./file/membres.json"), membres);
			MembresMain.main(null);
			break;
		case ">> Supprimer un membre":
			System.out.println("> Nom du membre :");
			String nom = scan.nextLine();
			System.out.println("> Prenom du membre :");
			String prenom = scan.nextLine();
			Membre m = new Membre(nom, prenom, "", null, 0);
			membres.remove(m);
			membres.gestionMembres();
			json.write(new File("./file/membres.json"), membres);
			MembresMain.main(null);
			break;
		case ">> Retour":
			AEITextual.main(null);
			break;
		}
	}
}
