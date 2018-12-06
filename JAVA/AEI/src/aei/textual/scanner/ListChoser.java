package aei.textual.scanner;

import java.util.*;

import aei.textual.scanner.ScannerInt;

public class ListChoser {
	/**
	 * Return the element chose in a list
	 * @param msg : (type-String) message to show what your choose
	 * @param l : (type-List) list in which one of its elements
	 * @return : (type-T)
	 */
	public <T> T chose(String msg, List<T> l){
		System.out.println();
		System.out.println(msg);
		if(l.size()<2){
			System.out.println("Votre seul choix est :");
		}else{
			System.out.println("Vous avez "+l.size()+" choix :");
		}
		for(Object o : l){
			System.out.println(l.indexOf(o)+1 +" - "+o.toString());
		}
		int choice = ScannerInt.readInt(l.size()+1);
		System.out.println();
		if(choice < 0){
			return null;
		}else{
			return l.get(choice-1);
		}
	}
}
