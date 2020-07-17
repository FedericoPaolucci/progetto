package com.project.EsameProgettoTwitter.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * E' la classe i cui oggetti sono le statistiche sulle menzioni
 * 
 * @author Federico Paolucci
 */
public class Stats {
	
	
	HashMap<String, Integer> mappa;
	ArrayList<String> mostMentions;
	ArrayList<String> lessMentions;
	
	
	public Stats(HashMap<String, Integer> mappa, ArrayList<String> mostMentions, ArrayList<String> lessMentions) {
		super();
		this.mappa = mappa;
		this.mostMentions = mostMentions;
		this.lessMentions = lessMentions;
	}
	
	
	public HashMap<String, Integer> getMappa() {
		return mappa;
	}
	public void setMappa(HashMap<String, Integer> mappa) {
		this.mappa = mappa;
	}
	
	
	public ArrayList<String> getMostMentions() {
		return mostMentions;
	}
	public void setMostMentions(ArrayList<String> mostMentions) {
		this.mostMentions = mostMentions;
	}
	
	
	public ArrayList<String> getLessMentions() {
		return lessMentions;
	}
	public void setLessMentions(ArrayList<String> lessMentions) {
		this.lessMentions = lessMentions;
	}

}
