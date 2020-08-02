package board.model;

import java.util.Date;

public class Board {
	
	private int bidx;
	private String mid;
	private String bphoto;
	private String bmessage;
	private String baddr;
	private Date bregdate;
	
	
	public Board(int bidx, String mid, String bphoto, String bmessage, String baddr, Date bregdate) {
		this.bidx = bidx;
		this.mid = mid;
		this.bphoto = bphoto;
		this.bmessage = bmessage;
		this.baddr = baddr;
		this.bregdate = bregdate;
	}


	public Board() {
	}


	public int getBidx() {
		return bidx;
	}


	public void setBidx(int bidx) {
		this.bidx = bidx;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getBphoto() {
		return bphoto;
	}


	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}


	public String getBmessage() {
		return bmessage;
	}


	public void setBmessage(String bmessage) {
		this.bmessage = bmessage;
	}


	public String getBaddr() {
		return baddr;
	}


	public void setBaddr(String baddr) {
		this.baddr = baddr;
	}


	public Date getBregdate() {
		return bregdate;
	}


	public void setBregdate(Date bregdate) {
		this.bregdate = bregdate;
	}


	@Override
	public String toString() {
		return "Board [bidx=" + bidx + ", mid=" + mid + ", bphoto=" + bphoto + ", bmessage=" + bmessage + ", baddr="
				+ baddr + ", bregdate=" + bregdate + "]";
	}
	
	
	
	
	
}
