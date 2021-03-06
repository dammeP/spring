package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {

MemberVO getMember(String userId);
	
	List<MemberVO> selectAllMember();
	
	List<MemberVO> selectAllMemberPage(PageVO pageVO);
	
	int selectMemberTotalCount();
//	
	int insertMember(MemberVO memberVO);
//
//	int deleteMember(String userid);
	
	int updateMember(MemberVO memberVO);
}
