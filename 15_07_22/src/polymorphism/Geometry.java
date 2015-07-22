package polymorphism;

abstract class Geometry { //추상 클래스 선언
	protected int x;
	protected int y;
	
	public Geometry(int x, int y) { 	
		this.x = x;
		this.y = y;
	}
	
	abstract void draw(); //추상 메소드
	
}
