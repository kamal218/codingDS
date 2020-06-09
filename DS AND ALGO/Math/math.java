import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class math {
    public static void main(String[] args) {
        questions();
    }

    public static void questions() {
        // 'LEETCODE' 1281
        /*
         * System.out.println(subtractProductAndSum(234));
         */
        // LEETCODE 1323
        /*
         * System.out.println(maximum69Number(6996));
         */
        // LEETCODE 728
        /*
         * displayArrayList1D(selfDividingNumbers(5, 2000));
         */
        // LEETCODE 942
        /*
         * display1D(diStringMatch("IIDI"));
         */
        // LEETCODE 204
        /*
         * System.out.println(countPrimes(1500));
         */
        // LEETCODE 633
        /*
         * System.out.println(judgeSquareSum(1002145));
         */
        // LEETCODE 914
        /*
         * int[] deck = { 1, 2, 3, 4, 4, 3, 2, 1, 1, 1 };
         * System.out.println(hasGroupsSizeX(deck));
         * System.out.println(hasGroupsSizeXArray(deck));
         */
        // LEETCODE
        /*
         * System.out.println(checkPerfectNumber(1248579));
         */
        // LEETCODE 1037
        /*
         * System.out.println(isBoomerang(p));
         */
        // LEETCODE 868
        /*
         * System.out.println(binaryGap(125478));
         */
        // LEETCODE 1103
        /*
         * System.out.println(distributeCandies(10, 3));
         */
        // LEETCODE 1009
        /*
         * System.out.println(bitwiseComplement(12485));
         */
        // LEETCODE 883
        /*
         * int[][] grid = { 2 }; System.out.println(projectionArea(grid));
         */
        // LEETCODE 812
        /*
         * int[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } };
         * System.out.println(largestTriangleArea(points));
         */
        // LEETCODE 976
        /*
         * int[] A={1,2,1}; System.out.println(largestPerimeter(A));
         */
        // LEETCODE 1317
        /*
         * display1D(getNoZeroIntegers(11));
         */
        // LEETCODE 202
        /*
         * System.out.println(isHappy(11)); System.out.println(isHappyBest(11));
         */
        // LEETCODE 453
        /*
         * int[] nums={1,2,3}; //Inverse approach System.out.println(minMoves(nums));
         */
        // LEETCODE 598
        /*
         * int[][] ops={{2,2},{3,3}}; System.out.println(maxCount(3, 3, ops));
         */
        // LEETCODE 628
        /*
         * in1[] nums={-45,1,52,36}; System.out.println(maximumProduct(nums));
         */
        // LEETCODE
        /*
        System.out.println(isPowerOfTwo(256));
        */
        // LEETCODE 326
        /*
         * System.out.println(isPowerOfThree(243));
         */
        // LEETCODE 
        System.out.println(isPerfectSquare(2147483647));
    }

    public static int subtractProductAndSum(int n) {
        int[] ans = prAndSum(n);
        return ans[0] - ans[1];
    }

    public static int[] prAndSum(int n) {
        int[] ans = new int[2];
        ans[0] = 1;
        while (n != 0) {
            ans[0] *= (n % 10);
            ans[1] += (n % 10);
            n /= 10;
        }
        return ans;
    }

    public static int maximum69Number(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '6') {
                ch[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(ch));
    }

    public static ArrayList<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (slfDiv(i))
                ans.add(i);
        }
        return ans;
    }

    public static Boolean slfDiv(int n) {
        int p = n;
        while (p != 0) {
            if ((p % 10) == 0 || n % (p % 10) != 0)
                return false;
            p /= 10;
        }
        return true;
    }

    public static int[] diStringMatch(String S) {
        int[] ans = new int[S.length() + 1];
        int s = 0, e = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = s;
                s++;
            } else {
                ans[i] = e;
                e--;
            }
        }
        ans[S.length()] = s;
        return ans;
    }

    public static int countPrimes(int n) {
        int ans = 0;
        Boolean[] prime = new Boolean[n];
        for (int i = 2; i < n; i++)
            prime[i] = true;
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i)
                    prime[j] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (prime[i])
                ans++;
        }
        return ans;
    }

    public static boolean judgeSquareSum(int n) {
        if (n <= 1)
            return true;
        int i = 0, j = 0;
        j = (int) Math.sqrt(n);
        while (i <= j) {
            if ((i * i) + (j * j) == n)
                return true;
            else if ((i * i) + (j * j) > n)
                j--;
            else
                i++;
        }
        return false;
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min_ = -1;
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        min_ = map.get(deck[0]);
        for (int key : map.keySet())
            min_ = GCD(min_, map.get(key));

        if (min_ < 2)
            return false;
        for (int key : map.keySet()) {
            if (map.get(key) < min_ || map.get(key) % min_ != 0)
                return false;
        }
        return true;
    }

    public static boolean hasGroupsSizeXArray(int[] deck) {
        int[] count = new int[10000];
        for (int c : deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = GCD(g, count[i]);
            }

        return g >= 2;
    }

    public static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static boolean checkPerfectNumber(int num) {
        if (num == 0)
            return false;
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) // i is already added to sum if it is a perfect square
                    sum += num / i;
            }
        }
        return sum - num == num; // while checking 1 num is added to the sum
    }

    public static boolean isBoomerang(int[][] p) {
        return (p[0][0] * (p[1][1] - p[2][1]) + p[0][1] * (p[2][0] - p[1][0])
                + (p[1][0] * p[2][1] - p[1][1] * p[2][0])) != 0;
    }

    public static int binaryGap(int N) {
        if ((N & (N - 1)) == 0)
            return 0;
        int ans = 0;
        int mx = 0;
        while ((N & 1) != 1)
            N = (N >> 1);
        while (N != 0) {
            if ((N & 1) != 0) {
                ans = Math.max(ans, mx);
                mx = 1;
            } else {
                mx++;
            }
            N = (N >> 1);
        }
        return ans;
    }

    public static int[] distributeCandies(int c, int p) {
        int[] ans = new int[p];
        int s = 1, i = 0;
        while (c - s > 0) {
            ans[i] += s;
            c -= s;
            s++;
            i++;
            i %= p;
        }
        ans[i] += c;
        return ans;
    }

    public static int bitwiseComplement(int N) {
        if (N == 0)
            return 1;
        int k = 0;
        int ans = 0;
        while (N != 0 && k < 32) {
            if ((N & 1) == 0) {
                ans = (ans | (1 << k));
            }
            N = (N >> 1);
            k++;
        }
        return ans;
    }

    public static int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            int bestRow = 0; // largest of grid[i][j]
            int bestCol = 0; // largest of grid[j][i]
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0)
                    ans++; // top shadow
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }

        return ans;
    }

    public static double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i + 1; j < N; ++j)
                for (int k = j + 1; k < N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    public static double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1] - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
    }

    public static int largestPerimeter(int[] A) {
        if (A.length < 3)
            return 0;
        Arrays.sort(A);
        int a = A.length;
        while (a != 2) {
            if (A[a - 3] + A[a - 2] > A[a - 1])
                return (A[a - 3] + A[a - 2] + A[a - 1]);
            a--;
        }
        return 0;
    }

    public static int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        int i = 1, j = n - 1;
        while (i <= j) {
            if (isNoZero(i, j)) {
                ans[0] = i;
                ans[1] = j;
                return ans;
            }
            i++;
            j--;
        }
        return ans;
    }

    public static Boolean isNoZero(int a, int b) {
        while (a > 0 || b > 0) {
            if (a > 0 && a % 10 == 0)
                return false;
            if (b > 0 && b % 10 == 0)
                return false;
            a /= 10;
            b /= 10;
        }
        return true;
    }

    public static boolean isHappy(int n) {
        int slow = n, fast = n, ct = 0;
        while (ct == 0 || fast != slow) {
            slow = sqSum(slow);
            fast = sqSum(fast);
            fast = sqSum(fast);
            ct++;
        }
        if (fast == 1)
            return true;
        return false;
    }

    public static boolean isHappyBest(int n) {
        int slow = n, fast = n;
        do {
            slow = sqSum(slow);
            fast = sqSum(fast);
            fast = sqSum(fast);
        } while (fast != slow);
        if (fast == 1)
            return true;
        return false;
    }

    public static int sqSum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += ((n % 10) * (n % 10));
            n /= 10;
        }
        return ans;
    }

    public static int minMoves(int[] nums) {
        int min_ = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            min_ = Math.min(nums[i], min_);
        }
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i] - min_;
        }
        return ans;
    }

    public static int maxCount(int m, int n, int[][] ops) {
        for (int i = 0; i < ops.length; i++) {
            m = Math.min(m, ops[i][0]);
            n = Math.min(n, ops[i][1]);
        }
        return m * n;
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0 || n == Integer.MIN_VALUE)
            return false;
        return ((n & (n - 1)) == 0);
    }

    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static boolean isPerfectSquare(int num) {
        for (long i = 1; i * i <= num; i++) {   // long is because i*i may be out of integer range
            if (i * i == num)
                return true;
        }
        return false;
    }

    // **********************************HELPER FUNCTIONS LIKE
    // DISPLAY****************************/
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