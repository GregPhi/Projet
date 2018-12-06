package aei;

import java.util.ArrayList;
import java.util.List;

import aei.graphical.AEIGraphical;
import aei.textual.AEITextual;
import aei.textual.scanner.ListChoser;

public class Main 
{
	private static List<String> textual = new ArrayList<String>();
	
	public static List<String> textualForm() {
		textual.clear();
		textual.add(">> Textual");
		textual.add(">> Graphical");
		return textual;
	}
		
    public static void main( String[] args )
    {
    	ListChoser lc = new ListChoser();
		String s = lc.chose("Quelle option voulez vous utiliser :", textualForm());
		switch(s) {
			case ">> Textual":
				AEITextual.main(null);
				break;
			case ">> Graphical":
				AEIGraphical.main(null);
				break;
		}
    }
}
