package MoGong;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class productcrawling {
	
	
	static int i = 0;
			static void Crawling(ArrayList<productdto> pl) throws IOException {
				int itemid = 0;
				String itemname = null;
				String itemprice = null;
				String itembrand = null;
				String itemclass = null;
				String itemimage = null;
		
		// 1. 구찌시계 크롤링  사이트 : 쿠팡
					String url = "https://www.coupang.com/np/search?rocketAll=false&q=%EA%B5%AC%EC%B0%8C+%EC%8B%9C%EA%B3%84&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36";
					Document doc = null;
					Elements tmp;
				
					try {
						doc = Jsoup.connect(url).get();
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					//
					// 상위 7개정보 추출하여 DB에 넣기
					
					Elements element = doc.select("ul[id=\"productList\"]");
					Elements images = 
				             element.select("img[class=\"search-product-wrap-img\"]");  
				 
					for(int i = 0 ; i <5;i++) {
						itemid =i+1;
						tmp = element.select("div.name"); // 상품이름
						itemname=(tmp.get(i).text());
						
						tmp = element.select("strong.price-value"); //상품가격
						itemprice=(tmp.get(i).text());
						
						
						itembrand="구찌";
					
						itemclass = "시계";
						
						itemimage  = images.get(i).attr("src");
						
					
						
						pl.add(new productdto(itemid,itemname,itemprice,itembrand,itemclass,itemimage));
				
					}
	}
}
