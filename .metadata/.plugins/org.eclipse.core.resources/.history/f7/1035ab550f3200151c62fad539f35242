package springHello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IHello hello = (IHello)ctx.getBean("hello");
		String message = hello.sayHello("김웅빈");
		System.out.println("메시지 : " + message);
	}

}
