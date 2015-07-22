package test;

public class main {

	public static void main(String[] args) {
		date  myDate = new date();
		myDate.displayDate();
		
		date currentDate = new date(2015, 7, 22);
		currentDate.displayDate();
		
		date wrongDate = new date(-1990, 54, 20);
		wrongDate.displayDate();
		
		Employee emp1 = new Employee("201501", "±è°³¶Ë", myDate, "°æ±âµµ");
		emp1.displayEmployee();
		emp1.setName("±è¸»ÀÚ");
		emp1.displayEmployee();
		date Date = emp1.getEntryDate();
		
				
	}

}
