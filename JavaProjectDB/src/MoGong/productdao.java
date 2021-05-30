package MoGong;

import java.io.IOException;
import java.util.ArrayList;

public class productdao {
	

	public static void main(String[] args) {
		ArrayList<productdto> pl = new ArrayList<>();
		try {
			productcrawling.Crawling(pl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProductDB db = new ProductDB();
		db.insertitem(pl);
		
		

	}

}
