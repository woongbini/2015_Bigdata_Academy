package BookStore;

public class Product {
	private int id;
	private int productId;
	private String description;
	private String maker;
	private int price;
	
	public Product(int type, int nextId, String desc, String maker, int price) {
		this.id = type;
		this.productId = nextId;
		this.description = desc;
		this.maker = maker;
		this.price = price;
	}
	
	public void showProduct() {
		System.out.println("��ǰID : "+productId+" ��ǰ���� : " + description+" ������ : "+maker
				+"���� : "+price);
	}

}
