/**
 * 
 */
package com.project.EsameProgettoTwitter.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.EsameProgettoTwitter.model.Proprieties;

/**
 * Classe che effettua il parsing del JSON
 * 
 * @author Federico Paolucci
 *
 */
public class Parser {

	static ArrayList<Proprieties> proprieties = new ArrayList<>();
	static String[] HT; // hashtags array
	static String[] U_M_S_N; // user mentions screen name array
	static String[] U_M_N; // user mentions name array
	static String[] U_M_id; // user mentions string_id array

	/**
	 * effettua il parsing salvando le proprietà più rilevanti in oggetti
	 * Proprieties
	 * 
	 * @param json
	 * @return
	 */
	public static ArrayList<Proprieties> Parsing(JSONArray json) {

		// iterazione per prendere ogni oggetto
		try {
			for (int numObject = 0; numObject < json.length(); numObject++) {

				JSONObject object = json.getJSONObject(numObject); // oggetto singolo
				JSONObject entitiesObject = object.getJSONObject("entities"); // oggetto entities

				JSONArray hashtagsArray = entitiesObject.getJSONArray("hashtags"); // array hashtags (visto con json
																					// editor)

				HT = new String[hashtagsArray.length()];
				// iterazione per prendere ogni hashtag e metterli in un array di Strings
				for (int numHTObject = 0; numHTObject < hashtagsArray.length(); numHTObject++) {
					JSONObject HTobject = json.getJSONObject(numHTObject);
					HT[numHTObject] = HTobject.getString("text");
				}

				JSONArray user_mentionsArray = entitiesObject.getJSONArray("user_mentions"); // array user_mentions
																								// (visto con json
																								// editor)

				U_M_S_N = new String[user_mentionsArray.length()];
				U_M_N = new String[user_mentionsArray.length()];
				U_M_id = new String[user_mentionsArray.length()];
				// iterazione per prendere tutti gli elementi di user_mentions e metterli in
				// array di Strings diversi
				for (int numU_MObject = 0; numU_MObject < user_mentionsArray.length(); numU_MObject++) {
					JSONObject U_Sobject = json.getJSONObject(numU_MObject);
					U_M_S_N[numU_MObject] = U_Sobject.getString("screen_name");
					U_M_N[numU_MObject] = U_Sobject.getString("name");
					U_M_id[numU_MObject] = U_Sobject.getString("id_str");
				}

				// crea un oggetto Proprieties e lo aggiunge all'arraylist
				Proprieties objectProprieties = new Proprieties(object.getString("created_at"),
																object.getString("id_str"), 
																object.getString("text"), 
																HT, 
																U_M_S_N, 
																U_M_N, 
																U_M_id);
				proprieties.add(objectProprieties);
			}
			
		} catch (JSONException e) {
			throw new RuntimeException("Errore durante la costruzione di un oggetto JSON");
		} 
		
		return proprieties;

	}
}
