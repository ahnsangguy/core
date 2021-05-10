package hello.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderServiceTest {
	
	MemberService memberService;
	OrderService orderService;
	
	@BeforeEach
	public void beforeEach() {
		
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = new AppConfig().orderService();
	}
	
	@Test
	void createOrder() {
		
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(1L, "itemA", 10000);
		
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
