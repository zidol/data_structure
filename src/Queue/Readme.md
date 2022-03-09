##큐 (Queue)

## 1. 큐 구조
* Queue의 사전적 의미는 무엇을 기다리는 사람, 차량 등의 줄 혹은 줄을 서서 기다리는 것을 의미하는데 이처럼 줄을 지어 순서대로 처리되는 것
* 가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 구조
    - 음식점에서 가장 먼저 줄을 선 사람이 제일 먼저 음식점에 입장하는 것과 동일
    - FIFO(First-In, First-Out) 또는 LILO(Last-In, Last-Out) 방식으로 스택과 꺼내는 순서가 반대
<img src="https://www.fun-coding.org/00_Images/queue.png" />

> 출처 : http://www.stoimen.com/blog/2012/06/05/computer-algorithms-stack-and-queue-data-structure/

## 2. 큐 용어
- Enqueue: 큐에 데이터를 넣는 기능
- Dequeue: 큐에서 데이터를 꺼내는 기능

## 3. Queue의 특징

### 1. 먼저 들어간 자료가 먼저 나오는 구조 FIFO(First In FIrst Out) 구조
### 2. 큐는 한 쪽 끝은 프런트(front)로 정하여 삭제 연산만 수행함
### 3. 다른 한 쪽 끝은 리어(rear)로 정하여 삽입 연산만 수행함
### 4. 그래프의 넓이 우선 탐색(BFS)에서 사용
### 5. 컴퓨터 버퍼에서 주로 사용, 마구 입력이 되었으나 처리를 하지 못할 때, 버퍼(큐)를 만들어 대기 시킴

## 4. JAVA에서 큐 자료 구조 사용하기
- JAVA 에서는 기본적으로 java.util 패키지에 Queue 클래스를 제공하고 있음
  - Enqueue 에 해당하는 기능으로 Queue 클래스에서는 add(value) 또는 offer(value) 메서드를 제공
  - Dequeue 에 해당하는 기능으로 Queue 클래스에서는 poll() 또는 remove() 메서드를 제공
  - Queue 클래스에 데이터 생성을 위해서는 java.util 패키지에 있는 LinkedList 클래스를 사용해야 함
    
