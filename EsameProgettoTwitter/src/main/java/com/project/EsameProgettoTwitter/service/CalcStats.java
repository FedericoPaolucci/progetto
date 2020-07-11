
package com.project.EsameProgettoTwitter.service;

import java.util.ArrayList;

import com.project.EsameProgettoTwitter.model.Proprieties;

/**Classe che calcola le statistiche delle menzioni fatte nei retweets
 * @author Federico Paolucci
 */
public class CalcStats {
	
	ArrayList<String> arrayString = new ArrayList<String>();
	ArrayList<Integer> arrayInt = new ArrayList<Integer>();
	//in seguito oggetti temporanei utili per le operazioni
	Proprieties TempObject;
	int TempStringSize;
	String[] TempStringArray;
	
	/**Popola un arraylist di stringhe con tutte le menzioni dei retweet
	 * @return ArrayList con tutte le menzioni presenti in tutti i retweet
	 */
	public ArrayList<String> mentionsToArray(ArrayList<Proprieties> proprieties) {
	    
		//iterazione che prende ogni elemento di dell'arraylist proprieties
		for (int pos = 0; pos < proprieties.size(); pos++) {
			
			TempObject = proprieties.get(pos);
			TempStringSize = TempObject.getMentions_nameSize();
			TempStringArray = TempObject.getMentions_name();
			//iterazione che prende ogni elemento di dell'array di stringhe di mentions_name in un oggetto di proprieties
			for (int StringPos = 0; StringPos < TempStringSize  ; StringPos++) {
				arrayString.add(TempStringArray[StringPos]);  //aggiunge all'array di stringhe un elemento dell'array mentions_name
			}
		
		}
		
		return arrayString;
	}
	
	/**
	 * @param Arraylist<String> fornito dall'operazione mentionsToArray
	 * @return calcolo della statistica menzioni
	 */
	public void Calcolate(ArrayList<String> mentionsToArray) {
		//metto in un altro arraylist ogni elemento non ripetuto di arrayString(mentionsToArray) 
		//ogni volta che un elemento viene ripetuto aumento di 1 un contatore di un arraylist di Integer nella posizione
		//dell'elemento non ripetuto. Nel calcolo finale aumento di 1 tutti poichè il primo elemento,
		//quello non ripetuto, non viene contato.
		
	}
	
}
