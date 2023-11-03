package kr.or.ddit.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class Search extends Thread
{
	 String name;
	 String url;

	public Search(String name, String url)
	{
		this.name = name;
		this.url = url;
	}

	public void run()
	{
		try
		{
			// 크롤링 작업을 여기에 추가
			Document doc = Jsoup.connect(url).get();
			Yes24_SavaPage.savePageAsHtml(name, doc.outerHtml());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}