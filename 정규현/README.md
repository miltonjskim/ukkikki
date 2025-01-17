# 1월 13일 

# 아이디어 도출 회의 

## 자취 커뮤니티(1인 가구)

---

## 소개

최근 1인 가구는 꾸준히 증가하고 있으며, 이러한 트렌드는 앞으로도 지속될 전망입니다. 이에 따라 자취생 및 1인 가구만을 위한 커뮤니티 서비스를 제공하여 일상생활에서의 불편함을 해결하고, 서로의 경험과 정보를 공유할 수 있는 플랫폼을 구축하고자 합니다.

---

## 주요 대상

1. 1인 가구 및 자취생
2. 혼자 생활하며 유용한 정보와 서비스를 필요로 하는 사용자
3. 택시 카풀, 홈트레이닝 등 특정 활동을 원하는 사용자

---

## 주요 기능

1. **물품 등록 게시판**  
   - 자취생을 위한 중고 물품 거래 기능
   - 자취 생활에 필요한 물품 추천 및 리뷰 제공

2. **택시 카풀 시스템**  
   - 같은 지역으로 이동하는 사람들을 매칭하여 택시 요금을 분담할 수 있는 기능
   - 안전한 카풀 서비스를 위해 사용자 인증 필수

3. **화상 운동 기능**  
   - 집에서 홈트레이닝을 하며 외로움을 해소하기 위한 화상 회의 지원
   - 같은 목표를 가진 사용자들끼리 운동 그룹 생성

4. **취미 커뮤니티**  
   - 같은 취미를 가진 사람들이 모여 토론하고 만날 수 있는 기능
   - 취미 활동 장소와 일정 공유

---

## 추가 아이디어

- **지역 기반 추천 서비스**  
  - 사용자 위치 기반으로 가장 가까운 취미 모임, 카풀 옵션, 중고 거래 물품을 추천
- **리워드 시스템**  
  - 커뮤니티 활동에 따라 포인트를 지급하여 사용자가 더 많이 참여하도록 유도
- **AI 추천 기능**  
  - 사용자의 관심사와 활동 패턴을 분석하여 맞춤형 모임 및 활동 추천

---

## 문제점 및 해결 방안

1. **사용자 인증의 중요성**  
   - 안전 문제를 예방하기 위해 인증 시스템 도입 (휴대폰 인증, 이메일 인증 등)
   - 카풀 및 모임의 신뢰성을 높이기 위한 사용자 리뷰 및 평점 시스템 추가

2. **사생활 보호**  
   - 사용자 정보를 안전하게 관리하기 위한 암호화 및 보안 조치
   - 선택적으로 프로필 공개 설정 제공

3. **유지 관리 및 확장성**  
   - 초기 개발 이후 안정적인 유지 관리 계획 수립
   - 사용자 피드백 기반으로 지속적인 기능 업데이트

---

# 1월 14일
---
# WebRTC

WebRTC(Web Real-Time Communication)는 별도의 소프트웨어 설치 없이 웹/앱에서 카메라, 마이크 등을 사용하여 실시간 커뮤니케이션을 가능하게 하는 오픈 소스 기술입니다. 비디오, 음성, 데이터의 Peer-to-Peer(P2P) 전송을 지원하며, JavaScript API를 통해 구현할 수 있습니다.


## 주요 특징

### 장점
- **낮은 Latency**
  - RTMP를 사용하는 인스타 라이브, 트위치 등과 비교하여 더 낮은 Latency를 제공하며 Real-Time에 가까운 방송 구현이 가능.
- **소프트웨어 설치 불필요**
  - 브라우저 기반에서 실시간 커뮤니케이션 제공.
- **개발 진입장벽 낮음**
  - JavaScript API 제공으로 비교적 쉬운 구현 가능.

### 단점
- **P2P 통신의 제약**
  - Peer-to-Peer 연결을 위해 사용자의 IP 주소를 알아야 함.
  - NAT(Network Address Translation) 환경에서는 STUN/TURN 서버가 필수.

---

## WebRTC 작동 원리 및 필요 지식

### NAT (Network Address Translation)
- Private IP를 Public IP로 변환하는 기술.
- 네트워크 트래픽을 주고받기 위해 IP 주소 및 포트를 재기록.
- 내부망(LAN)에서 통신 가능한 Private IP와, 외부 네트워크 통신에 필요한 Public IP로 구분.
- 방화벽 및 NAT 환경에서 P2P 연결을 위해서는 Public IP를 통해 통신 가능해야 함.

### ICE (Interactive Connectivity Establishment)
- 두 단말 간 최적의 통신 경로를 탐색하는 프레임워크.
- STUN 및 TURN 서버를 활용하여 연결 경로를 결정.
- 방화벽을 통과하거나 NAT를 우회하여 Peer 간 연결을 가능하게 함.

