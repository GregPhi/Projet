package actions;

import client.SkeletonClient;
import compte.SkeletonCompte;
import scanner.ListChoser;

public class DebitAction extends SkeletonAction{

	public DebitAction() {
		super("debit");
	}

	@Override
	void action(SkeletonClient client) {
		ListChoser lc = new ListChoser();
		SkeletonCompte sCompte = lc.chose("Choississez le compte a débiter ;", client.getComptes());
		
	}
}
