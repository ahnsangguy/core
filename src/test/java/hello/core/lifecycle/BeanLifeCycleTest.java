package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
	
	@Test
	public void lifeCycleTest() {
		
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		NetworkClient networkClient = ac.getBean(NetworkClient.class);
		ac.close();
	}
	
	@Configuration
	static class LifeCycleConfig {
		
//		@Bean(initMethod = "init", destroyMethod = "close") 이건 외부 라이브러리에도 사용 가능함 (라이브러리에 있는 메소드 명만 지정해주면 됨 대부분 close 메소드는 있음)
		@Bean
		public NetworkClient networkClient() {
			
			NetworkClient networkClient = new NetworkClient();
			networkClient.setUrl("http://hello-spring.dev");
			return networkClient;
		}
	}
}
