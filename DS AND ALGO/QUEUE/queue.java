class queue {
    int[] que;
    int tail = 0;
    int head = -1;
    int size = 0;

    public queue() {
        this.que = new int[10];
    }

    public queue(int cap) {
        this.que = new int[cap];
    }

    public queue(int[] arr) {
        this.que = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
            this.que[i] = arr[i];
    }

    public void add(int val) {
        if (this.size == this.que.length) {
            System.out.println("queue overflow");
            return;
        }
        head = (head + 1) % que.length;
        que[head] = val;
        size++;
    }

    public void remove() {
        if (this.size == 0) {
            System.out.println("queue is empty");
            return;
        }
        tail = (tail + 1) % que.length;
        size--;
    }

    public int peek() {
        if (this.size == 0) {
            System.out.println("queue is empty");
            return -1;
        }
        return que[head];
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print((que[(tail+i)%que.length])+" ");
        }
    }

    public int size() {
        return size;
    }
}