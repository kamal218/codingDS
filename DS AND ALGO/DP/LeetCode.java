class LeetCode {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {

    }

    // LEETODE 198
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        return Math.max(help(nums, 0, dp), help(nums, 1, dp));
    }

    public int help(int[] nums, int pos, int[] dp) {
        if (pos >= nums.length)
            return 0;
        if (pos == nums.length - 1 || pos == nums.length - 2) {
            return nums[pos];
        }
        if (dp[pos] != 0)
            return dp[pos];
        if (pos + 2 < nums.length && pos + 3 < nums.length && nums[pos + 2] == nums[pos + 3])
            dp[pos] = help(nums, pos + 2, dp) + nums[pos];
        else
            dp[pos] = Math.max(help(nums, pos + 2, dp), help(nums, pos + 3, dp)) + nums[pos];
        return dp[pos];
    }

    // LEETCODE 746
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        return Math.min(help(cost, 0, dp), help(cost, 1, dp));
    }

    public int help(int[] cost, int pos, int[] dp) {

        if (pos > cost.length - 1) {
            return 0;
        }
        if (dp[pos] != 0)
            return dp[pos];
        dp[pos] = Math.min(help(cost, pos + 1, dp), help(cost, pos + 2, dp)) + cost[pos];
        return dp[pos];
    }
    // LEETCODE 70

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return help(n, 0, dp);
    }

    public int help(int n, int pos, int[] dp) {
        if (pos > n)
            return 0;
        if (pos == n)
            return 1;
        if (dp[pos] != 0)
            return dp[pos];
        dp[pos] += help(n, pos + 1, dp);
        dp[pos] += help(n, pos + 2, dp);
        return dp[pos];
    }

    // LEETCODE 64
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int ans = help(grid, 0, 0, dp);
        return ans;
    }

    public int help(int[][] grid, int sr, int sc, int[][] dp) {
        if (sr == grid.length - 1 && sc == grid[0].length - 1) {
            dp[sr][sc] = grid[sr][sc];
            return grid[sr][sc];
        }
        if (dp[sr][sc] != 0)
            return dp[sr][sc];
        int lm = Integer.MAX_VALUE;
        if (sr + 1 < grid.length)
            lm = (help(grid, sr + 1, sc, dp));
        int rm = Integer.MAX_VALUE;
        if (sc + 1 < grid[0].length)
            rm = (help(grid, sr, sc + 1, dp));
        dp[sr][sc] = Math.min(lm, rm) + grid[sr][sc];
        return dp[sr][sc];
    }

    // tabulation
    public int help(int[][] grid, int[][] dp) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int dm = Integer.MAX_VALUE;
                int rm = Integer.MAX_VALUE;
                if (i + 1 < grid.length)
                    dm = dp[i + 1][j];
                if (j + 1 < grid[0].length)
                    rm = dp[i][j + 1];
                dp[i][j] = Math.min(dm, rm) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    // LEETCODE 62
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return help(0, 0, m - 1, n - 1, dp);
    }

    public int help(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er & sc == ec) {
            dp[sr][sc] = 1;
            return 1;
        }
        int count = 0;
        if (dp[sr][sc] != 0)
            return dp[sr][sc];
        if (sr + 1 <= er)
            count += help(sr + 1, sc, er, ec, dp);
        if (sc + 1 <= ec)
            count += help(sr, sc + 1, er, ec, dp);
        dp[sr][sc] = count;
        return dp[sr][sc];
    }

    // LEETCODE 63
    public int uniquePathsWithObstacles(int[][] obs) {
        int[][] dp = new int[obs.length][obs[0].length];
        if (obs[0][0] == 1)
            return 0;
        return help(obs, 0, 0, obs.length - 1, obs[0].length - 1, dp);
    }

    public int help(int[][] obs, int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            if (obs[sr][sc] == 1)
                return 0;
            dp[sr][sc] = 1;
            return 1;
        }
        int count = 0;
        if (dp[sr][sc] != 0)
            return dp[sr][sc];
        if (sr + 1 <= er && obs[sr + 1][sc] != 1)
            count += help(obs, sr + 1, sc, er, ec, dp);
        if (sc + 1 <= ec && obs[sr][sc + 1] != 1)
            count += help(obs, sr, sc + 1, er, ec, dp);
        dp[sr][sc] = count;
        return dp[sr][sc];
    }

    // LEETCODE 55
    public boolean canJump(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] == 0) {
                int j = i - 1;
                while (j >= 0) {
                    if (nums[j] > i - j)
                        break;
                    j--;
                }
                if (j < 0)
                    return false;
                i = j;
            } else
                i--;
        }
        return true;
    }

    // LEETCODE
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++)
            dp[i] = dp[i - 1] + nums[i];
        return contArray(nums, k, dp);
    }

    public static boolean contArray(int[] nums, int k, int[] dp) {
        for (int gap = 1; gap < nums.length; gap++) {
            int si = 0;
            int ei = gap;
            while (ei < nums.length) {
                int val = dp[ei] - dp[si] + nums[si];
                if (val == 0 && k == 0)
                    return true;
                else if (k == 0) {
                    si++;
                    ei++;
                    continue;
                } else if (val % k == 0)
                    return true;
                si++;
                ei++;

            }
        }
        return false;
    }
    // LEETCODE DECODE 2

    public int encoding(String str, int[] dp, int idx) {
        if (str.length() == 0) {
            return 1;
        }
        if (dp[idx] != 0)
            return dp[idx];
        long count = 0;
        int ch = str.charAt(0) - '0';
        if (ch == '0') {
            count += encoding(str.substring(1), dp, idx + 1);
        }
        if (str.charAt(0) == '*') {
            count = 9 * encoding(str.substring(1), dp, idx + 1);

            if (str.length() > 1 && str.charAt(1) != '*') {
                if (str.charAt(1) - '0' >= 0 && str.charAt(1) - '0' <= 6)
                    count += 2 * encoding(str.substring(2), dp, idx + 2);
                else
                    count += encoding(str.substring(2), dp, idx + 2);
            } else if (str.length() > 1 && str.charAt(1) == '*') {
                count += 15 * encoding(str.substring(2), dp, idx + 2);
            }
        }
        if (ch > 0 && ch < 10) {
            count += encoding(str.substring(1), dp, idx + 1);
            if (str.length() > 1 && str.charAt(1) == '*') {
                if (ch == 1)
                    count += 9 * encoding(str.substring(2), dp, idx + 2);
                else if (ch == 2)
                    count += 6 * encoding(str.substring(2), dp, idx + 2);

            }
        }
        if (str.length() > 1 && str.charAt(1) != '*') {
            int ch1 = str.charAt(1) - '0';
            int num = ch * 10 + ch1;
            if (num > 9 && num < 27) {
                count += encoding(str.substring(2), dp, idx + 2);

            }
        }
        dp[idx] = (int) (count % M);
        return (int) (count % M);
    }
}