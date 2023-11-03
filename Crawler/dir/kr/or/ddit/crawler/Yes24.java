package kr.or.ddit.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Yes24
{

	
	//여기서 크롤링을 실행.
	public static void main(String[] args)
	{

		Yes24_ListPage Ys = new Yes24_ListPage();

		Map<String, String> categoryMap = Yes24_Category.getCategories(); // getCategories -> category 맵 호출.

		if (categoryMap != null)
		{
			// 쓰레드 배열 생성
			Search[] threads = new Search[categoryMap.size()];
			int index = 0;

			// 각 카테고리에 대한 크롤링을 병렬로 실행
			for (Map.Entry<String, String> entry : categoryMap.entrySet())
			{
				//GETKEY 이름 , URL 주소.
				String name = entry.getKey();
				String url = entry.getValue();
				threads[index] = new Search(name, url);
				threads[index].start(); // 쓰레드 실행
				index++;
			}

			for (Search thread : threads)
			{
				try
				{
					thread.join();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			Ys.sortSave(); // 페이지저장, 상세페이지 저장 메서드
			System.out.println("카테고리 페이지를 다 저장했습니다.");
		} else
		{
			System.out.println("카테고리가 없거나 오류가 발생했습니다.");
		}

	}

}