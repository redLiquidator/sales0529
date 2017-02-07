package kr.koreait.springMVCBoardJDBC;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.koreait.Service.DeleteService;
import kr.koreait.Service.IncrementService;
import kr.koreait.Service.ListService;
import kr.koreait.Service.MVCBoardService;
import kr.koreait.Service.ReplyOKService;
import kr.koreait.Service.ReplyService;
import kr.koreait.Service.UpdateService;
import kr.koreait.Service.ViewService;
import kr.koreait.Service.WriteService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//MVCBoardService인터페이스가 부모는 아니지만, 부모처럼 하나의 구심점 역할을 하고 있다.
	//인터페이스 객체를 인스턴스 변수로 만들자.
	//각각의 메서드에서 execute 메서드를 실행할 때, 해당 서비스 클래스와 동적으로 결합하게 된다.
	//동적 결합? 부모 = 자식() , 자식이 갖고 있는 메서드를 실행한다.
	//정적 결합은 부모걸 하는데, 자바에는 정적결합이 없음.
	//다형적 대입(다형성)을 하게 되면 '자식'의 메서드를 실행한다는 걸 기억하자!
	MVCBoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//쓰기 - 완료
	@RequestMapping("/write")
	public String write(){
		System.out.println("write.jsp로 이동합니다");
		return "write";	//단지 "글쓰기 form"을 보여주면 된다.
						//write.jsp로 이동!
	}
	
	//작성한 이후에.. submit을 누른다! 그러면 db에 쓰게 되는데..
	@RequestMapping("/writeOK")
	public String writeOK(HttpServletRequest request, Model model){
		System.out.println("writeOK -- DB에 쓰러갑니다");
		
		//서비스 페이지 부르기 위해 request를 model에 싣자.
		model.addAttribute("request",request);
		
		service = new WriteService();
		service.execute(model);

		return "redirect:list";
	}
	
	//목록보기
	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list - 글 목록보기");
		//database에 등록한 글을 가져와야한다.
		service = new ListService();	//모든 ~~service는 execute를 갖고 있고, 여기선 해당 클래스의 execute를 실행한다.
		service.execute(model);	//컨트롤러>ListService>~~DAO>ListService>컨트롤러
		//가져온 글을 model에 저장시킨 후..
		
		
		return "list";	//뷰페이지 "list" 로 가자!
	}
	
	//글 한건보기 - 목록(list)에서 한 건을 클릭했다는 얘기다!
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model){
		System.out.println("view - 글 세부보기");
		//글번호를 갖고 db에 가야한다.
		model.addAttribute("request", request);
		//db에서 글 세부내용을 싹 가져오자
		service = new ViewService();
		service.execute(model);
		//그 세부 내용을 model에 담자
		
		//그리고 뷰페이지로 가자
		
		return "view";
	}
	
	//view 또는 list에서 글 제목을 누르면 글 세부보기가 된다. 이때 조회수를 증가시켜야한다.
	//hit 카운트 증가(upHit())
	@RequestMapping("/increment")
	public String increment(HttpServletRequest request, Model model){
		System.out.println("increment - 글 조회수 증가합니다.");
		model.addAttribute("request",request);
		service = new IncrementService();
		service.execute(model);
		return "redirect:view";	//view 페이지로 가야한다.
	}
	
	//삭제하기
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete - 글을 삭제합니다. ");
		//글 내용을 보여주고 이 글을 삭제 시킬 수 있어야 한다.
		model.addAttribute("request", request);
		service = new DeleteService();
		service.execute(model);
		return "redirect:list";
	}

	//수정하기
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model){
		System.out.println("update - 글을 수정합니다. ");
		//글 내용을 보여주고 이 글을 수정 시킬 수 있어야 한다.
		model.addAttribute("request", request);
		service = new UpdateService();
		service.execute(model);
		return "redirect:list";
	}
	
	//답글달기
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model){
		System.out.println("reply - 뷰 페이지");
		model.addAttribute("request", request);
		service = new ReplyService();
		service.execute(model);
		return "reply";
	}

	@RequestMapping("/replyOK")
	public String replyOK(HttpServletRequest request, Model model){
		System.out.println("replyOK - 뷰 페이지");
		model.addAttribute("request", request);
		service = new ReplyOKService();
		service.execute(model);
		return "redirect:list"; //list 페이지로 가자
	}
	
}
