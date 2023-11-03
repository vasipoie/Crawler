package kr.or.ddit.crawler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Yes24_SavaPage
{

	// 사용안함
//	public static void savePageAsHtml(String categoryName, int page, String content)
//	{
//		String baseDirectoryPath = "D:\\SelfStudyjave\\Crawling\\save"; // 기본 디렉토리 경로
//		String categoryDirectoryPath = baseDirectoryPath + "/" + categoryName + "/" + page; // 카테고리별 디렉토리 경로
//
//		// 카테고리별 디렉토리 생성
//		File categoryDirectory = new File(categoryDirectoryPath);
//		categoryDirectory.mkdirs(); // 디렉토리가 이미 존재하면 아무 영향을 미치지 않음
//		String fileName = categoryDirectoryPath + "/page_" + categoryName + page + ".html"; // HTML 파일 경로
//
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
//		{
//			content = content.replaceAll("euc-kr", "utf-8");
//			writer.write(content);
//			System.out.println("카테고리 " + categoryName + "의 페이지 " + page + "를 저장했습니다.");
//		}
//
//		catch (IOException e)
//		{
//			e.printStackTrace();
//			System.out.println("페이지 " + page + "를 저장하지 못했습니다.");
//		}
//	}

	
	
	// 60개의 카테고리 폴더를 만들고 거기에 저장.
	public static void savePageAsHtml(String categoryName, String content)
	{
		String baseDirectoryPath = "D:\\SelfStudyjave\\Crawling\\save"; // 기본 디렉토리 경로
		String categoryDirectoryPath = baseDirectoryPath + "/" + categoryName; // 카테고리별 디렉토리 경로
		String fileName = categoryDirectoryPath + "/" + categoryName + ".html"; // HTML 파일 경로 "/" 이후에 파일이름.

		File file = new File(fileName);
		if (file.exists())
		{
			System.out.println("파일 있음 " + fileName);
			return;
		}

		// 카테고리별 디렉토리 생성
		File categoryDirectory = new File(categoryDirectoryPath);
		categoryDirectory.mkdirs(); // 디렉토리가 이미 존재하면 아무 영향을 미치지 않음

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
		{
			content = content.replaceAll("euc-kr", "utf-8");
			writer.write(content);
			System.out.println("카테고리 " + categoryName + "의 페이지를 저장했습니다.");
		}

		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(categoryName + "페이지를 저장하지 못했습니다.");
		}
	}

	// 각 카테고리의 페이지에 맞게 폴더에 저장.
	public static void savePageAsHtml(String categoryName, int page, String content, String title)
	{
		String baseDirectoryPath = "D:\\SelfStudyjave\\Crawling\\save"; // 기본 디렉토리 경로
		String categoryDirectoryPath = baseDirectoryPath + "/" + categoryName + "/" + page; // 카테고리별 디렉토리 경로
		String fileName = categoryDirectoryPath + "/page_" + categoryName + page + title + ".html"; // HTML 파일네임

		File file = new File(fileName);
		if (file.exists())
		{
			System.out.println("파일 있음" + fileName);
			return;
		}

		// 카테고리별 디렉토리 생성
		File categoryDirectory = new File(categoryDirectoryPath);
		categoryDirectory.mkdirs(); // 디렉토리가 이미 존재하면 아무 영향을 미치지 않음

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
		{
			content = content.replaceAll("euc-kr", "utf-8"); // 한글깨짐방지.
			writer.write(content);
			System.out.println("카테고리 " + categoryName + "의 페이지 " + page + "_" + title + "를 저장했습니다.");
		}

		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(title + "를 저장하지못했습니다.");
		}
	}

}
