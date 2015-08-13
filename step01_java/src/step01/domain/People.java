package step01.domain;

/*1. �뵵 - ������ �� Ŭ����
2. ��� - �����Ϳ� Ŭ�����ΰ�쿡�� value ��ü�̸鼭 �ټ��� class ������ ��ü�� ����
		  data transfer ��ü��� ��.
3. �������
	value ��ü = VO pattern
	data transfer ��ü = DTO pattern
4. �ڵ��� ������ ����ȭ�� ������ ����ȭ ���Ѽ� ���� -> design pattern

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
