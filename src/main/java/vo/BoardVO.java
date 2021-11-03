package vo;

import java.sql.Timestamp;

public class BoardVO {
	
	private int no;
	private String title;
	private String content;
	private String id;
	private Timestamp writeDate;
	
	public BoardVO(String title, String content, String id) {
		this.title=title;
		this.content=content;
		this.id=id;
	
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
		return no+", " + title+", " +content+","+ id+", " + writeDate;
	}

}