#### ICE가 필요한 이유
1. 다양한 네트워크 환경에서 Peer 간 단순 연결이 어려움.
2. 방화벽 및 NAT 환경을 우회하기 위해 STUN/TURN 서버 필요.
3. 최적의 연결 경로를 탐색하여 데이터 전송의 안정성 및 속도 보장.

---

## WebRTC를 활용한 구현 사례
- 화상 통화
- 실시간 스트리밍
- 파일 공유
- 화면 공유

---

## 보안 및 성능
- **P2P 연결**: 중계 서버를 거치지 않아 빠른 속도 보장.
- **보안 강화**: HTTPS를 통한 중간자 공격 방어.
- **UDP 기반 전송**: 낮은 Latency를 위해 UDP를 사용. (TCP도 지원하지만 제한적)
- **데이터 손실**: UDP의 특성상 일부 데이터 손실 가능성. (비디오/오디오 스트리밍에는 큰 문제 없음)

---

## WebRTC 구현 시 필수 구성 요소
1. **STUN 서버**: 클라이언트의 Public IP 및 포트 정보를 반환.
2. **TURN 서버**: P2P 연결이 불가능할 경우 데이터를 릴레이.


---
# 1월 15일
---
### STUN(Session Traversal Utilities for NAT)

- 공개 주소를 발견하거나 peer 간의 직접 연결을 막는 등 라우터의 제한을 결정하며 ICE를 보완한느 프로토콜이다.
- 간단하게 말하면 STUN 서버는 해당 Peer의 Public IP 주소를 보내는 역할을 한다.
- 두 엔드 포인트 간의 연결을 확인하고 NAT 바인딩을 유지하기 위한 연결 유지 프로토콜로 사용할 수 있다.
- 하지만 STUN은 항상 효과적이지 않다.
- 두 단말이 같은 NAT 환경에 있을 경우 NAT의 보안정책이 엄격하거나 등의 이유에 따라 STUN이 완벽한 해결책이 되지는 않는다.

### TURN(Traversal Using Relays around NAT)

- STUN의 확장으로 NAT 환경에서 릴레이하여 통신을 하게 된다.
- NAT 보안 정책이 너무 엄격하거나 NAT 순회를 하기 위해 필요한 NAT  바인딩을 성공적으로 생성할 수 없는 경우에 TURN을 사용함
- TURN 서버는 인터넷망에 위치하고 각 Peer(단말)들이 사설망(Private IP) 안에서 통신한다. 각 Peer들이 직접 통신하는 것이 아니라 릴레이 역할을 하는 TURN 서버를 사용하여 경유한다.
- TURN은 이러한 릴레이로부터 IP주소와 포트를 클라이언트가 취득할수 있는 릴레이 주소를 할당한다.

### TURN의 단점

- 클라이언트와의 연결을 거의 항상 제공하지만 STUN에 비해 리소스 낭비가 심하다.
- 따라서 ICE Candidate 과정에서 local IP로 연결할 수 있는지, Public IP로 연결할 수 있는지를( 모든 후보군을 찾은 후) 알아낸 후 최후의 수단으로 사용해야 함


### ICE Candidate Gathering

- Local Address, Server Reflexive Address, Relayed Address 등 통신 가능한 주소들을 모두 가져옴
- 이 주소들 중 가장 최적의 경로를 찾아서 연결

---

### P2P

- 클라이언트 컴퓨터끼리 직접적으로 통신하는 방식
- 양방향 통신을 통해 파일을 전송하는 시스템, 물론 반드시 파일 전송에만 쓰이는 것은 아님
- 중앙 서버 없이도 서로가 서로를 연결하여 데이터를 공유
- 중앙 서버가 없이 서로가 연결하여 데이터를 공유하기 때문에 중앙 서버 손실 시 데이터 회손에 대한 걱정이 없음
- 다만 데이터를 나눠 가질 수 있는 연결된 컴퓨터가 많으면 많을 수록 전송 속도는 점점 빨라지지만, 반대로 연결된 컴퓨터의 수가 적으면 속도가 많이 저하됨
- 또한, 개인의 정보 노출에 대한 피해가 발생할 수 있음.

# 1월 16일
# JPA (Java Persistence API)

- JPA는 Java 애플리케이션에서 객체 지향적인 방식으로 관계형 데이터베이스를 사용할 수 있도록 하는 **표준 API**. 
- ORM(Object-Relational Mapping) 기술의 일부로, 자바 객체와 데이터베이스 테이블 간의 매핑을 제공하여 개발자가 SQL 중심이 아닌 객체 중심으로 데이터베이스 다룸

---

## JPA의 주요 특징

