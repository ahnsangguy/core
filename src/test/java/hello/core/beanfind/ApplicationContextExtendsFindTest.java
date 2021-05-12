package hello.core.beanfind;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	
//	@Test
//	@DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면 중복 오류가 발생한다")
//	void findBeanByParentTypeDuplicate() {
//		
//		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
//	}
	
//	@Test
//	@DisplayName("부모 타입으로 조회 시 자식이 둘 이상 있으면 빈 이름을 지정하면 된다")
//	void findBeanByParentTypeBeanName() {
//		
//		DiscountPolicy bean = ac.getBean("rate", DiscountPolicy.class);
//		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
//	}
	
//	@Test 
//	@DisplayName("특정 하위 타입으로 조회")
//	void findBeanBySubType() {
//		
//		DiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
//		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
//	}
	
//	@Test 
//	@DisplayName("부모 타입으로 모두 조회하기")
//	void findBeanByParentType() {
//		
//		Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
//		
//		for (String key : beansOfType.keySet()) {
//			
//			System.out.println("key : " + key + ", value = " + beansOfType.get(key));
//		}
//		
//		System.out.println("beanOfType : " + beansOfType);
//		assertThat(beansOfType.size()).isEqualTo(2);
//	}
	
	@Test 
	@DisplayName("부모 타입으로 모두 조회하기 - Object")
	void findAllBeanByObjectType() {
		
		Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
		
		for (String key : beansOfType.keySet()) {
			
			System.out.println("key : " + key + ", value = " + beansOfType.get(key));
		}
		
		System.out.println("beanOfType : " + beansOfType);
	}
	
	@Configuration
	static class TestConfig {
		
		@Bean
		public DiscountPolicy rate() {
			
			return new RateDiscountPolicy();
		}
		
		@Bean
		public DiscountPolicy fix() {
			
			return new FixDiscountPolicy();
		}
	}
}