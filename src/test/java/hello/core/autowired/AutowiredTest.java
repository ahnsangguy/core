package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import hello.core.member.Member;

public class AutowiredTest {
	
	@Test
	void AutowiredOption() {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}
	
	static class TestBean {
		
		@Autowired(required = false) // 해당 옵션 설정되어 있으며 주입 할 Bean이 없을 경우 애초에 메서드 호출도 안 됨
		public void setNoBean1(Member member) {
			System.out.println("AutowiredTest.TestBean.setNoBean1() : " + member);
		}
		
		@Autowired // Null로 호출 됨
		public void setNoBean2(@Nullable Member member) {
			System.out.println("AutowiredTest.TestBean.setNoBean2() : " + member);
		}
		
		@Autowired // Optional.empty로 호출 됨
		public void setNoBean3(Optional<Member> member) {
			System.out.println("AutowiredTest.TestBean.setNoBean3() : " + member);
		}
	}
}
