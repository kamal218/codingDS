import java.util.Stack;

class client {
    public static void main(String[] args) {
        // statStack();
        dynamStack();
    }

    public static void statStack() {
        stack st = new stack();
        // System.out.println(st.peek());
        System.out.println(st.isEmpty());
        for (int i = 1; i < 10; i++)
            st.push(i * 10);
        System.out.println(st.isEmpty());
        // System.out.println(st.peek());
        st.display();
    }

    public static void dynamStack() {
        dynamicstack st = new dynamicstack();
        for (int i = 1; i <= 19; i++)
            st.push(i * 10);
        System.out.println(st.capacity());
        st.display();
    }
}