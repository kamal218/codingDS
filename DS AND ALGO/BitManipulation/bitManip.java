public class bitManip {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        // System.out.println(numberOfSteps(45));
        // int[] nums={1,1,9,8,9,4,4};
        // System.out.println(singleNumber(nums));
        // int[] nums={0,1,0,1,0,1,99};
        // System.out.println(singleNumber2(nums));
        // System.out.println(hammingDistance(5, 15));
        // int[] nums={1,4,2,5,1,1,1,8,1,1,7,5,1};
        // System.out.println(majorityElement(nums));
        // System.out.println(reverseBits(690));
        // int[] nums={1,2,9,6,3,5,4,8};
        // System.out.println(missingNumber(nums));
        // System.out.println(findComplement(58));
        System.out.println(findTheDifference("abcd", "abcde"));
        // System.out.println(minFlips(2, 6, 5));
        // System.out.println(countPrimeSetBits(6, 10));

    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if ((num & 1) == 0)
                num = (num >> 1);
            else
                num = (num & (~1));
            steps++;
        }
        return steps;
    }

    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = (ans ^ nums[i]);

        }
        return ans;

    }

    public static int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            long mask = (1 << i);
            for (int ele : nums) {
                ans |= (ele & mask);
            }
        }
        return ans;
    }

    public static int hammingDistance(int x, int y) {
        x = (x ^ y);
        y = 0;
        while (x != 0) {
            if ((x & (1)) == 1)
                y++;
            x = (x >> 1);
        }
        return y;
    }

    public static int majorityElement(int[] nums) {
        int max_ = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[max_] == nums[i])
                count++;
            else
                count--;
            if (count == 0) {
                max_ = i;
                count = 1;
            }
        }
        return nums[max_];
    }

    public static int reverseBits(int n) {

        int bits = 31;
        long ans = 0;
        while (n != 0 && bits >= 0) {
            if ((n & 1) != 0) {
                ans = ans | (1 << bits);
            }
            n = (n >> 1);
            bits--;
        }
        return (int) ans;
    }

    public static int missingNumber(int[] nums) {
        int num = nums.length;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ (i ^ nums[i]);
        }
        return num;
    }

    public static boolean isPowerOfFour(int num) {
        int count = 1;
        if ((num & (1 << 31)) != 0)
            count--;
        num = (num & (~(1 << 31)));

        if (num == 0)
            return false;
        if ((num & (num - 1)) == 0) {
            while (num > 1) {
                num = (num >> 1);
                count++;
            }
            return (count % 2) == 0 ? false : true;
        }
        return false;
    }

    public static int findComplement(int num) {
        int k = 0;
        int mask = 1;
        int ans = 0;
        while (num != 1) {
            mask = 1;
            if ((num & 1) == 0) {
                mask = (mask << k);
                ans = (ans | mask);
            }
            k++;
            num = (num >> 1);
        }
        return ans;
    }

    public static char findTheDifference(String s, String t) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = (ans ^ (s.charAt(i)) - 'a');
        }
        for (int i = 0; i < t.length(); i++) {
            ans = (ans ^ (t.charAt(i)) - 'a');
        }
        return (char) ('a' + ans);
    }

    public static int minFlips(int a, int b, int c) {
        int flips = 0;
        while (c != 0 || a != 0 || b != 0) {
            if ((c & 1) == 1 && (a & 1) == 0 && (b & 1) == 0) {
                flips++;
            } else if ((c & 1) == 0) {
                flips += (a & 1) + (b & 1);
            }
            c = (c >> 1);
            a = (a >> 1);
            b = (b >> 1);
        }
        return flips;
    }

    public static int countPrimeSetBits(int L, int R) {
        int ans = 0;
        int sbit = 0;
        for (int i = L; i <= R; i++) {
            sbit = Integer.bitCount(i);
            if (sbit == 2 || sbit == 3 || sbit == 5 || sbit == 7 || sbit == 11 || sbit == 13 || sbit == 17 || sbit == 19
                    || sbit == 23 || sbit == 29 || sbit == 31)
                ans++;
        }
        return ans;
    }
}