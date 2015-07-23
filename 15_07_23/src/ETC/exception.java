package ETC;
/*
일부러 예외를 만들어야할때도 있다
throw와 catch를 써서 쓴다.(건너뛰고 싶을때...)
*/
public class exception {
	
	public static double divideByZero(int x, int y) {
		return x / y;
	}
	
	public static void main(String[] args) {
		int x = 50;
		int y = 0;
		double z = 0;
		
		//0으로 나누기 예외처리
		try {
			
			z = divideByZero(x,y);
			System.out.printf("결과 : %f \n", z);
			
		} catch (ArithmeticException e) {
			
			System.out.println("0으로 나누기 예외 발생ㅋ");
		
		} finally {
		
			System.out.println("처리 완료");
		}
	}
}