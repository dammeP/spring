package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"kr.or.ddit.board"})		// kr.or.ddit 하면 member쪽도 같이 읽는다
public class JavaSpringScanConfig {

}
