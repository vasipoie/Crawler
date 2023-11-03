package kr.or.ddit.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



//여기는 카테고리 범위 정하는 곳.
public class Yes24_Category
{
	public static Map<String, String> getCategories()
	{
		try
		{

			String url = "https://www.yes24.com/24/Category/Display/001001025008";
			Document doc = Jsoup.connect(url).get();
			Element cateLiArea = doc.selectFirst("div.cateLiArea");

			if (cateLiArea != null)
			{
				
				

				Elements links = cateLiArea.select("a");
				boolean start = false;

				Map<String, String> categoryMap = new HashMap<>();

				for (Element link : links)
				{

					if (start)
					{
						String text = link.text().replaceAll("[/:]", "_");
						String href = link.attr("href");
						categoryMap.put(text, "https://www.yes24.com" + href);

					}

					if (link.text().contains("밀리터리"))
					{
						start = true;
					}

					else if (link.text().contains("학습만화/코믹스"))
					{
						start = false;
					}
				}

//				categoryMap.put("baseUrl", url);

				return categoryMap;
			}

			else
			{
				System.out.println("클래스를 못찾음.");
				return null;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
