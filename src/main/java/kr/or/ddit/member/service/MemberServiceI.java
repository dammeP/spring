package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberServiceI {
	
	MemberVO getMember(String userid);
	
	List<MemberVO> selectAllMember();
	
	Map<String, Object> selectAllMemberPage(PageVO pageVO);
	
	int selectMemberTotalCount();
//
	int insertMember(MemberVO memberVO);
//	
//	int deleteMember(String userid);
//	
	int updateMember(MemberVO memberVO);
}
