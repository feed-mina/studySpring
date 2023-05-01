package com.min.biz.board;

import java.sql.Date;


// 1. VO (Value Object) 칼럼이름과 똑같은 변수를 getter, setter + tostring
public class BoardVO {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	

	// Alt + shift + S : Generate Getter and Setter
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
	//	System.out.println("BoardVO()" + title);
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
	//	System.out.println("BoardVO()" + writer);
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
	//	System.out.println("BoardVO()" + content);
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	// Alt + shift + S : Generate to String
	@Override
	public String toString() {
		// System.out.println("BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
		// 		+ regDate + ", cnt=" + cnt + "]");
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}

	
	
}
