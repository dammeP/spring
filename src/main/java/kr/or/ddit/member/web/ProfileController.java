package kr.or.ddit.member.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.mvc.view.ProfileImgView;

@Controller
public class ProfileController {

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	
	@RequestMapping("/profileImgView")	
	// 화면과 컨트롤러 기능을 분리하기위해 이렇게 함
	public String profileImgView(String userid,Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는 것
			
		MemberVO memberVO = memberService.getMember(userid);
		model.addAttribute("filepath" , memberVO.getFilename());
		
		return "ProfileImgView";
	}
	
	
	@RequestMapping("/profileImg")
	public void profileImg(String userid,HttpServletResponse response) throws IOException {

		// response content-type 설정
		response.setContentType("image/png");


		// db에서 사용자 filename 확인
		MemberVO memberVO = memberService.getMember(userid);

		// 경로 확인 후 파일 입출력을 통해 응답생성
		// 파일 읽기
		// 응답 생성
		FileInputStream fis = new FileInputStream(memberVO.getFilename());
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}

		fis.close();
		sos.flush();
		sos.close();
		
	}
	
	@RequestMapping("/profileDownView")
	public String profileDownView(String userid,Model model) throws IOException {
		
	MemberVO memberVO = memberService.getMember(userid);
		model.addAttribute("filepath" , memberVO.getFilename());
		
		return "ProfileDownView";
	}

	
	@RequestMapping("/profileDown")
	public void profileDown(String userid,HttpServletResponse response) throws IOException {
		
		MemberVO memberVO = memberService.getMember(userid);
		
		//response content-type 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"\"" + memberVO.getRealfilename()+ "\"");
		response.setContentType("application/octet-stream");
		
		// 경로 확인 후 파일 입추력을 통해 응답생성
		// 파일 읽기
		// 파일 생성
		FileInputStream fis = new FileInputStream(memberVO.getFilename());
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer) != -1) { 
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
		
		
		}
	
}
