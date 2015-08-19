package model.domain;

import java.sql.Date;
import java.sql.Time;

public class RegiDTO {
	private int board_number;
	private String title;
	private String region;
	private Date date;
	private Time time;
	private int number_of_person;
	private String age;
	private String gender;
	private float location_x;
	private float location_y;
	private String detail;

	public RegiDTO() {
		super();
	}
	public RegiDTO(int board_number, String title, String region, int number_of_person,String age, String gender, float location_x, float location_y, String detail) {
		super();
		this.board_number = board_number;
		this.title = title;
		this.region = region;
		this.number_of_person = number_of_person;
		this.age = age;
		this.gender = gender;
		this.location_x = location_x;
		this.location_y = location_y;
		this.detail = detail;
	}

	public RegiDTO(int board_number, String title, String region, Date date, Time time, int number_of_person,
			String age, String gender, float location_x, float location_y, String detail) {
		super();
		this.board_number = board_number;
		this.title = title;
		this.region = region;
		this.date = date;
		this.time = time;
		this.number_of_person = number_of_person;
		this.age = age;
		this.gender = gender;
		this.location_x = location_x;
		this.location_y = location_y;
		this.detail = detail;
	}

	public int getBoard_number() {
		return board_number;
	}

	public void setBoard_number(int board_number) {
		this.board_number = board_number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getNumber_of_person() {
		return number_of_person;
	}

	public void setNumber_of_person(int number_of_person) {
		this.number_of_person = number_of_person;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getLocation_x() {
		return location_x;
	}

	public void setLocation_x(float location_x) {
		this.location_x = location_x;
	}

	public float getLocation_y() {
		return location_y;
	}

	public void setLocation_y(float location_y) {
		this.location_y = location_y;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "RegiDTO [board_number=" + board_number + ", title=" + title + ", region=" + region + ", date=" + date
				+ ", time=" + time + ", number_of_person=" + number_of_person + ", age=" + age + ", gender=" + gender
				+ ", location_x=" + location_x + ", location_y=" + location_y + ", detail=" + detail + "]";
	}
}
