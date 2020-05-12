import java.util.Scanner;
import java.util.ArrayList;

public class basicfunc {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        basicf();
    }

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
         * int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 }; revArray(arr); for (int ele : arr)
         * System.out.print(ele + " ");
         */

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

    public static void swapf(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
}