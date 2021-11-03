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

	public boolean createArticel(BoardVO vo) {
		boolean flag = false;
		flag = boardDAO.insertArticle(vo);
		return flag;
	}
	
	public boolean deleteArticle(int no) {
		boolean flag = false;
		flag = boardDAO.removeArticle(no);
		return flag;
	}
}
