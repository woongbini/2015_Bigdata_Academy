package test_inheritance_employee_department;

public class SalesEmployee extends RegularEmployee {
	private double salessalary;
	public SalesEmployee(String name, String tell, double salary, double salessalary) {
		super(name, tell, salary);
		this.salessalary = salessalary;
	}
	public void setSalesSalary(double salessalary) { this.salessalary = salessalary; }
	public double getSalesSalary() { return salessalary; }
	
	public void displayEmployee() {
		//System.out.println();
		super.displayEmployee();
		System.out.print(" �߰��޿�: "+salessalary);
	}

}
