package test_ISpellingChecker;

/*
ISpellingChecker �������̽��� �����Ѵ�.
	-���ñ��
	-�˻��� �ܾ� ���� ���
	-����� �˻� ���
ISpellingChecker �����ϴ� Ŭ������ �����Ѵ�.
	-ǥ�� �ܾ� ����� �����Ѵ�.
	-�������̽� �޼��带 �����Ѵ�.
*/

public interface ISpellingChecker { //����� �˻��
	String [] check();
	void setWords(String [] words);
	void setLanguage(int lang);
	
	

	
}
