package hello.core.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {
	
	MemberService memberService;
	
	@BeforeEach // @Test 실행 전 먼저 해당 메서드를 실행
	public void beforeEach() {
		
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	
	@Test
	void join() {
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		assertThat(member).isEqualTo(findMember);
	}
}
