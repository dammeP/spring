package kr.or.ddit.member.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberVoValidator implements Validator{

	// 검증하려고 하는 객체가 MemberVoValidator에서 검증이 가능한
	// 객체인지 boolean으로 리턴하는 메서드
	@Override
	public boolean supports(Class<?> clazz) {
		
		return MemberVO.class.isAssignableFrom(clazz);
	}
	
	// 검증 로직을 작성
	// Object targer : command 객체
	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memberVO = (MemberVO)target;
		
		// usernm 값이 null이거나 empty 문자열이면 안됨
		if(memberVO.getUsernm() == null || memberVO.getUsernm().equals("")) {
			errors.rejectValue("usernm", "required");
		}
	}

}
