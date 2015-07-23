package ETC;

public class SavingsAccount {
	//필드 선언
	private String name; //이름
	private double amount; //예금 잔액
	private static double interestRate = 0.01; //이자율
	
	//생성자.메소드 
	public SavingsAccount () { }
	public SavingsAccount (String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public void earnInterest() {
		amount += (amount * interestRate);
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public double getAmount() { return amount; }
	public void setAmount(double amount) { this.amount = amount; }
	
}
