package kr.or.ddit.fileuplod.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import kr.or.ddit.WebTestConfig;

public class FileUploadControllerTest extends WebTestConfig{

	@Test
	public void viewTest() throws Exception{
			mockMvc.perform(get("/fileupload/view"))
					.andExpect(status().isOk())
					.andExpect(view().name("fileupload/view"))
					.andDo(print());
	}

	@Test
	public void uploadTest() throws Exception {
		
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("kr/or/ddit/upload/2.jpg");
		
//		FileInputStream fis = new FileInputStream("D:\\A_TeachingMaterial\\6.JspSpring\\workspace\\spring\\src\\test\\resources\\kr\\or\\ddit\\upload\\3.png");
		MockMultipartFile file = new MockMultipartFile("file","2.jpg", "image/jpg",is);
		
		mockMvc.perform(fileUpload("/fileupload/upload")
				.file(file)
				.param("userid", "브라운"))
				.andExpect(view().name("fileupload/upload"))
				.andExpect(status().isOk());
		
	}
}
