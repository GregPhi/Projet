package aei.textual;

import java.util.ArrayList;
import java.util.List;

import aei.textual.calendrierAvent.CalendrierAventMain;
import aei.textual.membre.MembresMain;
import aei.textual.scanner.ListChoser;
import aei.textual.tombola.TombolaMain;

public class AEITextual {
	private static List<String> textual = new ArrayList<String>();

	// METHODS
	public static void initializeTextual() {
		textual.add(">> Membre");
		textual.add(">> Tombola");
		textual.add(">> Calendrier de l'Avent");
		textual.add(">> KILL");
	}
					
	// MAIN
	public static void main(String args[]) {
		initializeTextual();
		ListChoser lc = new ListChoser();
		String s = lc.chose("Quelle option voulez vous utiliser :", textual);
		switch(s) {
			case ">> Membre":
				MembresMain.main(null);
				break;
			case ">> Tombola":
				TombolaMain.main(null);
				break;
			case ">> Calendrier de l'Avent":
				CalendrierAventMain.main(null);
				break;
			case ">> KILL":
				System.exit(0);
		}
	}
}
