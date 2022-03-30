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

    public static void main(String[] args) {
        Heap heap = new Heap(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20);

        System.out.println(heap.heapArray);
    }
}
