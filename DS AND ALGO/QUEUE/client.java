class client {
    public static void main(String[] args) {
        // queue();
        dynamicQueue();
    }

    public static void queue() {
        queue que = new queue();
        for (int i = 1; i < 11; i++) {
            que.add(i * 10);
        }
        que.display();
        // System.out.println(que.size());
    }

    public static void dynamicQueue() {
        dynamicqueue dq = new dynamicqueue();
        for (int i = 1; i < 12; i++)
            dq.add(i);
        dq.remove();
        dq.remove();
        dq.remove();
        dq.add(1);
        dq.display();
    }
}