package kr.koreait.DAO;

import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
	//접속하는 걸 context.xml에서 갖고 오지 말고, servlet-context.xml에 만들어놓은 bean으로 가져올 수 있다.
	public static JdbcTemplate template;
	
	//HomeController에 가서 위 변수를 사용할 수 있도록 객체를 연결하고 getter/setter를 준비하자.
	
}
