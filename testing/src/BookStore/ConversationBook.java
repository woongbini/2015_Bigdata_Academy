package BookStore;

public class ConversationBook extends Book {

	private String language;
	
	public ConversationBook(int type, int nextId, String desc, String maker, int price, String title, String author,
			int isbn) {
		super(type, nextId, desc, maker, price, title, author, isbn);
		this.language = language;
	}
	
	public void showProduct() {
		super.showProduct();
		System.out.print("¾ð¾î : "+language);
	}
}
