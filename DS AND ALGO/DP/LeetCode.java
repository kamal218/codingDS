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
}