package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
	
	private String name;
	private int age;
	
	public static void main(String[] args) {
		
		HelloLombok helloLombok = new HelloLombok();
		
		helloLombok.setAge(15);
		helloLombok.setName("A");
		
		System.out.println(helloLombok.getName() + ", " + helloLombok.getAge());
		System.out.println(helloLombok);
	}
}
