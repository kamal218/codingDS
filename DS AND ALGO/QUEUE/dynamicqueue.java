class dynamicqueue extends queue {
    public dynamicqueue() {
        super();
    }

    public dynamicqueue(int cap) {
        super(cap);
    }

    public dynamicqueue(int[] input) {
        super(input);
    }

    @Override
    public void add(int val) {
        if (super.size == super.que.length) {
            int[] temp = que;
            que = new int[que.length * 2];
            for (int i = 0; i < super.size(); i++) {
                que[i] = temp[(i + tail) % temp.length];
            }
        }
        super.add(val);
    }
}