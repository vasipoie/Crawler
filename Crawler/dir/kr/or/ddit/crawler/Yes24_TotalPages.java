package kr.or.ddit.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Yes24_TotalPages
{
	public static long getCategoryTotalPages(String categoryUrl)
	{
		try
		{
			Document doc = Jsoup.connect(categoryUrl).get(); // URL를 받고 a.bgYUI 에가서 숫자 출력.
			Element endLink = doc.select("a.bgYUI.end").first(); 

			if (endLink != null)
			{
				String pageNumberStr = endLink.attr("href").replaceAll("\\D", ""); // 숫자 외의 문자 제거 번호출력
				return Long.parseLong(pageNumberStr);
			} 
			else
			{
				System.out.println("끝 페이지를 찾을 수 없습니다 (기본값 380)");
			}

		} 
		
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("오류가 발생하여 totalPages를 가져오지 못함.");
		}
		return 380;
	}
}
