package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter {
		
	private static Map<String,Integer> sortSymptom;
	
	public static void main(String args[]) throws Exception {
	
		
		ReadSymptomDataFromFile readerFile = new ReadSymptomDataFromFile("symptoms.txt");
		WriteSymptomDataToFile writeSymptom = new WriteSymptomDataToFile("result.out.txt");
		
		
		/** 
		 *   Recuperation des symptoms depuis le fichier
		 * 
		 * 
		
		 */
		
		List<String> listeSymptoms = readerFile.getSymptoms();
		
		
		 // writeSymptom.afficherSymptoms(listeSymptoms);
		
		/*
		 * Plymorphisme avec la methode sortSymptoms 
		 * qui prends comme arguemnt une Map mais retourne une TreeMap
		 */
		
		sortSymptom= writeSymptom.sortSymptoms(listeSymptoms);
		// next generate output
			
			
		writeSymptom.writeSymptoms(sortSymptom);
		
		// Affichage des symptoms dans la console
		writeSymptom.afficherSymptoms(sortSymptom);
		
	}
}
