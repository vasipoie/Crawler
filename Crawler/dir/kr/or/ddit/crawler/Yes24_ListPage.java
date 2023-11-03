package kr.or.ddit.crawler;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


//여기는 카테고리 안에서 페이지를 모두 저장하는곳 ex)BL(보이즈러브) 1~ 388페이지까지 다 저장하는곳.
public class Yes24_ListPage
{
	public void sortSave()
	{
		Map<String, String> categoryUrls = Yes24_Category.getCategories();

		// 모든 카테고리에 대한 페이지를 추출
		for (Map.Entry<String, String> entry : categoryUrls.entrySet())
		{
			String categoryName = entry.getKey();
			String categoryUrl = entry.getValue();

			if (Yes24_SkipCategory.SkipCategory(categoryName))
			{
				System.out.println("카테고리 '" + categoryName + "'은 건너뛰었습니다.");
				continue;
			}

			long categoryTotalPages = Yes24_TotalPages.getCategoryTotalPages(categoryUrl);

			for (int page = 1; page <= categoryTotalPages; page++)
			{
				final int finalPage = page;
				String pageUrl = categoryUrl + "?PageNumber=" + page;

				// ListSearch 상세페이지...		
				//여기는 각 페이지의 상세페이지 ex)BL(보이즈러브) 1~ 388페이지라면 1페이지에 20개의 책정보를 저장하는곳 2페이지도 20개저장.. 3페이지 30개저장.. 쓰레드안에 기능을 넣어둠 ListSearch.
				ListSearch listSearchThread = new ListSearch(categoryName, pageUrl, finalPage);

				// 스레드 생성
				Thread thread = new Thread(listSearchThread);

				// 스레드 시작
				thread.start();
			}
		}
	}
}