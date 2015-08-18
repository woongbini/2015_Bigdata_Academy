1. 로직
	1. dept정보 추가
	2. 특정 부서번호로 해당 부서 정보 검색
	3. 모든 부서 정보 검색
	
2. 제약 조선
	1. MVC & DAO[Data Access Object] & DTO, VO[DataTransferObject, Value Object] pattern
	2. 실행 performance를 고려해야 한다.
		- 객체수는 조절해야한다. (객체 자체가 필요한건지, 기능이 필요한지 구분(static키워드로 메소드 적용 유무)
		- 공유자원은 단 한번만 실행되는 구조로 개발해야한다. (static{ } 적절히 활용...
		

ojdbc.jar 를 넣으면 DB랑 통신여건

3. DB연동흐름
	1. Driver로딩
	2. Connection 접속
	3. statement : sql문장 실행 객체 preparedstatement
		dml - int반환
		ddl - boolean 반환
		query - resultset 객체 반환
	4. 자원반환 : resultset -> statement -> connection순으로 반환 