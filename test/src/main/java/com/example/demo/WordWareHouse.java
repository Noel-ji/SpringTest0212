package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

public class WordWareHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 스프링 용어정리집.
		// JPA(Java Persistence API)
		// ORM(Object Relational Mapping)
		//   -> 프로그래밍 문법으로도 데이터 베이스를 다룰수 있는 방법.
		//   -> ORM을 이용하면 개발자는 SQL을 직접 쓰지 않아도 DB를 활용하는것이 가능
		//      (이론상으로는요)
		//   -> JPA는 자바의 ORM 프레임워크를 JPA라 부름.
		//   -> JPA를 실제로 구현한 클래스들중 대표적인것이 하이버네이트 라는 클래스가 있음.
		
		// @Autowired : 해당 필드나 생성자 또는 메서드에 대해 스프링 컨테이너가
		//				적적한 객체(Bean)를 찾아 자동으로 주입해주는 어노테이션
		//	   -> 안쓰면 생성자부터 일일히 직접 선언하고 연결하는게 너무 귀찮음. 
		
		// @Transactional : 데이터베이스에서 트랜젝션을 관리하기 위해 사용.
		//	 -> 변경을 감지하는 어노테이션
		//   -> 서비스단의 업무 자체를 하나로 묶어버릴 수 있는 어노테이션
		//   -> 객체의 변경이 감지가 되면 repository에서 자동으로 감지하여 저장.
		
		// JUnit : 테스트코드를 작성하고 작성한 테스트 코드를 실행 할 떄 사용하는 자바의 사용 코드
		//  -> 스프링과는 별개의 프레임워크.
		
		// 엔티티 관련 용어 정리.
		// @Entity : 스프링이 해당 클래스를 엔티티 객체로 인식하도록 돕는 어노테이션
		// @Id : 기본키 설정
		//  - 고유한 값인 컬럼(멤버변수)를 설정해야해서
		//  - 중복이 없는 컬럼으로 설정해야함.
		// @GeneratedValue : 데이터 저장시 해당 속성에 값을 지정하지 않아도
		// 					 차등으로 1씩 증가하여 저장되는 어노테이션.
		// strategy = GenerationType.IDENTITY : 고유한 번호를 생성하는 방법을 지정하는 부분.
		// IDENTITY : db가 기본 키값을 자동으로 생성하도록 유도
		//  -> DB에 키 생성을 완전히 위임하는 전략.
		//  -> 데이터를 INSERT 해야지만 ID값을 알 수 있음.
		// SEQUENCE : 주로 Oracle, postgreSQL에서 사용.
		//  -> 여러 엔티티가 하나의 시퀀스를 공유 할 수도 있음.
		//  -> 성능 최적하에도 좋다.(미리 일정량의 ID를 받아둔뒤 메모리에 두고 사용하는 형태)
		// TABLE : 키 생성 전용 테이블을 두고 ID를 가져오는 방식.
		//  -> 이런거만 있다고 알아두세요.(거의 안씀)
		
		
		// GenerationType : 전략 설정
		
		
		// @Column : 컬럼(멤버변수)에 다양한 제약조건을 설정할수 있음
		//  -> 열(컬럼)의 세부 설정을 진행
		// length : 열의 길이 설정
		// columnDefinition : 열 데이터의 유형이나 성격을 정의 할 때.
		//  - TEXT : 말그대로 문자(텍스트)들을 열의 데이터로 넣을 수 있음.
		//  - 잘모르겠다 싶으면 내가 알고있는 DB sql 문법으로 작성해도 됨.
		// name : dbms 컬럼명(흔히 dbms에 써둔 컬럼명과 일치시킬 때 사용) 
		// nullable : null값 허용 여부. (기본값 : true)
		// unique
		// precision : 전체 자릿수 설정
		// scale : 소숫점 이하 자릿수
		//  -> precision, scale 사용 에씨 : @Column(precision = 10, scale = 2)
		//  -> decimal(10, 2);
		
		// 엔티티(테이블) 연관 관계 매핑 어노테이션
		// @ManyToOne = N:1
		// @OneToMany = 1:N
		// @ManyToMany = N:M
		
		// 유효성검사 (validation check) : 데이터를 검증하는 단계
		// @NotNull(message="메세지") : 널값 불허
		// @NotBlank(message="메세지") : 공백 불허
		// @Email() : 이메일 형식 검증
		//
		// 숫자관련
		// @Min(Value = 20, message = "20이하면 메세지뜸")
		// @Max(Min과 사용방법 같음)
		// @Pattern(정규표현식 활용하여 많은 조건을 지정 할 수 있음.)
		
		// 날짜 관련
