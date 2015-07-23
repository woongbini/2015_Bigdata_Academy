package test_inheritance_employee_department;

public class Main {

	public static void main(String[] args) {
		Employee emp1 = new Employee("��Ʈ��", "01011112222");
		Employee emp2 = new Employee("��Ʈ��", "01022223333");
		//emp1.displayEmployee();
		
		RegularEmployee Remp1 = new RegularEmployee("����", "01033334444", 1000000);
		RegularEmployee Remp2 = new RegularEmployee("�̻��", "01044445555", 2000000);
		//Remp1.displayEmployee();
		
		SalesEmployee Semp1 = new SalesEmployee("�迵��", "01055556666", 1000000, 50000);
		SalesEmployee Semp2 = new SalesEmployee("�̿���", "01066667777", 3000000, 20000);
		//Semp1.displayEmployee();
		
		TempEmployee Temp1 = new  TempEmployee("������", "01077778888", 5800);
		TempEmployee Temp2 = new  TempEmployee("������", "01088889999", 5800);
		//Temp1.displayEmployee();
		
		Department dept = new Department();
		dept.addEmployee(emp1); dept.addEmployee(emp2);
		dept.addEmployee(Remp1); dept.addEmployee(Remp2);
		dept.addEmployee(Semp1); dept.addEmployee(Semp2);
		dept.addEmployee(Temp1); dept.addEmployee(Temp2);
		
		dept.display(); //�μ��� ��� ����� �Ϲ�,�޿����� ���
		
		//�� ��ü�� ���ϴ� �ڵ带 �ۼ��Ѵ�.(ObjectŬ������ equals()�޼ҵ� ���)
		//������ �̸��� ��ȭ��ȣ�� ���� �Ϲݻ���� ������� ��ü�������ϰ� ��
		Employee emp3 = new Employee("����Ű", "01011111111");
		SalesEmployee Semp3 = new SalesEmployee("����Ű", "01011111111", 3000000, 20000);
		
		//������ ������ false�� ���´�.
		boolean b = emp3.equals(Semp3);
		//���
		System.out.println();
		System.out.println(b);
		
		
		
		
		
		
	}

}