class stack {
    int[] arr;
    int top = -1;

    public stack() {
        this.arr = new int[10];
    }

    public stack(int cap) {
        this.arr = new int[cap];
    }

    public stack(int[] input) {
        this.arr = new int[2 * input.length];
        for (int i = 0; i < input.length; i++) {
            this.arr[i] = input[i];
        }
        this.top = input.length - 1;
    }

    public void push(int val) {
        if (top + 1 == arr.length) {
            System.out.println("Stack Overflow at : " + top);
            return;
        }
        arr[++top] = val;
    }

    public void pop() {
        if (top == 0) {
            System.out.println("Stack is empty ");
            return;
        }
        top--;
    }

    public int peek() {
        if (top == -1) {
            System.out.print("Stack is empty ");
            return -1;
        }

        return arr[top];
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(this.arr[i] + " ");
        }
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public  int capacity() {
        return arr.length;
    }
}