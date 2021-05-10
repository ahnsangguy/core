package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용 되어야 한다.")
	void vip_o() {
		
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		
		int discount = discountPolicy.discount(member, 10000);
		
		assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP가 아닌 경우 할인 적용이 되지 않아야 한다.")
	void vip_x() {
		
		Member member = new Member(1L, "memberVIP", Grade.BASIC);
		
		int discount = discountPolicy.discount(member, 10000);
		
		assertThat(discount).isEqualTo(1000);
	}
}
