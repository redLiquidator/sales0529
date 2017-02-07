package kr.koreait.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.koreait.DAO.MVCBoardDAO;
import kr.koreait.VO.MVCBoardVO;

public class ReplyService implements MVCBoardService {

	@Override
	public void execute(Model model) {
		System.out.println("ReplyService execute()");

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		MVCBoardDAO dao = new MVCBoardDAO();
		MVCBoardVO vo = dao.reply(idx);
		
		model.addAttribute("reply", vo);
	}

}
