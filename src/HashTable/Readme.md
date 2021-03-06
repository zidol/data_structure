# 해시 테이블 (Hash Table)
해시 테이블은 (Key, Value)로 데이터를 저장하는 자료구조 중 하나로 빠르게 데이터를 검색할 수 있는 자료구조이다. 해시 테이블이 빠른 검색속도를 제공하는 이유는 내부적으로 배열(버킷)을 사용하여 데이터를 저장하기 때문이다. 해시 테이블은 각각의 Key값에 해시함수를 적용해 배열의 고유한 index를 생성하고, 이 index를 활용해 값을 저장하거나 검색하게 된다. 여기서 실제 값이 저장되는 장소를 버킷 또는 슬롯이라고 한다.

출처: https://mangkyu.tistory.com/102 [MangKyu's Diary]
- 키(Key)에 데이터(Value)를 매핑할 수 있는 데이터 구조
- 해시 함수를 통해, 배열에 키에 대한 데이터를 저장할 수 있는 주소(인덱스 번호)를 계산
- Key를 통해 바로 데이터가 저장되어 있는 주소를 알 수 있으므로, 저장 및 탐색 속도가 획기적으로 빨라짐
- 미리 해시 함수가 생성할 수 있는 주소(인덱스 번호)에 대한 공간을 배열로 할당한 후, 키에 따른 데이터 저장 및 탐색 지원
### 해시 테이블 키워드
* 해시 함수(Hash Function)
    - 해시(Hash), 해시 값(Hash Value), 또는 해시 주소(Hash Address): 해싱 함수를 통해 리턴된 고정된 길이의 값
    - key를 고정된 길이의 hash로 변경해주는 역할
    - 서로 다른 key가 hashing 후 같은 hash값이 나오는 경우가 있다. 이를 해시충돌이라고 부른다. 해시 충돌 발생확률이 적을 수록 좋다.
    - 해시충돌이 균등하게 발생하도록 하는것도 중요함 
    - 모든 키가 같은 해시값이 나오게 되면 데이터 저장시 비효율성도 커지고 보안이 취약해져서 좋지 않음
* 해시 테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
    - 슬롯(Slot): 해시 테이블에서 한 개의 데이터를 저장할 수 있는 곳
    - 버킷: 데이터가 저장되는 곳
  
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FeHiqbk%2FbtqS1WeoGXA%2FfIo6eAPnZtGiY9Glrn8Zek%2Fimg.png" />

### 해시 함수
- Key 가 문자열일 때, 문자열의 앞 글자를 숫자로 변환해서, Division 기법을 사용하여, Key에 대한 주소(인덱스 번호) 계산
  - Division 
    - 가장 간단한 해시 함수 중 하나로, 나누기를 통해, 나머지 값을 사용하는 기법 
  ```java
    //간단한 해싱함수
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hasTable.length;
    }
  ```
  - Multiplication
    - 숫자 키 k, A는 0<A<1 사이의 실수 일때 `h(k) = (ka mod 1)*m 으로 계산
    - 2진수 연산에 최적화된 컴퓨터구조를 고려한 해시함수
  - Univeral hasing
    - 여러개의 해시함수를 만들고, 이 해사함수의 집합 H에서 무작위로 해시함수를 선택해 해시값을 만드는 기법
      서로 다른 해시함수가 서로 다른 해시값을 만들어내기 때문에 같은 공간에 매핑할 확률을 줄이는 것이 목적
### 장점
  - 해시테이블은 key-value가 1:1로 매핑되어 있기 때문에 삽입, 삭제, 검색의 과정에서 모두 평균적으로O(1)의 시간복잡도를 가지고 있다.
  - 해시는 키에 대한 데이터가 있는지(중복) 확인이 쉬움

### 단점
  - 해시 충돌이 발생(개방 주소법, 체이닝 과 같은 기법으로 해결해 줘야 한다.)
  - 순서/관계가 있는 배열에는 어울리지 않는다. 
  - 공간 효율성이 떨어진다. 데이터가 저장되기 전에 저장공간을 미리 만들어놔야한다. 공간을 만들었지만 공간에 채워지지 않는 경우가 발생한다.

### 주요 용도
  - 검색이 많이 필요한 경우
  - 읽기, 저장, 삭제가 많은 경우

### 충돌(Collision) 해결 알고리즘 

#### 1) Chaining 기법
- **개방 해싱 또는 Open Hashing 기법** 중 하나: 해시 테이블 저장공간 외의 공간을 활용하는 기법
- 충돌이 일어나면, 링크드 리스트라는 자료 구조를 사용해서, 링크드 리스트로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FnMfgg%2FbtqS1WyRuWI%2F32LmJGOvrT9YTndHMvYW50%2Fimg.png" />

### 장점
  - 미리 충돌을 대비해서 공간을 많이 잡아놓을 필요가 없다. 
  - 출돌이 나면 그때 공간을 만들어서 연결만 해주면 된다. 
### 단점
  - 같은 hash에 자료들이 많이 연결되면 검색시 효율이 낮아진다.
  - 해결 방법 : Open Addressing(개방주소법)개방 주소법은 충돌이 일어나면 비어있는 hash에 데이터를 저장하는 방법이다. 
  - 개방주소법의 해시 테이블은 hash와 value가 1:1관계를 유지한다.

#### 2) Linear Probing 기법
- **폐쇄 해싱 또는 Close Hashing 기법** 중 하나: 해시 테이블 저장공간 안에서 충돌 문제를 해결하는 기법
- 충돌이 일어나면, 해당 hash address의 다음 address부터 맨 처음 나오는 빈공간에 저장하는 기법
  - 저장공간 활용도를 높이기 위한 기법