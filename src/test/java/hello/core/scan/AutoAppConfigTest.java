package hello.core.scan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class AutoAppConfigTest {
	
	@Test
	void basicScan() {
		
		/* AutoAppConfig의 @ComponentScan으로 인해 @Component 적용한 모든 클래스 스프링 빈에 등록 
		 * 
		 * OrderServiceImpl에 있는 @Autowired 때문에 해당 테스트는 에러 발생
		 * DiscountProlicy를 상속받는 클래스가 Fix, Rate 2개가 있어 NoUniqueBeanDefinitionException 에러 발생
		 * 
		 */
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		
		MemberService memberService = ac.getBean(MemberService.class);
		OrderService orderService = ac.getBean(OrderService.class);
//		assertThat(memberService).isInstanceOf(MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		memberService.findMember(1L);
		
		Member findMember = memberService.findMember(1L);
		
		System.out.println("New Member : " + member.getName());
		System.out.println("Find Member : " + findMember.getName());
		
		Order order = orderService.createOrder(1L, "itemA", 20000);

		System.out.println(order);
	}
}
