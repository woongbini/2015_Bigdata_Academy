package test_inheritance_employee_department;

//�μ� Ŭ������ �����Ѵ�.
public class Department {
	private Employee [] employees;
	private int count;
	//�μ��� �ִ� 10���� ����� �ִ�.
		public Department() {
		employees = new Employee[10];
		count = 0;
	}
	//�տ��� ������ ��� ��ü�� �μ��� �߰��Ѵ�. 
	public void addEmployee(Employee e) {
		if(count < 10) 
			employees[count++] = e;
	}
	//�μ��� ���Ե� ��� ����� �Ϲ�����, �޿������� ����Ѵ�.
	public void display() {
		for(int i=0 ; i < count ; ++i) {
			employees[i].displayEmployee();
		}
	}
	

}
