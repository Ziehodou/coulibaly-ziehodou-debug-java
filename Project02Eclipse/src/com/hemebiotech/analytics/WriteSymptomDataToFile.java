package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;



/**
 * @author Ziehodou
 *class qui implemente l'interface ISymptomWriter
 * @see ISymptomWriter
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	/**
	 * Variable qui stocke le chemin du fichier
	 * dans lequel les symptoms seront ecris par ordre alphabetique
	 */
	private String pathFileWriter;
		
	public WriteSymptomDataToFile(String cheminFichier)
	{
		this.pathFileWriter = cheminFichier;
	}

	
	/**
	 * Ecrit les donnees dans le fichier
	 * @param listeSymptom,une Map qui contient les symptoms à assigner dans le fichier de sortir
	 * @throws  IOException, si le fichier de sortir est introuvable
	 */
	public void writeSymptoms(Map<String,Integer> symptoms)
	{
		
		try
		{
			
			BufferedWriter writer =new BufferedWriter(new FileWriter(this.pathFileWriter));
						
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
	 * Cette fonction trie les symptoms et compte le nombre occurence de chaque symptom
	 * @param liste,prends en parametre une liste(instance ArrayList) qui contien les symptoms 
	 * @return a treeMap Objet listeTriee, qui correspond à liste des symptoms triés
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
	 * affiche les symptoms dans la console
	 *@param tmp
	 *		prends une Map en paramètre puis l'affiche
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