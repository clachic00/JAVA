package di.service;

import java.util.Date;

import di.dao.Dao;
import di.domain.Member;
import di.domain.RegisterRequest;
import di.exception.AlreadyExistingMemberException;



public class MemberRegisterService2 {
	
	private Dao Dao;

	//메서드 주입 방식
	public void setDao(Dao dao) {
		this.Dao = dao;
	}
	
	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		Member member = Dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		Dao.insert(newMember);
	}

}
