package springHello;

public class Hello implements IHello {
	public String sayHello(String name) {
		return "안녕하세요? " + name + " 씨!";
	}
}
