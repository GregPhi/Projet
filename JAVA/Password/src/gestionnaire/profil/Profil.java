package gestionnaire.profil;

import password.Password;

public class Profil {
	// ATTRIBUTS
	private String pseudo = "";
	private Password pwd;
	private Site site;
	
	// CONSTRUCTOR
	public Profil() {
	}

	// GETTER AND SETTER
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the pwd
	 */
	public Password getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(Password pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the site
	 */
	public Site getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(Site site) {
		this.site = site;
	}

}
