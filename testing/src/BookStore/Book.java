package BookStore;

public class Book extends Product {

	private String title;
	private String author;
	private int isbn;
	
	public Book(int type,int nextId,String desc,String maker,int price,String title,String author,int isbn) {
		super(type, nextId, desc, maker, price);
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	public void showProduct() {
		super.showProduct();
		System.out.print("책제목 : "+title+" 저자 : "+author+" ISBN : "+isbn);
	}
	
	
}
