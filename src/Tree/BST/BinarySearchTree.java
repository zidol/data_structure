package Tree.BST;

public class BinarySearchTree {

    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    //데이터 입력 메소드
    public boolean insertNode(int data) {
        //Case1 : Node가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            //Case2: Node 가 하나 이상 들어가 있을때
            Node findNode = this.head;
            while (true) {
                //Case2-1 : 현재 Node의 왼쪽에 Nodee가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;// 데이터 생성후 while 종료
                    }
                } else {//Case2-2 : 현재 Node의 오른쪽에 Nodee가 들어가야 할 때
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;// 데이터 생성후 while 종료
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertNode(2);
        tree.insertNode(3);
        tree.insertNode(4);
        tree.insertNode(6);
    }
}
