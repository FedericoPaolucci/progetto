/**
 * 
 */
package com.project.EsameProgettoTwitter.retweets;

import java.util.ArrayList;

import com.project.EsameProgettoTwitter.model.Metadata;
import com.project.EsameProgettoTwitter.model.Proprieties;

/**
 * @author Federico Paolucci
 *
 */
public class RetweetsClass {

	private static ArrayList<Proprieties> proprieties= new ArrayList<Proprieties>();
	private static ArrayList<Metadata> metadata= new ArrayList<Metadata>();
	
	/**
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
		
		metadata.add(new Metadata("created_at","created_at","String"));
		metadata.add(new Metadata("id","id_str","String"));
		metadata.add(new Metadata("text","text","String"));
		metadata.add(new Metadata("hashtags","entities_hashtags","String[]"));
		metadata.add(new Metadata("mentions_screen_name","entities_user_mentions_screen_name","String[]"));
		metadata.add(new Metadata("mentions_name","entities_user_mentions_name","String[]"));
		metadata.add(new Metadata("mentions_id","entities_user_mentions_id_str","String[]"));
		return metadata;
	}	
	
	public static void download(String url) {
		
		}
}
