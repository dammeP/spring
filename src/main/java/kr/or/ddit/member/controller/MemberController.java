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
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.JSRMemberVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.MemberVoValidator;
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
		
		
//		return "/member/list";
//		return "tiles.memberList";
		return "tiles/member/memberListContent";
		
	}
	
	@RequestMapping("/listAjaxPage")
	public String listAjaxPage() {
		return "tiles/member/listAjaxPage";
	}
	
	// 페이지 요청(/list와 다르게 page, pageSize 파라미터가 반드시 존재한다는 가정으로 작성)
	@RequestMapping("/listAjax")
	public String listAjax(PageVO pageVO, Model model) {
		
		
		logger.debug("pageVO:{}", pageVO);
		
		Map<String, Object> map = memberService.selectAllMemberPage(pageVO);
		model.addAttribute("memList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		return "jsonView";
	}
	
	@RequestMapping("/listAjaxHTML")
	public String listAjaxHTML(PageVO pageVO, Model model) {
		
		
		logger.debug("pageVO:{}", pageVO);
		
		Map<String, Object> map = memberService.selectAllMemberPage(pageVO);
		model.addAttribute("memList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		// 응답을 html ==> jsp로 생성
		return "member/listAjaxHTML";
	}
	
	
	@RequestMapping(path="/detail")
	public String memberDetail(String userid, Model model) {
		
		MemberVO memberVO = memberService.getMember(userid);
		
		model.addAttribute("memberVO", memberVO);
		
//		return "/member/detail";
		return "tiles/member/detailContent";
	}
	
	@RequestMapping("/detailAjaxPage")
	public String detailAjaxPage() {
		return "tiles/member/detailAjaxPage";
	}
	
	@RequestMapping(path="/detailAjax")
	public String memberDetailAjax(String userid, Model model) {
		
		model.addAttribute("memberVO",  memberService.getMember(userid));
		
//		return "/member/detail";
		return "jsonView";
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
	public String memberRegister(@Valid MemberVO memberVO,BindingResult br,@RequestPart("realFile") MultipartFile file) {
//	public String memberRegister(@Valid JSRMemberVO memberVO,BindingResult br,@RequestPart("realFile") MultipartFile file) {
		
//		new MemberVoValidator().validate(memberVO, br);
		
		// 검증을 통과하지 못했으므로 사용자 등록 화면으로 이동
		if(br.hasErrors()) {
			return "tiles/member/registContent";
		}
		
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
			return "tiles/member/registContent";
		}
	}
	
	@RequestMapping(path="/update", method= {RequestMethod.GET})
	public String memberUpdate(@RequestParam("userid") String userid, Model model) {
		
//		model.addAttribute("userid",userid);
		
		MemberVO memberVO = memberService.getMember(userid);
		
		model.addAttribute("memberVO", memberVO);
		
		return "tiles/member/updateContent";
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
			return "tiles/member/updateContent";
		}
	}

}
