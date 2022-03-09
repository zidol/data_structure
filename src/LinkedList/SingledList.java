package LinkedList;

public class SingledList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) { // 다음 노드가 있다는 의미
                System.out.println(node.data);
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }

    public void printAll() {
        if(head != null) {
            Node<T> node = this.head;
            System.out.print(node.data + " ");
            while (node.next != null) {
                node = node.next;
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    public boolean delNode(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            if (node.data == isData) {
                this.head = this.head.next;
                return true;
            } else {
                while (node.next != null) {
                    if (node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }

    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }

    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }

    }

    public static void main(String[] args) {
        SingledList<Integer> linkedList = new SingledList<Integer>();
        linkedList.addNode(1);

        System.out.print(linkedList.head.data);
        System.out.println();

        linkedList.addNode(2);
        System.out.print(linkedList.head.next.data);
        System.out.println();

        linkedList.addNode(3);
        linkedList.printAll();

        linkedList.addNodeInside(5, 1);
        linkedList.printAll();

        linkedList.addNodeInside(6, 3);
        linkedList.printAll();

        //없는 노드에 추가 하기때문에 맨 마지막 노드에 추가가 됨
        linkedList.addNodeInside(7, 20);
        linkedList.printAll();

        linkedList.delNode(3);
        linkedList.printAll();

        linkedList.delNode(1);
        linkedList.printAll();

        //맨 마지막 노드 삭제
        linkedList.delNode(5);
        linkedList.printAll();

        //없는 노드 삭제
        System.out.println(linkedList.delNode(20));
    }
}
