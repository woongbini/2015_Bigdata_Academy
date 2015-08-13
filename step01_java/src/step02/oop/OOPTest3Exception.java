/**����ó��
1. ������ �迭 exception
2. runtime �迭 exception
3. ����ó�� ����
	3-1 ��Ÿ�Ӱ迭 : �����Ͱ��� ����
	3-2 ������ �迭
		1. �߻��������� ó��
		2. ȣ���� ������ ����ó�� ����
*/

package step02.oop;

public class OOPTest3Exception {
	
	//������ exception & �߻��� �������� ó���ϴ°� �ƴ� �MǮ�Ѱ����� ����ó������ ����
	static void m2() throws ClassNotFoundException {
		Class.forName("step02.oop.A");
	}
	
	//����ó�� �߰� ���� : ���� ���ܹ߻������� �����ϰ� ������ ���ຸ�� ������ �����Ұ���� �ڵ� ���
	static void m3() throws ClassNotFoundException {
		try {
		Class.forName("step02.oop.A");
		} finally {
			System.out.println("������ �����ؾ� �ϴ� �����̶� ����");
		}
	}
	
	public static void main(String[] args) {
		//m1();
		
		try{
			m2();
		} catch (ClassNotFoundException e1) {
			
		}
		//RuntimeException �� ����Ÿ���� test: try~catch���� ���ʿ�...
		System.out.println(10/0);
		
		
		//byte code�� �޸� �ε��ϴ� API java.lang.class forName

			try {
				Class.forName("A2");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Ŭ���� �� ");
			}
		

	}
}

	
/**static��� ���� ����
byte code�� �޸𸮿� �ε��ɋ� �ڵ� ����
���� �ڵ� : ������ ���� �����߿� ��� user���� �����ϴ� �ڿ��� ��� ���ѹ��� �ʱ�ȭ

*/
class A extends Object {


	static {
		System.out.println("A");
	}
	
}