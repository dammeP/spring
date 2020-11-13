package kr.or.ddit.config.spring;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;

//@ImportResource({"classpath:kr/or/ddit/config/spring/aop-context.xml"})
//@Import({AopContext.class, DataSourceContext.class, TransactionContext.class})
//Bean구성 class임을 알려주는 어노테이션, 자바파일이 스프링임을 알려준다
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false,
								includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Service.class, Repository.class})})	// context
public class RootContext {
	
	// bean에 이름설정하면 그게 이름이 되지만 따로 설정안하면 메서드가 이름이 된다
	@Bean
	public MessageSource messageSource() {		// bean
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasenames("classpath:kr/or/ddit/message/error", "classpath:kr/or/ddit/message/msg");
		
		return messageSource;
	}
	
	

}
