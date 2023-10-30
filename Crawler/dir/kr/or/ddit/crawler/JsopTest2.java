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
			String domesBookCate = "";
			Scanner sc = new Scanner(new File("C:\\Users\\PC-25\\Downloads\\dd2.txt"));
			while(sc.hasNext()) {
				String str = sc.next();
				System.out.println(str);
				int beginIndex = str.indexOf('\"');
				int endIndex = str.indexOf("\" on");
				System.out.println(str.substring(beginIndex, endIndex+1));
//				String[] cate = str.split("\n");
//				System.out.println(Arrays.toString(cate));
				
				
			}
			
//			https://www.yes24.com/24/Category/Display/001001025008
			Document doc = Jsoup.connect("https://www.yes24.com/24/Category/Display/001001025008?PageNumber=1").get();
//			System.out.println(doc.html());
			String str = doc.html();
			String[] line = str.split("\n");
			boolean con = true;
			boolean chk = true;
			String s = "";
			for(int i=0; i<line.length; i++) {
				s = line[i];
				if(s.contains("gd_nameF")) 
					con = false;
				if(con) continue;
				if(chk == false ) {
					s = s.replace("<a href=\"", "");
					s = s.trim();
					chk = true;
					String[] name = s.split("\">");
					
					System.out.println(name[0]);
				}
				if(s.contains("<span class=\"gd_nameF\"></span>")) chk = false;
			}
			 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
