/**
 * 
 */
package com.hemebiotech.analytics;
import java.util.*;

/**
 * @author Ziehodou
 * 
 * Toute class qui doit écrire la liste des symptoms dans le fichier de sortir 
 * doit implementyer cette interface
 *
 */
public interface ISymptomWriter {

	/**
	 * Ecrire les symptoms dans un fichier txt
	 * @param symptoms, une Map qui contient les symptoms
	 */
	void writeSymptoms(Map<String,Integer> symptoms);
	
}
