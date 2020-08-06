package com.ci.op.member.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="member-list")
public class MemberXmlList {

	@XmlElement(name="member")
	private List<MemberXML> members;

	public MemberXmlList(List<MemberXML> members) {
		
		this.members = members;
	}

	public MemberXmlList() {
	}
	
	
	
	
	
	
}
