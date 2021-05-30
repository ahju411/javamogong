package MoGong;

public class productdto {
	private int itemid;
	private String itemname;
	private String itemprice;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemprice() {
		return itemprice;
	}
	public void setItemprice(String itemprice) {
		this.itemprice = itemprice;
	}
	@Override
	public String toString() {
		return "productdto [itemid=" + itemid + ", itemname=" + itemname + ", itemprice=" + itemprice + "]";
	}
	
}