1. **객체와 관계형 데이터베이스 매핑**
   - JPA는 엔티티 클래스를 통해 데이터베이스 테이블과 매핑을 수행. 
   - 개발자는 SQL 대신 자바 객체를 조작하며 데이터베이스 연산을 처리할 수 있음음.

2. **표준화**
   - JPA는 자바 EE 표준 사양으로, Hibernate, EclipseLink, OpenJPA와 같은 구현체를 사용.
   - 구현체를 교체해도 코드 변경 없이 동일한 방식으로 동작하도록 설계되어있음음.

3. **JPQL (Java Persistence Query Language)**
   - SQL과 유사한 문법을 가진 객체 지향 쿼리 언어로, 엔티티 객체를 기반으로 데이터베이스를 쿼리할 수 있음음.

4. **자동 매핑 및 관리**
   - 테이블 생성, 매핑, 데이터 변경 등을 자동으로 처리.
   - 지연 로딩(Lazy Loading), 캐싱 등 최적화 기능을 제공.

---

## JPA의 주요 구성 요소

### 1. Entity
- 데이터베이스 테이블에 매핑되는 자바 클래스.
- `@Entity` 어노테이션을 사용하여 선언.

```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
```

### 2. EntityManager
- JPA에서 데이터베이스와의 모든 상호작용을 담당.
- 엔티티 객체를 생성, 수정, 삭제, 조회하는 데 사용.
- `EntityManagerFactory`를 통해 생성.

### 3. Persistence Unit
- `persistence.xml` 파일에서 JPA 설정을 정의.

```xml
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.1">
    <persistence-unit name="my-persistence-unit">
        <class>com.example.User</class>
        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/mydb" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="password" />
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
        </properties>
    </persistence-unit>
</persistence>
```

### 4. JPQL
- 객체를 대상으로 하는 쿼리 언어.

```java
TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
query.setParameter("name", "John");
List<User> users = query.getResultList();
```

---

## JPA의 장점

1. **생산성**
   - SQL 대신 객체 조작으로 비즈니스 로직 구현에 집중 가능.
2. **유지보수성**
   - 객체 모델과 데이터베이스 모델 간 매핑으로 코드 가독성 증가.
3. **확장성**
   - Hibernate, EclipseLink 등 다양한 구현체 사용 가능.
4. **데이터베이스 독립성**
   - 데이터베이스 변경 시 코드 변경 최소화.

---

## JPA의 단점

1. **학습 곡선**
   - 초기에 설정과 매핑 이해에 시간이 필요.
2. **추상화 비용**
   - 자동 생성된 SQL이 비효율적일 수 있음.
3. **복잡한 쿼리**
   - 복잡한 쿼리는 JPQL 대신 네이티브 SQL 사용이 필요할 수 있음.

---

## 주요 JPA 구현체

1. **Hibernate**
   - 가장 널리 사용되는 JPA 구현체.
   - 다양한 추가 기능(캐싱, 배치 처리) 지원.
2. **EclipseLink**
   - Oracle이 지원하는 JPA 구현체.
3. **OpenJPA**
   - Apache에서 제공하는 JPA 구현체.

---
# 1월 17일

## DB 설계
---

### datetime vs timestamp ?
    - timestamp 장점
        - 서버 시간 반영이 바로 된다
    - timestamp 단점
        - 1970-01-01 00:00:01 ~ 2038-01-19 08:44:07까지의 데이터만 지원
        - timestamp 타입을 갖는 쿼리는 캐시로 저장되나 Datetime 타입을 갖는 쿼리는 캐시로 저장되지 않는다.
    
    시스템적 로그 → timestamp
    
    보기좋은 시간 → datetime
    
---
## DB 테이블 설계

