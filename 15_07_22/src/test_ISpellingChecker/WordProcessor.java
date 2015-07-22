package test_ISpellingChecker;

public class WordProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����� �˻��� �ѱ� �ܾ� ����� �����Ѵ�
		String [] koreans = { "���", "�̿�", "��ȭ", "����", "����" };
		// �߸��� �ܾ �޾Ƶ��� String �迭 ������ �����Ѵ�
		String [] errors;
		// ����� �˻�� �ν��Ͻ��� �����ϰ�, ISpellingChecker �������̽��� ���Ѵ�
		SpellingChecker spellingchecker = new SpellingChecker();
		ISpellingChecker sc = spellingchecker;
		// ����� �˻��� �� �ѱ۷� �����Ѵ�
		sc.setLanguage(0);
		// ����� �˻��� �ܾ� ����� �����Ѵ�
		sc.setWords(koreans);
		// ����� �˻縦 �����Ѵ�
		errors = sc.check();
		// ����� �˻� ��� ��ȯ�� �߸��� �ܾ��� ����� ����Ѵ�
		for(int i = 0; i < errors.length; ++i) {
			if(errors[i] != null)
				System.out.println(errors[i]);
		}
		// ����� �˻��� ���� �ܾ� ����� �����Ѵ�
		String [] englishes = { "love", "hate", "peace", "unhappiness", "war" };
		// ����� �˻��� �� ����� �����Ѵ�
		sc.setLanguage(1);
		// ����� �˻��� �ܾ� ����� �����Ѵ�
		sc.setWords(englishes);
		// ����� �˻縦 �����Ѵ�
		errors = sc.check();
		// ����� �˻� ��� ��ȯ�� �߸��� �ܾ��� ����� ����Ѵ�
		for(int i = 0; i < errors.length; ++i) {
			if(errors[i] != null)
				System.out.println(errors[i]);
		}		
		// IDictionary �������̽� ���
		IDictionary dic = spellingchecker;
		String result = dic.find("���");
		System.out.println(result);

	}

}
