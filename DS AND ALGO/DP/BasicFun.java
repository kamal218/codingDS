import java.util.Arrays;

import javax.lang.model.util.ElementScanner6;

import java.util.ArrayList;

class BasicFun {
    public static void main(String[] args) {
        set();
    }

    /// ****************************************************/
    public static void set() {

        // SET_01
        // FIBONACCI
        // int n=10000;
        // int[] dp=new int[n+1];
        /*
         * long curr=System.currentTimeMillis(); // n+1 because we have n+1 numbers
         * System.out.println(fib_01(n,dp)); long now=System.currentTimeMillis();
         * System.out.println(now-curr);
         */
        /*
         * long curr=System.currentTimeMillis(); System.out.println(fib_02(n,dp)); long
         * now=System.currentTimeMillis(); System.out.println(now-curr);
         */

        // MazePath
        // int[][] dp = new int[3][3];
        // System.out.println(mazePath_HVD_multi(0,0,3,3,dp));
        // System.out.println(mazePath_HVD_multi_tab(0, 0, 3, 3, dp));

        // BOARD PATH
        // int n = 4;
        // int[] dp = new int[n + 1];
        // System.out.println(boardPathDice(n, 0, dp));
        // System.out.println(boardPathDice_tab(n, 0, dp));

        // set03
        // System.out.println(pairSingleUp(10));
        // int n = 4;
        // int[] dp=new int[n+1];
        // System.out.println(pairSingleUp_01(n, dp));
        // System.out.println(pairSingleUp_02(10));

        // MAXIMUM GOLD
        // int[][] gold = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2
        // } };
        // int ans = 0;
        // int[][] dp = new int[gold.length][gold[0].length];
        // for (int i = 0; i < gold.length; i++) {
        // ans = Math.max(ans, goldMine(i, 0, gold));
        // }
        // for (int i = 0; i < gold.length; i++) {
        // ans = Math.max(ans, goldMine_01(i, 0, gold, dp));
        // }
        // System.out.println(ans);
        // System.out.println(goldMine_02( gold));
        // display2D(gold);

        // Maximum Square Size
        // int[][] mat = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1,
        // 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
        // { 0, 0, 0, 0, 0 } };
        // int[][] dp = new int[mat.length][mat[0].length];
        // for (int[] ar : dp)
        // Arrays.fill(ar, -1);
        // maxSquareWith1s(0, 0, mat, dp);
        // System.out.println(maxSquare);
        // System.out.println(maxSquareWith1s_Dp(mat));
        // display2D(mat);

        // Tile floor
        // int n = 8, m = 4;
        // int[] dp = new int[n + 1];
        // System.out.println(tileFloor(8, 4));
        // System.out.println(tileFloor_01(n, m, dp));
        // System.out.println(tileFloor_02(n, m, dp));

        // ROD CUTTING
        // int[] arr = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
        // System.out.println(rodCutting(arr));
        // int[] dp=new int[arr.length];
        // System.out.println(rodCutting_01(arr, arr.length-1,dp));
        // display1D(arr);

        // SET 04

        // PERMUTATION AND COMBINATION COIN CHANGE
        // int[] coins = { 2, 3, 5, 7 };
        // int tar = 10;
        // int[] dp = new int[tar + 1];
        // System.out.println(combination(coins, tar, 0, ""));
        // System.out.println(combination_DP(coins, tar, dp));
        // int[][] dp = new int[tar + 1][coins.length];
        // System.out.println(combination_memo(coins, tar, 0, "", dp));
        // int[] dp = new int[tar + 1];
        // System.out.println(permutation(coins, tar, "", dp));
        // System.out.println(permutation_DP(coins, tar, dp));
        // int[][] dp = new int[coins.length][tar + 1];
        // System.out.println(combination_DP_Norep(coins, tar, dp));
        // int[][] dp = new int[coins.length][tar + 1];
        // System.out.println(targetSum_memo(coins, tar, 0, dp));
        // System.out.println(targetSum_DP(coins, tar, dp));

        // KNAPSACK PROBLEM
        // int[] w = { 2, 5, 1, 3, 4 };
        // int[] m = { 15, 14, 10, 45, 30 };
        // int cap = 7;
        // int[][] dp = new int[w.length][cap + 1];
        // System.out.println(knapSack(w, m, cap, 0, dp));
        // System.out.println(knapSack_DP(w, m, cap, dp));
        // System.out.println(unBoundedKnapSack(w, m, cap));

        // SET_05(String based)
        // String str = "abccbc";
        // boolean[][] dp = new boolean[str.length()][str.length()];
        // System.out.println(allPallindromicSubstring(str, dp));
        // System.out.println(longetsPalindromicSubstring(str, dp));
        // int[][] dp = new int[str.length()][str.length()];
        // System.out.println(longestPalindromicSubstring_01(str, dp));
        // System.out.println(longestPalindromicSubstring_02(str));
        // System.out.println(longetsPalindromicSubseq(str, dp));
        // System.out.println(allPallindromicSubstring_01(str));
        // System.out.println(allPallindromicSubseq(str, dp));
        // System.out.println(longestCommonSubsequence("abc", "ace"));
        // String str1 = "ssunday";
        // String str2 = "sunday";
        // int[][] dp = new int[str1.length()][str2.length()];
        // System.out.println(longestCommonSubsequence_memo("saturday", "sunday", dp));
        // System.out.println(longestCommonSubsequence_DP(str1, str2, dp));
        // System.out.println(longestCommonSubstring(str1, str2, 0));
        // System.out.println(longestCommonSubstring_memo(str1, str2, 0, dp));
        // System.out.println(stringOccurAsSubsequneceInAnotherString("ADX", "AGDFTY"));
        // System.out.println(stringOccurAsSubsequneceInAnotherString_it("ADXY",
        // "ADGCDX"));

        // LIS TYPE
        // int[] arr = { 10, 9, 2, 5, 3, 4 };
        // int[] arr={10,9,2,5,3,7,101,18};
        // int[] arr = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        // int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        // int[] arr = { 80, 60, 41, 50, 21, 33, 9, 22, 10 };

        // int ans = 0;
        // for(int i=0;i<arr.length;i++){
        // ans=Math.max(ans,LIS_01(arr, i));
        // }
        // int[] dp = new int[arr.length];
        // for (int i = 0; i < arr.length; i++) {
        // ans = Math.max(ans, LIS_memo(arr, i, dp));
        // }
        // System.out.println(ans);
        // System.out.println(LIS_DP(arr));
        // System.out.println(countOfLIS(arr));
        // System.out.println(LDS_DP(arr));
        // System.out.println(LBS(arr));
        // int[] arr = { 1, 101, 2, 3, 100, 4, 5 };
        // System.out.println(maxSumIncSubseq(arr));

        // CUT TYPE
        // int[] mat={10,30,5,60};
        // int[] mat = { 10, 20, 30, 40, 30 };
        // int[][] dp = new int[mat.length][mat.length];
        // System.out.println(MCM_memo(mat, 0, mat.length - 1, dp));
        // System.out.println(MCM_DP(mat, dp));
        String str = "ababbbabbababa";
        boolean[][] isPalin = new boolean[str.length()][str.length()];
        allPallindromicSubstring(str, isPalin);
        int[][] dp = new int[str.length()][str.length()];
        // System.out.println(minPallindromicCut(str, isPalin, 0, str.length() - 1,
        // dp));
        System.out.println(minPallindromicCut_DP(str, dp, isPalin));

        // MISCELLANEOUS
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // display1D(arrayBlockSum(arr, 2)); // sum of k elements from left and right
        // display1D(dp);
        display2D(dp);
    }

