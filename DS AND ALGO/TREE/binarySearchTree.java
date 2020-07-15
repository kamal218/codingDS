class binarySearchTree {
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            String str = "";
            System.out.print(left == null ? "--" : left.data);
            System.out.print("<- " + data + " ->");
            System.out.print(right == null ? "--" : right.data);
            return str;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        Node root = createBalancedBST(arr, 0, arr.length - 1);
        display(root);
        basicFunc(root);
    }

    public static Node createBalancedBST(int[] arr, int si, int ei) {
        if (si > ei)
            return null;
        int mid = (si + ei) / 2;
        Node node = new Node(arr[mid]);
        node.left = createBalancedBST(arr, si, mid - 1);
        node.right = createBalancedBST(arr, mid + 1, ei);
        return node;
    }

    public static void display(Node root) {
        if (root == null)
            return;
        System.out.println(root);
        display(root.left);
        display(root.right);
    }

    public static void basicFunc(Node root) {
        // System.out.println("\n\n");
        // System.out.println("min: " + minInBST(root));
        // System.out.println("max: " + maxInBST(root));
        // System.out.println(search(root, 36));
        // System.out.println(search_01(root, 30));
        // increasingBST(root);
        // display(head);
        // trimBST(root, 30, 60);
         root=convertBST(root);
         display(root);
    }

    public static Node minInBST(Node root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return minInBST(root.left);
    }

    public static Node maxInBST(Node root) {
        if (root == null)
            return null;
        if (root.right == null)
            return root;
        return maxInBST(root.right);
    }

    public static boolean search(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        else if (data < root.data)
            return search(root.left, data);
        else
            return search(root.right, data);
    }

    public static boolean search_01(Node root, int data) {
        while (root != null) {
            if (root.data == data)
                return true;
            else if (root.data < data)
                root = root.right;
            else
                root = root.left;
        }
        return false;
    }

    static Node ans = new Node(1);
    static Node head = ans;

    public static Node increasingBST(Node root) {
        if (root == null)
            return null;
        increasingBST(root.left);
        ans.right = new Node(root.data);
        ans.right = new Node(root.data);
        ans = ans.right;
        increasingBST(root.right);
        return ans;
    }

    public static Node trimBST(Node root, int L, int R) {
        if (root == null)
            return root;
        if (root.data > R)
            return trimBST(root.left, L, R);
        if (root.data < L)
            return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    static int sum = 0;

    public static Node convertBST(Node root) {
        if (root == null)
            return null;
        root.right = convertBST(root.right);
        sum = root.data + sum;
        root.data = sum;
        root.left = convertBST(root.left);
        return root;
    }
}