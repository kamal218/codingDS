import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

public class leetCode {
    public static void main(String[] args) {
        LeetCode();
    }

    public static void LeetCode() {
        System.out.println(numTilePossibilities("AAB"));
    }
    // 37 and 36

    public static Boolean sudoku(char[][] board, int idx) {
        if (idx == board.length * board[0].length) {

            return true;
        }
        Boolean res = false;
        int r = (idx / board.length);
        int c = (idx % board.length);
        if (board[r][c] == '.') {
            for (int i = 1; i < 10; i++) {
                if (isValidSudoku_(board, r, c, (char) (i + '0'))) {
                    board[r][c] = (char) (i + '0');
                    res = res || sudoku(board, idx + 1);
                    if (res == false)
                        board[r][c] = '.';
                }
            }
        } else
            res = res || sudoku(board, idx + 1);
        return res;
    }

    public static boolean isValidSudoku(char[][] board, int vidx) {
        Boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.')
                    res = res || (!isValidSudoku_(board, i, j, board[i][j]));
            }
        }
        return !res;
    }

    public static Boolean isValidSudoku_(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < board.length; i++) {
            if (i != r && ch == board[i][c])
                return false;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (i != c && ch == board[r][i])
                return false;
        }
        int row = (r / 3) * 3;
        int col = (c / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (i != r && j != c && ch == board[i][j])
                    return false;
            }
        }
        return true;
    }

    // LEETCODE 1079
    HashMap<String, Boolean> map = new HashMap<>();

    public static int numTilePossibilities(String tiles) {
        char ch[] = tiles.toCharArray();
        Arrays.sort(ch);
        tiles = String.valueOf(ch);
        int ans = 0;
        subSeq(tiles, "");
        map.remove("");
        int ct = 0;
        for (String keys : map.keySet()) {
            ct = per(keys);
            // System.out.println(ct+" "+keys);
            ans = ct + ans;
        }
        return ans;
    }

    public static void subSeq(String str, String ans) {
        if (str.length() == 0) {
            map.put(ans, true);
            return;
        }
        subSeq(str.substring(1), ans + str.charAt(0));
        subSeq(str.substring(1), ans);
    }

    public static int per(String str) {
        if (str.length() == 0)
            return 1;
        boolean[] arr = new boolean[26];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!arr[str.charAt(i) - 'A']) {
                arr[str.charAt(i) - 'A'] = true;
                String sub = str.substring(0, i) + str.substring(i + 1);
                count += per(sub);
            }
        }
        return count;
    }
    // LEETCODE 39

    List<List<Integer>> lis = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        combination_02(arr, target, 0, new ArrayList<Integer>());
        return lis;
    }

    public void combination_02(int[] arr, int tar, int idx, List<Integer> ans) {
        if (idx == arr.length || tar == 0) {
            // System.out.print(ans+" ");
            if (tar == 0)
                lis.add(new ArrayList(ans));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                ans.add(arr[i]);
                // System.out.print(ans+" ");
                combination_02(arr, tar - arr[i], i, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // LEETCODE 77
    public List<List<Integer>> combine(int n, int k) {
        nQueenWaysCom(n, k, 0, 0, new ArrayList<Integer>());
        return lis;
    }

    public void nQueenWaysCom(int boxes, int tnq, int qpsf, int vidx, List<Integer> ans) {
        if (tnq == qpsf) {
            lis.add(new ArrayList(ans));
            return;
        }
        for (int i = vidx; i < boxes; i++) {
            ans.add(i + 1);
            nQueenWaysCom(boxes, tnq, qpsf + 1, i + 1, ans);
            ans.remove(ans.size() - 1);
        }
    }

    // LEETCODE 526
    public static int countArrangement(int n) {
        return help(n, new boolean[n + 1], 1);
    }

    public int help(int n, boolean[] isVis, int idx) {
        if (n < idx)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!isVis[i] && (i % idx == 0 || idx % i == 0)) {
                isVis[i] = true;
                count += help(n, isVis, idx + 1);
                isVis[i] = false;
            }
        }
        return count;
    }

    // LEETCODE 216
    List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        com(9, n, 1, k, new ArrayList<Integer>());
        return list;
    }

    public void com(int n, int tar, int idx, int len, List<Integer> ans) {
        if (tar == 0) {
            if (len == 0)
                list.add(new ArrayList(ans));
            return;
        }
        if (len == 0)
            return;
        for (int i = idx; i <= n; i++) {
            if (tar - i >= 0) {
                ans.add(i);
                com(n, tar - i, i + 1, len - 1, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // LEETCODE 40
    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        com(arr, target, 0, new ArrayList<Integer>());
        return list;
    }

    public static void com(int[] arr, int tar, int vidx, List<Integer> ans) {
        if (tar == 0 || vidx == arr.length) {
            if (tar == 0) {
                list.add(new ArrayList(ans));
            }
            return;
        }
        for (int i = vidx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                ans.add(arr[i]);
                com(arr, tar - arr[i], i + 1, ans);
                ans.remove(ans.size() - 1);
            }
            while (i + 1 < arr.length && arr[i] == arr[i + 1])
                i++;
        }

    }
    // LEETCODE 31
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i - 1 >= 0 && nums[i - 1] >= nums[i])
            i--;
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }
        int num = Integer.MAX_VALUE;
        int j = len - 1;
        int k = len - 1;
        while (j >= i) {
            if (nums[j] > nums[i - 1] && nums[j] < num) {
                k = j;
                num = nums[j];
            }
            j--;
        }
        System.out.print(i + " " + k);
        int temp = nums[i - 1];
        nums[i - 1] = nums[k];
        nums[k] = temp;
        Arrays.sort(nums, i, len);
    }
}