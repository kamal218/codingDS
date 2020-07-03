class question {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        queueUsingStack();
    }

    public static void queueUsingStack() {
        // Queue using 2 stacks push(O(n)) pop(O(1))
        // QueueUsingStack que = new QueueUsingStack();
        // que.add(1);
        // que.add(2);
        // que.add(3);
        // que.remove();
        // que.remove();
        // que.add(4);
        // que.add(5);
        // que.display();

        // Queue using 2 stacks push(O(1)) pop(O(1))
        QueueUsingStack2 que = new QueueUsingStack2();
        que.add(1);
        que.add(2);
        que.add(3);
        que.remove();
        que.remove();
        que.add(4);
        que.add(5);
        System.out.println(que.peek());
    }
}