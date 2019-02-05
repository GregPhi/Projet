package gestionnaire.creation;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import password.Password;
import password.Type;

public class Creator {
	// ATTRIBUTS
	private static SecureRandom random = new SecureRandom();
	private Password pwd = new Password();
	
	// CONSTRUCTOR
	public Creator() {
	}
	
	// GETTER AND SETTER
	/**
	 * @return the pwd
	 */
	public Password getPassword() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPassword(Password pwd) {
		this.pwd = pwd;
	}
	
	// METHODS
	public Password creation() {
		String mdp = "";
		String word = this.pwd.getType().toString();
		List<String> list = Arrays.asList(word.split(";"));
		for(int i = 0; i < this.pwd.getLength(); i++) {
			int idx = random.nextInt(list.size());
			mdp += list.get(idx);
		}
		this.pwd.setPwd(mdp);
		return this.pwd;
	}
		
	public static void main(String[] args) {
		System.out.println("Exemple de password généré");
		Creator c = new Creator();
		Password p1 = new Password(12);
		c.setPassword(p1);
		c.creation();
		System.out.println(c.getPassword().toString());
		Password p2 = new Password(8,Type.ALPHANUM);
		c.setPassword(p2);
		c.creation();
		System.out.println(c.getPassword().toString());
		Password p3 = new Password(8,Type.ALPHANUMWITHMAJ);
		c.setPassword(p3);
		c.creation();
		System.out.println(c.getPassword().toString());
		Password p4 = new Password(8,Type.ALPHANUMWITHMAJANDCARACT);
		c.setPassword(p4);
		c.creation();
		System.out.println(c.getPassword().toString());
	}
}
