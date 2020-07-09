import java.util.*;

public class genericTree {
    public static class Node {
        int data = 0;
        ArrayList<Node> childrens = new ArrayList();

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, 50, 80, -1, -6, -1, -1, -1, 60, 70, -1, -1, 100, -1, -1 };
        // Node root = createGenericTreeRec(arr);
        Node root = createGenericTreeIt(arr);
        displayGenericTree(root);
        basicFunc(root);
    }

    static int idx = 0;

    public static Node createGenericTreeRec(int[] arr) {
        if (idx == arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        Node node = new Node(arr[idx]);
        idx++;
        while (idx < arr.length && arr[idx] != -1) {
            node.childrens.add(createGenericTreeRec(arr));
        }
        idx++;
        return node;
    }

    public static Node createGenericTreeIt(int[] arr) {
        Stack<Node> st = new Stack();
        int i = 0;
        Node root = new Node(arr[i]);
        st.push(root);
        i++;
        while (st.size() != 0) {
            if (arr[i] != -1) {
                Node top = st.peek();
                Node nnode = new Node(arr[i]);
                top.childrens.add(nnode);
                st.push(nnode);
            } else {
                st.pop();
            }
            i++;
        }
        return root;
    }

    public static void displayGenericTree(Node root) {
        System.out.println(root.data);
        for (Node child : root.childrens) {
            displayGenericTree(child);
        }
    }

    public static void basicFunc(Node root) {
        System.out.println(minInTree(root));
        System.out.println(maxInTree(root));
        System.out.println(sizeOfTree(root));
        System.out.println(heightOfTree(root));
        System.out.println(findInTree(root, 30));
    }

    public static int minInTree(Node root) {
        int ans = root.data;
        for (Node child : root.childrens) {
            ans = Math.min(ans, minInTree(child));
        }
        return ans;
    }

    public static int maxInTree(Node root) {
        int ans = root.data;
        for (Node child : root.childrens) {
            ans = Math.max(ans, maxInTree(child));
        }
        return ans;
    }

    public static int sizeOfTree(Node root) {
        int ans = 0;
        for (Node child : root.childrens) {
            ans += sizeOfTree(child);
        }
        return ans + 1;
    }

    public static int heightOfTree(Node root) {
        int height = 0;
        for (Node child : root.childrens) {
            height = Math.max(height, heightOfTree(child));
        }
        return height + 1;
    }

    public static boolean findInTree(Node root, int data) {
        boolean res = false;
        if (root.data == data)
            return true;
        for (Node child : root.childrens) {
            res = res || (findInTree(child, data));
        }
        return res;
    }
}