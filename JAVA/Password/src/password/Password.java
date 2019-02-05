package password;

public class Password {
	// ATTRIBUTS
	private int length = 2;
	private Type type = Type.NUM;
	private String pwd = "";
	
	// CONSTRUCTOR
	public Password() {
	}
	
	public Password(int l) {
		this.length = l;
	}
	
	public Password(int l, Type t) {
		this.length = l;
		this.type = t;
	}

	// GETTER AND SETTER
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "Longueur : "+this.length+" | Mot de passe : "+this.pwd;
	}
}
