package vo;

import java.sql.Timestamp;

public class BoardVO {
	
	private int no;
	private int groupNO;
	private int depth;
	private String title;
	private String content;
	private String id;
	private Timestamp writeDate;
	
	public BoardVO(String title, String content, String id) {
		this.title=title;
		this.content=content;
		this.id=id;
	
	}
	

	public int getGroupNO() {
		return groupNO;
	}


	public void setGroupNO(int groupNO) {
		this.groupNO = groupNO;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public Timestamp getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return no+", " +groupNO+", "+ title+", " +content+","+ id+", " + writeDate;
	}

}
