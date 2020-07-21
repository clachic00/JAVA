package member.model;

import java.sql.Date;

public class Comments {

	private int cidx;
	private int bidx;
	private String memail;
	private String comment;
	private Date cregdate;
	
	public Comments(){}
	
	public Comments(int cidx, int bidx, String memail, String comment, Date cregdate) {
		super();
		this.cidx = cidx;
		this.bidx = bidx;
		this.memail = memail;
		this.comment = comment;
		this.cregdate = cregdate;
	}

	public int getCidx() {
		return cidx;
	}

	public void setCidx(int cidx) {
		this.cidx = cidx;
	}

	public int getBidx() {
		return bidx;
	}

	public void setBidx(int bidx) {
		this.bidx = bidx;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCregdate() {
		return cregdate;
	}

	public void setCregdate(Date cregdate) {
		this.cregdate = cregdate;
	}

	
	@Override
	public String toString() {
		return "Comment [cidx=" + cidx + ", bidx=" + bidx + ", memail=" + memail + ", comment=" + comment
				+ ", cregdate=" + cregdate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
