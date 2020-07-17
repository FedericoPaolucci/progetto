package com.project.EsameProgettoTwitter.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.EsameProgettoTwitter.model.Metadata;
import com.project.EsameProgettoTwitter.model.Proprieties;
import com.project.EsameProgettoTwitter.model.Stats;
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
	 * Richiesta GET /metadata: riporta i metadati 
	 * 
	 * @return RetweetsClass.getArrayMetadata() cioe' i metadati
	 */
	
	@RequestMapping(value = "metadata", method = RequestMethod.GET)
	public ArrayList<Metadata> getMetadata(){
		
		RetweetsClass.ResetMetadata();
		return RetweetsClass.getArrayMetadata();
	}
	
	/**
	 * Richiesta GET /data: riporta i dati del JSON
	 * 
	 * @return RetweetsClass.getProprieties() cioe' tutti i dati piu' rilevanti del JSON
	 */
	
	@RequestMapping(value = "data", method = RequestMethod.GET)
	public ArrayList<Proprieties> getData() {
		
		return RetweetsClass.getProprieties();
	}
	
	/**
	 * Richiesta GET /stats: riporta quante volte una menzione compare nei tweets retwittati dell'user. 
	 * Riporta anche quanti retweets non presentano menzioni.
	 * 
	 * @return oggetto Stats che rappresenta le statistiche dei retweets
	 */
	
	@RequestMapping(value = "stats", method = RequestMethod.GET)
	public Stats getStats() {
		
		CalcStats.ResetMap();  //reset per evitare che ad una seconda chiamata, le informazioni siano errate
		ArrayList<Proprieties> proprieties = RetweetsClass.getProprieties();
		ArrayList<String> mToArray = CalcStats.mentionsToArray(proprieties);
		return CalcStats.Calcolate(mToArray);
		
	}

}
