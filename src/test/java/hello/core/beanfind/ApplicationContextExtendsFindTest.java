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
//	@DisplayName("�θ� Ÿ������ ��ȸ �� �ڽ��� �� �̻� ������ �ߺ� ������ �߻��Ѵ�")
//	void findBeanByParentTypeDuplicate() {
//		
//		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
//	}
	
//	@Test
//	@DisplayName("�θ� Ÿ������ ��ȸ �� �ڽ��� �� �̻� ������ �� �̸��� �����ϸ� �ȴ�")
//	void findBeanByParentTypeBeanName() {
//		
//		DiscountPolicy bean = ac.getBean("rate", DiscountPolicy.class);
//		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
//	}
	
//	@Test 
//	@DisplayName("Ư�� ���� Ÿ������ ��ȸ")
//	void findBeanBySubType() {
//		
//		DiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
//		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
//	}
	
//	@Test 
//	@DisplayName("�θ� Ÿ������ ��� ��ȸ�ϱ�")
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
	@DisplayName("�θ� Ÿ������ ��� ��ȸ�ϱ� - Object")
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
