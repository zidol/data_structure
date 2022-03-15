## 링크드 리스트(Linked List, 연결 리스트)
## 1. 링크드 리스트 (Linked List) 구조
- 연결 리스트(LinkedList)는 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식의 자료구조
- 링크드 리스트는 떨어진 곳에 존재하는 데이터를 화살표로 연결해서 관리하는 데이터 구조
- 데이터를 담고 있는 노드들이 연결되어 있고, 노드의 포인터가 이전 노드와 다음 노드와의 연결을 담당

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbqsySc%2FbtqEk1stewE%2Ftnty2kV69c7l45eyUO3Jh0%2Fimg.png"/>

## 2. 링크드 리스트의 장단점 (전통적인 C언어에서의 배열과 링크드 리스트)
* 장점
    - 미리 데이터 공간을 미리 할당하지 않아도 됨
        - 배열은 **미리 데이터 공간을 할당** 해야 함
* 단점
    - 연결을 위한 별도 데이터 공간이 필요하므로, 저장공간 효율이 높지 않음
    - 연결 정보를 찾는 시간이 필요하므로 접근 속도가 느림
    - 중간 데이터 삭제시, 앞뒤 데이터의 연결을 재구성해야 하는 부가적인 작업 필요
### 3. 링크드 리스트의 복잡한 기능1 (링크드 리스트 데이터 사이에 데이터를 추가)
- 링크드 리스트는 유지 관리에 부가적인 구현이 필요함

<img src="https://www.fun-coding.org/00_Images/linkedlistadd.png" />

> 출처: wikipedia, https://en.wikipedia.org/wiki/Linked_list
### 4. 다양한 링크드 리스트 구조: 더블 링크드 리스트(Doubly linked list)
* 더블 링크드 리스트(Doubly linked list) 기본 구조
    - 이중 연결 리스트라고도 함
    - 장점: 양방향으로 연결되어 있어서 노드 탐색이 양쪽으로 모두 가능
      <br>
      <br>
      <img src="https://www.fun-coding.org/00_Images/doublelinkedlist.png" />
> 출처: wikipedia, https://en.wikipedia.org/wiki/Linked_list)