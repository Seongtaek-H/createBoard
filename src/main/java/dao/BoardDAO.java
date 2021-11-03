package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connection.ConnectionController;
import vo.BoardVO;

public class BoardDAO {
//	public boolean check() {
//		boolean flag=false;
//		Connection con = ConnectionController.getConnection();
//		if(con!=null) {
//			System.out.println("daoconneted");
//			ConnectionController.closeConnection(con);
//		} else {
//			System.out.println("fail");
//		}
//		return flag;
//	}
//		
		
	public ArrayList<BoardVO> selectAll(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = ConnectionController.getConnection();
		String sql = "select articleNO,title,content,id,writeDate from board "
				+ "order by articleNO desc";
		Statement stmt=null;
		ResultSet rs=null;
		BoardVO vo = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String title=rs.getString("title");
				String content=rs.getString("content");
				String id=rs.getString("id");
				vo = new BoardVO(title,content,id);
				vo.setNo(rs.getInt("articleNO"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
				list.add(vo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionController.closeAll(con, stmt, rs);
		}
		return list;
	}

	public boolean insertArticle(BoardVO vo) {
		boolean flag = false;
		String sql = "insert into board(title, content, id) values(?,?,?);";
		Connection con = ConnectionController.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getId());
			
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount>0) {
				System.out.println("등록이 완료되었습니다.");
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionController.closeAll(con, pstmt, null);
		}
		return flag;
	}
	
	public boolean removeArticle(int no) {
		boolean flag=false;
		String sql = "delete from board where articleNO=?";
		Connection con = ConnectionController.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount>0) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionController.closeAll(con, pstmt, null);
		}
		return flag;
		
	}
	
	public BoardVO selectArticle(int no) {
		BoardVO vo = null;
		String sql ="select title,content,id,writeDate from board where articleNO=?";
		Connection con = ConnectionController.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				vo=new BoardVO(title,content,id);
				vo.setNo(no);
				vo.setWriteDate(rs.getTimestamp("writeDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionController.closeAll(con, pstmt, rs);
		}
		return vo;
	}
	
	public boolean modifyArticle(BoardVO vo) {
		boolean flag=false;
		String sql = "update board set title=?,content=?,id=? where articleNO=?";
		Connection con = ConnectionController.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getId());
			pstmt.setInt(4, vo.getNo());
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount>0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionController.closeAll(con, pstmt, null);
		}
		return flag;
	}
}





