package polymorphism;

public class Circle extends Geometry {
	private int radius;
	
	public Circle(int x, int y, int radius) {
		super(x,y);
		this.radius = radius;
	}
	public void draw() {  
		System.out.println("Cricle - ��ǥ: "+x+","+ y + " ���� : " + radius 
				+ " ���� : "+3.14*radius*radius);
	}
	
}