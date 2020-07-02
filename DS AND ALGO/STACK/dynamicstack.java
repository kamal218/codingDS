import java.util.Stack;

class dynamicstack extends stack {
    public dynamicstack() {
        super();
    }

    public dynamicstack(int cap) {
        super(cap);
    }

    public dynamicstack(int[] input) {
        super(input);
    }

    @Override
    public void push(int val) {
        if (super.top + 1 == arr.length) {
            int[] temp = super.arr;
            super.arr = new int[arr.length * 2];
            for (int i = 0; i < temp.length; i++)
                super.arr[i] = temp[i];
        }
        super.push(val);
    }
}