/**�н�����
1. �迭 + API + ��� ������ + ����ȯ ������ Ȱ���� ����
2. java.util.arraylist APIȰ��
	- �迭�� ������ Ư¡
	- ������ index�� ������ ����
	- ��üŸ�Ը� ���� ����
	- �迭�� �ѹ� ������ �޸� ������ �Һ�, arrayList ���� �޸� ���� (������ ����)
3. ���
	1. ArrayList ���� - ������������� Ȯ��
	2. ������ �����ؼ� ArrayList ������ ����
		- v�� �����ϴ� �����͸� arrayList��ü�� ����
			public boolean add(Object v) { } 
		
	3. ArrayList���� ����� �ټ��� ������ Ȱ��
		- Ư�� �ε����� ����� �����͸� ��ȯ 
			public Object get(int index) { }
		- Ư�� �ε����� �ش� ������ ����
			public boolean remove(int index) { }
	4. 
	*/
package step02.oop;

import java.util.HashMap;

public class OOPTest2 {

	public static void main(String[] args) {
		java.util.ArrayList al = new java.util.ArrayList();
		//? "���ȣ", new Integer(25)�� ���� arrayList�� �����Ͻÿ�
		
		al.add("���ȣ"); //index 0�� �ڵ� ����
		al.add(new Integer(25));
		
		//? index 0��° �����ϴ� �����͸� ��ȯ
		String s = (String) al.get(0); //ObjectŸ���� �ڽ�Ÿ������ ����ȯ ������Ѵ�.
		System.out.println(s);
		
		//? IntegerŬ������ �޼ҵ� �� intValue()��� �޼ҵ� ����, �� �޼ҵ带 ȣ���ؼ� Integer��ü Ÿ���� intŸ������ ���
		Integer i = (Integer)al.get(1);
		int i2 = i.intValue();
		System.out.println(i2);
		
		/**Key�� value�� ������ �����ϴ� ������ ���� - �ڷᱸ��!
		1. Key��   �ߺ� �Ұ�
		2. Value�� �ߺ� ����
		3. *** JDK1.5������ ���� ���� - ���׸�
		*/
		//���׸��� �� ����� Map��ü
		HashMap m = new HashMap(); 
		m.put("��",  "������1");
		m.put("��",  new Integer(25));
		String st = (String) m.get("��");
		
		//���׸� ���� - Ư�� Ÿ�Ը� ���� �� �����Ҽ� �ְ� �������� ���� 
		//���� - ����ȯ���� �ڽ�Ÿ���� ������ ���԰��� (�ڵ��� ���Ἲ)
		HashMap<String, String> m2 = new HashMap<String, String>();
		m2.put("��",  "������1");
		//m2.put("��",  new Integer(25)); //��������!!!
		String st2 = m2.get("��");
		System.out.println(st2);
		
		
		/**autoboxing & unboxing : JDK1.5���͸� ����
		�ڹ��� �⺻Ÿ�� : ����� ����Ÿ�� Ŭ����(wrapper class������ �����)
		int -> Integer
		float -> Float
		...���� ����!!!�Ѵ�!!!
		*/
		
		int i6 = new Integer(2); //unboxing
			//������ ���� ����Ǵ� �ڵ�
			//int i6 = (new Integer(2)).intValue();
		
		Integer i7 = 3; //autoboxing
			//������ ���� ����Ǵ� �ڵ�
			//Integer i7 = new Integer(3);
		
		
	}
	
}
