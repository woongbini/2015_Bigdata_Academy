package inheritance;

public class SalesEmployee extends RegularEmployee {
	
	public SalesEmployee(String empno, String name, date entryDate, String address, double salary) {
		super(empno, name, entryDate, address, salary);
	}
	
	public double payCheck() /*{ return payCheck(); //recursive call(������� ȣ��) - ������ �߰� } */
	{ return super.payCheck(); //�θ��� payCheck()�������� }
	
	
	
	
	
	}
}