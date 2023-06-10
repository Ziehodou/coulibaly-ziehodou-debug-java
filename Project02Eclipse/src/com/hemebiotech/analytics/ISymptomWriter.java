/**
 * 
 */
package com.hemebiotech.analytics;
import java.util.*;

/**
 * @author Ziehodou
 * 
 * Toute class qui doit écrire dans le fichier de sortir 
 * doit implementyer cette interface
 *
 */
public interface ISymptomWriter {

	
	void writeSymptoms(Map<String,Integer> symptoms);
	
}
