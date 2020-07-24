import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.util.Pair;

public class pqquestions {

  public static void main(String[] args) {
    Queue<Integer> pq = new PriorityQueue();
    //Leetcode 1046
    // int[] stones = { 2, 7, 4, 1, 8, 1 };
    // System.out.println(lastStoneWeight(stones));

    // LEETCODE
    // int[] arr = { 3, 2, 1, 5, 6, 4 };
    // System.out.print(findKthLargest(arr, 3));

    // LEETCODE 378
    // int[][] mat = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
    // System.out.println(kthSmallestFromOrigin(mat, 3));

    // LEETCODE
    int[] nums = { 1, 1, 1, 2, 2, 3 };
    display1DArray(topKFrequent(nums, 2));
  }

  public static int lastStoneWeight(int[] stones) {
    // Method 1 creating a max heap using collections class
    // PriorityQueue<Integer> pq = new PriorityQueue(
    //   stones.length,
    //   Collections.reverseOrder()
    // );

    // Method 2 using lambda function
    // Comparator<Integer> comp=(x,y)->{
    //     return (y-x);
    // };
    // PriorityQueue<Integer> pq=new PriorityQueue(comp);

    // Method 3 using anonymous function
    Comparator<Integer> comp = new Comparator<Integer>() {

      @Override
      public int compare(Integer a, Integer b) {
        return b - a;
      }
    };
    PriorityQueue<Integer> pq = new PriorityQueue(comp);

    for (int ele : stones) pq.add(ele);

    while (pq.size() > 1) {
      int first = pq.poll();
      int second = pq.poll();

      if (first != second) {
        pq.add(first - second);
      }
    }
    if (pq.size() == 1) return pq.peek();
    return 0;
  }

  public static int findKthLargest(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue(); // min pq
    for (int ele : arr) pq.add(ele);
    while (pq.size() > k) {
      pq.poll();
    }
    return pq.peek();
  }

  //LEETCODE 703 kth largest in a stream
  //   PriorityQueue<Integer> pq = new PriorityQueue();
  //   int k = 0;

  //   public KthLargest(int k, int[] arr) {
  //     this.k = k;
  //     for (int ele : arr) pq.add(ele);
  //   }

  //   public int add(int val) {
  //     pq.add(val);
  //     while (pq.size() > k) {
  //       pq.poll();
  //     }
  //     return pq.peek();
  //   }
  public static class triple {
    int ele = 0;
    int i = 0;
    int j = 0;

    public triple(int ele, int i, int j) {
      this.ele = ele;
      this.i = i;
      this.j = j;
    }
  }

  public static int kthSmallestFromOrigin(int[][] mat, int k) {
    Comparator<triple> comp = (a, b) -> {
      return a.ele - b.ele;
    };
    PriorityQueue<triple> pq = new PriorityQueue(comp);
    for (int i = 0; i < mat.length; i++) {
      pq.add(new triple(mat[i][0], i, 0));
    }

    while (k-- > 1) {
      triple top = pq.poll();
      if (top.j + 1 < mat[0].length) pq.add(
        new triple(mat[top.i][top.j + 1], top.i, top.j + 1)
      );
    }
    return pq.peek().ele;
  }

  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap();
    for (int ele : nums) {
      map.put(ele, map.getOrDefault(ele, 0) + 1);
    }
    int[] ans = new int[k];
    Comparator<Pair<Integer, Integer>> comp = (a, b) -> {
      int v = b.getValue() - a.getValue();
      if (v > 0) return 1;
      return -1;
    };
    PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue(comp);
    //  pair of element,frequency
    for (Integer key : map.keySet()) {
      pq.add(new Pair(key, map.get(key)));
    }
    int i = 0;
    while (k-- > 0) {
      Pair<Integer, Integer> top = pq.poll();
      ans[i] = top.getKey();
      i++;
    }
    return ans;
  }

  public static void display1DArray(int[] arr) {
    for (int ele : arr) {
      System.out.print(ele + " ");
    }
    System.out.println();
  }
}
