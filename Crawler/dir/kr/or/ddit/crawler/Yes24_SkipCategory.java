package kr.or.ddit.crawler;

import java.util.Arrays;

public class Yes24_SkipCategory
{
	 static String[] categoriesToSkip = { "어린이 문 학", "공무원", "취업_상식_적성검사", "공인중개_주택관리", "경제_금융_회계_물류",
			"국가자격_전문사무", "편입_검정고시_독학사", "한국산업인력공단", "예비 초등학생", "Meet_Deet_Peet", "초등학습", "어린이 문학" };

	public static boolean SkipCategory(String categoryName)
	{
		return Arrays.asList(categoriesToSkip).contains(categoryName);
	}
}
