package com.project.EsameProgettoTwitter.retweets;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.project.EsameProgettoTwitter.model.Metadata;
import com.project.EsameProgettoTwitter.model.Proprieties;
import com.project.EsameProgettoTwitter.service.Parser;

/**
 * Classe che gestisce i retweets, si usa per richiedere Proprieties dei Retweets, i metadata e per scaricare il JSON.
 * 
 * @author Federico Paolucci
 */

public class RetweetsClass {

	private static ArrayList<Proprieties> proprieties = new ArrayList<Proprieties>();
	private static ArrayList<Metadata> metadata = new ArrayList<Metadata>();

	/**
	 * Restituisce l'ArrayList di Proprieties, ovvero tutte le informazioni principali dei retweets.
	 * 
	 * @return proprieties : Arraylist di oggetti Proprieties
	 */

	public static ArrayList<Proprieties> getProprieties() {
		return proprieties;
	}

	/**
	 * Inizializza e restituisce l'ArrayList di Metadata
	 * 
	 * @return metadata : ArrayList di oggetti Metadata
	 */

	public static ArrayList<Metadata> getArrayMetadata() {

		metadata.add(new Metadata("created_at", "created_at", "String"));
		metadata.add(new Metadata("id", "id_str", "String"));
		metadata.add(new Metadata("text", "full_text", "String"));
		metadata.add(new Metadata("hashtags", "entities_hashtags", "String[]"));
		metadata.add(new Metadata("mentions_screen_name", "entities_user_mentions_screen_name", "String[]"));
		metadata.add(new Metadata("mentions_name", "entities_user_mentions_name", "String[]"));
		metadata.add(new Metadata("mentions_id", "entities_user_mentions_id_str", "String[]"));
		return metadata;
	}
	
	/**
	 * Reset dell'ArrayList 
	 */
	public static void ResetMetadata() {
		
		metadata.clear();	
	}

	/**
	 * Scarica dall'url inserito (come parametro) un json.
	 * Crea un file .json con all'interno il json scaricato.
	 * In seguito trasforma il json in un array di oggetti Proprieties richiamando la classe Parser.
	 * 
	 * @param url : l'indirizzo dell'API
	 * @throws IOException se l'url inserito non è valido
	 * @throws JSONException se c'e' un errore durante la creazione del JSON 
	 */
	
	public static void downloadJSON(String url) throws IOException, JSONException {
		
		InputStream is = new URL(url).openStream();
		
		try {
			// inizializzo rd come BufferedReader che "incapsula" InputStreamReader (con charset UTF-8) 
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			//la stringa allText conterrà tutto il json
			String allText = readAll(rd); 
			//Crea un JSONObject di tutto il json
			JSONArray json = new JSONArray(allText);  
			
			//crea o sovrascrive un file .json con il json scaricato
			try (FileWriter file = new FileWriter("retweets_json.json")) {
				 
	            file.write(json.toString());
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			//popola l'Arraylist<Proprieties> con tutti gli oggetti Proprieties scaricati
			proprieties = Parser.Parsing(json);
			
		}finally {
			//chiudo l'InputStream is
			is.close();
		}     
		
	}
	
	/**
	 * Crea una stringa con tutto ciò che ha letto
	 * 
	 * @param rd : è il flusso di dati da cui estrarre il json
	 * @return sb : stringa con ciò che ha letto
	 * @throws IOException che viene lanciata in caso di errori di input/output (rd non fornisce dati)
	 */

	private static String readAll(Reader rd) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		int temp;
		
		while ((temp = rd.read()) != -1) {
			//aggiunge con append un carattere trasformato dall' Integer alla stringa
			sb.append((char) temp);
		}
		return sb.toString();
	}

}
