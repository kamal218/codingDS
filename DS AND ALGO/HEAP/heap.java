import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.*;

public class heap {
    ArrayList<Integer> arr;
    boolean isMax = true;

    public heap() {
        this.arr = new ArrayList();
    }

    public heap(int[] arr) {
        this.arr = new ArrayList();
        createHeap(arr); // O(n) using down heapiy
        // createHeap_(arr); // O(nlog(n)) using upheapify
    }

    public heap(int[] arr, boolean isMax) {
        this.isMax = isMax;
        this.arr = new ArrayList();
        createHeap(arr);
    }

    public void createHeap(int[] ar) {
        for (int ele : ar)
            arr.add(ele);
        for (int i = arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public void createHeap_(int[] ar) {
        for (int ele : ar) {
            arr.add(ele);
            upHeapify(arr.size() - 1);
        }
    }

    public void downHeapify(int idx) {
        int vidx = idx;
        int lci = (idx * 2) + 1;
        int rci = (idx * 2) + 2;
        // using both the below calls we will get the best place for idx that is if both
        // children are greater the parent
        if (lci < arr.size() && compareTo(lci, vidx) > 0) {
            vidx = lci;
        }
        if (rci < arr.size() && compareTo(rci, vidx) > 0) {
            vidx = rci;
        }
        if (vidx != idx) { // if idx is greater then function will not be called
            swap(idx, vidx);
            downHeapify(vidx);
        }
    }

    public void upHeapify(int idx) {
        int pi = (idx - 1) / 2;
        if (pi >= 0 && compareTo(idx, pi) > 0) {
            swap(pi, idx);
            upHeapify(pi);
        }
    }

    public void push(int val) {
        arr.add(val);
        upHeapify(arr.size() - 1);
    }

    public void pop() {
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        downHeapify(0);
    }

    public int get() {
        if (arr.size() == 0) {
            return -1;
        }
        return arr.get(0);
    }

    public void update(int idx, int val) {
        arr.set(idx, val);
        // value which we enter may transer upward or downward according to its value
        upHeapify(idx);
        downHeapify(idx);
    }

    public void swap(int i, int j) {
        int val1 = arr.get(i);
        int val2 = arr.get(j);
        arr.set(i, val2);
        arr.set(j, val1);
    }

    public int compareTo(int ci, int pi) {
        if (isMax) {
            return arr.get(ci) - arr.get(pi);
        } else {
            return arr.get(pi) - arr.get(ci);
        }
    }

    public void displayHeap() {
        int i = 0;
        int count = 1;
        while (i < arr.size()) {
            for (int j = 1; j <= count; j++) {
                if (i + j - 1 < arr.size())
                    System.out.print(arr.get(i + j - 1) + "\t");
            }
            System.out.println();
            i += count;
            count *= 2;
        }
    }

    /*************** HEAP SORT *********************/
    public void sort() {
        System.out.println();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(0) + " ");
            swap(0, arr.size() - i - 1);
            downHeapify_sort(0, arr.size() - i - 2);
        }
    }

    public void downHeapify_sort(int idx, int lidx) {
        int vidx = idx;
        int lci = (idx * 2) + 1;
        int rci = (idx * 2) + 2;
        // using both the below calls we will get the best place for idx that is if both
        // children are greater the parent
        if (lci <= lidx && compareTo(lci, vidx) > 0) {
            vidx = lci;
        }
        if (rci <= lidx && compareTo(rci, vidx) > 0) {
            vidx = rci;
        }
        if (vidx != idx) { // if idx is greater then function will not be called
            swap(idx, vidx);
            downHeapify_sort(vidx, lidx);
        }
    }
}