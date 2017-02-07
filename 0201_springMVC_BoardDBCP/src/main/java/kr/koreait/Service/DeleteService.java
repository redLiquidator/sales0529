package kr.koreait.Service;

import org.springframework.ui.Model;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.koreait.DAO.MVCBoardDAO;
public class DeleteService implements MVCBoardService {

	@Override
	public void execute(Model model) {
		System.out.println("DeleteService execute()");

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		MVCBoardDAO dao = new MVCBoardDAO();
		dao.delete(idx);
	}

}
