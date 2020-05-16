public class sorting
{
    public static void main(String args[])
    {
        int[] arr={5,7,8,1,2,9,-8,3,0,1,7,8,2,4,6};
        display1D(arr);
        // selectionSort(arr);
        // bubbleSort(arr);
        insertionSort(arr);
        display1D(arr);
    }
    public static void selectionSort(int[] arr)
    {
        int n=arr.length,min_idx=0;
        for(int i=0;i<n;i++)
        {
            min_idx=i;
            for(int j=i;j<n;j++)
            {
                if(arr[j]<arr[min_idx])
                min_idx=j;
            }
            if(min_idx==i)              // condition for sorted array
            break;
            swap(arr,min_idx,i);
        }
    }
    public static void bubbleSort(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j+1]<arr[j])
                swap(arr,j,j+1);
            }
        }
    }
    public static void insertionSort(int[] arr)
    {
        int n=arr.length,j=0;
        for(int i=1;i<n;i++)
        {
            for( j=i;j>0;j--)
            {
                if(arr[j]<arr[j-1])
                swap(arr,j,j-1);
                else                // condition for sorted array
                break;
            }
        }
    }
    public static void display1D(int[] arr)
    {
        for(int ele:arr)
        {
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    public static void swap(int[] arr,int i,int j)
    {
     int temp=arr[i];
     arr[i]=arr[j];
     arr[j]=temp;
    }
}