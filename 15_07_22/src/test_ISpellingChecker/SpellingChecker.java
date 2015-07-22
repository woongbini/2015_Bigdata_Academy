package test_ISpellingChecker;
// SpellingChecker.java 파일

class SpellingChecker implements ISpellingChecker, IDictionary {

	public String[] check() {
		
		String [] errorStrings = new String[words.length]; // 잘못된 단어들을 반환하기 위한 String 배열을 생성한다
		int count = 0; // 잘못된 단어의 갯수를 저장할 변수를 선언
		for(int i = 0; i < words.length; ++i) { // 맞춤법을 검사할 각각의 단어들에 대하여
			if (language == 0) { // 만약 한글을 검사한다면( 한글)
				boolean bFound = false; // 표준 단어를 찾았는지 여부를 저장할 변수를 정의하고 초기값으로 못찼았다고 설정한다
				for(int j = 0; j < wordsKorean.length; j++) { // 맞춤법 검사할 단어가 표준 단어 목록에 있는지 검사한다
					if(words[i] == wordsKorean[j]) { // 만약 찾았다면
						bFound = true; // 찾았다는 표시를 하고 
						break; // 더 이상 표준 단어 목록을 검사할 필요가 없으므로 for 문을 빠져나온다
					}
				}
				
				if(bFound == false) // 맞춤법 검사할 단어가 표준 단어 목록에 없다면
					errorStrings[count++] = words[i]; // 그 단어를 잘못된 단어 목록에 저장하고 잘못된 단어의 갯수를 하나 증가시킨다
			} else
				if (language == 1) { // 영문을 검사하는 경우에도 한글을 검사하는 것과 유사하다( 영문 )
				boolean bFound = false;
				for(int j = 0; j < wordsEnglish.length; j++) {
					if(words[i] == wordsEnglish[j]) {
						bFound = true;
						break;
					}
				}
				if(bFound == false)
					errorStrings[count++] = words[i];
			}
		}
		return errorStrings;
	}
	public void setWords(String[] words) {
		this.words = words;
	}
	public void setLanguage(int lang) {
		if(lang == 0 || lang == 1)
			this.language = lang;
	}
	// IDictionary 인터페이스
	public String find(String word) {
		for(int i = 0; i < wordsKorean.length; i++) {
			if(word == wordsKorean[i]) {
				return wordsEnglish[i];
			}
		}
		return null;
	}
	private String [] words;
	private int language;
	private String [] wordsKorean = { "사랑", "평화", "행복" };
	private String [] wordsEnglish = { "love", "peace", "happiness" };	

}
