package Tree.BST;

public class BinarySearchTree {

    Node head = null;

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

    public Node search(int data) {
        //Case1 : Node가 하나도 없을 때
        if (this.head == null) {
            return null;
        } else {//Case2 : Node가 하나 이상 있을 때
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            //모두 탐색 후 존재 하지 않을경우
            return null;

        }


    }

    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        //예외 케이스1 : Node가 하나도 없을때
        if (this.head == null) {
            return false;
        } else {
            //예외 케이스2 : Node가 하나만 있고, 해당하는 Node가 삭제할 Node 일때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }
            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            //삭제 할 값이 없을 경우
            if (searched == false) {
                return false;
            }
        }
        /**
         * 현재 라인까지 온것은,
         * currNode에는 해당 데이터를 가지고 있는 Node,
         * currParentNode에는 해당 데이터를 가지고 있는 Node의 부모 Node임
         */
        //케이스 1 : 삭제 할 Node가 leaf인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < currParentNode.value) {//부모 노드 보다 작을 경우 좌측 노드 삭제
                currParentNode.left = null;
                currNode = null;
            } else {//부모 노드 보다 작을 경우 우측 노드 삭제
                currParentNode.right = null;
                currNode = null;
            }
            return true;
            //케이스 2.1 : 삭제할 Node가 Child Node를 한 개 가지고 있을 경우(좌측)
        } else if (currNode.left != null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;
            } else {    //삭제 할 노드가 부모 노드의 오른쪽인 경우
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
            //케이스 2.2 : 삭제할 Node가 Child Node를 한 개 가지고 있을 경우(우측)
        } else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return  true;
            // 케이스3.1 : 삭제할 Node가 Child Node를 두 개 가지고 있을 경우 (삭제할 Node가 Parent Node 좌측 있을 때)
        } else {
            // 삭제할 Node가 부모 Node의 왼쪽에 있을때
            if (value < currParentNode.value) {

                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                //루프가 끝나면 changeNode에는 삭제할 Node의 오른쪽 Node중에서,
                //가장 작은 값을 지닌 Node가 들어 있음

                if (changeNode.right != null) {
                    //케이스 3.1.2 : changeNode의 오른쪽 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    //케이스 3.1.1 : changeNode의 Child Node가 없을 때
                    changeParentNode.left = null;
                }
                //currParentNode의 왼쪽 ChildNode에 삭제 할 Node의 오른쪽 자식중,
                // 가장 작은 값을 가진 changeNode를 연결
                currParentNode.left = changeNode;

                //parentNode의 왼쪽 ChildNode가 현재, changeNode이고,
                // changeNode의 왼쪽 or 오른쪽 ChildNode를 모두, 삭제 할 currNode의 기존 왼쪽 or 오른쪽 Node로 변경
                changeNode.right = currNode.right;
                changeNode.left  = currNode.left;
                currNode = null;
                // Case3-2: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 오른쪽에 있을 때)
            } else {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                if (changeNode.right != null) {
                    //케이스 3.1.2 : changeNode의 오른쪽 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    //케이스 3.1.1 : changeNode의 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                //currParentNode의 오른쪽 ChildNode에 삭제 할 Node의 오른쪽 자식중,
                // 가장 작은 값을 가진 changeNode를 연결
                currParentNode.right = changeNode;

                //parentNode의 왼쪽 ChildNode가 현재, changeNode이고,
                // changeNode의 왼쪽 or 오른쪽 ChildNode를 모두, 삭제 할 currNode의 기존 왼쪽 or 오른쪽 Node로 변경
                changeNode.right = currNode.right;
                changeNode.left  = currNode.left;
                currNode = null;
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        BinarySearchTree tree = new BinarySearchTree();
//        tree.insertNode(2);
//        tree.insertNode(3);
//        tree.insertNode(4);
//        tree.insertNode(6);
//
//        Node testNode = tree.search(3);
//
//        System.out.println(testNode.right.value);

        // Case3.1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertNode(10);
        tree.insertNode(15);
        tree.insertNode(13);
        tree.insertNode(11);
        tree.insertNode(14);
        tree.insertNode(18);
        tree.insertNode(16);
        tree.insertNode(19);
        tree.insertNode(17);
        tree.insertNode(7);
        tree.insertNode(8);
        tree.insertNode(6);
        System.out.println(tree.delete(15));
        System.out.println("HEAD: " + tree.head.value);
        System.out.println("HEAD LEFT: " + tree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + tree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + tree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + tree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + tree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + tree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + tree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + tree.head.right.right.right.value);
    }
}
