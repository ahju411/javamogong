package MoGong;

import java.util.ArrayList;

public class productdto {
	private int itemid;
	private String itemname;
	private String itemprice;
	private String itembrand;
	private String itemclass;
	private String itemimage;
	
	
	public productdto(int itemid, String itemname, String itemprice, String itembrand, String itemclass, String itemimage) {
		this.itemid =itemid;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.itembrand = itembrand;
		this.itemclass = itemclass;
		this.itemimage = itemimage;
	}
	public String getItembrand() {
		return itembrand;
	}
	public void setItembrand(String itembrand) {
		this.itembrand = itembrand;
	}
	public String getItemclass() {
		return itemclass;
	}
	public void setItemclass(String itemclass) {
		this.itemclass = itemclass;
	}
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
	public String getItemimage() {
		return itemimage;
	}
	public void setItemimage(String itemimage) {
		this.itemimage = itemimage;
	}
	
	
}
