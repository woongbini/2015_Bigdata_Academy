package inheritance;

public class RegularEmployee extends Employee {
	
	//����Ŭ������ �⺻�����ڰ� �����Ƿ� �����߻�.
	public RegularEmployee (String empno, String name, date entryDate, String address, double salary) {
		super(empno, name, entryDate, address, entryDate); //superŰ���带 ����ؼ� ����Ŭ���� �����ڸ� ȣ���Ѵ�.
		this.salary = salary;
	}
	public double payCheck() {	return salary; }
	
	private double salary;
}