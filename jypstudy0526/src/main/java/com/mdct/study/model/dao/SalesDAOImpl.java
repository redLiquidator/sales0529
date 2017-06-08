package com.mdct.study.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mdct.study.model.dto.AreaVO;
import com.mdct.study.model.dto.Parameter;
import com.mdct.study.model.dto.SalesVO;

//현재 클래스를 DAO bean으로 등록시킴
@Repository
public class SalesDAOImpl implements SalesDAO {
	// SqlSession 객체를 스프링에서 생성하여 주입시켜준다.
    // 의존관계 주입(Dependency Injection, DI)
    // 느스한 결함
    // IoC(Inversion of Control, 제어의 역전)
	// Inject애노테이션이 없으면 sqlSession은 null상태이지만
	// Inject애노테이션이 있으면 외부에서 객체를 주입시켜주게 된다. 
	// try catch문, finally문, 객체를 close할 필요가 없어졌다.
	
	@Inject
    SqlSession sqlSession;
	
	
	@Override
	public List<SalesVO> salesList(HashMap<String, Object> map) {
		System.out.println("this is SalesDAOImpl page"+map.get("city"));
		int direction1=(Integer) map.get("direction");
		List<SalesVO> list ;
		if(map.get("city")==null){
			list = sqlSession.selectList("sales.listAll",direction1);
			System.out.println("we got list here2:"+list);
		}
		else{
			map.put("direction", direction1);
			list = sqlSession.selectList("sales.listCity",map);	
			System.out.println("we got list here:"+list);
		}
		return list;
	};
	
	@Override
	public List<AreaVO> areaList(){
	List<AreaVO> areaList=sqlSession.selectList("sales.areaList");
/*	ArrayList<AreaVO> list1=new ArrayList<AreaVO>();
	for(Iterator<AreaVO> itr=list1.iterator(); itr.hasNext();){
		
		list1.get(itr.next());
	}*/
	System.out.println("we got areaList here:"+areaList);
	return areaList;
	};
}
