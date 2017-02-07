package kr.koreait.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.koreait.DAO.MVCBoardDAO;

public class IncrementService implements MVCBoardService {

	@Override
	public void execute(Model model) {
		System.out.println("incrementService- 조회수 증가시킵니다.");
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int idx= Integer.parseInt(request.getParameter("idx"));
		new MVCBoardDAO().upHit(idx);
		model.addAttribute("idx", idx);
		
	}

}
