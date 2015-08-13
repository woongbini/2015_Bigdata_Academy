/**학습내용
1. 배열 + API + 상속 다형성 + 형변환 문법을 활용한 응용
2. java.util.arraylist API활용
	- 배열과 동일한 특징
	- 고유한 index로 데이터 구분
	- 객체타입만 저장 가능
	- 배열은 한번 생성된 메모리 사이즈 불변, arrayList 동적 메모리 제공 (유연성 제공)
3. 기능
	1. ArrayList 생성 - 데이터저장공간 확보
	2. 데이터 저장해서 ArrayList 통으로 제공
		- v가 참조하는 데이터를 arrayList객체에 저장
			public boolean add(Object v) { } 
		
	3. ArrayList내에 저장된 다수의 데이터 활용
		- 특정 인덱스의 저장된 데이터를 반환 
			public Object get(int index) { }
		- 특정 인덱스로 해당 데이터 삭제
			public boolean remove(int index) { }
	4. 
	*/
package step02.oop;

import java.util.HashMap;

public class OOPTest2 {

	public static void main(String[] args) {
		java.util.ArrayList al = new java.util.ArrayList();
		//? "김두호", new Integer(25)를 각각 arrayList에 저장하시오
		
		al.add("김두호"); //index 0에 자동 저장
		al.add(new Integer(25));
		
		//? index 0번째 존재하는 데이터를 반환
		String s = (String) al.get(0); //Object타입을 자식타입으로 형변환 해줘야한다.
		System.out.println(s);
		
		//? Integer클래스의 메소드 중 intValue()라는 메소드 존재, 이 메소드를 호출해서 Integer객체 타입을 int타입으로 출력
		Integer i = (Integer)al.get(1);
		int i2 = i.intValue();
		System.out.println(i2);
		
		/**Key와 value로 데이터 관리하는 형태의 구조 - 자료구조!
		1. Key는   중복 불가
		2. Value는 중복 가능
		3. *** JDK1.5부터의 문법 적용 - 제네릭
		*/
		//제네릭이 미 적용된 Map객체
		HashMap m = new HashMap(); 
		m.put("일",  "데이터1");
		m.put("이",  new Integer(25));
		String st = (String) m.get("일");
		
		//제네릭 적용 - 특정 타입만 저장 및 관리할수 있게 제약조건 설정 
		//장점 - 형변환없이 자식타입의 변수에 대입가능 (코드의 간결성)
		HashMap<String, String> m2 = new HashMap<String, String>();
		m2.put("일",  "데이터1");
		//m2.put("이",  new Integer(25)); //문법오류!!!
		String st2 = m2.get("일");
		System.out.println(st2);
		
		
		/**autoboxing & unboxing : JDK1.5부터만 적용
		자바의 기본타입 : 도우미 참조타입 클래스(wrapper class에서만 적용됨)
		int -> Integer
		float -> Float
		...등이 존재!!!한다!!!
		*/
		
		int i6 = new Integer(2); //unboxing
			//컴파일 직후 변경되는 코드
			//int i6 = (new Integer(2)).intValue();
		
		Integer i7 = 3; //autoboxing
			//컴파일 직후 변경되는 코드
			//Integer i7 = new Integer(3);
		
		
	}
	
}
