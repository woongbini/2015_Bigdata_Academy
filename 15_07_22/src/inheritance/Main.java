package inheritance;

public class Main {

	public static void main(String[] args) {
		date  myDate = new date();
		myDate.setDate(2010, 12, 21);
		myDate.displayDate();
		RegularEmployee rg1 = new RegularEmployee("201502", "김일", myDate, "경기도", 10000000);
		rg1.displayEmployee();
		double salary = rg1.payCheck();
		System.out.println("급여액 : "+salary);
		
	}

}
