import java.util.Arrays;

public class voidType {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        basicQuestions();
    }

    public static void basicQuestions() {
        // STRING TYPE
        // removeHi("ihihihiiiihhi", "");
        // removeHiWithoutHit("hithithithiiih", "");
        // compression("aaaaabbbbdddfrfrfffrtttt", "", 1);
        // removeConsecutive("aaaaabbbdddcccgggggggggggg","");
        // subsequences("abc", "");
        // permutation("aab", "");
        // System.out.println(permutationWithoutRepetition("aabb", ""));

        // PATH TYPE
        // System.out.println(mazePath_HVD(0, 0, 2, 2, ""));
        // System.out.println(mazePath_HVD_Multi(0, 0, 2, 2, ""));
        // System.out.println(boardPath_Dice(10, "", 1));

        // NQUEEN WAYS 1D BOARD
        // Boolean[] boxes=new Boolean[4];
        // Arrays.fill(boxes,false);
        // System.out.println(nQueenWaysPer(boxes, 2, 0, ""));
        // System.out.println(nQueenWaysCom(4, 2, 0, 0, ""));
        // System.out.println(nQueenWaysCom_sub(4, 2, 0, 0, ""));
        // Boolean[] box=new Boolean[4];
        // Arrays.fill(box,false);
        // System.out.println(nQueenWaysper_sub(box, 2, 0, 0, ""));

        // NQUEENS
        // Boolean[][] board = new Boolean[4][4];
        // for (Boolean[] ar : board)
        // Arrays.fill(ar, false);
        // System.out.println(nQueen(board, 0, 0, ""));

        // COIN CHANGE ALL VARIATIONS
        // int[] arr = { 2, 3, 5, 7 };
        // System.out.println(coin_change_per_01(arr, 10, ""));
        // System.out.println(coin_change_com_01(arr, 10, 0, ""));
        // System.out.println(coin_change_com_02(arr, 10, 0, ""));
        // Boolean[] isSelected=new Boolean[arr.length];
        // Arrays.fill(isSelected,false);
        // System.out.println(coin_change_per_02(arr, isSelected,10, ""));
        // System.out.println(coin_change_per_03(arr, 10, 0, ""));
        // System.out.println(coin_change_com_03(arr, 10, 0, ""));
        int[] arr={10,20,30};
        System.out.println(equiSet(arr, 0, 0, "", "", 0));

    }

    public static void removeHi(String str, String ans) {
        if (str.length() <= 1) {
            ans += str;
            System.out.print(ans);
            return;
        }
        if (str.length() > 1 && str.substring(0, 2).equals("hi"))
            removeHi(str.substring(2), ans);
        else
            removeHi(str.substring(1), ans + str.charAt(0));
    }

    public static void removeHiWithoutHit(String str, String ans) {
        if (str.length() <= 1) {
            ans += str;
            System.out.print(ans + " ");
            return;
        }
        if (str.length() > 2 && str.substring(0, 3).equals("hit"))
            removeHiWithoutHit(str.substring(3), ans + "hit");
        else if (str.length() >= 2 && str.substring(0, 2).equals("hi"))
            removeHiWithoutHit(str.substring(2), ans);
        else
            removeHiWithoutHit(str.substring(1), ans + str.charAt(0));
    }

    public static void compression(String str, String ans, int count) {
        if (str.length() <= 1) {
            ans += count == 1 ? str : str + count;
            System.out.print(ans + " ");
            return;
        }
        if (str.charAt(0) == str.charAt(1)) {
            compression(str.substring(1), ans, count + 1);

        } else {
            compression(str.substring(1), ans + str.charAt(0) + (count == 1 ? "" : count), 1);
        }
    }

    public static void removeConsecutive(String str, String ans) {
        if (str.length() <= 1) {
            ans += str;
            System.out.print(ans + " ");
            return;
        }
        if (str.charAt(0) == str.charAt(1))
            removeConsecutive(str.substring(1), ans);
        else
            removeConsecutive(str.substring(1), ans + str.charAt(0));
    }

    public static void subsequences(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        subsequences(str.substring(1), ans + str.charAt(0));
        subsequences(str.substring(1), ans);
    }

    public static void permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(0, i) + str.substring(i + 1);
            permutation(sub, ans + str.charAt(i));
        }
    }

    public static int permutationWithoutRepetition(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return 1;
        }
        Boolean[] map = new Boolean[26];
        int count = 0;
        Arrays.fill(map, false);
        for (int i = 0; i < str.length(); i++) {
            if (!map[str.charAt(i) - 'a']) {
                map[str.charAt(i) - 'a'] = true;
                String sub = str.substring(0, i) + str.substring(i + 1);
                count += permutationWithoutRepetition(sub, ans + str.charAt(i));
            }
        }
        return count;
    }

    public static int mazePath_HVD(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        if (sr + 1 <= er) {
            count += mazePath_HVD(sr + 1, sc, er, ec, ans + "V");
        }
        if (sc + 1 <= ec) {
            count += mazePath_HVD(sr, sc + 1, er, ec, ans + "H");
        }
        if (sr + 1 <= er && sc <= ec) {
            count += mazePath_HVD(sr + 1, sc + 1, er, ec, ans + "D");
        }
        return count;
    }

    public static int mazePath_HVD_Multi(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        for (int jump = 1; jump + sr <= er; jump++) {
            count += mazePath_HVD_Multi(jump + sr, sc, er, ec, ans + "V" + jump + " ");
        }
        for (int jump = 1; jump + sc <= ec; jump++) {
            count += mazePath_HVD_Multi(sr, jump + sc, er, ec, ans + "H" + jump + " ");

        }
        for (int jump = 1; jump + sr <= er && jump + sc <= ec; jump++) {
            count += mazePath_HVD_Multi(sr + jump, sc + jump, er, ec, ans + "D" + jump + " ");
        }
        return count;
    }

    public static int boardPath_Dice(int board, String ans, int s) {
        if (s == board) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        for (int i = 1; i < 7; i++) {
            if (s + i <= board)
                count += boardPath_Dice(board, ans + i + " ", s + i);
        }
        return count;
    }

    public static int nQueenWaysPer(Boolean[] boxes, int tnq, int qpsf, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                count += nQueenWaysPer(boxes, tnq, qpsf + 1, ans + i + " ");
                boxes[i] = false;
            }
        }
        return count;
    }

    public static int nQueenWaysCom(int boxes, int tnq, int qpsf, int vidx, String ans) {
        if (tnq == qpsf) {
            System.out.println(ans + " ");
            return 1;
        }
        int count = 0;
        for (int i = vidx; i < boxes; i++) {
            count += nQueenWaysCom(boxes, tnq, qpsf + 1, i + 1, ans + i + " ");
        }
        return count;
    }

    public static int nQueenWaysCom_sub(int box, int tnq, int qpsf, int vidx, String ans) {
        if (vidx == box || tnq == qpsf) {
            if (qpsf == tnq) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        count += nQueenWaysCom_sub(box, tnq, qpsf + 1, vidx + 1, ans + vidx + " ");
        count += nQueenWaysCom_sub(box, tnq, qpsf, vidx + 1, ans);
        return count;
    }

    public static int nQueenWaysper_sub(Boolean[] box, int tnq, int qpsf, int vidx, String ans) {
        if (tnq == qpsf || vidx == box.length) {
            if (tnq == qpsf) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (!box[vidx]) {
            box[vidx] = true;
            count += nQueenWaysper_sub(box, tnq, qpsf + 1, 0, ans + vidx + " ");
            box[vidx] = false;
        }
        count += nQueenWaysper_sub(box, tnq, qpsf, vidx + 1, ans);
        return count;
    }

    public static Boolean isQueenSafe(Boolean[][] board, int r, int c) {
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        for (int i = 0; i < dir.length; i++) {
            for (int rad = 1; rad < board.length; rad++) {
                int x = r + rad * dir[i][0];
                int y = c + rad * dir[i][1];
                if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y])
                    return false;
            }
        }
        return true;
    }

    public static int nQueen(Boolean[][] board, int qpsf, int vidx, String ans) {
        if (vidx == board.length * board[0].length)
            return 0;
        if (qpsf == board.length) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = vidx; i < board.length * board[0].length; i++) {
            int r = i / board.length;
            int c = i % board.length;
            if (isQueenSafe(board, r, c)) {
                System.out.println(r + " " + c);
                board[r][c] = true;
                count += nQueen(board, qpsf + 1, i + 1, ans + r + " " + c + "\t");
                board[r][c] = false;
            }
        }
        return count;
    }

    public static int coin_change_per_01(int[] arr, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += coin_change_per_01(arr, tar - arr[i], ans + arr[i] + " ");
            }
        }
        return count;
    }

    public static int coin_change_com_01(int[] arr, int tar, int vidx, String ans) {
        if (tar == 0 || vidx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = vidx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += coin_change_com_01(arr, tar - arr[i], i, ans + arr[i] + " ");
            }
        }
        return count;
    }

    public static int coin_change_com_02(int[] arr, int tar, int vidx, String ans) {
        if (tar == 0 || vidx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = vidx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += coin_change_com_02(arr, tar - arr[i], i + 1, ans + arr[i] + " ");
            }
        }
        return count;
    }

    public static int coin_change_per_02(int[] arr, Boolean[] isSelected, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tar - arr[i] >= 0 && !isSelected[i]) {
                isSelected[i] = true;
                count += coin_change_per_02(arr, isSelected, tar - arr[i], ans + arr[i]);
                isSelected[i] = false;
            }
        }
        return count;
    }

    public static int coin_change_per_03(int[] arr, int tar, int vidx, String ans) {
        if (tar == 0 || vidx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[vidx] >= 0) {
            count += coin_change_per_03(arr, tar - arr[vidx], 0, ans + arr[vidx] + " ");
        }
        count += coin_change_per_03(arr, tar, vidx + 1, ans);
        return count;
    }

    public static int coin_change_com_03(int[] arr, int tar, int vidx, String ans) {
        if (tar == 0 || vidx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[vidx] >= 0) {
            count += coin_change_com_03(arr, tar - arr[vidx], vidx, ans + arr[vidx] + " ");
        }
        count += coin_change_com_03(arr, tar, vidx + 1, ans);
        return count;
    }

    public static int equiSet(int[] arr, int sum1, int sum2, String ans1, String ans2, int vidx) {
      //  System.out.println(sum1+ " " + sum2);
        if (vidx == arr.length) {
            if (sum1 == sum2) {
                System.out.println("[" + ans1 + "]" + "=" + "[" + ans2 + "]");
                return 1;
            }
            return 0;
        }
        int count = 0;
        count+=equiSet(arr, sum1+arr[vidx], sum2, ans1+arr[vidx]+" ", ans2, vidx+1);
        count+=equiSet(arr, sum1, sum2+arr[vidx], ans1, ans2+arr[vidx]+" ", vidx+1);
        return count;
    }
}