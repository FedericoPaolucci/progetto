package com.project.EsameProgettoTwitter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * Classe che contiene operazioni di calcolo delle statistiche
 * 
 * @author Federico Paolucci
 */
public class CalcMostAndLess {
	
	static int value;
	static ArrayList<String> tempStrings;
	
	/**
	 * Ritorna le menzioni più presenti nei retweets
	 * 
	 * @param mappa : Hashmap di Strings e Interi
	 * @return tempStrings : Arraylist di Stringhe
	 */
	
	public static ArrayList<String> calcMost(HashMap<String, Integer> mappa) {
		
		value = Collections.max(mappa.values());   //massimo valore nella mappa
		
		tempStrings = new ArrayList<String>();
		for (Entry<String, Integer> entry : mappa.entrySet()) {
		    if (entry.getValue()==value) {
		        tempStrings.add(entry.getKey());
		    }
		}
		return tempStrings;
		
	}
	
	/**
	 * Ritorna le menzioni meno presenti nei retweets
	 * 
	 * @param mappa : Hashmap di Strings e Interi
	 * @return tempStrings : Arraylist di Stringhe
	 */
	
	public static ArrayList<String> calcLess(HashMap<String, Integer> mappa) {
		
		value = Collections.min(mappa.values());   //minimo valore nella mappa
		
		tempStrings = new ArrayList<String>();
		for (Entry<String, Integer> entry : mappa.entrySet()) {
		    if (entry.getValue()==value) {
		        tempStrings.add(entry.getKey());
		    }
		}
		return tempStrings;
		
	}

}
