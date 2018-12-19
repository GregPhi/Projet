package scanner;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import client.SkeletonClient;

public class Json {	
	// ATTRIBUTS
	private ObjectMapper map = new ObjectMapper();
	
	// CONSTRUCTOR
	/**
	 * Cree JSON
	 */
	public Json() {
	}
	
	// METHODS
	public SkeletonClient load(File json) {
		try {
			return map.readValue(json, SkeletonClient.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void write(File json, SkeletonClient list) {
		try {
			map.writeValue(json, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
