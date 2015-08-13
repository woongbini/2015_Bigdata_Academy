
package step01.test;

import step01.domain.People;

/*학습내용
1. 객체 생성 문법
	-String도 참조타입이지만, 많이 사용되는 타입이라서 ""표기법만으로 자동 객체화
	 String을 제외한 모든 타입은 반드립 new생성자 조합으로만 가능

2. 자바의 데이터 타입을 반환타입 또는 parameter 타입으로 활용

3. 배열에 대한 test
	-배열 생성시 자동 생성되는 변수 - length
	-모든 배열은 객체

4. Application Programming Interface 활용
	-제공받은 오라클의 library
	-class, 변수, 메소드, 생성자 싸잡아서 API라고 함.

5. 상속과 다형성
	
6. MVC 패턴 정리
	-main메소드 시반의 mvc구조를 적용한 실습 제시

7. JDK 1.5부터 추가된 문법
	1. for
	2. 젠네릭
	3. autoboxing
	4. unboxing
-분석력, 구글링, 가공력, 비판력, 코드튜닝, ... -> PM이 된다 
*/

public class Test {
	
	static void m3(int[] v) {
		//int[] 반복해서 출력
		for(int i=0 ; i<v.length ; i++) {
			System.out.print(i + "\t");
		}
		//JDK1.5부터 추가된 for (변수 : 배열)
		for(int i :v) {
			System.out.print(i + "\t");
		}
	}
	
	static People m4() {
		People p1 = new People("김혜경",43);
		return p1;
	}
	
	static void m5(People p) {
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}
	
	//객People객체 3개생성해서 반환하는 메소드
	static People[] m6() {
		People[] pp =  { new People("뱅뱅뱅", 21), new People("김김김", 22), new People("이이이", 23)};
		return pp;
	}
	//다수의 People객체를 하나의 변수로 받아서 데이터가 존재하는 만큼 반복해서 이름만 출력하기 (반복문andlength사용하기
	static void m7(People[] pp) {
		for(int i = 0 ; i<pp.length ; i++) {
			System.out.println(pp[i].getName());
		}
	}
	
	public static void main(String[] args) {
		int i = 3;
		String s = "3";
		Integer i2 = new Integer(3);
		People p = new People("김두호", 25);
		p.setName("김혜경");
		//System.out.println(p.getName());
		Test.m5(Test.m4());	
		Test.m7(Test.m6());
		
		//실행시마다 0.0~1.0이전까지의 double값 반환해주는 난수 발생 메소드 결과값 출력 java.lang.Math클래스의 메소드 활용
		System.out.println(Math.random());
		
		//3 5 하나의 최대값을 반환(API는 상식선에서 다 활용 생각 가능하다)
		System.out.println(Math.max(3, 5));
		
		
	}
}