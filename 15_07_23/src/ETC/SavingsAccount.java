package ETC;

public class SavingsAccount {
	//�ʵ� ����
	private String name; //�̸�
	private double amount; //���� �ܾ�
	private static double interestRate = 0.01; //������
	
	//������.�޼ҵ� 
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
