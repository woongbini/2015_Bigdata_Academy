
package step01.test;

import step01.domain.People;

/*�н�����
1. ��ü ���� ����
	-String�� ����Ÿ��������, ���� ���Ǵ� Ÿ���̶� ""ǥ��������� �ڵ� ��üȭ
	 String�� ������ ��� Ÿ���� �ݵ帳 new������ �������θ� ����

2. �ڹ��� ������ Ÿ���� ��ȯŸ�� �Ǵ� parameter Ÿ������ Ȱ��

3. �迭�� ���� test
	-�迭 ������ �ڵ� �����Ǵ� ���� - length
	-��� �迭�� ��ü

4. Application Programming Interface Ȱ��
	-�������� ����Ŭ�� library
	-class, ����, �޼ҵ�, ������ ����Ƽ� API��� ��.

5. ��Ӱ� ������
	
6. MVC ���� ����
	-main�޼ҵ� �ù��� mvc������ ������ �ǽ� ����

7. JDK 1.5���� �߰��� ����
	1. for
	2. ���׸�
	3. autoboxing
	4. unboxing
-�м���, ���۸�, ������, ���Ƿ�, �ڵ�Ʃ��, ... -> PM�� �ȴ� 
*/

public class Test {
	
	static void m3(int[] v) {
		//int[] �ݺ��ؼ� ���
		for(int i=0 ; i<v.length ; i++) {
			System.out.print(i + "\t");
		}
		//JDK1.5���� �߰��� for (���� : �迭)
		for(int i :v) {
			System.out.print(i + "\t");
		}
	}
	
	static People m4() {
		People p1 = new People("������",43);
		return p1;
	}
	
	static void m5(People p) {
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}
	
	//��People��ü 3�������ؼ� ��ȯ�ϴ� �޼ҵ�
	static People[] m6() {
		People[] pp =  { new People("����", 21), new People("����", 22), new People("������", 23)};
		return pp;
	}
	//�ټ��� People��ü�� �ϳ��� ������ �޾Ƽ� �����Ͱ� �����ϴ� ��ŭ �ݺ��ؼ� �̸��� ����ϱ� (�ݺ���andlength����ϱ�
	static void m7(People[] pp) {
		for(int i = 0 ; i<pp.length ; i++) {
			System.out.println(pp[i].getName());
		}
	}
	
	public static void main(String[] args) {
		int i = 3;
		String s = "3";
		Integer i2 = new Integer(3);
		People p = new People("���ȣ", 25);
		p.setName("������");
		//System.out.println(p.getName());
		Test.m5(Test.m4());	
		Test.m7(Test.m6());
		
		//����ø��� 0.0~1.0���������� double�� ��ȯ���ִ� ���� �߻� �޼ҵ� ����� ��� java.lang.MathŬ������ �޼ҵ� Ȱ��
		System.out.println(Math.random());
		
		//3 5 �ϳ��� �ִ밪�� ��ȯ(API�� ��ļ����� �� Ȱ�� ���� �����ϴ�)
		System.out.println(Math.max(3, 5));
		
		
	}
}