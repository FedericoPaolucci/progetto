/**
 * 
 */
package com.project.EsameProgettoTwitter.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.EsameProgettoTwitter.model.Metadata;
import com.project.EsameProgettoTwitter.model.Proprieties;
import com.project.EsameProgettoTwitter.retweets.RetweetsClass;
import com.project.EsameProgettoTwitter.service.CalcStats;


/**
 * E' la classe che gestisce le chiamate client-server
 * 
 * @author Federico Paolucci
 */

@RestController
public class ControllerClass {
	
	
	/**
	 * Richiesta GET /metadata: ritorna i metadati 
	 * 
	 * @return RetweetsClass.getArrayMetadata()
	 */
	
	@RequestMapping(value = "metadata", method = RequestMethod.GET)
	public ArrayList<Metadata> getMetadata(){
		
		return RetweetsClass.getArrayMetadata();
	}
	
	/**
	 * Richiesta GET /data: ritorna i dati del JSON
	 * 
	 * @return RetweetsClass.getProprieties()
	 */
	
	@RequestMapping(value = "data", method = RequestMethod.GET)
	public ArrayList<Proprieties> getData() {
		
		return RetweetsClass.getProprieties();
	}
	
	/**
	 * Richiesta GET /stats: ritorna quante volte una menzione compare nei retweets dell'user. 
	 * Riporta anche quanti retweets non presentano menzioni.
	 * 
	 * @return
	 */
	
	@RequestMapping(value = "stats", method = RequestMethod.GET)
	public HashMap<String,Integer> getStats() {
		
		ArrayList<Proprieties> proprieties = RetweetsClass.getProprieties();
		ArrayList<String> mToArray = CalcStats.mentionsToArray(proprieties);
		return CalcStats.Calcolate(mToArray);
		
		
	}

}
