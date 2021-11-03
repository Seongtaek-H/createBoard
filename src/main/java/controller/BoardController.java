package controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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
			System.out.println(list);
			req.setAttribute("key", list); 

			url="./article/list_article.jsp";

		} else if(command.equals("create")) {
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String id = req.getParameter("id");
			BoardVO vo = new BoardVO(title,content,id);
			boolean flag = service.createArticel(vo);
			if(flag) {
				url = "/board?cmd=list";
			} else {
				req.setAttribute("message", "input fail");
			}
			
		} else if(command.equals("view_input")) {
			url="./article/create_article.jsp";
		} else if(command.equals("delete")) {
			int no = Integer.parseInt(req.getParameter("articleNO"));
			boolean flag = service.deleteArticle(no);
			if(flag) {
				url="/board?cmd=list";
			} else {
				req.setAttribute("message", "remove fail");	
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
//		resp.sendRedirect(url);
	}
}
