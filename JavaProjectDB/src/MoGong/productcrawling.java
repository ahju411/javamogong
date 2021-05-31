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
		
		// 크롤링 사이트 : 쿠팡
					String url = "https://www.coupang.com/np/search?rocketAll=false&q=%EA%B5%AC%EC%B0%8C+%EC%8B%9C%EA%B3%84&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36";
					Document doc = null;
					Elements tmp;
				
					try {
						doc = Jsoup.connect(url).get();
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					//
					// 
					
					Elements element = doc.select("ul[id=\"productList\"]");
					Elements images = 
				             element.select("img[class=\"search-product-wrap-img\"]");  
				
					// 1. 구찌 시계 ( 이름 , 가격 , 이미지 ) 크롤링 및 브랜드,종류 지정
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
					
					
					// 2. 구찌 가방
				   url = "https://www.coupang.com/np/search?rocketAll=false&q=%EA%B5%AC%EC%B0%8C+%EA%B0%80%EB%B0%A9&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36";
				   doc = null;
			
				
					try {
						doc = Jsoup.connect(url).get();
					}catch (Exception e) {
						e.printStackTrace();
					}
					 element = doc.select("ul[id=\"productList\"]");
				      images = 
				             element.select("img[class=\"search-product-wrap-img\"]");  
					
					for(int i=0 ; i <5;i++) {
						itemid =i+6;
						tmp = element.select("div.name"); // 상품이름
						itemname=(tmp.get(i).text());
						
						tmp = element.select("strong.price-value"); //상품가격
						itemprice=(tmp.get(i).text());
						
						
						itembrand="구찌";
					
						itemclass = "가방";
						
						itemimage  = images.get(i).attr("src");
						
					
						pl.add(new productdto(itemid,itemname,itemprice,itembrand,itemclass,itemimage));
				
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
	}
}
