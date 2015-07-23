package ETC;

public class UserException extends exception {
	//변수 설정
	private int code = 0;
	private static String[] message;
	static {
		message = new String[10];
		for(int i = 0 ; i < 10 ; i++) {
			message[i] = "에러메시지"+i;
		}
	}
	
	//생성자.메소드 입력
	public UserException(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return String.format("예외코드 :%d, 메시지:%s",code, message[code]);
	}
	
}
