class AVL {
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;
        int height = 0;
        int balFac = 0;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        for (int i = 1; i <= 7; i++) {
            root = addNode(root, i * 10);
        }
        display(root);
    }

    public static void update(Node root) {
        int lh = -1;
        int rh = -1;
        if (root.left != null) {
            lh = root.left.height;
        }
        if (root.right != null) {
            rh = root.right.height;
        }
        root.height = Math.max(lh, rh) + 1;
        root.balFac = lh - rh;
    }

    public static Node llRotation(Node A) {
        Node B = A.left;
        Node bRight = B.right;
        B.right = A;
        A.left = bRight;
        update(A);
        update(B);
        return B;
    }

    public static Node rrRotation(Node A) {
        Node B = A.right;
        Node bLeft = B.left;
        B.left = A;
        A.right = bLeft;
        update(A);
        update(B);
        return B;
    }

    public static Node rotation(Node root) {
        update(root);
        if (root.balFac == 2) {
            if (root.left.balFac == 1) { // ll
                return llRotation(root);
            } else { // lr
                root.left = rrRotation(root.left);
                return llRotation(root);
            }
        } else if (root.balFac == -2) {
            if (root.right.balFac == -1) { // rr
                return rrRotation(root);
            } else { // rl
                root.right = llRotation(root.right);
                return rrRotation(root);
            }
        }
        return root;
    }

    public static Node addNode(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (root.data < data) {
            root.right = addNode(root.right, data);
        } else {
            root.left = addNode(root.left, data);
        }
        root = rotation(root);
        return root;
    }

    public static Node removeNode(Node root, int data) {
        if (root == null)
            return null;
        if (root.data == data) {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null) {
                return root.right;
            } else {
                int max_ = maxInTree(root.left).data;
                root.data = max_;
                removeNode(root.left, max_);
                return root;
            }
        } else if (root.data < data) {
            root.right = removeNode(root.right, data);
        } else {
            root.left = removeNode(root.left, data);
        }
        rotation(root);
        return root;
    }

    public static Node maxInTree(Node root) {
        if (root == null)
            return null;
        if (root.right == null)
            return root;
        return maxInTree(root.right);
    }

    public static void display(Node node) {
        if (node == null)
            return;
        String ans = "";

        ans += node.left != null ? node.left.data : ".";
        ans += " -> " + node.data + "(" + node.balFac + ")" + " <- ";
        ans += node.right != null ? node.right.data : ".";
        System.out.println(ans);

        display(node.left);
        display(node.right);
    }
}
