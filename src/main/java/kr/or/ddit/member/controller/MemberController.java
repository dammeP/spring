package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;


@RequestMapping("/member")
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@RequestMapping(path="/list")
	public String memberList(@RequestParam(value="page",defaultValue = "1", required=false ) int page,@RequestParam(value="pageSize" ,defaultValue = "7", required=false) int pageSize,Model model) {
		
		model.addAttribute("page",page);
		model.addAttribute("pageSize",pageSize);
		
		PageVO pageVO = new PageVO(page, pageSize);
		
		Map<String, Object> map = memberService.selectAllMemberPage(pageVO);
		model.addAttribute("memList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		return "/member/list";
		
	}
	
	@RequestMapping(path="/detail")
	public String memberDetail(@RequestParam("userid")String userid, Model model) {
		
		MemberVO memberVO = memberService.getMember(userid);
		
		model.addAttribute("memberVO", memberVO);
		
		return "/member/detail";
	}
	
	@RequestMapping(path="/profileImg")
	public void profileImg(@RequestParam("userid")String userid, Model model,HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		
		model.addAttribute("userid",userid);
		MemberVO memberVO = memberService.getMember(userid);
		
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
	
	@RequestMapping(path="/regist" ,method={RequestMethod.GET})
	public String memberRegister() {
		return "/member/regist";
	
	}
	
	@RequestMapping(path="/regist" ,method={RequestMethod.POST})
	public String memberRegister( MemberVO memberVO,@RequestPart("realFile") MultipartFile file) {
		
		File uploadFile = new File("d:\\upload\\" + file.getOriginalFilename());
		
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		logger.debug("가입한 멤버VO : {}", memberVO);
		memberVO.setFilename("d:\\upload\\" + file.getOriginalFilename());
		memberVO.setRealfilename(file.getOriginalFilename());
		int insertCnt = memberService.insertMember(memberVO);
		
		logger.debug("insertCnt: {}", insertCnt);
			
		if(insertCnt == 1) {
			return "redirect:/member/list";
		}
		else {
			return "/member/regist";
		}
	}
	
	@RequestMapping(path="/update", method= {RequestMethod.GET})
	public String memberUpdate(@RequestParam("userid") String userid, Model model) {
		
//		model.addAttribute("userid",userid);
		
		MemberVO memberVO = memberService.getMember(userid);
		
		model.addAttribute("memberVO", memberVO);
		
		return "/member/update";
	}
	
	
	@RequestMapping(path="/update", method= {RequestMethod.POST})
	public String memberUpdate(MemberVO memberVO,@RequestPart("realFile") MultipartFile file) {
		
		
		if(file.getSize() > 0 ) {
			
			File uploadFile = new File("d:\\upload\\" + file.getOriginalFilename());
			
			memberVO.setFilename("d:\\upload\\" + file.getOriginalFilename());
			memberVO.setRealfilename(file.getOriginalFilename());
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		logger.debug("수정한 멤버VO : {}", memberVO);
		
		int updateCnt = memberService.updateMember(memberVO);
		
		logger.debug("updateCnt: {}", updateCnt);
		
		if(updateCnt == 1) {
			return "redirect:/member/detail?userid="+memberVO.getUserid();
		}
		else {
			return "/member/update";
		}
	}
	
	

}
