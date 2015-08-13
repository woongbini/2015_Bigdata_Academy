package step02.oop;

class Parent extends Object{
	String msg;
	Parent() { //코딩하지 않아도 생성자 컴파일 직후 자동추가
		super(); //parameter가 일치하는 부모 생성자 호출
		System.out.println("나는 부모이므니다");
	}
	void printAll () {
		System.out.println(msg);
	}
}

class Child extends Parent {
	int money;
	Child() {
		super(); //부모 생성자 호출하는 원리가 기본적으로 첫라인에 적용
		System.out.println("자식이다");
	}
	void printAll() { //상속받았으나 내용 즉 {}즉 body부분 수정(재정의)
		super.printAll(); //부모메소드의 100%적용
		System.out.println(money);
	}
	String hopeMsg() {  //자식만의 새로운 메소드
		return "돈 벼락";
	}
}

public class OOPTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.printAll();
		System.out.println(c.hopeMsg());
		
		Parent p = new Child(); //다형성 - 전제조건 상속관계에서만 성립	
		p.printAll();
		Child c2 = (Child)p; //객체간의 형변환 문법
		c2.money = 100;
		
		Parent[] all = { new Parent(), new Child() };
		Child cd = (Child)all[1];
		System.out.println(cd.money);
	}

}
