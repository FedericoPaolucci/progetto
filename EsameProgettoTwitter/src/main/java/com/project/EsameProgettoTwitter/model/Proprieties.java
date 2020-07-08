/**
 * 
 */
package com.project.EsameProgettoTwitter.model;

/** E' la classe i cui oggetti contengono i parametri principali di un retweet
 * @author Federico Paolucci
 *
 */
public class Proprieties {
	
	protected String created_at;
	protected String id;
	protected String text;
	protected String[] hashtags;
	protected String[] mentions_screen_name;
	protected String[] mentions_name;
	protected String[] mentions_id;
	
	
	public Proprieties(String created_at, String id, String text, String[] hashtags, String[] mentions_screen_name,
			String[] mentions_name, String[] mentions_id) 
	{
		this.created_at = created_at;
		this.id = id;
		this.text = text;
		this.hashtags = hashtags;
		this.mentions_screen_name = mentions_screen_name;
		this.mentions_name = mentions_name;
		this.mentions_id = mentions_id;
	}
	
	
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	public String[] getHashtags() {
		return hashtags;
	}
	public void setHashtags(String[] hashtags) {
		this.hashtags = hashtags;
	}
	
	
	public String[] getMentions_screen_name() {
		return mentions_screen_name;
	}
	public void setMentions_screen_name(String[] mentions_screen_name) {
		this.mentions_screen_name = mentions_screen_name;
	}
	
	
	public String[] getMentions_name() {
		return mentions_name;
	}
	public void setMentions_name(String[] mentions_name) {
		this.mentions_name = mentions_name;
	}
	
	
	public String[] getMentions_id() {
		return mentions_id;
	}
	public void setMentions_id(String[] mentions_id) {
		this.mentions_id = mentions_id;
	}
	

}
