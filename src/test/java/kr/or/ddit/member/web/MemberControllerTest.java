package kr.or.ddit.member.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class MemberControllerTest extends WebTestConfig{

	@Test
	public void getViewTest() throws Exception{
		mockMvc.perform(get("/login/view"))
				.andExpect(status().isOk())
				.andExpect(view().name("login/view"));
	}
	
	@Test
	public void memberListTest() throws Exception {
		mockMvc.perform(get("/member/listAjaxHTML")
				.param("page", "1")
				.param("pageSize", "5"))
				.andExpect(status().is(200))
				.andExpect(view().name("member/listAjaxHTML"))
				.andExpect(model().attributeExists("pageVO"));
		
	}
	@Test
	public void memberDetailTest() throws Exception {
		mockMvc.perform(get("/member/detailAjax")
				.param("userid", "brown"))
				.andExpect(status().is(200))
				.andExpect(view().name("jsonView"))
				.andExpect(model().attributeExists("memberVO"));
		
	}
	
	@Test
	public void memberRegistTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/가위.PNG");
		
		MockMultipartFile file = new MockMultipartFile("realFile","가위.PNG", "image/PNG",is);
		
		mockMvc.perform(fileUpload("/member/regist")
				.file(file)
				.param("userid", "new")
				.param("pass", "뉴")
				.param("usernm", "뉴")
				.param("alias", "뉴")
				.param("addr1", "뉴")
				.param("addr2", "뉴")
				.param("zipcode", ""))
				.andExpect(view().name("redirect:/member/list"))
				.andExpect(status().is3xxRedirection())
				.andDo(print());
	}
	
	@Test
	public void memberUpdateTest() throws Exception {
		
		InputStream is =getClass().getResourceAsStream("/kr/or/ddit/upload/2.jpg");
		
		MockMultipartFile file = new MockMultipartFile("realFile","2.jpg", "image/jpg",is);
		
		mockMvc.perform(fileUpload("/member/update")
				.file(file)
				.param("userid", "aaa")
				.param("pass", "뉴")
				.param("usernm", "뉴")
				.param("alias", "뉴")
				.param("addr1", "뉴")
				.param("addr2", "뉴")
				.param("zipcode", "123456"))
				.andExpect(status().is(302))
				.andExpect(view().name("redirect:/member/detail?userid=aaa"));
	}

}
