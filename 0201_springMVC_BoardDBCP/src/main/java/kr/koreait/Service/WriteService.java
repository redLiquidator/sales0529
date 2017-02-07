package kr.koreait.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.koreait.DAO.MVCBoardDAO;

public class WriteService implements MVCBoardService {

	@Override		
	//model: 제목, 내용, 이름을 싣고옴
	public void execute(Model model) {
		System.out.println("WriteService의 execute() 실행");
		//model에 request영역에 제목, 내용, 이름이 키-value 구조로 들어가있다.
		//model에서 데이터를 꺼내고 싶으면, request구조로 바꾸기 위한 메서드가 있다. asMap().
		
		Map<String, Object> map = model.asMap();  
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		new MVCBoardDAO().insert(name, title, content);
	}

}
