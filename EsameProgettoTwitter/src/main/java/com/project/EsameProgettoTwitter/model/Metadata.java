package com.project.EsameProgettoTwitter.model;

/** 
 * E' la classe i cui oggetti rappresentano il nome del parametro assegnato,
 * il nome del parametro nel json e il tipo di dato.
 * 
 * @author Federico Paolucci
 */
public class Metadata {

	String alias;
	String source;
	String type;
	
	
	public Metadata(String alias, String source, String type) {
		this.alias = alias;
		this.source = source;
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
}
