import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class basicfunc {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        // basicf();
        LeetCode();
    }

    /**********************************************************************************/
    public static void basicf() {
        // MIN_MAX
        /*
         * int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; int[] ans = min_max(arr);
         * System.out.print("min->" + ans[0] + "\n" + "max->" + ans[1]);
         */

        // All index
        /*
         * int[] arr = { 1, 2, 3, 4, 4, 4, 5, 6, 7, 4, 4, 6, 4, 4 }; ArrayList<Integer>
         * indices = findAllIndex(arr, 4); for (Integer index : indices) {
         * System.out.print(index + " "); }
         */

        // Reverse array
        /*
         * int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 }; revArray(arr); display1D(arr);
         */

        // Matrix

        int[][] mat = { { 1, 2, 3 }, { 2, 3, 4 }, { 4, 5, 6 } };
        int[][] hmat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // addTwoMatrix(mat, hmat);
        // transposeMatrix(mat);
        // multiplyMatrix(mat, hmat);
        wavePrint(mat);
        // display2D(matrix);

    }

    public static int[] min_max(int[] arr) {
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ans[1] = Integer.MIN_VALUE;
        for (int ele : arr) {
            ans[0] = Math.min(ans[0], ele);
            ans[1] = Math.max(ans[1], ele);
        }
        return ans;
    }

    public static ArrayList<Integer> findAllIndex(int[] arr, int val) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                ans.add(i);
        }
        return ans;
    }

    public static void revArray(int[] arr) {
        int si = 0, ei = arr.length - 1;
        while (si < ei) {
            swapf(arr, si, ei);
            si++;
            ei--;
        }
    }

    public void rotateArray(int[] nums, int k) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }

    }

    void rotateArrayWithoutSpace(int[] nums, int k) {
        int len = nums.length;
        k = (k % len);
        if (k == 0)
            return;
        k = (len - k);
        revValue(nums, 0, k - 1);
        revValue(nums, k, len - 1);
        revValue(nums, 0, len - 1);

    }

    void revValue(int[] arr, int si, int ei) {

        while (si <= ei) {
            {
                int temp = arr[si];
                arr[si] = arr[ei];
                arr[ei] = temp;
            }
            si++;
            ei--;
        }
    }

    public int searchInRotatedArry(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int si = 0;
        int ei = nums.length - 1;
        int last = nums[ei];
        while (si <= ei) {
            int mid = si - ((si - ei) >> 1);
            if (nums[mid] <= last) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        if (ei == -1 || si == nums.length) {
            si = 0;
            ei = nums.length - 1;
        } else if (target <= last && target >= nums[si])
            ei = nums.length - 1;
        else
            si = 0;
        while (si <= ei) {
            int mid = si - ((si - ei) / 2);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                si = mid + 1;
            else
                ei = mid - 1;
        }
        return -1;
    }

    public static void addTwoMatrix(int[][] mat1, int[][] mat2) {
        int[][] ans = new int[mat1.length][mat1[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                ans[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        display2D(ans);
    }

    public static void transposeMatrix(int[][] mat) {
        // int[][] ans=new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i <= j)
                    swap2D(mat, i, j); // Extra space ans[j][i]=mat[i][j];
            }
        }
        display2D(mat);
    }

    public static void multiplyMatrix(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length;
        int r2 = mat2.length;
        int c1 = mat1[0].length;
        int c2 = mat2[0].length;
        int sum = 0;
        if (c2 != r1) {
            System.out.println("\n" + " \t OOPS! Matrices cannot be multiplies");
            return;
        }
        int[][] ans = new int[r1][c2];
        for (int i = 0; i < ans.length; i++) {
            sum = 0;
            for (int j = 0; j < ans[0].length; j++) {
                for (int k = 0; k < c1; k++) {
                    sum += (mat1[i][k] * mat2[k][j]);
                }
                ans[i][j] = sum;
            }
        }
        display2D(ans);
    }

    public static void wavePrint(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (i % 2 == 0) // if(i==0 || (i&(i-1))!=0) // more faster method to find %2 then previous
            {
                for (int j = 0; j < mat[0].length; j++)
                    System.out.print(mat[i][j] + " ");
            } else {
                for (int j = mat[0].length - 1; j >= 0; j--) {
                    System.out.print(mat[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    /***************************************************************************/
    public static void LeetCode() {
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // Rotate Array
        /*
         * rotateArray(arr,3); for (int ele : arr) System.out.print(ele + " ");
         */

        // without space

        /*
         * rotateArrayWithoutSpace(arr,3);for (int ele : arr) System.out.print(ele +
         * " ");
         */

        // SEARCH IN ROTATEDARRAY
        /*
         * rotateArray(arr,3); return searchInRotatedArry(arr,4);
         */

        // LEETCODE 1431
        /*
         * int[] candies={2,3,5,3,0}; ArrayList<Boolean> ans=kidsWithCandies(candies,3);
         * for(Boolean ele:ans) { System.out.println(ele+" "); }
         */
        // LEETCODE 1313

        /*
         * int[] arr={1,2,3,4}; int[] ans=decompressRLElist(arr); display1D(ans);
         */
        // LEETCODE 1295
        /*
         * int[] nums = { 1, 154, 0, 22, 44, 7893 };
         * System.out.println(findNumbers(nums));
         */
        // LEETCODE 1266
        /*
         * int[][] arr = { { 1, 1 }, { 3, 4 }, { -1, 0 } };
         * System.out.println(minTimeToVisitAllPoints(arr));
         */
        // LEETCODE 1252
        /*
         * int[][] indices = { { 0, 1 }, { 1, 0 } }; System.out.println((oddCells(2, 3,
         * indices)));
         */
        // LEETCODE 1299
        /*
         * int[] arr = { 88, 5, 6, 99, 4, 2 }; display1D(replaceElements(arr));
         */
        // LEETCODE 1304
        /*
         * display1D(sumZero(10));
         */
        // LEETCODE832
        /*
         * int[][] arr={{1,1,0},{1,0,1},{0,0,0}}; display2D(flipAndInvertImage(arr));
         */
        // LEETCODE 1351
        /*
         * int[][] grid={{3,2},{1,0}}; System.out.println(countNegatives(grid));
         */
        // LEETCODE 905
        /*
         * int[] arr={3,1,2,4}; display1D(sortArrayByParity(arr));
         */
        // LEETCODE1380
        /*
         * int[][] matrix = { { 7, 8 }, { 1, 2 } }; ArrayList<Integer> ans =
         * luckyNumbers(matrix); System.out.println(ans);
         */
        // LEETCODE977
        /*
         * int[] arr={-4,-3,1,3,5}; display1D(arr);
         */
        // LEETCODE 561
        /*
         * int[] nums={2,2,4,5,7,8,3,4,5,7}; System.out.println(arrayPairSum(nums));
         */
        // LEETCODE 922
        innt[] arr = { 4, 2, 3, 5 };
        display1D(arr);
    }

    public static ArrayList<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> ans = new ArrayList<Boolean>();
        int max_ = Integer.MIN_VALUE;
        for (int ele : candies) {
            if (ele > max_)
                max_ = ele;
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max_)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }

    public static int[] decompressRLElist(int[] nums) {
        int size_ = 0;
        for (int i = 0; i < nums.length; i += 2)
            size_ += nums[i];
        int[] ans = new int[size_];
        int idx = 0;
        for (int i = 0, j = 1; i < nums.length; i += 2, j += 2) {
            while (nums[i] != 0) {
                ans[idx] = nums[j];
                nums[i]--;
                idx++;
            }
        }
        return ans;
    }

    public static int findNumbers(int[] nums) {
        int ans = 0;
        for (int ele : nums) {
            if (digits(ele) % 2 == 0)
                ans++;
        }
        return ans;
    }

    public static int digits(int n) {
        int dig = 0;
        while (n != 0) {
            dig++;
            n /= 10;
        }
        return dig;
    }

    // public int findNumbers(int[] nums) {
    // int ans=0;
    // for(int ele:nums)
    // {
    // if((ele>=10 && ele<=99) || (ele>=1000 && ele<=9999) || ele==100000)
    // ans++;
    // }
    // return ans;
    // }
    public static int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 0)
            return 0;
        int ans = 0;

        for (int i = 1; i < points.length; i++) {
            ans += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }
        return ans;
    }

    public static int oddCells(int n, int m, int[][] indices) {
        Boolean[] isevencol = new Boolean[m];
        Boolean[] isevenrow = new Boolean[n];
        Arrays.fill(isevenrow, false);
        Arrays.fill(isevencol, false);
        int hitrow = 0;
        int ans = 0;
        for (int i = 0; i < indices.length; i++) {
            if (!isevenrow[indices[i][0]]) {
                ans += m;
                hitrow++;
                isevenrow[indices[i][0]] = true;
            } else {
                ans -= m;
                hitrow--;
                isevenrow[indices[i][0]] = false;
            }
        }
        for (int i = 0; i < indices.length; i++) {
            if (!isevencol[indices[i][1]]) {
                ans += (n - hitrow) - hitrow;
                isevencol[indices[i][1]] = true;
            } else {
                ans = ans - (n - hitrow) + hitrow;
                isevencol[indices[i][1]] = false;
            }
        }
        return ans;

    }

    public static int[] replaceElements(int[] arr) {
        int max_ = Integer.MIN_VALUE;
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = -1;
        max_ = Math.max(max_, arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            ans[i] = max_;
            max_ = Math.max(max_, arr[i]);
        }
        return ans;
    }

    public static int[] sumZero(int n) {
        int[] ans = new int[n];
        int i = 0;
        for (i = 0; i < (n / 2); i++) {
            ans[i] = -((n / 2) - i);
        }
        int j = i - 1;
        if (n % 2 != 0) {
            ans[i] = 0;
            i++;
        }

        while (j >= 0) {
            ans[i] = -(ans[j]);
            j--;
            i++;
        }
        return ans;
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int si = 0;
        int ei = A[0].length - 1;
        for (int[] arr : A) {
            si = 0;
            ei = A[0].length - 1;
            while (si <= ei) {
                if (arr[si] == arr[ei]) {
                    if (si == ei) {
                        arr[si] = (arr[si] == 0 ? 1 : 0);
                    } else {
                        arr[si] = (arr[si] == 0 ? 1 : 0);
                        arr[ei] = (arr[ei] == 0 ? 1 : 0);
                    }
                }
                si++;
                ei--;
            }
        }
        return A;

    }

    public static int countNegatives(int[][] grid) {
        int ans = 0;
        int si = 0;
        int ei = 0, mid = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] < 0) {
                ans += (row - i) * col;
                break;
            } else if (grid[i][col - 1] >= 0) {
                continue;
            } else {
                si = 0;
                ei = col - 1;
                while (si <= ei) {
                    mid = (si + ei) / 2;
                    if (grid[i][mid] < 0)
                        ei = mid - 1;
                    else
                        si = mid + 1;
                }
                ans += (col - (si));
            }
        }
        return ans;
    }

    public static int[] sortArrayByParity(int[] A) {
        int i = 0, j = 0;
        for (int ele : A) {
            if ((A[j] & 1) == 0) {
                swapf(A, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }
        return A;
    }

    public static ArrayList<Integer> luckyNumbers(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        int[] min_row = new int[row];
        int min_ = 0;
        for (int i = 0; i < row; i++) {
            min_ = Integer.MAX_VALUE;
            for (int j = 0; j < col; j++) {
                min_ = Math.min(min_, matrix[i][j]);
            }
            min_row[i] = min_;
        }
        int max_ = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            max_ = Integer.MIN_VALUE;
            for (int j = 0; j < row; j++) {
                max_ = Math.max(max_, matrix[j][i]);
            }
            for (int k = 0; k < min_row.length; k++) {
                if (max_ == min_row[k])
                    ans.add(max_);
            }
        }
        return ans;
    }

    public static int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int neg = 0, pos = 0, idx = 0;
        while (pos < A.length && A[pos] < 0) {
            pos++;
        }
        neg = pos - 1;
        if (neg == -1) {
            for (int i = 0; i < A.length; i++)
                ans[i] = A[i] * A[i];
        } else if (pos == A.length) {
            for (int i = A.length - 1; i >= 0; i--)
                ans[A.length - i - 1] = A[i] * A[i];
        } else {

            while (pos < A.length && neg >= 0) {
                if (A[pos] * A[pos] > A[neg] * A[neg]) {
                    ans[idx] = A[neg] * A[neg];
                    neg--;
                    idx++;
                } else if (A[pos] * A[pos] < A[neg] * A[neg]) {
                    ans[idx] = A[pos] * A[pos];
                    pos++;
                    idx++;
                } else {
                    ans[idx] = A[pos] * A[pos];
                    ans[idx + 1] = A[pos] * A[pos];
                    neg--;
                    pos++;
                    idx += 2;
                }
            }
            if (pos == A.length) {
                while (neg >= 0) {
                    ans[idx] = A[neg] * A[neg];
                    idx++;
                    neg--;
                }
            } else if (neg < 0) {
                while (pos < A.length) {
                    ans[idx] = A[pos] * A[pos];
                    pos++;
                    idx++;
                }
            }
        }
        return ans;
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += Math.min(nums[i], nums[i + 1]);
        }
        return ans;
    }

    public static int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int even = 0;
        int odd = 0;
        while (i < A.length && j < A.length) {
            even = A[i] % 2;
            odd = A[j] % 2;
            if (even != 0 && odd == 0) {
                swapf(A, i, j);
                i += 2;
                j += 2;
            } else if (even != 0) {
                j += 2;
            } else {
                i += 2;
            }

        }
        return A;
    }

    // *****************************************************************//
    // Helper functions

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
    // *****************************************************************/
}