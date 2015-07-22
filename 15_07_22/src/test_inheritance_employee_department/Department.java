package test_inheritance_employee_department;

//부서 클래스를 구현한다.
public class Department {
	private Employee [] employees;
	private int count;
	//부서는 최대 10명의 사원이 있다.
		public Department() {
		employees = new Employee[10];
		count = 0;
	}
	//앞에서 생성된 사원 객체를 부서에 추가한다. 
	public void addEmployee(Employee e) {
		if(count < 10) 
			employees[count++] = e;
	}
	//부서에 포함된 모든 사원의 일반정보, 급여정보를 출력한다.
	public void display() {
		for(int i=0 ; i < count ; ++i) {
			employees[i].displayEmployee();
		}
	}
	

}
