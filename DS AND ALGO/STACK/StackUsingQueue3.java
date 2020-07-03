import java.util.*;

class StackUsingQueue3 {
    Queue<Integer> q;
    int top = -1;

    public StackUsingQueue3() {
        q = new LinkedList();
    }

    public void push(int val) {
        q.add(val);
        top = val;
    }

    public void pop() {
        int size = q.size();
        while (size-- > 1) {
            top = q.peek();
            q.add(q.remove());
        }
        q.remove();
    }

    public int peek() {
        return top;
    }

    public boolean isEmpty() {
        return q.size() == 0;
    }

    public void display() {
        int size = q.size();
        while (size-- > 0) {
            System.out.print(q.peek() + " ");
            q.add(q.remove());
        }
    }
}