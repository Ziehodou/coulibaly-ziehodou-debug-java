package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;


public class AnalyticsCounter {
		/**
		 * Object de type Map<String,Integer>
		 * 			Pour stocker la liste des symptoms triés
		 */
	private static Map<String,Integer> sortSymptom;
	
	public static void main(String args[]) throws Exception {
	
		
		ReadSymptomDataFromFile readerFile = new ReadSymptomDataFromFile("symptoms.txt");
		WriteSymptomDataToFile writeSymptom = new WriteSymptomDataToFile("result.out.txt");
		
		
		/** 
		 *   Recuperation des symptoms depuis le fichier
		 */
		
		List<String> listeSymptoms = readerFile.getSymptoms();
		
		/** 
		 *Retourne les symptoms tries  avec le nombre d'occurence de chaque symptoms
		 *dans une TreeMap dont la cle estr le symptom et la valeur son occurence
		 */
		sortSymptom= writeSymptom.sortSymptoms(listeSymptoms);
		/**
		 *  Générer le fichier de sortir result.out.txt
		 */
		writeSymptom.writeSymptoms(sortSymptom);
		
		/**
		 *  Affichage des symptoms dans la console
		 */
		writeSymptom.afficherSymptoms(sortSymptom);
		
	}
}
