import java.util.ArrayList;
import java.util.HashMap;

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
        System.out.println(checkPerfectNumber(1248579));
        */
        // LEETCODE 1037
        /*
        System.out.println(isBoomerang(p));
        */
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
                    g = gcd(g, count[i]);
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