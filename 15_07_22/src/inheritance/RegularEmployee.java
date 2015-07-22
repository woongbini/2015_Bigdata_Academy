package inheritance;

public class RegularEmployee extends Employee {
	
	//슈퍼클래스의 기본생성자가 없으므로 오류발생.
	public RegularEmployee (String empno, String name, date entryDate, String address, double salary) {
		super(empno, name, entryDate, address, entryDate); //super키워드를 사용해서 슈퍼클래스 생성자를 호출한다.
		this.salary = salary;
	}
	public double payCheck() {	return salary; }
	
	private double salary;
}
