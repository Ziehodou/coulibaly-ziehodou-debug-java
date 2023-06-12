package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implemente l'interface ISymptomReader
 * @author Ziehodou
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param cheminFichier a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String cheminFichier) {
		this.filepath = cheminFichier;
	}
	
	@Override
	/**
	 *  Mettre tous les symptoms dans une liste,
	 * cette fonction retourne la liste des symptoms contenus dans le fichier
	 * @return result, la liste des symptoms recuperes depuis le fichier des symptoms
	 * @throws IOException, quand le fichier des symptoms est introuvable
	 */	public List<String> getSymptoms() {
		 
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) 
		{
			try {
					BufferedReader reader = new BufferedReader (new FileReader(this.filepath));
					String line = reader.readLine();
				
					while (line != null)
					{
						result.add(line);
						line = reader.readLine();
					}
					reader.close();
				} catch (IOException e)
			
				{
					e.printStackTrace();
				}
		}
		
		return result;
	}
	
	
	

}
