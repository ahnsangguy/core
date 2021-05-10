package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository;
	private final DiscountPolicy DiscountPolicy;
	
	public OrderServiceImpl(MemberRepository memberRepository, hello.core.discount.DiscountPolicy discountPolicy) {
		
		this.memberRepository = memberRepository;
		this.DiscountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		
		Member member = memberRepository.findById(memberId);
		int discountPrice = DiscountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	// 테스트 용도
	public MemberRepository getMemberRepository() {
		
		return memberRepository;
	}
}
