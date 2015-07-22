package test_inheritance_employee_department;

public class RegularEmployee extends Employee {
	private double salary;
	public RegularEmployee(String name, String tell, double salary) {
		super(name, tell);
		this.salary = salary;
	}
	public void setSalary(double salary) { this.salary = salary; }
	public double getSalary() { return salary; }
	
	public void displayEmployee() {
		System.out.println();
		super.displayEmployee();
		System.out.print(" ±Þ¿©: "+salary);
	}

}
