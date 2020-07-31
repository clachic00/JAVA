package com.aia.mvc.search.model;

public class SearchType {

	private int tno;
	private String type;
	
	
	
	
	
	public SearchType(int tno, String type) {
		super();
		this.tno = tno;
		this.type = type;
	}

	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SearchType [tno=" + tno + ", type=" + type + "]";
	}
	
	
	
}
