// RETURN TYPE BASED QUESTIONS

import java.util.Arrays;
import java.util.ArrayList;

public class basicRec {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        basicFunctions();
        // leetCode();
    }

    public static void basicFunctions() {
        // 1-10 and 10-1 print
        // printIncUp(1,10);
        // printIncDown(1, 10);
        // printDecDown(10, 1);
        // printDecUp(10, 1);

        // POWER OF A TO B
        // System.out.println(powerAToB(2, 50));
        // System.out.println(powerAToBOptimized(2, 50));

        // FIBONACCI AND FACTORIAL
        // System.out.println(fac(6));
        // System.out.println(fib(6));

        // RECURSION WITH ARRAY
        // int[] arr = { 1, 5, 4, 5, 5, 2, 4, 8, 5, 5, 9, 6, 3, 5, 4, 7, 8, 5, 2, 5, 2,
        // 3, -5, 9, 7, 1, 2, 5 };
        // displayRec(arr, 0);
        // displayRec(minMax(arr, 0), 0);
        // displayRec(allIndex(arr, 0, 5, 0), 0);

        // String type
        // System.out.println(removeHi("hihihiiihi"));
        // System.out.println(removeHiWithoutHit("hithithihihiii"));
        // System.out.println(removeConsecDuplicates("aaabbbaaabbbaaaccc"));
        // System.out.println(compression("aaaaaabbbbccc", 1));
        // System.out.print(subsequences("abc"));
        // System.out.println(subsequence1("abc"));
        // System.out.println(permutation("abc"));
        System.out.println(permutationWithoutRep(str));

        // MAZEPATH TYPE
        // System.out.println(mazepath_HVD(0, 0, 3, 3));
        // System.out.println(ct);
        // Boolean[][] mat = { { false, false, false }, { false, false, false }, {
        // false, false, false } };
        // int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, 1 }, { 1, 1
        // }, { -1, -1 }, { 1, -1 } };
        // String[] move = { "R", "L", "D", "U", "D1", "D2", "D3", "D4" };
        // System.out.println(floodFill(0, 0, mat.length - 1, mat[0].length - 1, mat,
        // dir, move));
        // -----------
        // int[][] dirKnight = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, {
        // -1, -2 }, { 1, -2 }, { 2, -1 } };
        // String[] moveKnight = { "A", "b", "c", "d", "e", "f", "g", "h" };
        // System.out.println(knights(0, 0, 2, 2, mat, dirKnight, moveKnight));
        // -----------
        // int[][] ans = new int[8][8];
        // knights_fill(0, 0, 64, 1, dirKnight, ans);
    }

    public static void printIncUp(int s, int n) {
        if (n + 1 == s)
            return;
        System.out.print(s + " ");
        printIncUp(s + 1, n);
    }

    public static void printIncDown(int s, int n) {
        if (s - 1 == n)
            return;
        printIncDown(s, n - 1);
        System.out.print(n + " ");
    }

    public static void printDecDown(int n, int e) {
        if (n + 1 == e)
            return;
        System.out.print(n + " ");
        printDecDown(n - 1, e);
    }

    public static void printDecUp(int n, int e) {
        if (n + 1 == e)
            return;
        printDecUp(n, e + 1);
        System.out.print(e + " ");
    }

    public static long powerAToB(int a, int b) {
        if (b == 0)
            return 1;
        return a * (powerAToB(a, b - 1));
    }

    public static long powerAToBOptimized(int a, int b) {
        if (b == 0)
            return 1;
        long val = powerAToBOptimized(a, b / 2);
        val *= val;
        if (b % 2 != 0) {
            val = a * val;
        }
        return val;
    }

    public static long fac(int n) {
        if (n <= 1)
            return 1;
        return n * fac(n - 1);
    }

    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void displayRec(int[] arr, int idx) {
        if (idx == arr.length)
            return;
        System.out.print(arr[idx] + " ");
        displayRec(arr, idx + 1);
    }

    public static int[] minMax(int[] arr, int idx) {
        if (idx == arr.length) {
            int[] base = { Integer.MAX_VALUE, Integer.MIN_VALUE };
            return base;
        }
        int[] ans = minMax(arr, idx + 1);
        ans[0] = Math.min(ans[0], arr[idx]);
        ans[1] = Math.max(ans[1], arr[idx]);
        return ans;
    }

    public static int[] allIndex(int[] arr, int idx, int val, int size) {
        if (idx == arr.length) {
            int[] base = new int[size];
            return base;
        }
        if (arr[idx] == val)
            size++;
        int[] ans = allIndex(arr, idx + 1, val, size);
        if (arr[idx] == val)
            ans[size - 1] = idx;
        return ans;
    }

    public static String removeHi(String str) {
        if (str.length() == 0)
            return "";
        if (str.length() > 1 && str.substring(0, 2).equals("hi"))
            return removeHi(str.substring(2));
        else {
            char ch = str.charAt(0);
            return ch + removeHi(str.substring(1));
        }
    }

    public static String removeHiWithoutHit(String str) {
        if (str.length() == 0)
            return "";
        if (str.length() > 2 && str.substring(0, 3).equals("hit"))
            return "hit" + removeHiWithoutHit(str.substring(3));
        if (str.length() > 1 && str.substring(0, 2).equals("hi"))
            return removeHiWithoutHit(str.substring(2));
        else
            return str.charAt(0) + removeHiWithoutHit(str.substring(1));
    }

    public static String removeConsecDuplicates(String str) {
        if (str.length() <= 1)
            return str;
        else {
            if (str.charAt(0) == str.charAt(1))
                return removeConsecDuplicates(str.substring(1));
            else
                return str.charAt(0) + removeConsecDuplicates(str.substring(1));
        }
    }

    public static String compression(String str, int count) {
        if (str.length() <= 1) {
            return count == 1 ? str : str + (count + "");
        }
        if (str.charAt(0) == str.charAt(1)) {
            return compression(str.substring(1), count + 1);
        } else {
            return count != 1 ? str.charAt(0) + (count + "") + compression(str.substring(1), 1)
                    : str.charAt(0) + compression(str.substring(1), 1);
        }
    }

    public static ArrayList<String> subsequences(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans = subsequences(str.substring(1));
        int idx = ans.size();
        for (int i = 0; i < idx; i++) {
            ans.add(str.charAt(0) + ans.get(i));
        }
        return ans;
    }

    public static ArrayList<String> subsequence1(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = subsequence1(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>();
        for (String s : recAns) {
            myAns.add(s);
            myAns.add(ch + s);
        }

        return myAns;
    }

    public static ArrayList<String> permutation(String str) {
        if (str.length() == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add(str);
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> recAns = permutation(str.substring(1));
        for (String s : recAns) {
            for (int i = 0; i <= s.length(); i++) {
                ans.add(s.substring(0, i) + str.charAt(0) + s.substring(i));
            }
        }

        return ans;
    }

    static int ct = 0;

    public static ArrayList<String> mazepath_HVD(int sr, int sc, int er, int ec) {
        if (sr == er - 1 && sc == ec - 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            ct++;
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        if (sr + 1 <= er) {
            ArrayList<String> ver = mazepath_HVD(sr + 1, sc, er, ec);
            for (String s : ver)
                ans.add("V" + s);
        }
        if (sc + 1 <= ec) {
            ArrayList<String> hor = mazepath_HVD(sr, sc + 1, er, ec);
            for (String s : hor)
                ans.add("H" + s);
        }
        if (sr + 1 <= er && sc + 1 <= ec) {
            ArrayList<String> diag = mazepath_HVD(sr + 1, sc + 1, er, ec);
            for (String s : diag)
                ans.add("D" + s);
        }
        return ans;
    }

    public static ArrayList<String> floodFill(int sr, int sc, int er, int ec, Boolean[][] mat, int[][] dir,
            String[] move) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < dir.length; i++) {
            mat[sr][sc] = true;
            int x = sr + dir[i][0];
            int y = sc + dir[i][1];
            if (x >= 0 && y >= 0 && x <= er && y <= ec && !mat[x][y]) {

                ArrayList<String> recAns = floodFill(x, y, er, ec, mat, dir, move);
                for (String s : recAns) {
                    ans.add(move[i] + s);
                }
            }
            mat[sr][sc] = false;
        }
        return ans;
    }

    public static ArrayList<String> knights(int sr, int sc, int er, int ec, Boolean[][] mat, int[][] dir,
            String[] move) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < dir.length; i++) {
            mat[sr][sc] = true;
            int x = sr + dir[i][0];
            int y = sc + dir[i][1];
            if (x >= 0 && y >= 0 && x <= er && y <= ec && !mat[x][y]) {

                ArrayList<String> recAns = knights(x, y, er, ec, mat, dir, move);
                for (String s : recAns) {
                    ans.add(move[i] + s);
                }
            }
            mat[sr][sc] = false;
        }
        return ans;
    }

    public static Boolean knights_fill(int sr, int sc, int boxsize, int count, int[][] dir, int[][] ans) {
        ans[sr][sc] = count;
        if (count == boxsize) {
            for (int[] a : ans) {
                for (int ele : a)
                    System.out.print(ele + " ");
                System.out.println();
            }
            return true;
        }
        Boolean res = false;
        for (int i = 0; i < dir.length; i++) {

            int x = sr + dir[i][0];
            int y = sc + dir[i][1];
            if (x >= 0 && y >= 0 && x < ans.length && y < ans[0].length && ans[x][y] == 0)
                res = res || knights_fill(x, y, boxsize, count + 1, dir, ans);
        }
        ans[sr][sc] = 0;
        return res;
    }

    /*********************** HELPER FUNCTIONS ****************************/
    public static void display1D(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] mat) {
        for (int[] submat : mat) {
            for (int ele : submat) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void displayArrayList1D(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }

    public static void displayArrayList2D(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void swapf(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap2D(int[][] mat, int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

}