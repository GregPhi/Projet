package compte;

public class CompteCourant extends SkeletonCompte{
	public CompteCourant() {
		super(TypeCompte.CC);
	}
	
	public CompteCourant(float argent, String id) {
		super(argent, TypeCompte.CC, id);
	}

	@Override
	public void taux() {
	}
}
