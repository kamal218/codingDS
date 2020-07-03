import java.util.Stack;

class QueueUsingStack2 {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int top = -1;

    public QueueUsingStack2() {
        st1 = new Stack();
        st2 = new Stack();
    }

    public void add(int val) {
        if (st1.size() == 0 && st2.size() == 0) {       //leetcode has wrong answer
            top = val;
        }
        st1.push(val);
    }

    public void remove() {
        if (st2.size() == 0) {
            while (st1.size() != 0) {
                st2.push(st1.pop());
            }
        }
        st2.pop();
        if (st2.size() != 0)
            top = st2.peek();
    }

    public int peek() {
        return top;
    }

    public boolean isEmpty() {
        return (st1.size() == 0 && st2.size() == 0);
    }

}