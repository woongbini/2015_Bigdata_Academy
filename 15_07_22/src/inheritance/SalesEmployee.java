package inheritance;

public class SalesEmployee extends RegularEmployee {
	
	public SalesEmployee(String empno, String name, date entryDate, String address, double salary) {
		super(empno, name, entryDate, address, salary);
	}
	
	public double payCheck() /*{ return payCheck(); //recursive call(재귀적인 호출) - 수당계산 추가 } */
	{ return super.payCheck(); //부모의 payCheck()가져오기 }
	
	
	
	
	
	}
}
