package polymorphism;

abstract class Geometry { //�߻� Ŭ���� ����
	protected int x;
	protected int y;
	
	public Geometry(int x, int y) { 	
		this.x = x;
		this.y = y;
	}
	
	abstract void draw(); //�߻� �޼ҵ�
	
}
