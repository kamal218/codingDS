public class sorting {
    public static void main(String args[]) {
        int[] arr = { 5, 7, 8, 1, 2, 9, -8, 3, 0, 1, 7, 8, 2, 4, 6 };
        display1D(arr);
        // selectionSort(arr);
        // bubbleSort(arr);
        // insertionSort(arr);
        // mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        display1D(arr);
        /***************************************************/
        // int[] arr1 = { 3, 98, 0, 0, 0 };
        // int[] arr2 = { 9, 38, 82 };
        // mergeSortedArraysInplace(arr1, arr2, 1);
        // display1D(arr1);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length, min_idx = 0;
        for (int i = 0; i < n; i++) {
            min_idx = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            swap(arr, min_idx, i);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j])
                    swap(arr, j, j + 1);
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length, j = 0;
        for (int i = 1; i < n; i++) {
            for (j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else // condition for sorted array
                    break;
            }
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        mergeSortedArrays(arr, l, mid, r);
    }

    public static void mergeSortedArrays(int[] arr, int l, int m, int r) {
        // left-> l to mid and right-> mid+1 to r
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arr[m + j + 1];
        }
        int i = 0, j = 0, vidx = l;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[vidx] = left[i];
                i++;
                vidx++;
            } else {
                arr[vidx] = right[j];
                j++;
                vidx++;
            }
        }
        while (i < left.length) {
            arr[vidx] = left[i];
            i++;
            vidx++;
        }
        while (j < right.length) {
            arr[vidx] = right[j];
            j++;
            vidx++;
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int pivot = arr[r];
        int pidx = partition(arr, l, r, pivot);
        quickSort(arr, l, pidx - 1);
        quickSort(arr, pidx + 1, r);

    }

    public static int partition(int[] arr, int l, int r, int pivot) {
        int itr = l;
        int pidx = l;
        while (itr <= r) {
            if (arr[itr] <= pivot) {
                int temp = arr[itr];
                arr[itr] = arr[pidx];
                arr[pidx] = temp;
                pidx++;
            }
            itr++;
        }
        return pidx - 1;
    }

    /**********************************************************/

    public static void mergeSortedArraysInplace(int[] arr1, int[] arr2, int l) {
        int i = l;
        int j = arr2.length - 1;
        int vidx = arr1.length - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[vidx] = arr1[i];
                i--;
                vidx--;
            } else {
                arr1[vidx] = arr2[j];
                j--;
                vidx--;
            }
        }
        if (i < 0) {
            while (j >= 0) {
                arr1[vidx] = arr2[j];
                j--;
                vidx--;
            }
        }
    }

    /**************************************/
    public static void display1D(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}