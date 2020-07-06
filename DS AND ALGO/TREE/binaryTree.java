import java.util.Stack;
import java.util.ArrayList;

class binaryTree {
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        public Node() {
        }

        public Node(int val) {
            this.data = val;
        }

        @Override
        public String toString() {
            String str = "";
            str += left != null ? left.data : " . ";
            str += "  <-  " + data + "  ->  ";
            str += right != null ? right.data : " . ";
            str += "\n";
            if (left != null)
                str += left.toString();
            if (right != null)
                str += right.toString();
            return str;
        }
    }

    public static class pair {
        Node node = null;
        int state = 0;

        public pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Node root = creation();
        basicFunc(root);
    }

    public static Node creation() {
        int[] arr = { 10, 20, 30, 40, -1, -1, 50, -1, -1, 160, -1, -1, 70, -6, 90, 100, -1, -1, -1, 110, 120, -1, -1,
                -1, 130, -1, -1 };
        // int[] arr = { 1, -1, 2, 3, 4, -1, -1, -1, -1 };

        // Node root = createBinatyTreeRec(arr);
        // System.out.println(root.toString()); // another method of display
        Node root = createBinatyTreeIt(arr);
        displayTree(root);
        return root;
    }

    static int idx = 0;

    public static Node createBinatyTreeRec(int[] arr) {
        if (idx >= arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        Node node = new Node(arr[idx]);
        idx++;
        node.left = createBinatyTreeRec(arr);
        node.right = createBinatyTreeRec(arr);
        return node;
    }

    public static Node createBinatyTreeIt(int[] arr) {
        Node root = null;
        Stack<pair> st = new Stack();
        root = new Node(arr[idx]);
        st.push(new pair(root, 0));
        idx++;
        while (st.size() != 0) {
            pair top = st.peek();
            if (top.state == 0) {
                if (arr[idx] != -1) {
                    top.node.left = new Node(arr[idx]);
                    st.push(new pair(top.node.left, 0));
                }
                top.state++;
                idx++;
            } else if (top.state == 1) {
                if (arr[idx] != -1) {
                    top.node.right = new Node(arr[idx]);
                    st.push(new pair(top.node.right, 0));
                }
                top.state++;
                idx++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    /****************** BASIC FUNCTIONS **************************/
    public static void basicFunc(Node root) {
        // System.out.println(minInTree(root));
        // System.out.println(maxInTree(root));
        // System.out.println(sizeOfTree(root));
        // System.out.println(heightOfTree(root));
        // System.out.println(findInTree(root, -6));

        // ROOT TO NODE PATH
        // ArrayList<Node> ans = rootToNodePath(root, 120);
        // for (Node node : ans) {
        // System.out.print(node.data + " ");
        // }
        // System.out.println(ans.size());

        // LEAST COMMON ANCESTOR
        // Node lca = LCA(root, -8, 120);
        // System.out.println(lca.data);

        // KDOWN AND KAWAY
        // kDown(root.right.left, 0);
        // kAway(root, root.right.left, 2);

        // DIAMETER all variations
        // System.out.println(diameter_01(root)); // O(n^2)
        // int[] ans = diameter_02(root); // O(n) and O(n)
        // System.out.println(ans[0] + " " + ans[1]);
        // System.out.println(diameter_03(root)); // O(n)
        // System.out.println(dia);

        // path types
        // System.out.println(leafToLeaf(root));
        // System.out.println(max_sum);
        // sumNumbers(root, 0);
        // System.out.println(ans);
        System.out.println(hasPathSum(root, 3000));
    }

    public static int minInTree(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int lmin = minInTree(root.left);
        int rmin = minInTree(root.right);
        return Math.min(Math.min(lmin, rmin), root.data);
    }

    public static int maxInTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int lmin = maxInTree(root.left);
        int rmin = maxInTree(root.right);
        return Math.max(Math.max(lmin, rmin), root.data);
    }

    public static int sizeOfTree(Node root) {
        if (root == null)
            return 0;
        int lsize = sizeOfTree(root.left);
        int rsize = sizeOfTree(root.right);
        return lsize + rsize + 1;
    }

    public static int heightOfTree(Node root) {
        if (root == null)
            return 0;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static boolean findInTree(Node root, int data) {
        if (root == null)
            return false;
        boolean res = false;
        res = res || findInTree(root.left, data) || findInTree(root.right, data) || root.data == data;
        return res;
    }

    public static ArrayList<Node> rootToNodePath(Node root, int data) {
        if (root == null)
            return new ArrayList();
        if (root.data == data) {
            ArrayList<Node> base = new ArrayList();
            base.add(root);
            return base;
        }
        ArrayList<Node> leftAns = rootToNodePath(root.left, data);
        if (leftAns.size() != 0) {
            leftAns.add(root);
            return leftAns;
        }
        ArrayList<Node> rightAns = rootToNodePath(root.right, data);
        if (rightAns.size() != 0) {
            rightAns.add(root);
            return rightAns;
        }
        return new ArrayList();

    }

    public static Node LCA(Node root, int val1, int val2) {
        ArrayList<Node> list1 = rootToNodePath(root, val1);
        ArrayList<Node> list2 = rootToNodePath(root, val2);
        if (list1.size() == 0 || list2.size() == 0)
            return new Node(0);
        int i = list1.size() - 1;
        int j = list2.size() - 1;
        Node ans = null;
        while (i >= 0 && j >= 0) {
            if (list1.get(i).data != list2.get(j).data)
                break;
            ans = list1.get(i);
            i--;
            j--;
        }
        return ans;
    }

    public static void kDown(Node root, int k) {
        if (k == 0 || root == null || k < 0) {
            if (k == 0 && root != null)
                System.out.println(root.data);
            return;
        }
        kDown(root.left, k - 1);
        kDown(root.right, k - 1);
    }

    public static void kDown_(Node root, Node prev, int k) {
        if (k == 0 || root == null || k < 0) {
            if (k == 0 && root != null)
                System.out.println(root.data);
            return;
        }
        if (root.left != prev)
            kDown_(root.left, prev, k - 1);
        if (root.right != prev)
            kDown_(root.right, prev, k - 1);
    }

    public static void kAway(Node root, Node curr, int k) {
        ArrayList<Node> path = rootToNodePath(root, curr.data);
        Node prev = null;
        for (int i = 0; i <= k; i++) {
            kDown_(path.get(i), prev, k - i);
            prev = path.get(i);
        }
    }

    public static int diameter_01(Node root) {
        if (root == null)
            return 0;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        int ld = diameter_01(root.left);
        int rd = diameter_01(root.right);
        if (root.left != null && root.right != null)
            return Math.max(Math.max(ld, rd), (lh + rh + 1));
        return Math.max(ld, rd);
    }

    public static int[] diameter_02(Node root) {
        if (root == null) {
            int[] base = new int[2];
            base[0] = -1; // in terms of edges
            base[1] = 0;
            return base;
        }
        int[] left = diameter_02(root.left);
        int[] right = diameter_02(root.right);
        int[] ans = new int[2];
        ans[0] = Math.max(left[0], right[0]) + 1;
        if (root.left != null && root.right != null)
            ans[1] = Math.max(Math.max(left[1], right[1]), left[0] + right[0] + 2); // +2 to get dia in terms of edges
        ans[1] = Math.max(left[1], right[1]);
        return ans;
    }

    static int dia = 0;

    public static int diameter_03(Node root) {
        if (root == null)
            return 0;

        int lh = diameter_03(root.left);
        int rh = diameter_03(root.right);
        if (root.left != null && root.right != null)
            dia = Math.max(lh + rh + 1, dia);
        return Math.max(lh, rh) + 1;
    }

    static int max_sum = 0;

    public static int leafToLeaf(Node root) {
        if (root == null)
            return 0;
        int lMax = leafToLeaf(root.left);
        int rMax = leafToLeaf(root.right);
        if (root.left != null && root.right != null)
            max_sum = Math.max(max_sum, lMax + rMax + root.data);
        return Math.max(lMax, rMax) + root.data;
    }

    static int ans = 0;

    public static void sumNumbers(Node root, int val) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            val = val * 10 + root.data;
            ans += val;
        }
        sumNumbers(root.left, val * 10 + root.data);
        sumNumbers(root.right, val * 10 + root.data);
    }

    public static  boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (sum - root.data == 0)
                return true;
            return false;
        }
        boolean res = false;
        res = res || hasPathSum(root.left, sum - root.data);
        res = res || hasPathSum(root.right, sum - root.data);
        return res;
    }

    /********************* DISPLAY FUNCTION ***********************/

    public static void displayTree(Node node) {
        if (node == null)
            return;
        System.out.print(node.left != null ? (node.left.data + "<-") : (". <-"));
        System.out.print(node.data);
        System.out.println(node.right != null ? ("->" + node.right.data) : ("-> ."));
        displayTree(node.left);
        displayTree(node.right);
    }
}