package kr.or.ddit.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ListSearch extends Thread
{
	 String name;
	 String url;
	 int page;

	public ListSearch(String name, String url, int page)
	{
		this.name = name;
		this.url = url;
		this.page = page;
	}

	
	public void run()
	{
		
		//여기가 각 페이지마다 상세 책 정보를 저장하는곳.
		try
		{
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href^=\"/Product/Goods/\"]:eq(1)");

			for (Element link : links)
			{
				String href = link.attr("href");
				String text = link.text().replaceAll("[/:?.*+^$|()]", "_");
				String url = "https://www.yes24.com" + href;

				Document doc1 = Jsoup.connect(url).get();
				String content = doc1.outerHtml();

				Yes24_SavaPage.savePageAsHtml(name, page, content, text);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("오류 페이지 " + page + " 저장 안됨");
		}
	}
}