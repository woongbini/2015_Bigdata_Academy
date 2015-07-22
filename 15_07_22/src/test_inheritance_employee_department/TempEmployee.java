package test_inheritance_employee_department;

public class TempEmployee extends Employee {
	private double salarybytime;
	public TempEmployee(String name, String tell, double salarybytime) {
		super(name, tell);
		this.salarybytime = salarybytime;
	}
	public void setSalaryByTime(double salarybytime) { this.salarybytime = salarybytime; }
	public double getSalaryByTime() { return salarybytime; }

	public void displayEmployee() {
		System.out.println();
		super.displayEmployee();
		System.out.print(" 시간당수당: "+salarybytime);
	}
}
