import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.util.ArrayList;

public class basicfunc {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        basicf();
        // LeetCode();
    }

    /***************************************
     * BASIC FUNCTIONS IN ARRAY
     ***************************************/
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
        // int[][] hmat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // addTwoMatrix(mat, hmat);
        // transposeMatrix(mat);
        // multiplyMatrix(mat, hmat);
        // wavePrint(mat);
        spiralPrint(mat);
        // int[][] mat={{0,0,0,1},{0,1,0,1},{0,0,0,0},{0,0,0,0}};
        // display1D(exitPoint1(mat));
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

    public static int[] exitPoint(int[][] mat) {
        int[] ans = new int[2];
        int row = mat.length, col = mat[0].length, r = 0, c = 0;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int cdir = 0;
        while (true) {
            cdir %= dir.length;
            if (cdir == 0) {
                while (mat[r][c] != 1) {
                    c += dir[cdir][1];
                    if (c == col) {
                        ans[0] = r;
                        ans[1] = c;
                        return ans;
                    }
                }
                cdir += 1;
            } else if (cdir == 1) {
                while (mat[r][c] != 1) {
                    r += dir[cdir][0];
                    if (r == row) {
                        ans[0] = row;
                        ans[1] = col;
                        return ans;
                    }
                }
                cdir += 1;
            } else if (cdir == 2) {
                while (mat[r][c] != 1) {
                    c += dir[cdir][1];
                    if (c == -1) {
                        ans[0] = row;
                        ans[1] = col;
                        return ans;
                    }
                }
                cdir += 1;
            } else {
                while (mat[r][c] != 1) {
                    r -= dir[cdir][1];
                    if (r == -1) {
                        ans[0] = row;
                        ans[1] = col;
                        return ans;
                    }
                }
                cdir += 1;
            }
        }
    }

    public static int[] exitPoint1(int[][] mat) {
        int r = 0, c = 0, dir = 0;
        while (true) {
            dir = (dir + mat[r][c]) % 4;
            if (dir == 0) {
                c++;
                if (c == mat[0].length) {
                    c--;
                    break;
                }
            } else if (dir == 1) {
                r++;
                if (r == mat.length) {
                    r--;
                    break;
                }
            } else if (dir == 2) {
                c--;
                if (c == -1) {
                    c++;
                    break;
                }
            } else {
                r--;
                if (r == -1) {
                    r++;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = r;
        ans[1] = c;
        return ans;
    }

    public static void spiralPrint(int[][] mat) {
        int rmin = 0, cmin = 0, rmax = mat.length - 1, cmax = mat[0].length - 1;
        int tne = (cmax + 1) * (rmax + 1);
        while (tne > 0) {
            for (int i = cmin; i <= cmax && tne > 0; i++) {
                System.out.print(mat[rmin][i] + " ");
                tne--;
            }
            rmin++;
            for (int i = rmin; i <= rmax && tne > 0; i++) {
                System.out.print(mat[i][cmax] + " ");
                tne--;
            }
            cmax--;
            for (int i = cmax; i >= cmin && tne > 0; i--) {
                System.out.print(mat[rmax][i] + " ");
                tne--;
            }
            rmax--;
            for (int i = rmax; i >= rmin && tne > 0; i++) {
                System.out.print(mat[i][cmin] + " ");
                tne--;
            }
            cmin++;
        }
    }

    /********************** LEETCODE QUESTIONS ************************************/
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
        /*
         * int[] arr = { 4, 2, 3, 5 }; display1D(arr);
         */
        // LEETCODE1
        /*
         * int[] nums={2,3,4}; display1D(twoSum(nums,6));
         */
        // LEETCODE 1450
        /*
         * int[] startTime={1,2,3}; int[] endTime={10,5,12};
         * System.out.println(busyStudent(startTime, endTime, 4));
         */
        // LEETCODE 1122
        /*
         * int[] arr1={2,3,1,3,2,4,6,7,9,2,19}; int[] arr2={2,1,4,3,9,6}
         * display1D(relativeSortArray(arr1, arr2)); display1D(relativeSortArray2(arr1,
         * arr2)); //faster the above method no need of sorting
         */
        // LEETCODE 1160
        /*
         * String[] words= {"cat","bt","hat","tree"}; String chars="atach";
         * System.out.println(countCharacters(words, chars));
         */
        // LEETCODE 1200
        /*
         * int[] arr={40,11,26,27,-20}; displayArrayList2D(minimumAbsDifference(arr));
         */
        // LEETCODE 1394
        /*
         * int[] arr={2,2,2,3,3}; System.out.println(findLucky(arr));
         * System.out.println(findLuckyNoHashMap(arr));
         */
        // LEETCODE 1413
        int[] nums={-3,2,-3,4,2};
        System.out.println(minStartValue(nums));

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

    public int findNumbers1(int[] nums) {
        int ans = 0;
        for (int ele : nums) {
            if ((ele >= 10 && ele <= 99) || (ele >= 1000 && ele <= 9999) || ele == 100000)
                ans++;
        }
        return ans;
    }

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

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.size() == 0)
                map.put(nums[i], i);
            else {
                if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                    ans[0] = map.get(target - nums[i]);
                    ans[1] = i;
                    break;
                }
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] == queryTime || endTime[i] == queryTime
                    || (startTime[i] < queryTime && endTime[i] > queryTime))
                ans += 1;
        }
        return ans;
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        int[] ans = new int[arr1.length];
        int idx = 0;
        for (int ele : arr2) {
            for (int i = 0; i < map.get(ele); i++)
                ans[idx++] = ele;
            map.remove(ele);
        }
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                for (int j = 0; j < map.get(arr1[i]); j++) {
                    ans[idx++] = arr1[i];
                }
                map.remove(arr1[i]);
            }
        }
        return ans;
    }

    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        int[] ans = new int[arr1.length];
        int idx = 0;
        for (int ele : arr2) {
            for (int i = 0; i < map.get(ele); i++)
                ans[idx++] = ele;
            map.remove(ele);
        }
        int[] arr = new int[ans.length - idx];
        int idx1 = 0;
        for (Integer ele : map.keySet()) {
            for (int i = 0; i < map.get(ele); i++) {
                arr[idx1++] = ele;
            }
        }
        idx1 = 0;
        Arrays.sort(arr);
        for (int i = idx; i < ans.length; i++) {
            ans[i] = arr[idx1++];
        }
        return ans;
    }

    public static int countCharacters(String[] words, String chars) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
        }
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            for (Character ch : map.keySet())
                temp.put(ch, map.get(ch));
            for (j = 0; j < words[i].length(); j++) {
                if (temp.containsKey(words[i].charAt(j)) && temp.get(words[i].charAt(j)) != 0) {
                    temp.put(words[i].charAt(j), temp.get(words[i].charAt(j)) - 1);
                } else
                    break;
            }
            if (j == words[i].length())
                ans += words[i].length();
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int min_ = 1452145;
        for (int i = 0; i < arr.length - 1; i++) {
            min_ = Math.min(min_, arr[i + 1] - arr[i]);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] <= min_) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                ans.add(list);
            }
        }
        return ans;
    }

    public static int findLucky(int[] arr) {
        int ans = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == key)
                ans = Math.max(ans, key);
        }
        return ans;
    }

    public static int findLuckyNoHashMap(int[] arr) {
        int ans = -1, ct = 1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            ct = 1;
            while (i + 1 < arr.length && arr[i + 1] == arr[i]) {
                ct++;
                i++;
            }
            if (ct == arr[i] && ct > ans)
                ans = ct;

        }
        return ans;
    }

    public static int minStartValue(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int ps = 0;
        for (int i = 0; i < nums.length; i++) {
            ps += nums[i];
            ans = Math.min(ps, ans);
        }
        return ans > 0 ? 1 : ((-ans) + 1);
    }

    // ******************************// Helper
    // functions***********************************//

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
            for (int j = 0; j < list.get(i).length; j++) {
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
    // *****************************************************************/
}