package org.postgis.model;

public class PostGisModel {
//    private int lid; : integer
//    private String brand; : character varying (255)
//    private String model; : character varying (255)
	
	
	private int id;
	private int seq;
	private String word;
	private String stdword;
	private int token;
	private boolean is_custom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getStdword() {
		return stdword;
	}
	public void setStdword(String stdword) {
		this.stdword = stdword;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public boolean isIs_custom() {
		return is_custom;
	}
	public void setIs_custom(boolean is_custom) {
		this.is_custom = is_custom;
	}
	
	//getter and setter
	
	
	
}
