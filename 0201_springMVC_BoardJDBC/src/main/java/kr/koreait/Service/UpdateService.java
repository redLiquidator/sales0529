package kr.koreait.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.koreait.DAO.MVCBoardDAO;

public class UpdateService implements MVCBoardService {

	@Override
	public void execute(Model model) {
		System.out.println("UpdateService execute()");

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDAO dao = new MVCBoardDAO();
		dao.update(idx, title, content);
	}

}
