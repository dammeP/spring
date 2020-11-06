package kr.or.ddit.mvc.exception.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@RequestMapping("/exception/view")
	public String view() {
		
		logger.debug("ExceptionController.view()");
		throw new ArithmeticException();
//		return "";
		
	}
	
//	@ExceptionHandler({ArithmeticException.class})
//	public String handler() {
//		logger.debug("ExceptionController.handler()");
//		
//		// 에러를 처리할 화면
//		return "/exception/arithmetic";
//	}
}
