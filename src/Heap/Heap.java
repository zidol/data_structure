package Heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap (Integer data) {
        heapArray = new ArrayList<Integer>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insert(Integer data) {
        Integer insertedIdx, parentIdx;
        if (heapArray == null) {
            heapArray = new ArrayList<Integer>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        //마지막 노드
        insertedIdx = this.heapArray.size() - 1;
        while (this.moveUp(insertedIdx)) {
            parentIdx = insertedIdx / 2;
            Collections.swap(this.heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
        return true;
    }

    public boolean moveUp(Integer insertedIdx) {
        //root node 인지 체크
        if (insertedIdx <= 1) {
            //더 이상 부모 노드 없음...
            return false;
        }
        Integer parentIdx = insertedIdx / 2;
        if (this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx)) {
            return true;
        } else {
            return false;
        }
    }

    public Integer pop() {
        //pop을 통해 가져올 값
        Integer returnedData, poppedIdx, leftChildPoppedIdx, rightChildPoppedIdx;

        if (this.heapArray == null) {
            return null;
        } else {
            returnedData = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            poppedIdx = 1;
            //순회 하여 트리의 구조를 힙에 맞춰 변경
            while (this.moveDown(poppedIdx)) {
                leftChildPoppedIdx = poppedIdx * 2;
                rightChildPoppedIdx = poppedIdx * 2 + 1;

                //Case2 : 오른족 자식 노드만 없을때
                if (rightChildPoppedIdx >= this.heapArray.size()) {
                    if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                        Collections.swap(heapArray, poppedIdx, leftChildPoppedIdx);
                        poppedIdx = leftChildPoppedIdx;
                    }
                    //Case3 : 왼쪽/오른쪽 자식 노드가 모두 있을 때
                } else {
                    //왼쪽이 큰경우
                    if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(rightChildPoppedIdx)) {
                        if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                            Collections.swap(heapArray, poppedIdx, leftChildPoppedIdx);
                            //체크할 인덱스 변경
                            poppedIdx = leftChildPoppedIdx;
                        }
                        //오른쪽이 큰 경우
                    } else {
                        if (this.heapArray.get(poppedIdx) < this.heapArray.get(rightChildPoppedIdx)) {
                            Collections.swap(heapArray, poppedIdx, rightChildPoppedIdx);
                            //체크할 인덱스 변경
                            poppedIdx = rightChildPoppedIdx;
                        }
                    }
                }

            }
            return returnedData;
        }
    }

    public boolean moveDown(Integer poppedIdx) {
        Integer leftChildPoppedIdx, rightChildPoppedIdx;

        leftChildPoppedIdx = poppedIdx * 2;
        rightChildPoppedIdx = poppedIdx * 2 + 1;

        //Case1 : 왼쪽 자식 노드도 없을때(오른쪽만 있을순 없기때문에 or 자식 노드가 하나도 없을때 : 완전 이진트리이기 때문)
        if (leftChildPoppedIdx >= this.heapArray.size()) {
            return false;
            //Case2 : 오른쪽 자식 노드만 없을 때
        } else if (rightChildPoppedIdx >= this.heapArray.size()) {
            if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                return true;
            } else {
                return false;
            }
            //Case3 : 왼쪽/오른쪽 자식 노드가 모두 있을 때
        } else {
            //왼쪽이 큰경우
            if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(rightChildPoppedIdx)) {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                    return true;
                } else {
                    return false;
                }
                //오른쪽이 큰 경우
            } else {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

    public static void main(String[] args) {
        Heap heap = new Heap(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20);

        System.out.println(heap.heapArray);

        System.out.println("heap.pop() = " + heap.pop());
        System.out.println(heap.heapArray);
    }
}
