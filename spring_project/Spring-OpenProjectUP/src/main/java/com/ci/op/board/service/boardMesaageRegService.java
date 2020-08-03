package com.ci.op.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.ci.op.board.dao.BoardDao;
import com.ci.op.board.model.Board;
import com.ci.op.board.model.MessageRegRequest;

public class boardMesaageRegService {

	@Autowired
	BoardDao dao;
	
	public int messageReg(
			MessageRegRequest regRequest,
			HttpServletRequest request
			
			) {
	int result = 0;
	
	Board board = regRequest.toBoard();
	
}
