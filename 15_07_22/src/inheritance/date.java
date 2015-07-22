package inheritance;

//date.java 파일
public class date {
	//필드 정의 (년 월 일)
	private int year, month, day;
	
	public date() { year=2000; month=1; day=1; } //생성자(초기화 하는 기능)
	
	public date(int year, int month, int day) {
		setDate(year, month, day);
	} //매개변수있는 생성자(constructor)
	
	public void finalize() { } //소멸자
	
	//method~
	
	public void setDate(int yy, int mm, int dd) {
		int [] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		year = Math.max(1990, yy);
		month = Math.max(1, mm);
		month = Math.min(month,  12);
		//윤년 생략
		day = Math.max(1, dd);
		day = Math.min(day,  days[month]);
	}
	public void displayDate() {
		System.out.println(year + month + day);
	}
	public String toString() {
		return String.format("%d-%d-%d", year, month, day);
	}
	


}
