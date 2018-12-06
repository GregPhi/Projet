package aei.textual.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMD {
	// CONSTRUCTOR
	public CMD(){
	}
	
	// ATTRIBUTS
	/**
	 * Execute the command (use to retrieve information from candidates from the server)
	 * @param command : (type-String) command executed 
	 */
	public void startCMD(String command){
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while((line=r.readLine())!=null){
				System.out.println(line);
			}
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
