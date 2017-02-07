package kr.koreait.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.koreait.DAO.MVCBoardDAO;
import kr.koreait.VO.MVCBoardVO;

public class ViewService implements MVCBoardService {

	@Override
	public void execute(Model model) {
		System.out.println("ViewService - 글 한건봅니다.");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int idx = Integer.parseInt(request.getParameter("idx"));
		MVCBoardVO vo = new MVCBoardDAO().view(idx);
		
		//또다시 실어보내자!
		model.addAttribute("view",vo);
		
	}

}
