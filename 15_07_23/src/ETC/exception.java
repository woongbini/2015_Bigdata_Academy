package ETC;
/*
�Ϻη� ���ܸ� �������Ҷ��� �ִ�
throw�� catch�� �Ἥ ����.(�ǳʶٰ� ������...)
*/
public class exception {
	
	public static double divideByZero(int x, int y) {
		return x / y;
	}
	
	public static void main(String[] args) {
		int x = 50;
		int y = 0;
		double z = 0;
		
		//0���� ������ ����ó��
		try {
			
			z = divideByZero(x,y);
			System.out.printf("��� : %f \n", z);
			
		} catch (ArithmeticException e) {
			
			System.out.println("0���� ������ ���� �߻���");
		
		} finally {
		
			System.out.println("ó�� �Ϸ�");
		}
	}
}