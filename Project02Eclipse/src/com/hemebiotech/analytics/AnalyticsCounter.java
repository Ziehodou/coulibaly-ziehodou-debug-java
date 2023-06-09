package com.hemebiotech.analytics;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter {
		
	
	public ISymptomReader reader;
	public ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader readeur, ISymptomWriter writeur)
	{
		this.reader=readeur;
		this.writer = writeur;
	}
	
	public static void main(String args[]) throws Exception {
	
		
		ReadSymptomDataFromFile readerFile = new ReadSymptomDataFromFile("symptoms.txt");
		WriteSymptomDataToFile writeSymptom = new WriteSymptomDataToFile("result.out");
		
		
		/** 
		 *   Recuperation des symptoms depuis le fichier
		 * 
		 * 
		
		 */
		List<String> listeSymptoms = readerFile.getSymptoms();
		
		  writeSymptom.afficherSymptoms(listeSymptoms);
		
		
		// next generate output
			
			
			writeSymptom.setSymptoms(listeSymptoms);
		
		
	
		
	}
}
