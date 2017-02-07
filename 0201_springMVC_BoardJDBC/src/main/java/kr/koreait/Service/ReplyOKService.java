package kr.koreait.Service;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.koreait.DAO.MVCBoardDAO;
public class ReplyOKService implements MVCBoardService {

	@Override
	public void execute(Model model) {
		System.out.println("ReplyOKService execute()");

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int ref = Integer.parseInt(request.getParameter("ref"));
		int step = Integer.parseInt(request.getParameter("step"));
		int indent = Integer.parseInt(request.getParameter("indent"));
		
		MVCBoardDAO dao = new MVCBoardDAO();
		dao.replyOK(idx, name, title, content, ref, step, indent);
	}

}
