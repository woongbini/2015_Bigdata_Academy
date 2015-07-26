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
		System.out.println("상품ID : "+productId+" 상품설명 : " + description+" 생산자 : "+maker
				+"가격 : "+price);
	}

}
