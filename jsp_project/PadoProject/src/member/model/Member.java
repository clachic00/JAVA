package member.model;

import java.sql.Date;

public class Member {

	private int midx;
	private String memail;
	private String mpw;
	private String mname;
	private String mphonenum;
	private String mphoto;
	private Date mregdate;
	
	
	public Member() {};

	public Member(int midx, String memail, String mpw, String mname, String mphonenum, String mphoto, Date mregdate) {
		super();
		this.midx = midx;
		this.memail = memail;
		this.mpw = mpw;
		this.mname = mname;
		this.mphonenum = mphonenum;
		this.mphoto = mphoto;
		this.mregdate = mregdate;
	}


	public void setMidx(int midx) {
		this.midx = midx;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public void setMpw(String mpw) {
		this.mpw = mpw;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public void setMphonenum(String mphonenum) {
		this.mphonenum = mphonenum;
	}


	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}


	public void setMregdate(Date mregdate) {
		this.mregdate = mregdate;
	}


	public int getMidx() {
		return midx;
	}


	public String getMemail() {
		return memail;
	}


	public String getMpw() {
		return mpw;
	}


	public String getMname() {
		return mname;
	}


	public String getMphonenum() {
		return mphonenum;
	}


	public String getMphoto() {
		return mphoto;
	}
	
	public java.util.Date getToDate() {// ${member.toDate}
	      return new java.util.Date(mregdate.getTime());
	   }



	@Override
	public String toString() {
		return "Member [midx=" + midx + ", memail=" + memail + ", mpw=" + mpw + ", mname=" + mname + ", mphonenum="
				+ mphonenum + ", mphoto=" + mphoto + ", mregdate=" + mregdate + "]";
	}
	
	

}
