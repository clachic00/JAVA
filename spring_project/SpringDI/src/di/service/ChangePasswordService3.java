package di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import di.dao.Dao;
import di.domain.Member;
import di.exception.IdPasswordNotMatchingException;
import di.exception.MemberNotFoundException;

@Component("memberPwSvc1")
public class ChangePasswordService3 {
	
	@Autowired
	private Dao Dao;

	

	public void changePassword(String email, String oldPwd, String newPwd) throws IdPasswordNotMatchingException, MemberNotFoundException {
		Member member = Dao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		Dao.update(member);
	}

}