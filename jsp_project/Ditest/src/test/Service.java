package test;

public class Service {

	MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao=dao;
	}
	
	
	public void print() {
		dao.print();
	}
	
	
}
