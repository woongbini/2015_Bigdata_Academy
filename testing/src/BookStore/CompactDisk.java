package BookStore;

public class CompactDisk extends Product {
	
	private String albumtitle;
	private String artist;
	
	public CompactDisk(int type, int nextId, String desc, String maker, int price) {
		super(type, nextId, desc, maker, price);
		// TODO Auto-generated constructor stub
		this.albumtitle = albumtitle;
		this.artist = artist;
	}
	
	public void showProduct() {
		super.showProduct();
		System.out.print("앨범제목 : "+albumtitle+" 아티스트 : "+artist);
	}
	
}
