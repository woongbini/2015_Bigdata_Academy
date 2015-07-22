package test_ISpellingChecker;

public class WordProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 맞춤법 검사할 한글 단어 목록을 정의한다
		String [] koreans = { "사랑", "미움", "평화", "불행", "전쟁" };
		// 잘못된 단어를 받아들일 String 배열 변수를 선언한다
		String [] errors;
		// 맞춤법 검사기 인스턴스를 생성하고, ISpellingChecker 인터페이스를 구한다
		SpellingChecker spellingchecker = new SpellingChecker();
		ISpellingChecker sc = spellingchecker;
		// 맞춤법 검사할 언어를 한글로 지정한다
		sc.setLanguage(0);
		// 맞춤법 검사할 단어 목록을 저장한다
		sc.setWords(koreans);
		// 맞춤법 검사를 실행한다
		errors = sc.check();
		// 맞춤법 검사 결과 반환된 잘못된 단어의 목록을 출력한다
		for(int i = 0; i < errors.length; ++i) {
			if(errors[i] != null)
				System.out.println(errors[i]);
		}
		// 맞춤법 검사할 영어 단어 목록을 정의한다
		String [] englishes = { "love", "hate", "peace", "unhappiness", "war" };
		// 맞춤법 검사할 언어를 영어로 지정한다
		sc.setLanguage(1);
		// 맞춤법 검사할 단어 목록을 저장한다
		sc.setWords(englishes);
		// 맞춤법 검사를 실행한다
		errors = sc.check();
		// 맞춤법 검사 결과 반환된 잘못된 단어의 목록을 출력한다
		for(int i = 0; i < errors.length; ++i) {
			if(errors[i] != null)
				System.out.println(errors[i]);
		}		
		// IDictionary 인터페이스 사용
		IDictionary dic = spellingchecker;
		String result = dic.find("사랑");
		System.out.println(result);

	}

}
