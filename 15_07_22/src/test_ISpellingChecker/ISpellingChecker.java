package test_ISpellingChecker;

/*
ISpellingChecker 인터페이스를 정의한다.
	-언어선택기능
	-검사할 단어 지정 기능
	-맞춤법 검사 기능
ISpellingChecker 구현하는 클래스를 정의한다.
	-표준 단어 목록을 정의한다.
	-인터페이스 메서드를 정의한다.
*/

public interface ISpellingChecker { //맞춤법 검사기
	String [] check();
	void setWords(String [] words);
	void setLanguage(int lang);
	
	

	
}
