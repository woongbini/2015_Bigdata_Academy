package kodb.domain;

public class PeopleDTO {
	private String name;
	private int age;
	
	public PeopleDTO() {	}

	public PeopleDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {return name;	}
	public void setName(String name) { this.name = name;	}
	public int getAge() {return age;	}
	public void setAge(int age) {this.age = age;}

	@Override
	public String toString() {
		return "PeopleDTO [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
