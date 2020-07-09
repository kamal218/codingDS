import java.util.Stack;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

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
        int[] arr = { 10, 20, 30, 40, -1, -1, 50, -1, -1, 160, -1, -1, 70, -6, 90, 100, -1, -1, -1, 110, 120, -1, -1,
                -1, 130, -1, -1 };
        // int[] arr = { 1, -1, 2, 3, 4, -1, -1, -1, -1 };
        // int[] arr = { 40, -8, -1, -1, -2, -1, -1 };
        // int[] arr = { 1, 2, -1, 4, -1, -1, 3, -1, -1 };
        // int[] shape = { 1, 2, -1, 4, -1, -1, 3, -1, -1 };
        // int[] mirror = { 1, 3, -1, -1, 2, 4, -1, -1, -1 };
        // int[] symm = { 1, 2, -1, 4, -1, -1, 3, 6, -1, -1, -1 };
        // int[] vSymm = { 1, 2, -1, 4, -1, -1, 2, 4, -1, -1, -1 };
        Node root = creation(arr);
        // idx = 0;
        // Node root1 = creation(shape);
        // Node root1 = creation(mirror);
        // Node root1 = creation(symm);
        // Node root1 = creation(vSymm);
        basicFunc(root, null);
    }

    public static Node creation(int[] arr) {

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
        Node node = new Node(arr[idx]);]         
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
    public static void basicFunc(Node root, Node root1) {
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
        // System.out.println(hasPathSum(root, 3000));
        // minHeight(root, 0);
        // System.out.println(min_);
        // averageOfLevels(root);
        // System.out.println(isCousin(root, 160, -6));

        // ALL SOLUTIONS IN 1 FUNCTION
        // allSol values = new allSol();
        // allSolution(root, 100, 1, values); // level=1 for (height in terms of node)
        // else (0 for edge)
        // System.out.println();
        // System.out.println("min:" + values.min);
        // System.out.println("max:" + values.max);
        // System.out.println("height:" + values.height);
        // System.out.println("size:" + values.size);
        // System.out.println("ceil:" + values.ceil);
        // System.out.println("floor:" + values.floor);
        // System.out.println("pred:" + values.pred.data);
        // System.out.println("succ:" + values.succ.data);
        // System.out.println(kThLargest(root, 3));

        // TRAVERSALS IN BINARY TREE
        // preInPostTraversal(root);
        // levelOrderTraversel(root);
        // levelOrderTraverselNewLine(root);
        // levelOrderTraverselNewLine02(root);
        // levelOrderTraverselZigZag(root);
        // zigzagLevelOrder(root);
        // preInPostIterative(root);
        // Floor(root, Integer.MIN_VALUE);
        // System.out.println(floor);

        // mirror-symm types
        // System.out.println(!isShapeSame(root, root1));
        // System.out.println(!isMirrorShape(root, root1));
        // System.out.println(!isSymmetric(root1, root1));
        // System.out.println(!isSymmetricWithValues(root1, root1));
        // Node rroot = mirrorGivenTree(root);
        // System.out.println(rroot);
        // System.out.println("\n\n");
        // displayTree(rroot);

        // MISC TYPES
        // removeLeaves(root);
        // System.out.println("\n\n");
        // displayTree(root);
        // System.out.println(tree2str(root));
        // isTreeBalanced(root);
        // System.out.println(res);
        // Node resRoot = linearizeTree(root);
        // System.out.println("\n\n");
        // singleChildNode(root);
        // ans = 0;
        // System.out.println(findTilt(root));
        int val = root.data;
        System.out.println(isUnivalTree(root, val));

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

    public static boolean hasPathSum(Node root, int sum) {
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

    static int min_ = Integer.MAX_VALUE;

    public static void minHeight(Node root, int ht) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            min_ = Math.min(min_, ht);
        minHeight(root.left, ht + 1);
        minHeight(root.right, ht + 1);
    }

    public static List<Double> averageOfLevels(Node root) {
        Queue<Node> que = new LinkedList();
        List<Double> ans = new ArrayList();
        que.add(root);
        while (que.size() != 0) {
            int size = que.size();
            int s = size;
            double mid = 0;
            while (size-- > 0) {
                Node top = que.remove();
                mid += top.data;
                if (top.left != null)
                    que.add(top.left);
                if (top.right != null)
                    que.add(top.right);
            }
            ans.add(mid / s);
        }
        return ans;
    }

    public static boolean isCousin(Node node, int x, int y) {
        int l1 = 0;
        int l2 = 0;
        Queue<Node> que = new LinkedList();
        que.add(node);
        int level = 1;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Node top = que.remove();

                if (top.data == x)
                    l1 = level;
                if (top.data == y)
                    l2 = level;
                if (top.left != null && top.right != null && ((top.left.data == x && top.right.data == y)
                        || (top.left.data == y && top.right.data == x))) {
                    return false;
                }
                if (top.left != null)
                    que.add(top.left);
                if (top.right != null)
                    que.add(top.right);
            }
            level++;
            if (l1 != 0 || l2 != 0)
                return l1 == l2;
        }
        return true;
    }

    public static class allSol {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int height = 0;
        boolean find = false;
        int size = 0;
        int ceil = Integer.MIN_VALUE;
        int floor = Integer.MAX_VALUE;
        Node pred = null;
        Node succ = null;
        Node prev = null;
    }

    public static void allSolution(Node root, int data, int level, allSol values) {
        if (root == null)
            return;
        values.size++;

        values.height = Math.max(values.height, level);

        values.min = Math.min(values.min, root.data);

        values.max = Math.max(values.max, root.data);

        values.find = values.find || root.data == data;

        if (root.data > data && root.data < values.ceil)
            values.ceil = root.data;

        if (root.data < data && root.data > values.floor)
            values.floor = root.data;

        if (root.data == data && values.pred == null) {
            values.pred = values.prev;
        }

        if (values.prev != null && values.succ == null && values.prev.data == data) {
            values.succ = root;
        }

        values.prev = root;
        allSolution(root.left, data, level + 1, values);
        allSolution(root.right, data, level + 1, values);
    }

    /**********************
     * TRAVERSALS IN A BINARY TREE
     ********************************/
    public static void preInPostTraversal(Node root) {
        if (root == null)
            return;
        // pre area
        System.out.println("pre:" + root.data);
        if (root.left != null)
            System.out.println("pre edge:" + root.data + "->" + root.left.data);

        preInPostTraversal(root.left);

        // in area
        System.out.println("in:" + root.data);

        preInPostTraversal(root.right);

        // post area
        if (root.right != null)
            System.out.println("post edge:" + root.right.data + "->" + root.data);

        System.out.println("post:" + root.data);

    }

    public static void levelOrderTraversel(Node root) {
        Queue<Node> st = new LinkedList();
        st.add(root);
        // remove print push
        while (st.size() != 0) {
            Node top = st.remove();
            System.out.println(top.data + "\t");
            if (top.left != null)
                st.add(top.left);
            if (top.right != null)
                st.add(top.right);
        }
    }

    public static void levelOrderTraverselNewLine(Node root) {
        Queue<Node> que = new LinkedList();
        que.add(root);
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Node top = que.remove();
                System.out.print(top.data + "\t");
                if (top.left != null)
                    que.add(top.left);
                if (top.right != null)
                    que.add(top.right);
            }
            System.out.println();
        }
    }

    public static void levelOrderTraverselNewLine02(Node root) {
        Queue<Node> que = new LinkedList();
        que.add(root);
        que.add(new Node(-1));
        while (que.size() != 1) {
            Node top = que.remove();
            if (top.data == -1) {
                System.out.println();
                que.add(new Node(-1));
            } else {
                System.out.print(top.data + "\t");
                if (top.left != null)
                    que.add(top.left);
                if (top.right != null)
                    que.add(top.right);
            }
        }
    }

    public static void levelOrderTraverselZigZag(Node root) {
        // we need a stack because we have to push the elements from the end of popped
        // element
        Stack<Node> que = new Stack();
        Stack<Node> help = new Stack();
        que.push(root);
        boolean right = true;
        while (que.size() != 0) {
            Node top = que.pop();
            System.out.println(top.data);
            if (right) {
                if (top.left != null)
                    help.push(top.left);
                if (top.right != null)
                    help.push(top.right);

            } else {
                if (top.right != null)
                    help.push(top.right);
                if (top.left != null)
                    help.push(top.left);

            }
            if (que.size() == 0) {
                Stack<Node> temp = que;
                que = help;
                help = temp;
                right = right == true ? false : true;
            }
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        if (root == null)
            return new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        Stack<Node> que = new Stack();
        Stack<Node> help = new Stack();
        que.push(root);
        List<Integer> list = new ArrayList();
        boolean right = true;
        while (que.size() != 0) {
            Node top = que.pop();
            list.add(top.data);

            if (right) {
                if (top.left != null)
                    help.push(top.left);
                if (top.right != null)
                    help.push(top.right);

            } else {
                if (top.right != null)
                    help.push(top.right);
                if (top.left != null)
                    help.push(top.left);

            }
            if (que.size() == 0) {
                ans.add(new ArrayList<>(list));
                list = new ArrayList();
                Stack<Node> temp = que;
                que = help;
                help = temp;
                right = right == true ? false : true;
            }

        }
        return ans;
    }

    public static class traversalStatus {
        Node node = null;
        boolean sd = false;
        boolean ld = false;
        boolean rd = false;

        public traversalStatus(Node node) {
            this.node = node;
        }
    }

    public static void preInPostIterative(Node root) {
        Stack<traversalStatus> st = new Stack();
        st.push(new traversalStatus(root));
        while (st.size() != 0) {
            traversalStatus status = st.peek();
            if (!status.sd) {
                status.sd = true;
                System.out.println(status.node.data);
            } else if (!status.ld) {
                status.ld = true;
                if (status.node.left != null)
                    st.push(new traversalStatus(status.node.left));
            } else if (!status.rd) {
                status.rd = true;
                if (status.node.right != null)
                    st.push(new traversalStatus(status.node.right));
            } else {
                st.pop();
            }
        }
    }

    static int floor = Integer.MIN_VALUE;

    public static void Floor(Node root, int data) {
        if (root == null)
            return;

        if (root.data < data && root.data > floor)
            floor = root.data;

        Floor(root.left, data);
        Floor(root.right, data);
    }

    public static int kThLargest(Node root, int k) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {

            Floor(root, ans);
            ans = floor;
            floor = Integer.MIN_VALUE;
        }
        return ans;
    }

    public static boolean leafSimilar(Node root1, Node root2) {
        ans = 0;
        leafSimilar_(root1);
        int s1 = ans;
        ans = 0;
        leafSimilar_(root2);
        int s2 = ans;
        return s1 == s2;
    }

    public static void leafSimilar_(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            ans = ans * 10 + root.data;
        leafSimilar_(root.left);
        leafSimilar_(root.right);
    }

    /*********************************************/
    public static boolean isShapeSame(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return false;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return true;
        boolean res = false;
        res = res || isShapeSame(root1.left, root2.left) || isShapeSame(root1.right, root2.right);
        return res;
    }

    public static boolean isMirrorShape(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return false;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return true;
        boolean res = false;
        res = res || isMirrorShape(root1.left, root2.right) || isMirrorShape(root1.right, root2.left);
        return res;
    }

    public static boolean isSymmetric(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return false;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return true;
        boolean res = false;
        res = res || isSymmetric(root1.left, root2.right) || isSymmetric(root1.right, root2.left);
        return res;
    }

    public static boolean isSymmetricWithValues(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return false;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.data != root2.data))
            return true;
        boolean res = false;
        res = res || isSymmetricWithValues(root1.left, root2.right) || isSymmetricWithValues(root1.right, root2.left);
        return res;
    }

    public static Node mirrorGivenTree(Node root) {
        if (root == null)
            return null;
        Node left = mirrorGivenTree(root.left);
        Node right = mirrorGivenTree(root.right);
        Node temp = left;
        root.left = right;
        root.right = temp;
        return root;
    }

    /**********************************************/

    public static Node removeLeaves(Node root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) // condition for leaf
            return null;
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

    public static String tree2str(Node t) {
        if (t == null)
            return null;
        if (t.left == null && t.right == null)
            return t.data + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        left = left == null ? "" : "(" + left + ")";
        right = right == null ? "" : "(" + right + ")";
        return t.data + left + right;
    }

    public static int sumOfLeftLeaves(Node root) {
        if (root == null)
            return 0;
        int v1 = sumOfLeftLeaves(root.left);
        int v2 = sumOfLeftLeaves(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null)
            return v1 + v2 + root.left.data;
        return v1 + v2;
    }

    static boolean res = true;

    public static int isTreeBalanced(Node root) {
        if (root == null)
            return 0;
        int l = 0, r = 0;
        if (res == false)
            return 0;
        l = isTreeBalanced(root.left);
        r = isTreeBalanced(root.right);
        if (Math.abs(l - r) > 1) {
            res = false;
        }
        return Math.max(l, r) + 1;
    }

    public static Node linearizeTree(Node root) {
        if (root == null)
            return null;
        Node left = linearizeTree(root.left);
        Node right = linearizeTree(root.right);
        Node tail = getTailForLinearization(left);
        tail.left = right;
        root.right = null;
        return root;
    }

    public static Node getTailForLinearization(Node root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        Node l = getTailForLinearization(root.left);
        if (l != null)
            return l;
        Node r = getTailForLinearization(root.right);
        if (r != null)
            return r;
        return null;
    }

    public static void singleChildNode(Node root) {
        if (root == null)
            return;
        if ((root.left == null && root.right != null) || (root.right == null && root.left != null)) {
            System.out.println(root.data);
        }
        singleChildNode(root.left);
        singleChildNode(root.right);
    }

    public static int findTilt(Node root) {
        if (root == null)
            return 0;
        int l = findTilt(root.left);
        int r = findTilt(root.right);
        ans += Math.abs(l - r);
        return l + r + root.data;
    }

    public static boolean isUnivalTree(Node root, int val) {
        if (root == null)
            return true;
        if (root.data != val)
            return false;
        boolean res = true;
        res = res && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);

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