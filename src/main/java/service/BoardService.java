package service;

import java.sql.Connection;
import java.util.ArrayList;

import connection.ConnectionController;
import dao.BoardDAO;
import vo.BoardVO;

public class BoardService {
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO=new BoardDAO();
	}
	
//	public boolean test() {
//		boolean flag=false;
//		flag=new BoardDAO().check();
//		return flag;
//	}
	
	public ArrayList<BoardVO> readAll(){
		ArrayList<BoardVO> list = boardDAO.selectAll();
		return list;
	}

	public boolean createArticle(BoardVO vo) {
		boolean flag = false;
		flag = boardDAO.insertArticle(vo);
		return flag;
	}
	
	public boolean deleteArticle(int no) {
		boolean flag = false;
		flag = boardDAO.removeArticle(no);
		return flag;
	}
	
	public BoardVO serchArticle(int no) {
		BoardVO vo = null;
		vo = new BoardDAO().selectArticle(no);
		return vo;
	}
	
	public boolean updateArticle(BoardVO vo) {
		boolean flag=false;
		flag=new BoardDAO().modifyArticle(vo);
		return flag;
	}
	public BoardVO makeGroup(int groupNO) {
		BoardVO vo = null;
		vo=new BoardDAO().createGroup(groupNO);
		return vo;
	}
	
	public boolean createReply(BoardVO vo) {
		boolean flag = false;
		flag = boardDAO.insertReply(vo);
		return flag;
	}
}
