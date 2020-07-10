/**
 * 
 */
package com.project.EsameProgettoTwitter.retweets;

import java.io.BufferedReader;
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
 * @author Federico Paolucci
 *
 */
public class RetweetsClass {

	private static ArrayList<Proprieties> proprieties = new ArrayList<Proprieties>();
	private static ArrayList<Metadata> metadata = new ArrayList<Metadata>();

	/**
	 * Restituisce l'ArrayList di Proprieties, ovvero tutte le informazioni principali dei retweets.
	 * @return Arraylist di oggetti Proprieties
	 */

	public static ArrayList<Proprieties> getProprieties() {
		return proprieties;
	}

	/**
	 * Inizializza e restituisce l'ArrayList di Metadata
	 * @return ArrayList di oggetti Metadata
	 */

	public static ArrayList<Metadata> getArrayMetadata() {

		metadata.add(new Metadata("created_at", "created_at", "String"));
		metadata.add(new Metadata("id", "id_str", "String"));
		metadata.add(new Metadata("text", "text", "String"));
		metadata.add(new Metadata("hashtags", "entities_hashtags", "String[]"));
		metadata.add(new Metadata("mentions_screen_name", "entities_user_mentions_screen_name", "String[]"));
		metadata.add(new Metadata("mentions_name", "entities_user_mentions_name", "String[]"));
		metadata.add(new Metadata("mentions_id", "entities_user_mentions_id_str", "String[]"));
		return metadata;
	}

	/**
	 * Scarica dall'url inserito come parametro un json.
	 * In seguito trasforma il json in un array di oggetti Proprieties richiamando la classe Parser.
	 * @param url
	 * @throws IOException
	 * @throws JSONException
	 */
	
	public static void readJsonFromUrl(String url) throws IOException, JSONException {
		
		InputStream is = new URL(url).openStream();
		
		try {
			// inizializzo rd come BufferedReader che "incapsula" InputStreamReader (con charset UTF-8) 
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			//la stringa allText conterrà tutto il json
			String allText = readAll(rd); 
			//Crea un JSONObject di tutto il json
			JSONArray json = new JSONArray(allText);  //forse JSONObject?
			//popola l'Arraylist<Proprieties> con tutti gli oggetti Proprieties scaricati
			proprieties = Parser.Parsing(json);
		} finally {
			//chiudo l'InputStream is
			is.close();
		}     
		
	}
	
	/**
	 * Crea una stringa con tutto ciò che ha letto
	 * @param rd
	 * @return stringa con ciò che ha letto
	 * @throws IOException
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
