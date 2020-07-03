import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top = -1;

    public StackUsingQueue() {
        this.q1 = new LinkedList();
        this.q2 = new LinkedList();

    }

    public void push(int val) {
        q1.add(val);
        top = val;
    }

    public void pop() {
        while (q1.size() != 1) {
            top = q1.peek();
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int peek() {
        return top;
    }

    public boolean isEmpty() {
        return q1.size() == 0;
    }

    public void display() {
        while (q1.size() != 0) {
            System.out.print(q1.peek() + " ");
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}