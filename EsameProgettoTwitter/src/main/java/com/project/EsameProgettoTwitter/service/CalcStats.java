package com.project.EsameProgettoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.project.EsameProgettoTwitter.model.Proprieties;
import com.project.EsameProgettoTwitter.model.Stats;

/**
 * Classe che calcola le statistiche delle menzioni fatte nei retweets
 * 
 * @author Federico Paolucci
 */
public class CalcStats {

	static ArrayList<String> arrayString = new ArrayList<String>();
	static ArrayList<Integer> arrayInt = new ArrayList<Integer>();
	static HashMap<String,Integer> mappa = new HashMap<String,Integer>();

	static Stats stats;
	
	public static int noMentions = 0; // numero di retweets senza menzioni

	// in seguito oggetti temporanei utili per le operazioni
	static Proprieties TempObject;
	static int TempValue;
	static String[] TempStringArray;
	static ArrayList<String> TempArray1 = new ArrayList<String>();
	static ArrayList<String> TempArray2 = new ArrayList<String>();

	/**
	 * Popola un arraylist di stringhe con tutte le menzioni dei retweet e
	 * incrementa un contatore per ogni retweet senza menzioni
	 * 
	 * @param proprieties : ArrayList di oggetti Proprieties che rappresenta i dati del json
	 * @return arrayString : ArrayList con tutte le menzioni presenti in tutti i retweet
	 */
	
	public static ArrayList<String> mentionsToArray(ArrayList<Proprieties> proprieties) {

		// iterazione che prende ogni elemento di dell'arraylist proprieties
		for (int pos = 0; pos < proprieties.size(); pos++) {

			TempObject = proprieties.get(pos);
			TempValue = TempObject.getMentions_nameSize();
			TempStringArray = TempObject.getMentions_screen_name();
			
			//controlla se la grandezza dell'array delle menzioni è 0
			if (TempValue == 0) {
				noMentions++; // incrementa noMentions
			} else {
				// iterazione che prende ogni elemento di dell'array di stringhe di
				// mentions_name in un oggetto di proprieties
				for (int StringPos = 0; StringPos < TempValue; StringPos++) {
					arrayString.add(TempStringArray[StringPos]); // aggiunge all'array di stringhe un elemento
																 // dell'array mentions_name
				}
			}
		}

		return arrayString;
	}

	/**
	 * Calcola la statistica delle menzioni, calcolando quante volte vengono
	 * ripetuti i nomi.
	 * 
	 * @param mentionsToArray : Arraylist fornito dall'operazione mentionsToArray (tutte le menzioni scritte in un Array di String)
	 * @return stats : oggetto Stats con le statistiche dei retweets
	 */
	public static Stats Calcolate(ArrayList<String> mentionsToArray) {
		
		//iterazione lungo tutto l'array 
		for (int i = 0; i < mentionsToArray.size(); i++) {
			//vede se nella HashMap c'è un certo valore dato da mentionsToArray
			if (mappa.containsKey(mentionsToArray.get(i))==true) {
				
				//aumenta il contatore della menzione gia presente di 1
				TempValue=mappa.get(mentionsToArray.get(i));
				mappa.replace(mentionsToArray.get(i), TempValue+1);
				
			}
			else {
				
				mappa.put(mentionsToArray.get(i), 1); //mette nella hashmap un elemento con una key che non esisteva
				
			}
			
			  
		}
		TempArray1=CalcMostAndLess.calcMost(mappa); //array con le menzioni piu presenti
		TempArray2=CalcMostAndLess.calcLess(mappa); //array con le menzioni meno presenti
		
		stats = new Stats(mappa, TempArray1, TempArray2);
		
		//aggiunge noMentions alla mappa
		mappa.put("Retweets senza menzioni", noMentions);
		
		arrayString.clear();    //reset di arrayString
		noMentions=0;           //reset di noMentions
		return stats;           //ritorna stats
	
	}
	
	
	
	
	
	/**
	 * Reset della HashMap.
	 * 
	 */
	public static void ResetMap() {
		
		mappa.clear();
	}

}
