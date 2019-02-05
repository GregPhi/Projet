package password;

public enum Type {
	// ATTRIBUTS
	NUM ("0;1;2;3;4;5;6;7;8;9"),
	ALPHA ("a;b;c;d;e;f;g;h;i;j;k;l;m;n;o;p;q;r;s;t;u;v;w;x;y;z"),
	ALPHAMAJ ("A;B;C;D;E;F;G;H;I;J;K;L;M;N;O;P;Q;R;S;T;U;V;W;S;Y;Z"),

	CARACTSPE ("&;~;#;@;ǿ;$;£;*;µ"),
	
	ALPHAWITHMAJ (ALPHA+";"+ALPHAMAJ),
	ALPHAWITHMAJANDCARACT (ALPHAWITHMAJ+";"+CARACTSPE),
	
	ALPHANUM (NUM+";"+ALPHA),
	ALPHANUMWITHMAJ (ALPHANUM+";"+ALPHAMAJ),
	ALPHANUMWITHMAJANDCARACT (ALPHANUMWITHMAJ+";"+CARACTSPE);
	
	private final String type;
	
	// CONSTRUCTOR
	private Type(String t) {
		this.type = t;
	}
	
	// METHODS	
	@Override
	public String toString() {
		return this.type;
	}
	
	//public static void main(String[] args) {	}
}
