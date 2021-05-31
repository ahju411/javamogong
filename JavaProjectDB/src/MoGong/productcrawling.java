package MoGong;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class productcrawling {
	static int itemid = 0;
	static String itemname = null;
	static String itemprice = null;
	static String itembrand = null;
	static String itemclass = null;
	static String itemimage = null;
	
	static int i = 0;
			static void Crawling(ArrayList<productdto> pl) throws IOException {
		
				
				// 구찌 파트
		crawlingproduct(pl,
				"https://www.coupang.com/np/search?rocketAll=false&q=%EA%B5%AC%EC%B0%8C+%EC%8B%9C%EA%B3%84&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
				"구찌",
				"시계"
				);
		crawlingproduct(pl,
				"https://www.coupang.com/np/search?rocketAll=false&q=%EA%B5%AC%EC%B0%8C+%EA%B0%80%EB%B0%A9&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
				"구찌",
				"가방"
				);
		crawlingproduct(pl,
				"https://www.coupang.com/np/search?rocketAll=false&q=%EA%B5%AC%EC%B0%8C+%EC%A7%80%EA%B0%91&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
				"구찌",
				"지갑"
				);
		crawlingproduct(pl,
				"https://www.coupang.com/np/search?rocketAll=false&q=%EA%B5%AC%EC%B0%8C+%EB%AA%A9%EA%B1%B8%EC%9D%B4&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
				"구찌",
				"목걸이"
				);
			
		
			// 샤넬 파트
		crawlingproduct(pl,
				"https://www.coupang.com/np/search?rocketAll=false&q=%EC%83%A4%EB%84%AC+%EC%8B%9C%EA%B3%84&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
				"샤넬",
				"시계"
				);
		crawlingproduct(pl,
				"https://www.coupang.com/np/search?rocketAll=false&q=%EC%83%A4%EB%84%AC+%EA%B0%80%EB%B0%A9&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
				"샤넬",
				"가방"
				);
		crawlingproduct(pl,
				"https://www.coupang.com/np/search?rocketAll=false&q=%EC%83%A4%EB%84%AC+%EC%A7%80%EA%B0%91&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
				"샤넬",
				"지갑"
				);
		crawlingproduct(pl,
				"https://www.coupang.com/np/search?rocketAll=false&q=%EC%83%A4%EB%84%AC+%EB%AA%A9%EA%B1%B8%EC%9D%B4&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
				"샤넬",
				"목걸이"
				);
		
		// 에르메스 파트
				crawlingproduct(pl,
						"https://www.coupang.com/np/search?rocketAll=false&q=%EC%97%90%EB%A5%B4%EB%A9%94%EC%8A%A4+%EC%8B%9C%EA%B3%84&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
						"에르메스",
						"시계"
						);
				crawlingproduct(pl,
						"https://www.coupang.com/np/search?rocketAll=false&q=%EC%97%90%EB%A5%B4%EB%A9%94%EC%8A%A4+%EA%B0%80%EB%B0%A9&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
						"에르메스",
						"가방"
						);
				crawlingproduct(pl,
						"https://www.coupang.com/np/search?rocketAll=false&q=%EC%97%90%EB%A5%B4%EB%A9%94%EC%8A%A4+%EC%A7%80%EA%B0%91&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
						"에르메스",
						"지갑"
						);
				crawlingproduct(pl,
						"https://www.coupang.com/np/search?rocketAll=false&q=%EC%97%90%EB%A5%B4%EB%A9%94%EC%8A%A4+%EB%AA%A9%EA%B1%B8%EC%9D%B4&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
						"에르메스",
						"목걸이"
						);
				

				// 디올 파트//////
				crawlingproduct(pl,
						"https://www.coupang.com/np/search?rocketAll=false&q=%EB%94%94%EC%98%AC+%EC%8B%9C%EA%B3%84&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
						"디올",
						"시계"
						);
				crawlingproduct(pl,
						"https://www.coupang.com/np/search?rocketAll=false&q=%EB%94%94%EC%98%AC+%EA%B0%80%EB%B0%A9&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
						"디올",
						"가방"
						);
				crawlingproduct(pl,
						"https://www.coupang.com/np/search?rocketAll=false&q=%EB%94%94%EC%98%AC+%EC%A7%80%EA%B0%91&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
						"디올",
						"지갑"
						);
				crawlingproduct(pl,
						"https://www.coupang.com/np/search?rocketAll=false&q=%EB%94%94%EC%98%AC+%EB%AA%A9%EA%B1%B8%EC%9D%B4&brand=&offerCondition=&filter=&availableDeliveryFilter=&filterType=&isPriceRange=false&priceRange=&minPrice=&maxPrice=&page=1&trcid=&traid=&filterSetByUser=true&channel=user&backgroundColor=&component=&rating=0&sorter=salePriceDesc&listSize=36",
						"디올",
						"목걸이"
						);
				
		
		
		
		
	}
			private static void crawlingproduct(ArrayList<productdto> pl,String cURL,String selectBrand,String selectClass) {
				String url = cURL;
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
					itemid =itemid+1;
					tmp = element.select("div.name"); // 상품이름
					itemname=(tmp.get(i).text());
					
					tmp = element.select("strong.price-value"); //상품가격
					itemprice=(tmp.get(i).text());
					
					
					itembrand=selectBrand;
				
					itemclass =selectClass;
					
					itemimage  = images.get(i).attr("src");
				
					pl.add(new productdto(itemid,itemname,itemprice,itembrand,itemclass,itemimage));
				}
				
			}
}









