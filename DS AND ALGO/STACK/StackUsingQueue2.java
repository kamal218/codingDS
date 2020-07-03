import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue2 {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top = -1;

    public StackUsingQueue2() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    public void push(int val) {
        top = val;
        while (q2.size() != 0) {
            q1.add(q2.remove());
        }
        q2.add(val);
        while (q1.size() != 0) {
            q2.add(q1.remove());
        }
    }

    public void pop() {
        q2.remove();
        top = q2.peek();
    }

    public int peek() {
        return q2.peek();
    }

    public boolean isEmpty() {
        return q2.size() == 0;
    }

    public void display() {
        while (q2.size() != 0) {
            System.out.print(q2.peek() + " ");
            q1.add(q2.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}