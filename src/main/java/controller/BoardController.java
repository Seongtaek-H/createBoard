package controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import service.BoardService;
import vo.BoardVO;

public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String command = req.getParameter("cmd");
		System.out.println("command: "+command);
		BoardService service = new BoardService();
		String url = "./article/result.jsp";
		
		if(command.equals("list")) {
//			boolean test = new BoardService().test();
//			System.out.println(test);
			System.out.println(command+"실행");
			ArrayList<BoardVO> list = service.readAll();
			req.setAttribute("key", list); 

			url="./article/list_article.jsp";

		} else if(command.equals("view_article")){
//			System.out.println("view_article");
				url="./article/view_article.jsp";
				int no = Integer.parseInt(req.getParameter("articleNO"));
//				System.out.println(no);
				BoardVO vo = service.serchArticle(no);
				req.setAttribute("view", vo);		
			
		} else if(command.equals("create")) {
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String id = req.getParameter("id");
			BoardVO vo = new BoardVO(title,content,id);
			boolean flag = service.createArticle(vo);
			if(flag) {
				url = "/board?cmd=list";
			} else {
				System.out.println("글생성실패");
			}
			
		} else if(command.equals("view_input")) {
			url="./article/create_article.jsp";
			
		} else if(command.equals("delete")) {
			int no = Integer.parseInt(req.getParameter("articleNO"));
			boolean flag = service.deleteArticle(no);
			if(flag) {
				url="/board?cmd=list";
			} else {
				System.out.println("삭제실패");
			}
			
		} else if(command.equals("view_update")) {
			url="./article/update_article.jsp";
			int no = Integer.parseInt(req.getParameter("articleNO"));
//			System.out.println(no);
			BoardVO vo = service.serchArticle(no);
			req.setAttribute("update", vo);	
			
		} else if(command.equals("update")) {
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String id = req.getParameter("id");
			BoardVO vo = new BoardVO(title,content,id);
			int no = Integer.parseInt(req.getParameter("articleNO"));
			vo.setNo(no);
			System.out.println(vo);
			boolean flag = service.updateArticle(vo);
			System.out.println(flag);
			if(flag) {
				url="./board?cmd=list";
			} else {
				System.out.println("수정실패");
			}			
		} else if(command.equals("view_reply")) {
			int groupNO = Integer.parseInt(req.getParameter("groupNO"));
			BoardVO vo = service.makeGroup(groupNO);
			req.setAttribute("reply", vo);
			System.out.println(vo);
//			vo.setGroupNO(groupNO);
			url="./article/create_reply.jsp";

		} else if(command.equals("create_reply")) {

			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String id = req.getParameter("id");
			BoardVO vo = new BoardVO(title,content,id);
			System.out.println(vo);
			System.out.println(req.getParameter("groupNO"));
			int groupNO = Integer.parseInt(req.getParameter("groupNO"));
			vo.setGroupNO(groupNO);
			boolean flag = service.createReply(vo);
			if(flag) {
				url = "/board?cmd=list";
			} else {
				System.out.println("답글실패");
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
//		resp.sendRedirect(url);
	}

	private String getParameter(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
