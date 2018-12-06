package aei.textual.calendrierAvent;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Winner implements Serializable{
	private static final long serialVersionUID = -3748518252232161638L;
	
	// ATTRIBUTS
	private HashMap<String, CalendrierMembres> win = new HashMap<String, CalendrierMembres>();
	private String date;
	
	// CONSTRUCTOR
	public Winner() {
		Date aujourdhui = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		this.date = formater.format(aujourdhui).toString();
	}

	// GETTER AND SETTER
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the win
	 */
	public HashMap<String, CalendrierMembres> getWin() {
		return win;
	}

	/**
	 * @param win the win to set
	 */
	public void setWin(HashMap<String, CalendrierMembres> win) {
		this.win = win;
	}

	//METHODS
	public boolean contains(CalendrierMembre membre) {
		CalendrierMembres membres = this.win.get(this.date);
		for(CalendrierMembre m : membres.getList()) {
			if(membre.getNom().toLowerCase().equals(m.getNom().toLowerCase()) && membre.getPrenom().toLowerCase().equals(m.getPrenom().toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
