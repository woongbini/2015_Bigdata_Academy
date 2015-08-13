1. 로직 
	1. dept 정보 추가
	2. 특정 부서번호로 해당 부서 정보 검색
	3. 모든 부서 정보 검색
	
2. 제약 조건
	1. MVC & DAO[DataAccessObject] & DTO, VO[DataTransferObject,Value Object] pattern 
	2. 실행 Performance 고려해야 한다. 
		- 객체수는 조절해야한다.
			- 객체자체가 필요한건지, 기능이 필요한지 구분 ( static 키워드로 메소드 적용 유무)
		- 공유자원은 단 한번만 실행되는 구조로 개발해야 한다. 
			- static { } 적절히 활용...
	....
	
	
	
TIP : ojdbc.jar를 넣으면 DB랑 통신할수있는게 생김

//DB연동흐름
Driver로딩
connection 접속
statement : sql문장 실행 객체preparedstatement
		dml - int 반환
		ddl - boolean 반환
		query - resultset객체 반환
자원반환 : resultset -> statement -> connection순으로 반환

