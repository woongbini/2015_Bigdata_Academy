/**예외처리
1. 컴파일 계열 exception
2. runtime 계열 exception
3. 예외처리 문장
	3-1 런타임계열 : 데이터값만 수정
	3-2 컴파일 계열
		1. 발생지점에서 처리
		2. 호출한 곳으로 예외처리 위임
*/

package step02.oop;

public class OOPTest3Exception {
	
	//컴파일 exception & 발생된 영역에서 처리하는게 아닌 홏풀한곳으로 예외처리위임 문법
	static void m2() throws ClassNotFoundException {
		Class.forName("step02.oop.A");
	}
	
	//예외처리 추가 문법 : 가령 예외발생유무와 무관하게 무조건 실행보장 문장이 존재할경우의 코딩 방법
	static void m3() throws ClassNotFoundException {
		try {
		Class.forName("step02.oop.A");
		} finally {
			System.out.println("무조건 실행해야 하는 로직이라 가정");
		}
	}
	
	public static void main(String[] args) {
		//m1();
		
		try{
			m2();
		} catch (ClassNotFoundException e1) {
			
		}
		//RuntimeException 의 하위타입의 test: try~catch문장 불필요...
		System.out.println(10/0);
		
		
		//byte code를 메모리 로딩하는 API java.lang.class forName

			try {
				Class.forName("A2");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("클래스 갑 ");
			}
		

	}
}

	
/**static블록 실행 시점
byte code가 메모리에 로딩될떄 자동 실행
권장 코드 : 서버가 최초 실행중에 모든 user들이 공유하는 자원인 경우 단한번만 초기화

*/
class A extends Object {


	static {
		System.out.println("A");
	}
	
}