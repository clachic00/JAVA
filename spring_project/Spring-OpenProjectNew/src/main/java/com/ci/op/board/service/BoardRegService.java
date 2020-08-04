package com.ci.op.board.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ci.op.board.dao.BoardDao;
import com.ci.op.board.model.Board;
import com.ci.op.board.model.MessageRegRequest;
import com.ci.op.jdbc.ConnectionProvider;

public class BoardRegService {

	@Autowired
	BoardDao dao;
	
	public int messageReg(
			MessageRegRequest regRequest,
			HttpServletRequest request
			
			) {
	int result = 0;
	
	Board board = regRequest.toBoard();
	
	Connection conn;
	
	try {
		conn= ConnectionProvider.getConnection();
		
		MultipartFile file = regRequest.getBphoto();
		
		System.out.println(regRequest);
		
		if(file != null && !file.isEmpty() && file.getSize() >0) {
			
			String uri = request.getSession().getServletContext().getInitParameter("BoardUploadPath");
			
			String realPath = request.getSession().getServletContext().getRealPath(uri);
			
			String newFileName = System.nanoTime() + "_"+ file.getOriginalFilename();
			
			File saveFile = new File(realPath, newFileName);
			file.transferTo(saveFile);
			System.out.println("저장 완료 : " + newFileName);
			
			// 데이터베이스에 저장할 Member 객체의 데이터를 완성한다. : 사진 경로
			board.setBphoto(newFileName);

		}
		
		result = dao.insertMessage(conn, board);
		
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		
	}
	
	
	return result;
	}
	
}
