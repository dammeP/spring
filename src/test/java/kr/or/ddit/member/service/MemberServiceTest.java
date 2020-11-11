package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest extends ModelTestConfig{

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Test
	public void insertMember_SUCCESS_Test() {
		/***Given***/
		MemberVO memberVO = new MemberVO("temp","dditPass", "대덕인재","개발원","대전","","123","","");

		/***When***/
		int insertCnt = memberService.insertMember(memberVO);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void insertMember_FAIL_Test() {
		/***Given***/
		MemberVO memberVO = new MemberVO("ddit","dditPass", "대덕인재","개발원","대전","","123","","");

		/***When***/
		int insertCnt = memberService.insertMember(memberVO);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void ListMemberTest() {
		/***Given***/
		

		/***When***/
		List<MemberVO> memberList = memberService.selectAllMember();
		
		/***Then***/
		assertTrue(memberList.size() > 13);
	}
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "brown";
		
		/***When***/
		MemberVO memberVO = memberService.getMember(userid);
		
		/***Then***/
		assertEquals("브라운", memberVO.getUsernm());
	}
	
	@Test
	public void SelectAllMemberPageTest() {
		/***Given***/
		int page = 1;
		int pageSize = 5;
		PageVO pageVO = new PageVO(page,pageSize);
		int totalCnt = memberService.selectMemberTotalCount();
		int pages = (int)Math.ceil((double)totalCnt/pageSize);
//		

		/***When***/
		Map<String, Object> map =memberService.selectAllMemberPage(pageVO);
		map.put("memberList", memberService.selectAllMemberPage(pageVO));
		map.put("pages", pages);

		/***Then***/
		assertEquals(map.get("pages"), 6);
	}
	@Test
	public void selectMemberTotalCountTest() {
		/***Given***/

		/***When***/
		int totalCnt = memberService.selectMemberTotalCount();
		
		/***Then***/
		assertEquals(30, totalCnt);
		
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		
		MemberVO memberVO = new MemberVO("gugu","dditPass", "수정","수정","대전","","123","","");

		/***When***/
		int updateCnt = memberService.updateMember(memberVO);

		/***Then***/
		assertEquals(1, updateCnt);
	}

}
