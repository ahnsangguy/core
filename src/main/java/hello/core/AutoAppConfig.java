package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
		basePackages = "hello.core.member, hello.core.discount",
		excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
	
	/* 빈 중복 등록 테스트 수동 생성 vs 자동 생성 일 경우 수동 생성으로 Overriding 
	 * 근데 스프링 부트에서는 빈 중복 등록 시 Exception 발생한다. */
//	@Bean(name = "memoryMemberRepository")
//	MemberRepository MemberRepository() {
//		return new MemoryMemberRepository();
//	}
}
