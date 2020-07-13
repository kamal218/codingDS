import java.util.*;

public class genericTree {
    public static class Node {
        int data = 0;
        ArrayList<Node> childrens = new ArrayList();

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            String str = "";
            str += data;
            return str;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, 50, 80, -1, -6, -1, -1, -1, 60, 70, -1, -1, 100, -1, -1 };
        // int[] sameshape = { 10, 20, 30, -1, -1, 40, 50, 80, -1, -6, -1, -1, -1, 60,
        // 70, -1, -1, 100, -1, -1 };
        // int[] mirror = { 10, 100, -1, 60, 70, -1, -1, 40, 50, -6, -1, 80, -1, -1, -1,
        // 20, 30, -1, -1, -1 };
        int[] symm = { 10, 20, 30, -1, -1, 40, 50, 80, -1, -6, -1, -1, -1, 60, 70, -1, -1, 100, 110, -1, -1, -1 };
        // Node root = createGenericTreeRec(arr);
        Node root = createGenericTreeIt(arr);
        // Node root1 = createGenericTreeIt(sameshape);
        // Node root1 = createGenericTreeIt(mirror);
        Node root1 = createGenericTreeIt(symm);
        displayGenericTree(root);
        // displayGenericTree(root1);
        basicFunc(root, root1);
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
        System.out.print(root.data);
        System.out.print("->");
        for (Node child : root.childrens)
            System.out.print(child.data + " ");
        System.out.println();
        for (Node child : root.childrens) {
            displayGenericTree(child);
        }
    }

    public static void basicFunc(Node root, Node root1) {
        System.out.println("\n\n");
        // min/max/size/find/height

        // System.out.println(minInTree(root));
        // System.out.println(maxInTree(root));
        // System.out.println(sizeOfTree(root));
        // System.out.println(heightOfTree(root));
        // System.out.println(findInTree(root, 30));

        // node to root path/LCA /kdown/kAway

        // ArrayList<Node> path = NodeToRootPath(root, -6);
        // for (Node node : path) {
        // System.out.println(node);
        // }
        // Node lca = LCAgenericTree(root, -6, 80);
        // System.out.println(lca);
        // K_DOWN(root, 2);
        // K_AWAY(root, root.childrens.get(1).childrens.get(0), 1);

        // path types diameter 2 ways / no fo leaves / leaf to leaf / node to node path
        // System.out.println(diameter_01(root));
        // System.out.println(diameter); //O(n)
        // System.out.println(diameter_02(root)); // o(n^2)
        // System.out.println(noOfLeaves(root));

        // all solution(min/max/height/size/find/ceil/floor/pred/succ) + kth largest
        // AllSolution data = new AllSolution();
        // allSolutionVoidType(root, 100, 1, data);
        // System.out.println("min: " + data.min);
        // System.out.println("max: " + data.max);
        // System.out.println("size: " + data.size);
        // System.out.println("height: " + data.height);
        // System.out.println("present: " + data.find);
        // System.out.println("ceil: " + data.ceil);
        // System.out.println("floor: " + data.floor);
        // System.out.println("pred: " + data.pred);
        // System.out.println("succ: " + data.succ);
        // System.out.println(kThLargest(root, 6));

        // traversals pre/in/post(rec+iterative) + levelorder(normal +new line(2 queue +
        // -1 + size)methods)+zigzag
        // traversalsPreInPostRec(root);
        // traversalsPreIt(root);
        // traversalsPostIt(root);
        // levelOrderTraversal(root);
        // levelOrderTraversal_newLine_01(root); // using size variable
        // levelOrderTraversal_newLine_02(root); // using new node with -1
        // levelOrderTraversal_newLine_03(root); // using 2 queues
        // levelOrderTraversalZigZag(root);

        // mirror types issame shape/ismirrorshape/issymm/issymm with value and shape
        // System.out.println(!isSameShape(root, root1));
        System.out.println(!isMirrorShape(root1, root1));
        // System.out.println(!isSymmetric(root1, root1));
        // System.out.println(isSymmetricWithValue(root, root));

        // misc linearize + remove leaves + remove node with 1 child
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

    public static ArrayList<Node> NodeToRootPath(Node root, int data) {
        if (root == null)
            return new ArrayList<>();
        if (root.data == data) {
            ArrayList<Node> base = new ArrayList();
            base.add(root);
            return base;
        }
        for (Node child : root.childrens) {
            ArrayList<Node> res = NodeToRootPath(child, data);
            if (res.size() > 0) {
                res.add(root);
                return res;
            }
        }
        return new ArrayList<>();
    }

    public static Node LCAgenericTree(Node root, int val1, int val2) {
        ArrayList<Node> list1 = NodeToRootPath(root, val1);
        ArrayList<Node> list2 = NodeToRootPath(root, val2);
        System.out.println(list1.size() + " " + list2.size());
        if (list1.size() == 0 || list2.size() == 0)
            return null;
        int i = list1.size() - 1, j = list2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (list1.get(i).data != list2.get(j).data)
                return list1.get(i + 1);
            i--;
            j--;
        }
        return null;
    }

    public static void K_DOWN(Node root, int k) {
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        for (Node child : root.childrens) {
            K_DOWN(child, k - 1);
        }
    }

    public static void K_DOWN_2(Node root, Node prev, int k) {
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        for (Node child : root.childrens) {
            if (child != prev)
                K_DOWN_2(child, prev, k - 1);
        }
    }

    public static void K_AWAY(Node root, Node node, int k) {
        ArrayList<Node> list = NodeToRootPath(root, node.data);
        Node prev = null;
        for (int i = 0; i < list.size(); i++) {
            Node cnode = list.get(i);
            K_DOWN_2(cnode, prev, k - i);
            prev = cnode;
        }
    }

    static int diameter = 0;

    public static int diameter_01(Node root) {
        int max1 = 0;
        int max2 = 0;
        for (Node child : root.childrens) {
            int currh = diameter_01(child);
            if (currh > max1) {
                max2 = max1;
                max1 = currh;
            } else if (currh > max2) {
                max2 = currh;
            }
        }
        diameter = Math.max(diameter, max1 + max2 + 1);
        return Math.max(max1, max2) + 1;
    }

    public static int diameter_02(Node root) {
        int max1 = 0;
        int max2 = 0;
        for (Node child : root.childrens) {
            int currh = heightOfTree(child);
            if (currh > max1) {
                max2 = max1;
                max1 = currh;
            } else if (currh > max2) {
                max2 = currh;
            }
        }
        int dia = 0;
        for (Node child : root.childrens) {
            dia = Math.max(dia, diameter_02(child));
        }
        return Math.max(dia, max1 + max2 + 1);
    }

    public static int noOfLeaves(Node root) {
        int ans = 0;
        // if (root.childrens.size() == 0)
        // return 1;
        for (Node child : root.childrens) {
            if (child.childrens.size() == 0)
                ans++;
        }
        for (Node child : root.childrens) {
            ans += noOfLeaves(child);
        }
        return ans;
    }

    // using void type
    public static class AllSolution {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int size = 0;
        int height = 0;
        boolean find = false;
        int ceil = Integer.MAX_VALUE; // used to find min put data=Integer.MIN_VALUE; (kth smallest)
        int floor = Integer.MIN_VALUE; // used to find max put data=Integer.MAX_VALUE; (kth largest)
        Node pred = null;
        Node succ = null;
        Node prev = null;
    }

    public static void allSolutionVoidType(Node root, int val, int level, AllSolution data) {
        data.min = Math.min(data.min, root.data);
        data.max = Math.max(data.max, root.data);
        data.size++;
        data.height = Math.max(data.height, level);
        data.find = data.find || (root.data == val);
        if (root.data > val && root.data < data.ceil)
            data.ceil = root.data;
        if (root.data > data.floor && root.data < val)
            data.floor = root.data;
        if (data.pred == null && root.data == val)
            data.pred = data.prev;
        if (data.prev != null && data.succ == null && data.prev.data == val)
            data.succ = root;
        data.prev = root;
        for (Node child : root.childrens) {
            allSolutionVoidType(child, val, level + 1, data);
        }
    }

    static int floor = Integer.MIN_VALUE;

    public static void floor(Node root, int val) {
        if (root.data > floor && root.data < val)
            floor = root.data;
        for (Node child : root.childrens)
            floor(child, val);
    }

    public static int kThLargest(Node root, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            floor(root, ans);
            ans = floor;
            floor = Integer.MIN_VALUE;
        }
        return ans;
    }

    public static void traversalsPreInPostRec(Node root) {
        // pre area
        System.out.println("pre :" + root.data);
        for (Node child : root.childrens) {
            System.out.println("edge :" + root.data + "->" + child.data);
            traversalsPreInPostRec(child);
            System.out.println("edge :" + child.data + "->" + root.data);
            System.out.println("In: " + root.data);
        }
        if (root.childrens.size() == 0)
            System.out.println("In: " + root.data);
        // post area
        System.out.println("post :" + root.data);
    }

    public static class TPair {
        Node node = null;
        int state = 0;

        public TPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void traversalsPreIt(Node root) {
        Stack<TPair> st = new Stack();
        st.push(new TPair(root, 0));
        while (st.size() != 0) {
            TPair top = st.peek();
            if (top.state == 0)
                System.out.println(top.node.data);
            if (top.state != top.node.childrens.size()) {
                st.push(new TPair(top.node.childrens.get(top.state), 0));
                top.state++;
            } else {
                st.pop();
            }
        }
    }

    public static void traversalsPostIt(Node root) {
        Stack<TPair> st = new Stack();
        st.push(new TPair(root, 0));
        while (st.size() != 0) {
            TPair top = st.peek();
            if (top.state != top.node.childrens.size()) {
                st.push(new TPair(top.node.childrens.get(top.state), 0));
                top.state++;
            } else {
                System.out.println(top.node.data);
                st.pop();
            }
        }
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> que = new LinkedList();
        que.add(root);
        while (que.size() != 0) {
            Node top = que.remove();
            System.out.println(top.data);
            for (Node child : top.childrens) {
                que.add(child);
            }
        }
    }

    public static void levelOrderTraversal_newLine_01(Node root) {
        Queue<Node> que = new LinkedList();
        que.add(root);
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Node top = que.remove();
                System.out.print(top.data + " ");
                for (Node child : top.childrens) {
                    que.add(child);
                }
            }
            System.out.println();
        }
    }

    public static void levelOrderTraversal_newLine_02(Node root) {
        Queue<Node> que = new LinkedList();
        que.add(root);
        que.add(new Node(-1));
        while (que.size() != 1) {
            Node top = que.remove();
            if (top.data == -1) {
                System.out.println();
                que.add(new Node(-1));
            } else {
                System.out.print(top.data + " ");
                for (Node child : top.childrens) {
                    que.add(child);
                }
            }
        }
    }

    public static void levelOrderTraversal_newLine_03(Node root) {
        Queue<Node> que = new LinkedList();
        Queue<Node> help = new LinkedList();
        que.add(root);
        while (que.size() != 0) {
            Node top = que.remove();
            System.out.print(top.data + " ");
            for (Node child : top.childrens) {
                help.add(child);
            }
            if (que.size() == 0) {
                System.out.println();
                Queue<Node> temp = que;
                que = help;
                help = temp;
            }
        }
    }

    public static void levelOrderTraversalZigZag(Node root) {
        Stack<Node> st = new Stack();
        Stack<Node> help = new Stack();
        st.push(root);
        boolean right = true;
        while (st.size() != 0) {
            Node top = st.pop();
            System.out.print(top.data + " ");
            if (right) {
                for (int i = 0; i < top.childrens.size(); i++) {
                    help.add(top.childrens.get(i));
                }
            } else {
                for (int i = top.childrens.size() - 1; i >= 0; i--) {
                    help.add(top.childrens.get(i));
                }
            }
            if (st.size() == 0) {
                System.out.println();
                right = !right;
                Stack<Node> temp = st;
                st = help;
                help = temp;
            }
        }
    }

    public static boolean isSameShape(Node root1, Node root2) {
        if (root1.childrens.size() != root2.childrens.size())
            return true;
        boolean res = false;
        for (int i = 0; i < root1.childrens.size(); i++) {
            res = res || isSameShape(root1.childrens.get(i), root2.childrens.get(i));
        }
        return res;
    }

    public static boolean isMirrorShape(Node root1, Node root2) {
        boolean res = false;
        if (root1.childrens.size() != root2.childrens.size())
            return true;
        int i = 0, j = root2.childrens.size() - 1;
        while (i < root1.childrens.size() && j >= 0) {
            res = res || isMirrorShape(root1.childrens.get(i), root2.childrens.get(j));
            i++;
            j--;
        }
        return res;
    }

    public static boolean isSymmetric(Node root1, Node root2) {
        boolean res = false;
        if (root1.childrens.size() != root2.childrens.size())
            return true;
        int i = 0, j = root2.childrens.size() - 1;
        while (i <= j) {
            res = res || isSymmetric(root1.childrens.get(i), root2.childrens.get(j));
            i++;
            j--;
        }
        return res;
    }
}