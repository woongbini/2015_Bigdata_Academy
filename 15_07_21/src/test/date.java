package test;
//date.java ����
public class date {
	//�ʵ� ���� (�� �� ��)
	private int year, month, day;
	
	public date() { year=2000; month=1; day=1; } //������(�ʱ�ȭ �ϴ� ���)
	
	public date(int year, int month, int day) {
		setDate(year, month, day);
	} //�Ű������ִ� ������(constructor)
	
	public void finalize() { } //�Ҹ���
	
	//method~
	
	public void setDate(int yy, int mm, int dd) {
		int [] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		year = Math.max(1990, yy);
		month = Math.max(1, mm);
		month = Math.min(month,  12);
		//���� ����
		day = Math.max(1, dd);
		day = Math.min(day,  days[month]);
	}
	public void displayDate() {
		System.out.println(year + month + day);
	}
	


}