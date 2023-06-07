package com.hemebiotech.analytics;

import java.util.List;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;


/**
 * 
 * @author Ziehodou
 * Implementation de l'interface ISymptomWriter
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	
	
	private String pathFile;
	
	
	public WriteSymptomDataToFile()
	{
		
	}
	public WriteSymptomDataToFile(String cheminFichier)
	{
		this.pathFile = cheminFichier;
	}

	
	/**
	 * Ecrit les donn�es dans le fichier
	 * @param listeSymptom
	 * 
	 * @void
	 */
	
	public void setSymptoms(List<String> listeSymptom)
	{
		
		try
		{
			//FileWriter writer = new FileWriter(this.pathFile);
			BufferedWriter writer =new BufferedWriter(new FileWriter(this.pathFile));
			
			TreeMap<String, Integer> tmp = this.trierListeSymptoms(listeSymptom);
			
			Set<String>listeTriee = tmp.keySet();
			
			/** 
			 * Ecris les symptoms triés et classés par ordre 
			 * alphabetique dans le fichioer $this.pathFile
			 * */
			for(String element : listeTriee)
			{
				writer.write(element+": "+"nombre ocurence:"+" "+tmp.get(element)+","+"\n");
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
	
	public TreeMap<String, Integer> trierListeSymptoms(List<String> liste)
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
	public void afficherSymptoms(List<String> liste)
	{
			
		TreeMap<String, Integer> tmp =this.trierListeSymptoms(liste);
		
		Set<String>listeTriee = tmp.keySet();
		
		for(String listS:listeTriee)
		{
			 
			System.out.println("symptom from file:"+ " "+listS+": " +"occurence : "+tmp.get(listS));
		}
		 
	}
	
	
}