package test_inheritance_employee_department;

public class Employee {
	private String name;
	private String tell;
	public Employee(String name, String tell) {
		this.name = name;
		this.tell = tell;
	}
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	public void setTell(String tell) { this.tell = tell; }
	public String getTell() { return tell; }
	
	public void displayEmployee() {
		System.out.print("이름: "+name+" 전화번호: "+tell+" ");	
	}
	
	//이름과 전화번호가 같은 객체는 동일한 객체로 간주할 수있도록 코드작성
	public boolean equals(Object object){
		Employee e = (Employee)object;
		if(name == e.name && tell == e.tell)
			return true;
		else return false;
	}

}
