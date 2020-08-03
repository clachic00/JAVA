package com.ci.op.board.model;

import java.sql.Date;

public class Board {
	private int bidx;
	private String uid;
	private String btitle;
	private String bmsg;
	private String bphoto;
	private int pidx;
	private int lcnt;
	private Date bregdate;
	
	
	
	public Board(){}

	public Board(int bidx, String uid, String btitle, String bmsg, String bphoto, int pidx, int lcnt, Date bregdate) {
		super();
		this.bidx = bidx;
		this.uid = uid;
		this.btitle = btitle;
		this.bmsg = bmsg;
		this.bphoto = bphoto;
		this.pidx = pidx;
		this.lcnt = lcnt;
		this.bregdate = bregdate;
	}
	
	public Board(String uid, String btitle, String bmsg,  int pidx, int lcnt ){
		this(0, uid, btitle, bmsg, null, pidx, lcnt, null);
	}
	
	
	
	
	
	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBmsg() {
		return bmsg;
	}
	public void setBmsg(String bmsg) {
		this.bmsg = bmsg;
	}
	public String getBphoto() {
		return bphoto;
	}
	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}
	public int getPidx() {
		return pidx;
	}
	public void setPidx(int pidx) {
		this.pidx = pidx;
	}
	public int getLcnt() {
		return lcnt;
	}
	public void setLcnt(int lcnt) {
		this.lcnt = lcnt;
	}
	public Date getBregdate() {
		return bregdate;
	}
	public void setBregdate(Date bregdate) {
		this.bregdate = bregdate;
	}
	@Override
	public String toString() {
		return "board [bidx=" + bidx + ", uid=" + uid + ", btitle=" + btitle + ", bmsg=" + bmsg + ", bphoto=" + bphoto
				+ ", pidx=" + pidx + ", lcnt=" + lcnt + ", bregdate=" + bregdate + "]";
	}
	
	
}
