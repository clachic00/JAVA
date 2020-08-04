package com.ci.op.member.model;

import org.springframework.web.multipart.MultipartFile;

import com.ci.op.member.model.Member;

public class MemberRegRequest {

	private String uid;
	private String upw;
	private String uname;
	private String uphone;
	private MultipartFile photo;
	
	public MemberRegRequest() {}



	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public String getUpw() {
		return upw;
	}



	public void setUpw(String upw) {
		this.upw = upw;
	}



	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getUphone() {
		return uphone;
	}



	public void setUphone(String uphone) {
		this.uphone = uphone;
	}



	public MultipartFile getPhoto() {
		return photo;
	}



	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}



	// MemberRegRequest -> Member 
	public Member toMember() {
		return new Member(uid, upw, uname, uphone );
	}



	public MemberRegRequest(String uid, String upw, String uname, String uphone, MultipartFile photo) {
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphone = uphone;
		this.photo = photo;
	}



	@Override
	public String toString() {
		return "MemberRegRequest [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphone=" + uphone + ", photo="
				+ photo + "]";
	}
	
	
	
	
	
	
	
}
