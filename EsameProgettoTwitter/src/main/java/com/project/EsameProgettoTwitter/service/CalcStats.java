package com.project.EsameProgettoTwitter.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.project.EsameProgettoTwitter.model.Proprieties;

/**
 * Classe che calcola le statistiche delle menzioni fatte nei retweets
 * 
 * @author Federico Paolucci
 */
public class CalcStats {

	static ArrayList<String> arrayString = new ArrayList<String>();
	static ArrayList<Integer> arrayInt = new ArrayList<Integer>();
	static HashMap<String,Integer> mappa = new HashMap<String,Integer>();

	public static int noMentions = 0; // numero di retweets senza menzioni

	// in seguito oggetti temporanei utili per le operazioni
	static Proprieties TempObject;
	static int TempValue;
	static String[] TempStringArray;

	/**
	 * Popola un arraylist di stringhe con tutte le menzioni dei retweet e
	 * incrementa un contatore per ogni retweet senza menzioni
	 * 
	 * @return ArrayList<String> con tutte le menzioni presenti in tutti i retweet
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
	 * @param Arraylist<String> fornito dall'operazione mentionsToArray (tutte le menzioni scritte in un Array di String)
	 * @return HashMap<String,Integer> con menzioni e numero di volte in cui esse compaiono
	 */
	public static HashMap<String,Integer> Calcolate(ArrayList<String> mentionsToArray) {
		
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
		//aggiunge noMentions alla mappa
		mappa.put("Retweets senza menzioni", noMentions);
		arrayString.clear();    //reset di arrayString
		noMentions=0;           //reset di noMentions
		return mappa;           //ritorna mappa
	
	}
	
	
	/**
	 * Reset della HashMap<String,Integer>.
	 * 
	 */
	public static void ResetMap() {
		
		mappa.clear();
	}

}