- 일반 사용자 - 기업 사용자 테이블 전략에 대한 고민
    
    ## 1. **테이블 설계**
    
    ### **1-1. 단일 테이블 전략 (Single Table)**
    
    하나의 `users` 테이블에 모든 사용자를 저장하되, 추가적으로 `user_type` 필드를 두어 사용자를 구분.
    
    ### 테이블 구조
    
    | Column | Type | Description |
    | --- | --- | --- |
    | id | VARCHAR | 사용자 고유 ID |
    | pwd | VARCHAR | 비밀번호 |
    | user_type | ENUM | 사용자 유형 (`NORMAL`/`COMPANY`) |
    | comp_id | VARCHAR | 기업 사용자용 추가 정보 |
    
    ### 장점
    
    - **간단한 설계**: 모든 사용자 데이터가 하나의 테이블에 있어 유지보수와 쿼리 작성이 단순.
    - **확장성**: Spring Security에서 사용자 유형을 `user_type`으로 쉽게 구분하여 권한을 처리.
    
    ### 단점
    
    - `comp_id`는 일반 사용자에게 항상 `NULL`.
    - 테이블이 커질 경우 성능 이슈가 발생 가능능.
    
    ---
    
    ### **1-2. 상속 구조 전략 (Table per Class)**
    
    슈퍼 테이블 `users`를 두고, `normal_users`와 `company_users`를 각각 별도 테이블로 분리하며 JPA의 상속 매핑 전략.
    
    ### 테이블 구조
    
    1. `users` (슈퍼클래스)
        
        
        | Column | Type | Description |
        | --- | --- | --- |
        | id | VARCHAR | 사용자 고유 ID |
        | pwd | VARCHAR | 비밀번호 |
    2. `normal_users` (일반 사용자 서브클래스)
        
        
        | Column | Type | Description |
        | --- | --- | --- |
        | id | VARCHAR | `users`의 ID (FK) |
    3. `company_users` (기업 사용자 서브클래스)
        
        
        | Column | Type | Description |
        | --- | --- | --- |
        | id | VARCHAR | `users`의 ID (FK) |
        | comp_id | VARCHAR | 기업 ID |
    
    ### 장점
    
    - **데이터 정규화**: 각 테이블이 해당 도메인에 맞는 데이터를 저장하므로 `NULL` 값이 없음.
    - **확장성**: 일반 사용자와 기업 사용자를 독립적으로 관리 가능.
    - **JPA 상속**: Spring Security에서 `@Inheritance`를 사용하여 편리하게 사용자 유형을 처리리.
    
    ### 단점
    
    - 테이블 조인이 필요해 복잡도가 증가할 수 있음.
    - 모든 사용자를 조회할 때 성능 저하 가능성이 있음음.
    
    ---
    
    ### **1-3. 두 테이블 전략 (Separate Tables)**
    
    `normal_users`와 `company_users`를 완전히 별도 테이블로 구성하고, 두 테이블을 분리하여 관리.
    
    ### 테이블 구조
    
    1. `normal_users`
        
        
        | Column | Type | Description |
        | --- | --- | --- |
        | id | VARCHAR | 사용자 고유 ID |
        | pwd | VARCHAR | 비밀번호 |
    2. `company_users`
        
        
        | Column | Type | Description |
        | --- | --- | --- |
        | id | VARCHAR | 사용자 고유 ID |
        | pwd | VARCHAR | 비밀번호 |
        | comp_id | VARCHAR | 기업 ID |
    
    ### 장점
    
    - **독립성**: 일반 사용자와 기업 사용자를 완전히 분리하여 관리할 수 있음.
    - **단순성**: 필요에 따라 각각의 테이블에 대해 최적화된 쿼리를 작성할 수 있음음.
    
    ### 단점
    
    - Spring Security에서 별도 사용자 저장소(`UserDetailsService`)를 구현해야 하므로 개발 부담이 커짐짐.
    - 두 테이블을 합쳐서 조회해야 하는 경우 복잡성이 증가.
    
    ---
    
    ## 2. **Spring Security와 JPA 설계**
    
    ### **2-1. 단일 테이블 전략**
    
    - `user_type` 필드를 기준으로 사용자 유형을 구분.
    - Spring Security의 `GrantedAuthority`를 활용해 권한을 설정.
    
    ```java
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        private String id;
        private String pwd;
        @Enumerated(EnumType.STRING)
        private UserType userType; // NORMAL, COMPANY
        private String compId; // 기업 사용자만 사용
    }
    
    ```
    
    ### **2-2. 상속 구조 전략**
    
    - JPA 상속을 사용하여 `users` 슈퍼클래스와 서브클래스를 구성.
    - Spring Security에서 서브클래스를 `UserDetails`로 매핑.
    
    ```java
    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    @Table(name = "users")
    public abstract class User {
        @Id
        private String id;
        private String pwd;
    }
    
    @Entity
    @Table(name = "normal_users")
    public class NormalUser extends User {
        // 일반 사용자용 필드 추가 가능
    }
    
    @Entity
    @Table(name = "company_users")
    public class CompanyUser extends User {
        private String compId; // 기업 사용자용 필드
    }
    
    ```
    
    ### **2-3. 두 테이블 전략**
    
    - 두 개의 `UserDetailsService` 구현체를 작성하여 각각 `normal_users`와 `company_users`를 처리.
    - Spring Security에서 요청에 따라 적절한 서비스로 라우팅.
    
    ---
    
    ## 3. **권장 설계**
    
    - **사용자 간의 관계가 거의 없고 분리된 처리가 중요하다면:** **두 테이블 전략**.
    - **공통된 처리가 많고 사용자가 자주 혼합되어 조회된다면:** **단일 테이블 전략**.
    - **유지보수성과 확장성을 고려하면서 데이터 정규화가 중요하다면:** **상속 구조 전략**.