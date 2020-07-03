import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;

class question {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        // stackUsingQueue();

        // System.out.println(balancedBrackets("()[]([]){{"));
        // System.out.println(balancedBracketsText("[po]"));

        // int[] arr = { 9, 1, 7, 3, 11, -2, 25, 20, 2, -4 };
        // display1D(nextGreaterOnRight(arr));
        // display1D(nextGreaterOnLeft(arr));
        // display1D(nextSmallerOnRight(arr));
        // display1D(nextSmallerOnLeft(arr));
        // Leetcode
        // int[] arr1 = { 1, 11, -2, 25, 20 };
        // display1D(nextGreaterElement(arr1, arr));
        int[] tar = { 2, 3, 4 };
        buildArray(tar, tar.length);

    }

    public static void stackUsingQueue() {
        // stack using 2 queues push(O(1)) and pop(O(n))

        // StackUsingQueue st = new StackUsingQueue();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.pop();
        // st.push(4);
        // st.push(5);
        // st.push(6);
        // st.display();
        // System.out.println(st.isEmpty());

        // stack using 2 queue push(O(n)) and pop(O(1))

        // StackUsingQueue2 st=new StackUsingQueue2();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.pop();
        // st.push(4);
        // st.push(5);
        // st.push(6);
        // st.display();

        // Stack using 1 queue push(O(1)) and pop(O(n))

        // StackUsingQueue3 st = new StackUsingQueue3();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.pop();
        // System.out.println(st.peek());
        // st.push(4);
        // st.push(5);
        // st.push(6);
        // st.display();
    }

    public static boolean balancedBrackets(String str) {
        Stack<Character> st = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (st.size() == 0) {
                st.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == ']') {
                if (st.peek() != '[') {
                    return false;
                }
                st.pop();
                continue;
            }
            if (str.charAt(i) == '}') {
                if (st.peek() != '{') {
                    return false;
                }
                st.pop();
                continue;
            }

            if (str.charAt(i) == ')') {
                if (st.peek() != '(') {
                    return false;
                }
                st.pop();
                continue;
            }
            st.push(str.charAt(i));
        }
        if (st.size() != 0)
            return false;
        return true;
    }

    public static boolean balancedBracketsText(String str) {
        Stack<Character> st = new Stack();
        int open = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{')
                open++;
            if (st.size() == 0) {
                st.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == ']') {
                while (st.peek() != '[') {
                    if (st.size() == 0)
                        return false;
                    st.pop();
                }
                open--;
                st.pop();
            } else if (str.charAt(i) == '}') {
                while (st.peek() != '{') {
                    if (st.size() == 0)
                        return false;
                    st.pop();
                }
                open--;
                st.pop();
            }

            else if (str.charAt(i) == ')') {
                while (st.peek() != '(') {
                    if (st.size() == 0)
                        return false;
                    st.pop();
                }
                open--;
                st.pop();
            } else
                st.push(str.charAt(i));
        }
        if (open != 0)
            return false;
        return true;
    }

    public static int[] nextGreaterOnRight(int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() < arr[i])
                st.pop();
            if (st.size() == 0)
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static int[] nextGreaterOnLeft(int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && st.peek() < arr[i])
                st.pop();
            if (st.size() == 0)
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static int[] nextSmallerOnRight(int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() > arr[i])
                st.pop();
            if (st.size() == 0)
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static int[] nextSmallerOnLeft(int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && st.peek() > arr[i])
                st.pop();
            if (st.size() == 0)
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static int[] nextGreaterElement(int[] arr1, int[] arr) {
        Stack<Integer> st = new Stack();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() < arr[i])
                st.pop();
            if (st.size() == 0)
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(arr[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = ans[map.get(arr1[i])];
        }
        return res;
    }

    public static ArrayList<String> buildArray(int[] tar, int n) {
        ArrayList<String> ans = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (j == tar.length)
                break;
            ans.add("Push");
            int val = i;
            while (tar[j] != i) {
                ans.add("Pop");
                ans.add("Push");
                i++;
            }

            j++;
        }
        return ans;
    }

    /***************************************************/
    public static void display1D(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] arr) {
        for (int[] ar : arr) {
            for (int ele : ar) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}