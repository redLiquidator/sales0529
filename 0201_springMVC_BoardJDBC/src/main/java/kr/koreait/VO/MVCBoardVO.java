package kr.koreait.VO;

import java.util.Date;

/*
 CREATE TABLE MVC_BOARD (
	IDX NUMBER(5,0) PRIMARY KEY,  --시퀀스
	NAME CHAR(20 BYTE) NOT NULL, --글쓴이
	TITLE VARCHAR2(200 BYTE) NOT NULL, --글제목
	CONTENT VARCHAR2(500 BYTE) NOT NULL, --글내용
	WRITEDATE TIMESTAMP (6) DEFAULT SYSDATE,  --작성시간 jstl <fmt:..>
	READCOUNT NUMBER(5,0) DEFAULT 0, --조회수
	REF NUMBER(5,0), --원글(모글)
	STEP NUMBER(5,0), --답글의 위치(몇번째 계단에 있는지)
	INDENT NUMBER(5,0) --원글에서 답글이 몇번 진행되었는지 (들여쓰기...)
);
 */
/*
 	bean 규약
 	private선언, 생성자(), +생성자(..), getter/setter
 */
public class MVCBoardVO {
	private int idx;
	private String name;
	private String title;
	private String content;
	private Date writeDate;
	//private Timestamp writedate;
	private int readCount;
	private int ref;	//글 그룹(참조글)
	private int step;	//그룹에서 출력하는 순서
	private int indent; //들여쓰기 레벨
	
	public MVCBoardVO() {
		// TODO Auto-generated constructor stub
	}

	public MVCBoardVO(int idx, String name, String title, String content, Date writeDate, int readCount, int ref,
			int step, int indent) {
		this.idx = idx;
		this.name = name;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.readCount = readCount;
		this.ref = ref;
		this.step = step;
		this.indent = indent;
	}

	public int getIdx() {
		return idx;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public int getRef() {
		return ref;
	}

	public int getStep() {
		return step;
	}

	public int getIndent() {
		return indent;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}
	
	
	
}
