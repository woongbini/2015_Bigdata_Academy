package test_ISpellingChecker;
// SpellingChecker.java ����

class SpellingChecker implements ISpellingChecker, IDictionary {

	public String[] check() {
		
		String [] errorStrings = new String[words.length]; // �߸��� �ܾ���� ��ȯ�ϱ� ���� String �迭�� �����Ѵ�
		int count = 0; // �߸��� �ܾ��� ������ ������ ������ ����
		for(int i = 0; i < words.length; ++i) { // ������� �˻��� ������ �ܾ�鿡 ���Ͽ�
			if (language == 0) { // ���� �ѱ��� �˻��Ѵٸ�( �ѱ�)
				boolean bFound = false; // ǥ�� �ܾ ã�Ҵ��� ���θ� ������ ������ �����ϰ� �ʱⰪ���� ��á�Ҵٰ� �����Ѵ�
				for(int j = 0; j < wordsKorean.length; j++) { // ����� �˻��� �ܾ ǥ�� �ܾ� ��Ͽ� �ִ��� �˻��Ѵ�
					if(words[i] == wordsKorean[j]) { // ���� ã�Ҵٸ�
						bFound = true; // ã�Ҵٴ� ǥ�ø� �ϰ� 
						break; // �� �̻� ǥ�� �ܾ� ����� �˻��� �ʿ䰡 �����Ƿ� for ���� �������´�
					}
				}
				
				if(bFound == false) // ����� �˻��� �ܾ ǥ�� �ܾ� ��Ͽ� ���ٸ�
					errorStrings[count++] = words[i]; // �� �ܾ �߸��� �ܾ� ��Ͽ� �����ϰ� �߸��� �ܾ��� ������ �ϳ� ������Ų��
			} else
				if (language == 1) { // ������ �˻��ϴ� ��쿡�� �ѱ��� �˻��ϴ� �Ͱ� �����ϴ�( ���� )
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
	// IDictionary �������̽�
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
	private String [] wordsKorean = { "���", "��ȭ", "�ູ" };
	private String [] wordsEnglish = { "love", "peace", "happiness" };	

}
