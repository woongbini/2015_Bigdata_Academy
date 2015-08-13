package step01.domain;

/*1. 용도 - 데이터 용 클래스
2. 용어 - 데이터용 클래스인경우에는 value 객체이면서 다수의 class 데이터 객체로 전송
		  data transfer 객체라고도 함.
3. 전문용어
	value 객체 = VO pattern
	data transfer 객체 = DTO pattern
4. 코드의 형식을 최적화된 구조로 정형화 기켜서 권장 -> design pattern

*/
public class People {
	private String name;
	private int age;
	
	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public People() {
		super();
	}

	public String getName() {	return name;}
	public void setName(String name) {	this.name = name;}
	public int getAge() {	return age;	}
	public void setAge(int age) {	this.age = age;	}
	
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
}
