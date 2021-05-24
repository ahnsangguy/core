package hello.core.order;

import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor // 요거 달면 final 달린 객체를 파라미터로 받는 생성자가 자동으로 생성
public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

//	@Autowired
//	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//		System.out.println("OrderServiceImpl.setDiscountPolicy() : " + discountPolicy);
//		this.discountPolicy = discountPolicy;
//	}
//	
//	@Autowired
//	public void setMemberRepository(MemberRepository memberRepository) {
//		System.out.println("OrderServiceImpl.setMemberRepository() : " + memberRepository);
//		this.memberRepository = memberRepository;
//	}
//
//	@Autowired
//	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//		
//		this.memberRepository = memberRepository;
//		this.discountPolicy = discountPolicy;
//	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
