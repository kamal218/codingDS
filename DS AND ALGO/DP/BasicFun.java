class BasicFun {
    public static void main(String[] args) {
        set_01();
    }

    /// ****************************************************/
    public static void set_01() {

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

        display1D(dp);
        // display2D(dp);
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
                if(i+jump<=n)
                dp[i] += dp[i + jump];
            }
        }
        return dp[0];
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