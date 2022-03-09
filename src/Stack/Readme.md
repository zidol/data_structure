##스택 (Stack)

##1. 스택 구조
- 사전적 정의는 '쌓다', '더미'이며 상자에 물건을 쌓아 올리듯이 데이터를 쌓는 자료 구조
- 데이터를 제한적으로 접근할 수 있는 구조
    - 한쪽 끝에서만 자료를 넣거나 뺄 수 있는 구조
* 가장 나중에 쌓은 데이터를 가장 먼저 빼낼 수 있는 데이터 구조
    - 큐: FIFO 정책
    - 스택: LIFO 정책

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FYhtxB%2FbtqHsbZTFED%2FDhCPI65pmzfsqETjti138k%2Fimg.jpg"/>

##2. Stack의 특징
### 1. 먼저 들어간 자료가 나중에 나옴 LIFO(Last In First Out) 구조
### 2. 시스템 해킹에서 버퍼오버플로우 취약점을 이용한 공격을 할 때 스택 메모리의 영역에서 함
### 3. 인터럽트처리, 수식의 계산, 서브루틴의 복귀 번지 저장 등에 쓰임
### 4. 그래프의 깊이 우선 탐색(DFS)에서 사용
### 5. 재귀적(Recursion) 함수를 호출 할 때 사용


##3.JAVA Stack 클래스
- java.util 패키지에서 Stack 클래스 제공함
  - push(데이터) 메서드 : 데이터를 Stack에 추가
  - pop() 메서드 : Stack 에서 마지막에 넣은 데이터를 리턴하고, 해당 아이템은 Stack 에서 삭제