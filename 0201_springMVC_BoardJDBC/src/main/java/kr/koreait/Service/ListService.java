package kr.koreait.Service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import kr.koreait.DAO.MVCBoardDAO;
import kr.koreait.VO.MVCBoardVO;

public class ListService implements MVCBoardService {

	@Override
	public void execute(Model model) {
		//dao의 list()를 불러와야 한다.
		System.out.println("ListService의 execute() 실행");
		MVCBoardDAO dao = new MVCBoardDAO();
		ArrayList<MVCBoardVO> list =dao.list();	//list로 가서 ArrayList에 담아놓은 내용을 가져와야한다.
		model.addAttribute("list",list);
	}

}
