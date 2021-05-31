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
				ArrayList<String> itemimage = new ArrayList<String>();
		
		// 1. 구찌시계 크롤링  사이트 : 옥션
					String url = "http://browse.auction.co.kr/search?keyword=%EA%B5%AC%EC%B0%8C%EC%8B%9C%EA%B3%84";
					Document doc = null;
					Elements tmp;
				
					try {
						doc = Jsoup.connect(url).get();
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					//
					// 상위 7개정보 추출하여 DB에 넣기
					
					Elements element = doc.select("div[class=\"section--inner_content_body\"]");
					
					for(int i = 0 ; i <5;i++) {
						itemid =i+1;
						tmp = element.select("span.text--title"); // 상품이름
						itemname=(tmp.get(i).text());
						
						tmp = element.select("strong.text--price_seller"); //상품가격
						itemprice=(tmp.get(i).text());
						
						
						tmp = element.select("span.text--brand"); //상품종류
						itembrand=(tmp.get(i).text());
						
						itemclass = "시계";
						
						pl.add(new productdto(itemid,itemname,itemprice,itembrand,itemclass));
				
					}
	}
}
