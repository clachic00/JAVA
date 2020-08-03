package com.ci.op.board.model;

import org.springframework.web.multipart.MultipartFile;

public class MessageRegRequest {

	private String uid;
	private String btitle;
	private String bmsg;
	private MultipartFile bphoto;
	private int pidx;
	private int lcnt;
	
	
	
	
	
	
	public MessageRegRequest() {

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

	public MultipartFile getBphoto() {
		return bphoto;
	}

	public void setBphoto(MultipartFile bphoto) {
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

	public Board toBoard() {
		return new Board(uid, btitle, bmsg, pidx,lcnt);
	}
	
	
	@Override
	public String toString() {
		return "MessageRegRequest [uid=" + uid + ", btitle=" + btitle + ", bmsg=" + bmsg + ", bphoto=" + bphoto
				+ ", pidx=" + pidx + ", lcnt=" + lcnt + "]";
	}
	
	
	
	
	
	
	
	
}