    public static int fib_01(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n; // this line does not matter in result but dp changes
            return n;
        }
        if (dp[n] != 0)
            return dp[n];
        dp[n] = fib_01(n - 1, dp) + fib_01(n - 2, dp);
        return dp[n];
    }

    public static int fib_02(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er - 1 && sc == ec - 1) {
            dp[sr][sc] = 1;
            return 1;
        }
        if (dp[sr][sc] != 0)
            return dp[sr][sc];
        int count = 0;
        for (int jump = 1; jump + sr < er; jump++)
            count += mazePath_HVD_multi(sr + jump, sc, er, ec, dp);
        for (int jump = 1; jump + sc < ec; jump++)
            count += mazePath_HVD_multi(sr, sc + jump, er, ec, dp);
        for (int jump = 1; jump + sr < er && jump + sc < ec; jump++)
            count += mazePath_HVD_multi(sr + jump, sc + jump, er, ec, dp);
        dp[sr][sc] = count;
        return count;
    }

    public static int mazePath_HVD_multi_tab(int sr, int sc, int er, int ec, int[][] dp) {

        for (int i = er - 1; i >= 0; i--) {
            for (int j = ec - 1; j >= 0; j--) {
                if (i == er - 1 && j == ec - 1) {
                    dp[i][j] = 1;
                    continue;
                }
                int count = 0;

                for (int jump = 1; jump + i < er; jump++)
                    count += dp[i + jump][j];

                for (int jump = 1; jump + j < ec; jump++)
                    count += dp[i][j + jump];

                for (int jump = 1; jump + i < er && jump + j < ec; jump++)
                    count += dp[i + jump][j + jump];

                dp[i][j] = count;
            }
        }
        return dp[0][0];
    }

    public static int boardPathDice(int n, int pos, int[] dp) {
        if (pos == n) {
            return 1;
        }
        if (dp[pos] != 0)
            return dp[pos];
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            if (pos + i <= n)
                count += boardPathDice(n, pos + i, dp);
        }
        dp[pos] = count;
        return count;
    }

    public static int boardPathDice_tab(int n, int pos, int[] dp) {
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int jump = 1; jump <= 6; jump++) {
                if (i + jump <= n)
                    dp[i] += dp[i + jump];
            }
        }
        return dp[0];
    }

    public static int pairSingleUp(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int ans = 0;
        ans += pairSingleUp(n - 1);
        ans += (n - 1) * pairSingleUp(n - 2);
        return ans;
    }

    public static int pairSingleUp_01(int n, int[] dp) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] += dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

    public static int pairSingleUp_02(int n) {
        int ans = 0;
        int f = 1;
        int s = 2;
        for (int i = 3; i <= n; i++) {
            ans = 0;
            ans += s + (i - 1) * f;
            f = s;
            s = ans;
        }
        return ans;
    }

    public static int goldMine(int sr, int sc, int[][] gold) {
        if (sc + 1 == gold[0].length)
            return gold[sr][sc];
        int ans = 0;
        int rum = 0, rm = 0, rdm = 0;
        if (sr - 1 >= 0 && sc + 1 < gold[0].length)
            rum = goldMine(sr - 1, sc + 1, gold);
        if (sc + 1 < gold[0].length)
            rm = goldMine(sr, sc + 1, gold);
        if (sr + 1 < gold.length && sc + 1 < gold[0].length)
            rdm = goldMine(sr + 1, sc + 1, gold);
        ans = Math.max(rm, Math.max(rum, rdm)) + gold[sr][sc];
        return ans;
    }

    public static int goldMine_01(int sr, int sc, int[][] gold, int[][] dp) {
        if (sc + 1 == gold[0].length)
            return gold[sr][sc];
        int ans = 0;
        if (dp[sr][sc] != 0)
            return dp[sr][sc];
        int rum = 0, rm = 0, rdm = 0;
        if (sr - 1 >= 0 && sc + 1 < gold[0].length)
            rum = goldMine_01(sr - 1, sc + 1, gold, dp);
        if (sc + 1 < gold[0].length)
            rm = goldMine_01(sr, sc + 1, gold, dp);
        if (sr + 1 < gold.length && sc + 1 < gold[0].length)
            rdm = goldMine_01(sr + 1, sc + 1, gold, dp);
        ans = Math.max(rm, Math.max(rum, rdm)) + gold[sr][sc];
        dp[sr][sc] = ans;
        return ans;
    }

    public static int goldMine_02(int[][] gold) {
        int rum = 0, rm = 0, rdm = 0;
        int ans = 0;
        for (int j = gold[0].length - 2; j >= 0; j--) {
            for (int i = gold.length - 1; i >= 0; i--) {
                // System.out.println(i+" "+j);

                if (i - 1 >= 0 && j + 1 < gold[0].length)
                    rum = gold[i - 1][j + 1];
                if (j + 1 < gold[0].length)
                    rm = gold[i][j + 1];
                if (i + 1 < gold.length && j + 1 < gold[0].length)
                    rdm = gold[i + 1][j + 1];
                gold[i][j] = Math.max(rm, Math.max(rum, rdm)) + gold[i][j];
                if (j == 0)
                    ans = Math.max(ans, gold[i][0]);
            }
        }
        return ans;
    }

    static int maxSquare = 0;

    public static int maxSquareWith1s(int sr, int sc, int[][] mat, int[][] dp) {
        if (sr == mat.length - 1 && sc == mat[0].length - 1)
            return mat[sr][sc];
        int rm = 0, dm = 0, rdm = 0;
        if (sr < mat.length && sc < mat[0].length && dp[sr][sc] != -1)
            return dp[sr][sc];
        if (sc + 1 < mat[0].length)
            rm = maxSquareWith1s(sr, sc + 1, mat, dp);
        if (sr + 1 < mat.length)
            dm = maxSquareWith1s(sr + 1, sc, mat, dp);
        if (sr < mat.length && sc < mat[0].length)
            rdm = maxSquareWith1s(sr + 1, sc + 1, mat, dp);
        int ans = 0;
        if (sr < mat.length && sc < mat[0].length && mat[sr][sc] == 1) {
            ans = Math.min(rm, Math.min(dm, rdm)) + 1;
            dp[sr][sc] = ans;
        }
        maxSquare = Math.max(maxSquare, ans);
        return ans;
    }

    public static int maxSquareWith1s_Dp(int[][] mat) {
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    int rm = 0, dm = 0, rdm = 0;
                    if (j + 1 < mat[0].length)
                        rm = mat[i][j + 1];
                    if (i + 1 < mat.length)
                        dm = mat[i + 1][j];
                    if (i + 1 < mat.length && j + 1 < mat[0].length)
                        rdm = mat[i + 1][j + 1];
                    mat[i][j] = Math.min(rm, Math.min(dm, rdm)) + 1;
                }
                maxSquare = Math.max(mat[i][j], maxSquare);
            }
        }
        return maxSquare;
    }

    public static int tileFloor(int n, int m) {
        if (n == m)
            return 2;
        if (m > n)
            return 1;
        int ans = 0;
        ans += tileFloor(n - 1, m);
        ans += tileFloor(n - m, m);
        return ans;
    }

    public static int tileFloor_01(int n, int m, int[] dp) {
        if (n == m) {
            dp[n] = 2;
            return 2;
        }
        if (m > n) {
            dp[n] = 1;
            return 1;
        }
        if (dp[n] != 0)
            return dp[n];
        int ans = 0;
        ans += tileFloor_01(n - 1, m, dp);
        ans += tileFloor_01(n - m, m, dp);
        dp[n] = ans;
        return ans;
    }

    public static int tileFloor_02(int n, int m, int[] dp) {
        for (int i = 0; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
                continue;
            }
            if (i == m) {
                dp[i] = 2;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - m];
        }
        return dp[n];
    }

    public static int rodCutting(int[] arr) {
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max_cost = arr[i];
            res[i] = i + "";
            int left = 1;
            int right = i - 1;
            while (left <= right) {
                if (arr[left] + arr[right] > max_cost) {
                    max_cost = arr[left] + arr[right];
                    res[i] = res[left] + "" + res[right];
                }
                left++;
                right--;
            }

            arr[i] = max_cost;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        return arr[arr.length - 1];
    }

    public static int rodCutting_01(int[] arr, int idx, int[] dp) {
        if (idx <= 1)
            return arr[idx];
        if (dp[idx] != 0)
            return dp[idx];
        int left = 1;
        int right = idx - 1;
        int ans = arr[idx];
        while (left <= right) {
            int lv = rodCutting_01(arr, 1, dp);
            int rv = rodCutting_01(arr, idx - 1, dp);
            if (lv + rv > ans) {
                ans = lv + rv;
            }
            left++;
            right--;
        }
        dp[idx] = ans;
        return ans;
    }

    public static int combination(int[] coins, int tar, int idx, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0)
                count += combination(coins, tar - coins[i], i, ans + coins[i] + " ");
        }
        return count;
    }

    public static int combination_DP(int[] coins, int tar, int[] dp) {
        dp[0] = 1;
        ArrayList<String>[] path = new ArrayList[dp.length];
        for (int i = 0; i < path.length; i++) {
            path[i] = new ArrayList<>();
        }
        path[0].add("");
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
                for (String s : path[j - coins[i]]) {
                    path[j].add(s + coins[i] + " ");
                }
            }
        }
        for (int i = 0; i < path.length; i++) {
            for (String ls : path[i]) {
                System.out.print(ls + " ");
            }
            System.out.println();
        }
        return dp[dp.length - 1];
    }

    public static int combination_memo(int[] coins, int tar, int idx, String ans, int[][] dp) {
        if (tar == 0) {
            System.out.println(ans);
            dp[tar][idx] = 1;
            return 1;
        }
        if (dp[tar][idx] != 0)
            return dp[tar][idx];
        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0)
                count += combination(coins, tar - coins[i], i, ans + coins[i] + " ");
        }
        dp[tar][idx] = count;
        return count;
    }

    public static int permutation(int[] coins, int tar, String ans, int[] dp) {
        if (tar == 0) {
            dp[tar] = 1;
            return 1;
        }
        if (dp[tar] != 0)
            return dp[tar];
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (tar - coins[i] >= 0)
                count += permutation(coins, tar - coins[i], ans + coins[i] + " ", dp);
        }
        dp[tar] = count;
        return count;
    }

    public static int permutation_DP(int[] coins, int tar, int[] dp) {

        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] += dp[i - coins[j]];
            }
        }
        return dp[dp.length - 1];
    }

    public static int combination_DP_Norep(int[] coins, int tar, int[][] dp) {
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= tar; j++) {
                if (j == 0 || coins[i] == j) {
                    dp[i][j] = 1;
                } else {
                    for (int k = i - 1; k >= 0; k--) {
                        dp[i][j] += dp[k][j - coins[i]];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
            ans += dp[i][tar];
        }
        return ans;
    }

    public static int targetSum_memo(int[] coins, int tar, int idx, int[][] dp) {
        if (tar < 0)
            return 0;
        if (idx == coins.length || tar == 0) {
            if (tar == 0)
                return 1;
            return 0;
        }
        if (dp[idx][tar] != 0)
            return dp[idx][tar];
        dp[idx][tar] = targetSum_memo(coins, tar - coins[idx], idx + 1, dp) + targetSum_memo(coins, tar, idx + 1, dp);
        return dp[idx][tar];
    }

    public static int targetSum_DP(int[] coins, int tar, int[][] dp) {
        ArrayList<String>[][] ans = new ArrayList[coins.length][tar + 1];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = new ArrayList<String>();
            }
        }
        // dp[0][0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= tar; j++) {
                if (coins[i] == j) {
                    dp[i][j] = 1;
                    ans[i][j].add(coins[i] + "");
                    // if(i==0)
                    // break;
                } else {
                    if (i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j];
                        for (String s : ans[i - 1][j]) {
                            ans[i][j].add(s + "");
                        }
                    }
                    if (j - coins[i] >= 0 && i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j - coins[i]];
                        for (String s : ans[i - 1][j - coins[i]]) {
                            ans[i][j].add(s + coins[i] + "");
                        }
                    }
                }
            }
        }
        for (ArrayList<String>[] arr : ans) {
            for (ArrayList<String> lst : arr) {
                System.out.print(lst);
            }
            System.out.println();
        }
        return dp[coins.length - 1][tar];
    }

    public static int knapSack(int[] w, int[] m, int cap, int idx, int[][] dp) {
        if (cap <= 0 || idx == w.length) {
            return 0;
        }
        if (dp[idx][cap] != 0)
            return dp[idx][cap];
        int unpicked = knapSack(w, m, cap, idx + 1, dp);
        int picked = 0;
        if (cap - w[idx] >= 0)
            picked = knapSack(w, m, cap - w[idx], idx + 1, dp) + m[idx];
        dp[idx][cap] = Math.max(picked, unpicked);
        return dp[idx][cap];
    }

    public static int knapSack_DP(int[] w, int[] m, int cap, int[][] dp) {
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <= cap; j++) {
                if (j == w[i]) {
                    dp[i][j] = m[i];
                } else {
                    int picked = 0, unpicked = 0;
                    if (i - 1 >= 0) {
                        unpicked = dp[i - 1][j];
                        if (j - w[i] >= 0)
                            picked = dp[i - 1][j - w[i]] + m[i];
                    }
                    dp[i][j] = Math.max(dp[i][j], Math.max(picked, unpicked));
                }
            }
        }
        return dp[w.length - 1][cap];
    }

    public static int unBoundedKnapSack(int[] w, int[] m, int cap) {
        int[] dp = new int[cap + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j - w[i] >= 0)
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + m[i]);
            }
        }

        display1D(dp);
        return dp[cap];
    }
    // */****************************************************************************/

    public static int allPallindromicSubstring(String str, boolean[][] dp) {
        int count = 0;
        for (int gap = 0; gap < str.length(); gap++) {
            int si = 0;
            int ei = gap;
            while (ei < str.length()) {
                if (gap == 0)
                    dp[si][ei] = true;
                else if (gap == 1 && str.charAt(si) == str.charAt(ei))
                    dp[si][ei] = true;
                else if (dp[si + 1][ei - 1] && str.charAt(si) == str.charAt(ei))
                    dp[si][ei] = true;
                if (dp[si][ei])
                    count++;
                si++;
                ei++;
            }
        }
        return count;
    }

    public static int allPallindromicSubstring_01(String str) {
        int ans = 1;
        int low = 0, high = 0;
        for (int i = 1; i < str.length(); i++) {
            ans++;
            low = i - 1;
            high = i;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                ans++;
                high++;
                low--;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                ans++;
                high++;
                low--;
            }
        }
        return ans;
    }

    public static String longetsPalindromicSubstring(String str, boolean[][] dp) {
        String ans = "";
        int len = 0;
        for (int gap = 0; gap < str.length(); gap++) {
            int si = 0;
            int ei = gap;
            while (ei < str.length()) {
                if (gap == 0)
                    dp[si][ei] = true;
                else if (gap == 1 && str.charAt(si) == str.charAt(ei))
                    dp[si][ei] = true;
                else if (dp[si + 1][ei - 1] && str.charAt(si) == str.charAt(ei))
                    dp[si][ei] = true;

                if (dp[si][ei] && (ei - si + 1) > len) {
                    ans = str.substring(si, ei + 1);
                    len = ei - si + 1;
                }
                si++;
                ei++;
            }
        }
        return ans;
    }

    public static int longestPalindromicSubstring_01(String str, int[][] dp) {
        boolean[][] isPalin = new boolean[str.length()][str.length()];
        allPallindromicSubstring(str, isPalin);
        for (int gap = 0; gap < str.length(); gap++) {
            int si = 0;
            int ei = gap;
            while (ei < str.length()) {
                if (gap == 0)
                    dp[si][ei] = 1;
                else if (gap == 1 && str.charAt(si) == str.charAt(ei))
                    dp[si][ei] = 2;
                else if (str.charAt(si) == str.charAt(ei) && isPalin[si + 1][ei - 1])
                    dp[si][ei] = dp[si + 1][ei - 1] + 2;
                else
                    dp[si][ei] = Math.max(dp[si + 1][ei], dp[si][ei - 1]);
                si++;
                ei++;
            }
        }
        return dp[0][str.length() - 1];
    }

    public static int longestPalindromicSubstring_02(String str) {
        int ans = 1;
        int start = 0;
        int low = 0, high = 0;
        for (int i = 1; i < str.length(); i++) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > ans) {
                    start = i - 1;
                    ans = high - low + 1;
                }
                high++;
                low--;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > ans) {
                    start = i;
                    ans = high - low + 1;
                }
                high++;
                low--;
            }
        }
        System.out.println(str.substring(start - 1, start + ans - 1));
        return ans;
    }

    public static int longetsPalindromicSubseq(String str, int[][] dp) {
        int len = 0;
        String ans = "";
        for (int gap = 0; gap < str.length(); gap++) {
            int si = 0;
            int ei = gap;
            while (ei < str.length()) {
                if (gap == 0)
                    dp[si][ei] = 1;
                else if (str.charAt(si) == str.charAt(ei))
                    dp[si][ei] = dp[si + 1][ei - 1] + 2;
                else
                    dp[si][ei] = Math.max(dp[si + 1][ei], dp[si][ei - 1]);
                if (len < dp[si][ei]) {
                    ans = str.substring(si, ei + 1);
                    len = ans.length();
                }
                si++;
                ei++;
            }
        }
        System.out.println(ans);
        return dp[0][str.length() - 1];
    }

    public static int allPallindromicSubseq(String str, int[][] dp) {
        for (int gap = 0; gap < str.length(); gap++) {
            int si = 0;
            int ei = gap;
            while (ei < str.length()) {
                if (gap == 0)
                    dp[si][ei] = 1;
                else if (str.charAt(si) == str.charAt(ei)) {
                    dp[si][ei] = dp[si + 1][ei - 1] + 1;
                    dp[si][ei] += dp[si + 1][ei] + dp[si][ei - 1] - dp[si + 1][ei - 1];
                } else
                    dp[si][ei] = dp[si + 1][ei] + dp[si][ei - 1] - dp[si + 1][ei - 1];
                si++;
                ei++;
            }
        }
        return dp[0][str.length() - 1];
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0)
            return 0;
        if (str1.charAt(0) == str2.charAt(0)) // if characters are
            return longestCommonSubsequence(str1.substring(1), str2.substring(1)) + 1;
        return Math.max(longestCommonSubsequence(str1.substring(1), str2), // if characters are unequal then 2
                                                                           // possibilities
                longestCommonSubsequence(str1, str2.substring(1)));
    }

    public static int longestCommonSubsequence_memo(String str1, String str2, int[][] dp) {
        if (str1.length() == 0 || str2.length() == 0)
            return 0;

        if (dp[dp.length - str1.length()][dp[0].length - str2.length()] != 0)
            return dp[dp.length - str1.length()][dp[0].length - str2.length()];

        int ans = 0;

        if (str1.charAt(0) == str2.charAt(0))
            ans = longestCommonSubsequence_memo(str1.substring(1), str2.substring(1), dp) + 1;
        else
            ans = Math.max(longestCommonSubsequence_memo(str1.substring(1), str2, dp),
                    longestCommonSubsequence_memo(str1, str2.substring(1), dp));

        dp[dp.length - str1.length()][dp[0].length - str2.length()] = ans;
        return ans;
    }

    public static int longestCommonSubsequence_DP(String str1, String str2, int[][] dp) {

        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {

                if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);

            }
        }
        return dp[0][0];
    }

    static int maxLen = 0;

    public static int longestCommonSubstring(String str1, String str2, int count) {
        if (str1.length() == 0 || str2.length() == 0)
            return count;
        if (str1.charAt(0) == str2.charAt(0)) {
            count = longestCommonSubstring(str1.substring(1), str2.substring(1), count + 1);
        }
        count = Math.max(Math.max(longestCommonSubstring(str1.substring(1), str2, 0),
                longestCommonSubstring(str1, str2.substring(1), 0)), count);
        return count;
    }

    public static int longestCommonSubstring_memo(String str1, String str2, int count, int[][] dp) {
        if (str1.length() == 0 || str2.length() == 0)
            return count;
        if (dp[dp.length - str1.length()][dp[0].length - str2.length()] != 0)
            return dp[dp.length - str1.length()][dp[0].length - str2.length()];
        if (str1.charAt(0) == str2.charAt(0)) {
            count = longestCommonSubstring_memo(str1.substring(1), str2.substring(1), count + 1, dp);
        }
        count = Math.max(Math.max(longestCommonSubstring_memo(str1.substring(1), str2, 0, dp),
                longestCommonSubstring_memo(str1, str2.substring(1), 0, dp)), count);
        dp[dp.length - str1.length()][dp[0].length - str2.length()] = count;
        return count;
    }

    // public static int longestCommonSubstring_DP(String str1, String str2) {
    // int count = 0;
    // for (int i = str1.length() - 1; i >= 0; i--) {
    // for (int j = str2.length(); j >= 0; j--) {
    // if(str1.charAt(i)==str2.charAt(j)){
    // count=dp[i+1][j+1]+1;
    // }
    // }
    // }
    // return dp[0][0];
    // }
    public static boolean stringOccurAsSubsequneceInAnotherString(String str1, String str2) {
        if (str1.length() == 0)
            return true;
        if (str2.length() == 0)
            return false;
        if (str1.charAt(0) == str2.charAt(0))
            return stringOccurAsSubsequneceInAnotherString(str1.substring(1), str2.substring(1));
        else
            return stringOccurAsSubsequneceInAnotherString(str1, str2.substring(1));
    }

    public static boolean stringOccurAsSubsequneceInAnotherString_it(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j))
                i++;
            else
                j++;
        }
        return i == str1.length();
    }

    /***************************************************************/
    public static int LIS_01(int[] arr, int idx) {
        if (idx == arr.length) {
            return 0;
        }
        int ans = 0;
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] > arr[idx]) {
                ans = Math.max(ans, LIS_01(arr, i));
            }
        }
        return ans + 1;
    }

    public static int LIS_memo(int[] arr, int idx, int[] dp) {
        if (idx == arr.length) {
            return 0;
        }
        if (dp[idx] != 0)
            return dp[idx];
        int ans = 0;
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] > arr[idx]) {
                ans = Math.max(ans, LIS_memo(arr, i, dp));
            }
        }
        dp[idx] = ans + 1;
        return ans + 1;
    }

    public static int LIS_DP(int[] arr) {
        int[] dp = new int[arr.length];
        String[] paths = new String[arr.length];
        int ans = 0;
        dp[0] = 1;
        paths[0] = arr[0] + "";
        for (int i = 1; i < arr.length; i++) {
            paths[i] = arr[i] + "";
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                    paths[i] = paths[j] + " " + arr[i] + "";
                }
            }
            if (dp[i] > ans)
                ans = dp[i];
        }
        for (int i = 0; i < paths.length; i++) {
            System.out.println(paths[i] + " ");
        }
        System.out.println();
        display1D(dp);
        return ans;
    }

    public static int countOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ct = new int[arr.length];
        dp[0] = 1;
        int max_ = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            ct[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    if (dp[j] >= dp[i]) { // update curr length
                        dp[i] = dp[j] + 1;
                        ct[i] = ct[j];
                    } else if (dp[j] + 1 == dp[i]) { // update count
                        ct[i] += ct[j];
                    }
                }
            }
            max_ = Math.max(max_, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] == max_)
                ans += ct[i];
        }
        return ans;
    }

    public static int LDS_DP(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (ans < dp[i])
                ans = dp[i];
        }
        display1D(dp);
        return ans;
    }

    public static int[] LISReturnDPForLBS(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 0;
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > ans)
                ans = dp[i];
        }
        return dp;
    }

    public static int[] LDSReturnDPForLBS(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (ans < dp[i])
                ans = dp[i];
        }
        return dp;
    }

    public static int LBS(int[] arr) {
        int[] lis = LISReturnDPForLBS(arr);
        int[] lds = LDSReturnDPForLBS(arr);
        int[] dp = new int[arr.length];
        int ans = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            dp[i] = lis[i] + lds[i] - 1;
            ans = Math.max(ans, dp[i]);
        }
        display1D(dp);
        return ans;
    }

    public static int maxSumIncSubseq(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[i] < arr[i] + dp[j]) {
                    dp[i] = arr[i] + dp[j];
                }
            }
            ans = Math.max(dp[i], ans);
        }
        display1D(dp);
        return ans;
    }

    // ******************************************************/
    public static int MCM_memo(int[] arr, int si, int ei, int[][] dp) {
        if (si + 1 == ei)
            return 0;
        int ans = Integer.MAX_VALUE;
        if (dp[si][ei] != 0)
            return dp[si][ei];
        for (int cut = si + 1; cut < ei; cut++) {
            ans = Math.min(MCM_memo(arr, si, cut, dp) + arr[si] * arr[cut] * arr[ei] + MCM_memo(arr, cut, ei, dp), ans);
        }
        dp[si][ei] = ans;
        return ans;
    }

    public static int MCM_DP(int[] arr, int[][] dp) {
        for (int gap = 2; gap < arr.length; gap++) {
            int si = 0;
            int ei = gap;
            while (ei < arr.length) {
                int val = Integer.MAX_VALUE;
                for (int cut = si + 1; cut < ei; cut++) {
                    val = Math.min(val, dp[si][cut] + arr[si] * arr[cut] * arr[ei] + dp[cut][ei]);
                }
                dp[si][ei] = val;
                si++;
                ei++;
            }
        }
        return dp[0][arr.length - 1];
    }

    public static int minPallindromicCut(String str, boolean[][] isPalin, int si, int ei, int[][] dp) {
        if (isPalin[si][ei]) {
            return 0;
        }
        if (dp[si][ei] != 0)
            return dp[si][ei];
        int ans = Integer.MAX_VALUE;
        for (int cut = si; cut < ei; cut++) {
            ans = Math.min(minPallindromicCut(str, isPalin, si, cut, dp)
                    + minPallindromicCut(str, isPalin, cut + 1, ei, dp) + 1, ans);
        }
        dp[si][ei] = ans;
        return ans;
    }

    public static int minPallindromicCut_DP(String str, int[][] dp, boolean[][] isPalin) {
        for (int gap = 0; gap < str.length(); gap++) {
            int si = 0;
            int ei = gap;
            while (ei < str.length()) {
                int val = Integer.MAX_VALUE;
                if (isPalin[si][ei]) {
                    dp[si][ei] = 0;
                    si++;
                    ei++;
                    continue;
                }
                for (int cut = si; cut < ei; cut++) {
                    val = Math.min(val, dp[si][cut] + dp[cut + 1][ei] + 1);
                }
                dp[si][ei] = val;
                si++;
                ei++;
            }
        }
        return dp[0][str.length() - 1];
    }

    /*********************************************************************************/
    public static int[] arrayBlockSum(int[] arr, int k) {
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            sum[i] = sum[i - 1] + arr[i];
        display1D(sum);
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            if (i + k >= arr.length && i - k - 1 < 0) {
                ans[i] = sum[arr.length - 1];
            } else if (i + k >= arr.length) {
                ans[i] = sum[arr.length - 1] - sum[i - k - 1];
            } else if (i - k - 1 < 0) {
                ans[i] = sum[i + k];
            } else {
                ans[i] = sum[i + k] - sum[i - k - 1];
            }
        }
        return ans;
    }

    // *****************************************************************/
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