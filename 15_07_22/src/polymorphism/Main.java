package polymorphism;

public class Main {
	public static void main(String[] args) {
		//각 도형 클래스의 객체를 생성한다.
		Triangle tri = new Triangle(10, 20, 11, 21, 12, 22); //삼각형
		Rectangle rect = new Rectangle(20, 30, 100, 200); //사각형
		Circle cir = new Circle(30, 40, 300); //원형
		
		//Geometry 배열에 각 도형 클래스 객체를 저장한다. 
		Geometry [] geos = new Geometry[3];
		geos[0] = tri;
		geos[1] = rect;
		geos[2] = cir;
		
		//Geometry 배열의 각 요소에 대하여 도형을 그리는 메소드를 호출하여 도형을 표현한다.
		for(Geometry geo : geos) {
			geo.draw();
		}
		
	}

}