//	    @CreatedDate
//	    private LocalDateTime createdAt;
//	    // 토심이: "생성 시간은 제가 자동으로 기록해드릴게요!"
//	    
//	    @LastModifiedDate  
//	    private LocalDateTime updatedAt;
//	    // 토심이: "수정 시간도 실시간으로 업데이트해드려요!"
//	    
//	    @CreatedBy
//	    private String createdBy;
//	    // 토심이: "누가 만들었는지도 기록할 수 있어요!"
//	    
//	    @LastModifiedBy
//	    private String lastModifiedBy;
//	    // 토심이: "마지막 수정자도 추적 가능합니다!"
		
		// 쿠키와 세션
		// 쿠키 : 클라이언드 로컬에 저장되는 키와 값이 들어있는 작은 데이터파일.
		//  - 사용자 인증이 유효한 시간 자체를 명시할 수 있어서.
		//  - 유효 시간이 정해지면 브라우저가 종료되어도 인증이 유지된다는 특징이 있음.
		//  - 클라이언트의 상태 정보를 로컬에 저장했다가 참조.
		
		// 세션 : 쿠키랑 비슷한데 다만 저장위치가 해당 서비스를 제공하는 서버측.
		//       세션ID 라는것을 부여한 후 서버에 접속해서 종료할때까지
		// 		 인증상태를 유지하는 것이 일반적.
		/*
		 * // 유효성 검사 어노테이션
		// @NotEmpty : 이 칸은 비워두면 안돼
		// - target = String, Collection, Map, Array
		// - null 혹은 내용물이 하나도 없는 경우를 허용하지 않음
		// - !단 공백문자만 있는 경우는 통과
		// - 게시글 내용처럼 내용은 있되 공백은 허용해야하는 경우에 씀      
		// -- @NotEmpty(message="이 칸은 비워두면 안돼!")
		      
		// @NotBlank : 공백은 인정 못 해
		// - target = String
		// - 기본적으로 NotEmpty 포함
		// - 사용자 아이디, 닉네임, 게시글 제목(애매)같이 의미없는 공백을 허용하고 싶지 않은 경우에 씀
		// -- @NotBlank(message="")
		      
		// @NotNull : 오직 null 객체가 들어있는 지만 확인함. 공백, 빈 List 허용
		// - 나이, 가격, 동의 여부처럼 null 자체만 막고싶을 때
		      
		// @Size : 최소글자수, 최대글자수 지정할 때 사용
		// - target = String, Collection
		// - 문자열의 길이나 컬렉션 크기가 지정된 최소 최대값 범위 안인지 확인
		// - 비밀번호 길이, 게시글 제목 길이 제한
		// -- @Size(min=8, max=20, message="")
		      
		// @Min, @Max : 숫자 크기를 제한할 때 사용
		// - target = int, long, Integer
		// -- @Min(value=1, message="");
		      
		// @Email(비추)
		// - @의 여부로 이메일 체크
		// - ! @만 있으면 이상한 이메일 형식도 통과시킬 수 있음 ==> 이거 쓸 때 이메일 인증 걸어두기
		      
		// @Pattern()
		// - 
		      
		// bindingResult : 검증 결과를 담아낼 객체
		 * 
		 * bindingResult : 검증을 진행하면 검증의 결과를 담아낼 객체.
		 *  -> 검증 대상 바로 뒤에 위치 시키면 
		 * 
		 *
		 * 필요한 만큼 보여준다.
		 * @ControllerAdvice
		 *  - 모든 컨트롤러를 중아집중식으로 관리하는 어노테이션.
		 *    (모든 컨트롤러에 적용되는 것이 기본. 단 특정한 범위로 제한하는 것도 가능.)
		 *    제한범위 : 해당 컨트롤러 파일, 해당 패키지, 상속관계
		 *  - 컨트롤러에서 공통적으로 발생하는 예외나 로직을 중앙에서 처리 할 수 있게 해주는 기능.
		 *  - AOP 하기전에 연습한다 생각하세요~
		 *  
		 * 페이징 처리를 돕는 클래스(객체)
		 * Page : 페이징 그 자체를 위한 클래스
		 * Pageable : 페이징 처리를 실질적으로 진행하는 클래스
		 * PageRequest : 현재 페이지와 한 페이지에 보여줄 게시물 개수 등을 설정하여
		 * 				 페이징 요청을 진행하는 클래스
		 * 
		 * 페이징관련 템플릿단(타임리프기준)의 주요 코드
		 * th:classappend="${!paging.hasPrevious} ? disabled"
		 *  -> 이전 페이지가 없으면 '이전'링크를 비활성화.
		 *     (해당하는 객체가 없으면 해당 링크 비활성화)
		 * th:classappend="${!paging.hasNext} ? disabled"
		 *  -> 다음 페이지가 없으면 '다음' 링크를 비활성화
		 * 
		 * th:href="@{|?page=${paging.number-1}|}" : 이전페이지 링크
		 * th:href="@{|?page=${paging.number+1}|}" : 다음페이지 링크
		 * 
		 * 0부터 전체 페이지수 만큼 이 요소를 반복하여 생성.
		 *  현재 순번은 page 객체(변수)에 대입.
		 * th:each="page: ${#numbers.sequence(0, paging.totalPages-1)}"
		 *   
		 * th:classappend="${page == paging.number} ? 'active'"
		 * 반복 구간내에서 해당 페이지가 현재페이지와 같은 경우 active 클래스를 적용한다.
		 *   
		 * 프로젝트 생성 후 만들어진 디렉토리 구조 설명  
		 * src/main/java : 자바 파일 저장공간.
		 *  -> 컨트롤러, 서비스, DTO, 엔티티, Repo등 서버단에서 동작하는 코드들을 저장.
		 *     (프로젝트명 Application 파일을 통해 Ioc가 발생하면서 프로젝트가 구동)  
		 * src/main/resource : 템플릿 저장공간.
		 *   -> static : 정적파일 저장공간
		 *      ex) css, js, 이미지등 미디어파일
		 *   -> application.properties : 프로젝트 환결성정 파일
		 *   			   .yml
		 *   	(스프링부트는 그래도 사용자 편의가 제법 괜찮은 프레임워크)
		 * src/test/java : junit으로 스프링 부트의 테스트 도구를 사용하여
		 * 				   서버 실행없이 java 디렉토리에 작성한 코드를 테스트 할 수 있음.
		 * 
		 * @RestController : 스프링에서 RESTful 웹 서비스를 구축할 때 사용.
		 *  - @Controller 는 리턴시 템플릿을 쫓아간다 치면
		 *    @RestController는 리턴시 값 자체를 뱉어내는 개념이라 생각.
		 *    
		 * @RestController 특징
		 * 객체를 리턴할 때 자동으로 JSON 형식으로 변환하여 클라이언트에 전송.
		 * @Controller + @ResponseBody
		 * 
		 * 왜 쓰냐? : 간결하게 RESTful api 구현하려고.
		 *   -> GET, POST 말고도 
		 *   
		 * ResponseEntity
		 * HTTP Response(응답)을 표현하는 클래스.
		 *  -> 상태코드, 헤더 및 본문을 모두 포함할 수 있음.
		 *  
		 * 200, 404, 500 등의 상태코드 지정 가능.
		 * HTTP 응답을 세밀하게 제어하는 도구.
		 *   ->> 개발자는 클라이언트에 대한 응답을 보다 명확하게 구성할 수 있음.
		 * 
		 * web server 와 was
		 * Web Server : HTTP 프로토콜을 통해 클라이언트의 요청을 받아들이고
		 * 				웹 페이지를 반환하는 프로그램.
		 * 				정적인 컨텐츠들을 즉시 응답 가능한 형태로 제공
		 * 
		 * WAS(Web Application Server)
		 *  - 웹 어플리케이션(웹서비스)와 서버 환경을 만들어서 동작시키는 기능을
		 *    제공하는 소프트웨어 프레임워크.
		 *  - 클라이언트와 데이터베이스간의 연결을 관리하고 동적인 컨테츠 생성과
		 *    비즈니스 로직 처리를 담당.
		 * 
		 * hibernate ddl-auto 옵션
		 * 
		 * 1. create : 기존 엔티티(테이블)들을 모두 삭제하고 새로 만들 때 사용.
		 *    - 운영 서버에서는 절대 금지!! 
		 * 2. create-drop : create와 똑같음
		 *    - 서버가 종료되면 테이블을 모두 삭제.
		 * 3. update : 기존 테이블 구조와 @Entity를 비교해서 바뀐 부분만 반영
		 *    - 개발시에는 매우 편리 근데 엔티티 작성하다가 틀리면 불필요한 컬럼이 생길 수 있음.
		 * 4. validate : 현상 유지 감시
		 *    - 테이블과 엔티티가 일치하는지만 검사 다르면 에러 뱉어냄.
		 * 5. none
		 *    - JPA는 데이터베이스(스키마)에 아무런 영향도 주지 않음.
		 *      (운영서버에서 권장되는 방식)
		 *      
		 * show-sql, format_sql
		 * show-sql : JPA가 생성하는 SQL을 콘솔에 출력할지 체크하는 여부.
		 * format_sql : 출력되는 SQL에 줄 바꿈과 들여쓰기를 적용시켜서 가독성을 높임.
		 * 
		 *     
		 *     
		 *   
		 * 
		 *  
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	
	
		
		
		
		
		
		
		
		
		
		
	}

}
