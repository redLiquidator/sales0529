package kr.koreait.DAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.koreait.VO.MVCBoardVO;

public class MVCBoardDAO {
	DataSource dataSource;	//DB에 연결할 이름이 뭔지
				//oracle, mySql, h2, mssql... server폴더의 context.xml에 dbcp를 오라클로 연동해놓았다.
				//이 객체에 DBCP를 연결해 놓으면 각 메서드가 DataSource 객체를 통해 커넥션풀(DBCP)를 사용할 수 있다.
	//생성자-dbcp연동
	public MVCBoardDAO() {
		try{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		dataSource = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = dataSource.getConnection();
		System.out.println("연결성공! --" + conn + "확인");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("DAO생성자에서 연결실패");
		}
	}
	
	//C R U D 해주자.
	//C : insert 삽입!
	public void insert(String name, String title, String content){
		System.out.println("MVC Board insert");
		Connection conn = null;
		PreparedStatement pstmt=null;
		try{
			conn = dataSource.getConnection();
			/*
			 nextVal : 시퀀스의 다음값. int num;  num++;		:idx
			 currVal : 현재값		getNum();					:ref 참조값
			 
			 */
			String sql= "insert into mvc_board(idx, name, title, content, ref, step, indent) "
					+ "values (mvc_board_seq.nextVal, ?, ?, ?, mvc_board_seq.currVal, 0, 0)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	//R : list - 테이블에 글 내용을 목록으로 간단하게 보여준다.
	public ArrayList<MVCBoardVO> list(){
		System.out.println("MVC Board list");
		ArrayList<MVCBoardVO> list = null;	//글들을 VO단위로 가져와서 resultset에 담을거..
		MVCBoardVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try{
			conn = dataSource.getConnection();
								//정렬을 해서 가져오자
			String sql= "select * from mvc_board order by ref desc, step asc";
			//특정메서드를 이용해서 글을 저장시킬 거다.
			//내부에서 사용하는 것(컨트롤러가 사용하는게 아니다)
			//private으로.. requestvo
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 	
			
			if(rs.next()){
				list = new ArrayList<MVCBoardVO>();
				do{
					vo = requestvo(rs);
					list.add(vo);	//한행, 한행씩 글들이 저장되면서 쌓일것임
				}while(rs.next());//rs의 데이터가 떨어질때까지 반복해라.
				
			}else{
				System.out.println("테이블에 저장된 글이 없음");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
			//한행씩 쌓인 list를 보내자.. 
		return list;	
	}
	
	private MVCBoardVO requestvo(ResultSet rs) throws SQLException{
		MVCBoardVO vo;
		int idx = rs.getInt("idx"); //테이블 컬럼 중에..idx컬럼에서 가져와!
		String name = rs.getString("name");
		String title = rs.getString("title");
		String content = rs.getString("content");
		Date date = rs.getTimestamp("writeDate");
		int readCount = rs.getInt("readCount");
		int ref = rs.getInt("ref");
		int step = rs.getInt("step");
		int indent = rs.getInt("indent");
		
		vo = new MVCBoardVO(idx, name, title, content, date, readCount, ref, step, indent);
		return vo;
	}
	
	//view 페이지 - 글 한 건을 볼거다.
	public MVCBoardVO view(int num){
		System.out.println("DAO - MVC Board view() 글 한건보기");
		MVCBoardVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try{
			conn = dataSource.getConnection();
			String sql= "select * from mvc_board where idx = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo=requestvo(rs);
			}else{
				System.out.println("해당 게시글은 존재하지 않습니다.");
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	//글 조회수 증가하는 메서드	, 글목록을 클릭하면 조회수가 증가해야한다.
	public void upHit(int idx){
		System.out.println("DAO - mvc board 조회수 증가");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = dataSource.getConnection();
			String sql="update mvc_board set readcount=readcount+1 where idx= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e){e.printStackTrace();}
		}
	}
	
	//글 삭제
	public void delete(int idx){
		System.out.println("DAO - mvc board 글 삭제");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = dataSource.getConnection();
			String sql = "delete from mvc_board where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e){e.printStackTrace();}
		}
	}
	
	//글 수정
	public void update(int idx, String title, String content){
		System.out.println("DAO - mvc board 글 수정");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = dataSource.getConnection();
			String sql="update mvc_board set title = ?, content = ? where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, idx);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e){e.printStackTrace();}
		}
	}
	
	//답변글
	public MVCBoardVO reply(int idx){
		System.out.println("DAO - MVC Board reply() 답글달기");
		MVCBoardVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try{
			conn = dataSource.getConnection();
			String sql = "select * from mvc_board where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	
				vo = requestvo(rs);
			} else {
				System.out.println("해당 글은 존재하지 않습니다.");
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return vo;	//글 한건에 대한 답변글 내용이 저장된다.
	}
	
	//답변글쓰기폼에서 넘어온 데이터 처리
	@SuppressWarnings("resource")
	public void replyOK(int idx, String name, String title, String content, int ref, int step, int indent){
		System.out.println("DAO - mvc board 답변글 등록(replyOK)");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = dataSource.getConnection();
			//reply에서 답변글을 작성하게 된다.
			//답변글 작성한 내용을 반영하라. (테이블 수정)
			//이때 참조글과 글 위치(step)에 대한 조건을 만들어서 배치하게된다.
			//모글 -- 
			//	--답변글(step1)
			//  --답변글(참조글에 대한 step을 가져와서 1증가시켜 위치시키자)
			String sql = "update mvc_board set step = step + 1 where ref = ? and step > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, step);
			pstmt.executeUpdate();
			
			
			//위에서 준비된 step의 위치에 (1증가된 위치) 입력하게 될 답글이 달리게 된다.
			sql = "insert into mvc_board(idx, name, title, content, ref, step, indent) " +
					" values(mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			//리소스 누수가 될 수 있기 때문에 어노테이션을 달아준다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, ref);
			pstmt.setInt(5, step + 1);
			pstmt.setInt(6, indent + 1);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e){e.printStackTrace();}
		}
	}
	
	
}
