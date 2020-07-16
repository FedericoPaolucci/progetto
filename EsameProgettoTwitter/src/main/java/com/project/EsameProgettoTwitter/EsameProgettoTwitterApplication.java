package com.project.EsameProgettoTwitter;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.EsameProgettoTwitter.retweets.RetweetsClass;

/**
 * All'accensione scarica il JSON e lo rende un array di oggetti Proprieties, poi avvia l'applicazione Spring.
 * 
 * @author Federico Paolucci
 */

@SpringBootApplication
public class EsameProgettoTwitterApplication {
	
	static String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/statuses/retweets_of_me.json";
	//parametro per mostrare le entities dove sono contenute le menzioni
	static String parameter = "?include_entities=true&tweet_mode=extended";
	//url completo
	static String urlcompleto = url + parameter;

	public static void main(String[] args) throws JSONException, IOException {
		RetweetsClass.downloadJSON(urlcompleto);
		SpringApplication.run(EsameProgettoTwitterApplication.class, args);
	}

}
