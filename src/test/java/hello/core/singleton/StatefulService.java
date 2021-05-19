package hello.core.singleton;

public class StatefulService {
	
	private int price;
	
	public void order(String name, int price) {
		
		System.out.println("name : " + name + ", price : " + price);
		this.price = price; // 여기가 문제
	}
	
	public int getPrice() {
		return price; // 여기도 문제 price를 세팅 후 바로 가져가는 것이 아니라 나중에 가져가니까 문제가 생김
	}
}
