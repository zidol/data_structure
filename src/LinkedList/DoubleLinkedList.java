package LinkedList;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if(this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node; //현재 노드를 지정
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchFromTail(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    //임의 노드에 추가 할수 있는 메서드
    public boolean insertFrontData(T exitedData, T addData) {//exitedData 해당 데이터 , addData 넣을 데이터
        if (this.head == null) {//헤드가 없을경우
            this.head = new Node<T>(addData);
            this.tail = this.head;
            return true;
        } else if (this.head.data == exitedData) {//헤드 앞에 데이터를 넣을 경우
            Node<T> newHead = new Node<T>(addData);
            newHead.next = this.head; //새로 넣은 데이터 next에 기존 헤드를 연결
            this.head = newHead;      //헤드에 새로운 값을 넣음
            this.head.next.prev = this.head; // 헤드 다음 노드의 prev에 head를 연결 해줌
            return true;
        } else {//헤드가 아닌 그 이후에 연결된 노드 중 하나 일때
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == exitedData) {
                    Node<T> nodePrev = node.prev;   //현재 노드의 앞에 있는 노드(nodePrev)

                    nodePrev.next = new Node<T>(addData);   //현재 노드의 앞에 있는 노드(nodePrev)의 next에 새로 넣을 노드를 연결
                    nodePrev.next.next = node;  //추가한 addData의 next에  현재 노드 데이터를 연결

                    nodePrev.next.prev = nodePrev;  //추가한 addData의 prev는 null 이기때문에 nodePrev를 추가해줘야
                    node.prev = nodePrev.next; //현재 노드의 prev는 addData(nodePrev.next)를 연결해야함
                    return true;
                } else {
                    node = node.next;//순회
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<Integer>();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);

        linkedList.printAll();

//        System.out.println(linkedList.searchFromHead(2));

        System.out.println("---------------");
        System.out.println(linkedList.insertFrontData(3, 2));
        linkedList.printAll();
        System.out.println("----------------");

        linkedList.insertFrontData(6, 2);
        linkedList.insertFrontData(1, 0);
        linkedList.printAll();
        System.out.println("----------------");

        linkedList.addNode(6);
        linkedList.printAll();

    }
}
