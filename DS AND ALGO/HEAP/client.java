public class client {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        heap myHeap = new heap(arr);
        // System.out.println(myHeap.get());
        myHeap.push(100);
        myHeap.pop();
        myHeap.displayHeap();
        myHeap.sort();
    }
}