package polymorphism;

public class Main {
	public static void main(String[] args) {
		//�� ���� Ŭ������ ��ü�� �����Ѵ�.
		Triangle tri = new Triangle(10, 20, 11, 21, 12, 22); //�ﰢ��
		Rectangle rect = new Rectangle(20, 30, 100, 200); //�簢��
		Circle cir = new Circle(30, 40, 300); //����
		
		//Geometry �迭�� �� ���� Ŭ���� ��ü�� �����Ѵ�. 
		Geometry [] geos = new Geometry[3];
		geos[0] = tri;
		geos[1] = rect;
		geos[2] = cir;
		
		//Geometry �迭�� �� ��ҿ� ���Ͽ� ������ �׸��� �޼ҵ带 ȣ���Ͽ� ������ ǥ���Ѵ�.
		for(Geometry geo : geos) {
			geo.draw();
		}
		
	}

}
