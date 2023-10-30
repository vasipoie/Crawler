package kr.or.ddit.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsopTestToKye {
   public static void main(String[] args) {
      try {
         Document doc = Jsoup.connect("https://www.yes24.com/24/Category/Display/001001025008").get();
         List<String> doc_list = new ArrayList<String>();
         doc_list.addAll(Arrays.asList(doc.html().split("\n")));

         for (int i=0; i< doc_list.size(); i++) {
//            System.out.println(doc_list.get(i));
            if(doc_list.get(i).contains("<div class=\"goods_name\">")) {
               String str = doc_list.get(i+2);
//               System.out.println(str);
               int beginIndex = str.indexOf("href=\"");
               int endIndex = str.indexOf("\">");
               String link = str.substring(beginIndex+6, endIndex);
               System.out.println("https://www.yes24.com"+link);
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}