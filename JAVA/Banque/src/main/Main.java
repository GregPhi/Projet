package main;

import java.io.File;

import client.SkeletonClient;
import compte.CompteCourant;
import compte.SkeletonComptes;
import scanner.Json;

public class Main {
	public static void main(String[] args) {
		Json json = new Json();
		SkeletonClient client = new SkeletonClient("TestNom", "TestPrenom", "IDCLIENT", 18);
		SkeletonComptes comptes = new SkeletonComptes();
		CompteCourant courant = new CompteCourant(100,"ID");
		courant.depot(100);
		comptes.add(courant);
		client.setComptes(comptes);
		json.write(new File("./file/client.json"), client);
	}
}
