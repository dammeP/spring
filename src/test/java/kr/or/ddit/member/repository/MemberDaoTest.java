package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;




public class MemberDaoTest extends ModelTestConfig{

	@Resource(name="memberDao")
	private MemberDaoI memberDao;

	@Test
	public void ListMemberTest() {
		/***Given***/
		

		/***When***/
		List<MemberVO> memberList = memberDao.selectAllMember();
		
		/***Then***/
		assertTrue(memberList.size() > 13);
	}
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "brown";
		
		/***When***/
		MemberVO memberVO = memberDao.getMember(userid);
		
		/***Then***/
		assertEquals("브라운", memberVO.getUsernm());
	}
	
	@Test
	public void SelectAllMemberPageTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1,5);
		
		/***When***/
		List<MemberVO> memListPage = memberDao.selectAllMemberPage(pageVO);

		/***Then***/
		assertTrue(memListPage.size() > 4);
		
	}
	
	@Test
	public void selectMemberTotalCountTest() {
		/***Given***/

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCount();
		
		/***Then***/
		assertEquals(30, totalCnt);
		
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO("tt","dditPass", "대덕인재","개발원","대전","","123","","");

		/***When***/
		int insertCnt = memberDao.insertMember(memberVO);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO("gugu","구구", "대덕인재뿅뿅","개발원","대전","","123","","");

		/***When***/
		int updateCnt = memberDao.updateMember(memberVO);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	

}
