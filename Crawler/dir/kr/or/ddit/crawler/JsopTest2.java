package kr.or.ddit.crawler;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsopTest2 {
	public static void main(String[] args) {
		try {
//			String url = "https://www.yes24.com/24/Category/Display/001001001011";
			String url = "";
			
			Document doc = Jsoup.connect(url).get();
			String html = doc.html();
//			System.out.println(html);
			String path = "C:\\Users\\PC-25\\Downloads\\dd2.txt";
			File list = new File(path);
			if(!list.exists()) {
				list.mkdirs();
			}
			String name = url.replace("https://www.yes24.com", "").replace("/", "@");
			System.out.println(name);
			File file = new File("D:\\yes24"+name+".html");
			
			
//			Scanner sc = new Scanner(new File("C:\\Users\\PC-25\\Downloads\\dd2.txt"));
//			while(sc.hasNext()) {
//				String str = sc.next();
//				System.out.println(str);
//				int beginIndex = str.indexOf('\"');
//				int endIndex = str.indexOf("\" on");
//				System.out.println(str.length());
//				String link = str.substring(beginIndex, endIndex);
//				System.out.println("https://www.yes24.com"+link);
//				String[] cate = str.split("\n");
//				System.out.println(Arrays.toString(cate));
//			}
			String url_ = "";
			for(int j=1; j<1180; j++) {
			url_ = "https://www.yes24.com/24/Category/Display/001001001011?PageNumber="+j;
			System.out.println(url_);
			}
			
			Document doc_ = Jsoup.connect(url_).get();
			String str = doc_.html();
			String[] line = str.split("\n");
//			System.out.println(doc_.html());
			boolean con = true;
			boolean chk = true;
			String s = "";
			for(int i=0; i<line.length; i++) {
				s = line[i];
				if(s.contains(">처음</a>"))
					con = false;
				if(con) continue;
				if(chk == false ) {
					s = s.replace("<a href=\"", "");
					s = s.trim();
					chk = true;
					String[] name_ = s.split("\">");
					
					System.out.println(Arrays.toString(name_));
				}
				if(s.contains("<div class=\"yesUI_pagenS\"></div>")) chk = false;
			}
			 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
