package ETC;

public class UserException extends exception {
	//���� ����
	private int code = 0;
	private static String[] message;
	static {
		message = new String[10];
		for(int i = 0 ; i < 10 ; i++) {
			message[i] = "�����޽���"+i;
		}
	}
	
	//������.�޼ҵ� �Է�
	public UserException(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return String.format("�����ڵ� :%d, �޽���:%s",code, message[code]);
	}
	
}
