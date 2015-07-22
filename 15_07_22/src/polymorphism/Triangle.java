package polymorphism;

public class Triangle extends Geometry {
	private int x1; 
	private int y1;
	private int x2;
	private int y2;
	
	public Triangle(int x, int y, int x1, int y1, int x2, int y2) { 
		super(x, y);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public void draw() {  
		System.out.println("Triangle - ÁÂÇ¥ : "+x+","+y+" ²ÀÁöÁ¡ : "+x1+","+y1+","+x2+","+y2
				+" ³ĞÀÌ : ");
	}
	
}
