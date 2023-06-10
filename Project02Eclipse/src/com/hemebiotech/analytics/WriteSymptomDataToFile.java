package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import com.hemebiotech.analytics.ReadSymptomDataFromFile;


/**
 * 
 * @author Ziehodou
 * Implementation de l'interface ISymptomWriter
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	
	
	private String pathFileWriter;
	
	
	public WriteSymptomDataToFile()
	{
		
	}
	public WriteSymptomDataToFile(String cheminFichier)
	{
		this.pathFileWriter = cheminFichier;
	}

	
	/**
	 * Ecrit les donn�es dans le fichier
	 * @param listeSymptom
	 * 
	 * @void
	 */
	
	public void writeSymptoms(Map<String,Integer> symptoms)
	{
		
		try
		{
			//FileWriter writer = new FileWriter(this.pathFile);
			BufferedWriter writer =new BufferedWriter(new FileWriter(this.pathFileWriter));
			
			
			
			
			//TreeMap<String, Integer> tmp = this.sortSymptoms(symptoms);
			
			//Set<String>listeTriee = tmp.keySet();
			
			Set<String>listeTriee = symptoms.keySet();
			
			
			for(String element : listeTriee)
			{
				writer.write(element+": "+"nombre ocurence:"+" "+symptoms.get(element)+","+"\n");
			}
			 writer.close();
			 
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Cette fonction trie la liste des symptoms 
	 * puis range la liste par ordre alphabetique avec la collection TreeMap
	 * @param List<String> liste 
	 * @return a treeMap Objet listeTriee // Liste des symptoms triés
	 */
	
	public TreeMap<String, Integer> sortSymptoms(List<String> liste)
	{
		TreeMap<String, Integer>listeTriee = new TreeMap<>();
		
		 String varIntermediaire;
		 int symptomCount=0;
		
		for(String symptom:liste)
		{
			 varIntermediaire=symptom;
			 symptomCount=0;
			 
			 for(String symptoms:liste)
				{
				 
				     if(varIntermediaire.equals(symptoms))
				         {
				               symptomCount++;	
					 
				         }
					
				}
			    listeTriee.put(varIntermediaire,symptomCount);
			
			 
			
		 }
		
		   return listeTriee;
	  }
	
	/**
	 * 
	 * qui affiche les symptoms dans la console
	 */
	public void afficherSymptoms(Map<String, Integer> tmp)
	{
			
		//TreeMap<String, Integer> tmp =this.trierListeSymptoms(liste);
		
		Set<String>listeTriee = tmp.keySet();
		
		for(String listS:listeTriee)
		{
			 
			System.out.println("symptom from file:"+ " "+listS+": " +"occurence : "+tmp.get(listS));
		}
		 
	}
	
	
}