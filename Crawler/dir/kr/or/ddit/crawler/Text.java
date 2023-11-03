package kr.or.ddit.crawler;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
	public static void main(String[] args) {
		Text test = new Text();
		String[] tmp = test.text();
		for(int i = 0; i<tmp.length; i++) {
			System.out.println(tmp[i]);
		}
	}
	
	public String[] text() {
	
	String list = "	\"/24/Category/Display/001001001011\" 육아\r\n" + 
			"	    \"/24/Category/Display/001001001012\" 자녀교육\r\n" + 
			"	    \"/24/Category/Display/001001001001\" 요리\r\n" + 
			"	    \"/24/Category/Display/001001001013\" 집/살림\r\n" + 
			"	    \"/24/Category/Display/001001001006\" 결혼/가족\r\n" + 
			"	    \"/24/Category/Display/001001011008\" 건강에세이/건강기타\r\n" + 
			"	    \"/24/Category/Display/001001011003\" 질병과 치료법\r\n" + 
			"	    \"/24/Category/Display/001001011002\" 요가/체조/기타\r\n" + 
			"	    \"/24/Category/Display/001001011007\" 한의학/한방치료\r\n" + 
			"	    \"/24/Category/Display/001001011010\" 의학/약학\r\n" + 
			"	    \"/24/Category/Display/001001011021\" 여행\r\n" + 
			"	    \"/24/Category/Display/001001011017\" 취미기타\r\n" + 
			"	    \"/24/Category/Display/001001011016\" 패션/수공예\r\n" + 
			"	    \"/24/Category/Display/001001011006\" 다이어트/미용\r\n" + 
			"	    \"/24/Category/Display/001001011014\" 스포츠/오락기타\r\n" + 
			"	    \"/24/Category/Display/001001011013\" 등산/낚시/바둑\r\n" + 
			"	    \"/24/Category/Display/001001011015\" 반려동물\r\n" + 
			"	    \"/24/Category/Display/001001011019\" 컬러링북\r\n" + 
			"	    \"/24/Category/Display/001001011018\" 퍼즐/스도쿠/기타\r\n" + 
			"	    \"/24/Category/Display/001001011011\" 성생활\r\n" + 
			"	    \"/24/Category/Display/001001025007\" 경제\r\n" + 
			"	    \"/24/Category/Display/001001025008\" 경영\r\n" + 
			"	    \"/24/Category/Display/001001025010\" 투자/재테크\r\n" + 
			"	    \"/24/Category/Display/001001025009\" 마케팅/세일즈\r\n" + 
			"	    \"/24/Category/Display/001001025001\" CEO/비즈니스맨\r\n" + 
			"	    \"/24/Category/Display/001001025011\" 인터넷비즈니스\r\n" + 
			"	    \"/24/Category/Display/001001025006\" 총람/연감\r\n" + 
			"	    \"/24/Category/Display/001001025012\" 정부간행물\r\n" + 
			"	    \"/24/Category/Display/001001004004\" 영어\r\n" + 
			"	    \"/24/Category/Display/001001004003\" 국어\r\n" + 
			"	    \"/24/Category/Display/001001004005\" 일본어\r\n" + 
			"	    \"/24/Category/Display/001001004006\" 중국어\r\n" + 
			"	    \"/24/Category/Display/001001004007\" 독일어\r\n" + 
			"	    \"/24/Category/Display/001001004012\" 러시아어\r\n" + 
			"	    \"/24/Category/Display/001001004011\" 스페인어\r\n" + 
			"	    \"/24/Category/Display/001001004010\" 이탈리아어\r\n" + 
			"	    \"/24/Category/Display/001001004009\" 프랑스어\r\n" + 
			"	    \"/24/Category/Display/001001004020\" 여행회화/어학연수\r\n" + 
			"	    \"/24/Category/Display/001001004013\" 기타 언어\r\n" + 
			"	    \"/24/Category/Display/001001004014\" 사전류\r\n" + 
			"	    \"/24/Category/Display/001001004001\" 한자/옥편\r\n" + 
			"	    \"/24/Category/Display/001001014008\" 경상계열\r\n" + 
			"	    \"/24/Category/Display/001001014019\" 공학계열\r\n" + 
			"	    \"/24/Category/Display/001001014007\" 농축산학 계열\r\n" + 
			"	    \"/24/Category/Display/001001014011\" 법학계열\r\n" + 
			"	    \"/24/Category/Display/001001014006\" 사범대 계열\r\n" + 
			"	    \"/24/Category/Display/001001014010\" 사회과학 계열\r\n" + 
			"	    \"/24/Category/Display/001001014002\" 어문학 계열\r\n" + 
			"	    \"/24/Category/Display/001001014009\" 예체능/문화/기타 계열\r\n" + 
			"	    \"/24/Category/Display/001001014005\" 의약학/간호 계열\r\n" + 
			"	    \"/24/Category/Display/001001014001\" 인문학 계열\r\n" + 
			"	    \"/24/Category/Display/001001014003\" 자연과학 계열\r\n" + 
			"	    \"/24/Category/Display/001001014015\" 방송통신대학교\r\n" + 
			"	    \"/24/Category/Display/001001008020\" 웹툰 \r\n" + 
			"	    \"/24/Category/Display/001001008007\" 액션\r\n" + 
			"	    \"/24/Category/Display/001001008016\" 로맨스 \r\n" + 
			"	    \"/24/Category/Display/001001008005\" 스포츠\r\n" + 
			"	    \"/24/Category/Display/001001008009\" 판타지\r\n" + 
			"	    \"/24/Category/Display/001001008014\" 코믹 \r\n" + 
			"	    \"/24/Category/Display/001001008012\" 드라마 \r\n" + 
			"	    \"/24/Category/Display/001001008008\" 학원\r\n" + 
			"	    \"/24/Category/Display/001001008010\" SF/밀리터리";
	
	
	String regex = "/24/Category/Display/\\d+";
// 정규표현식 정의 /Category/Display/ 까지의 문자열과 (\\d+) 이후에 정수 0개이상을 가져온다
    Pattern pt = Pattern.compile(regex);
//패턴에 정의한 정규표현식 컴파일
//    String url = "https://www.yes24.com/24/Category/Display/001001001011"
    String[] url = list.split("\n");
//공백을 기준으로 하나씩 잘라서 배열에 저장
    for (int i = 0; i < url.length; i++) {
      Matcher mt = pt.matcher(url[i]);
//loop를 하며 정규표현식과 일치하는것을 저장한다
      while (mt.find()) {
        url[i] = mt.group();
//url에 해당 값 저장
      }
    }
	return url;
    }
}


