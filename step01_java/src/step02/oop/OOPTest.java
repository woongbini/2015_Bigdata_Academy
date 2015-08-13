package step02.oop;

class Parent extends Object{
	String msg;
	Parent() { //�ڵ����� �ʾƵ� ������ ������ ���� �ڵ��߰�
		super(); //parameter�� ��ġ�ϴ� �θ� ������ ȣ��
		System.out.println("���� �θ��̹Ǵϴ�");
	}
	void printAll () {
		System.out.println(msg);
	}
}

class Child extends Parent {
	int money;
	Child() {
		super(); //�θ� ������ ȣ���ϴ� ������ �⺻������ ù���ο� ����
		System.out.println("�ڽ��̴�");
	}
	void printAll() { //��ӹ޾����� ���� �� {}�� body�κ� ����(������)
		super.printAll(); //�θ�޼ҵ��� 100%����
		System.out.println(money);
	}
	String hopeMsg() {  //�ڽĸ��� ���ο� �޼ҵ�
		return "�� ����";
	}
}

public class OOPTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.printAll();
		System.out.println(c.hopeMsg());
		
		Parent p = new Child(); //������ - �������� ��Ӱ��迡���� ����	
		p.printAll();
		Child c2 = (Child)p; //��ü���� ����ȯ ����
		c2.money = 100;
		
		Parent[] all = { new Parent(), new Child() };
		Child cd = (Child)all[1];
		System.out.println(cd.money);
	}

}
