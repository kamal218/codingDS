import java.util.Stack;

class QueueUsingStack {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int top = -1;

    public QueueUsingStack() {
        st1 = new Stack();
        st2 = new Stack();
    }

    public void add(int val) {
        if (st1.size() == 0)
            top = val;
        while (st1.size() != 0)
            st2.push(st1.pop());
        st2.push(val);
        while (st2.size() != 0)
            st1.push(st2.pop());
    }

    public void remove() {
        st1.pop();
        
        if (st1.size() != 0)
            top = st1.peek();
    }

    public int peek() {
        return top;
    }

    public boolean isEmpty() {
        return st1.size() == 0;
    }

    public void display() {
        while (st1.size() != 0) {
            System.out.print(st1.peek() + " ");
            st2.push(st1.pop());
        }
        while (st2.size() != 0) {

            st1.add(st2.pop());
        }
    }
}