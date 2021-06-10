package MoGong;

public class ordersdto {
	Member mem = new Member();
	productdto pdto = new productdto();
	String id = mem.getId();
	int itemid = pdto.getItemid();
	String price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	
	

}
