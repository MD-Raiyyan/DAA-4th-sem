import java.util.*;
class quicksort{
    public static void quicks(int a[],int low, int high){
        if(low<high){
            int pi = partition(a,low,high);
            quicks(a,low,pi-1);
            quicks(a,pi+1,high);
        }
    }
    public static int partition(int a[],int low,int high){
        int pivot = a[low];
        int i = low+1;
        int j = high;
        while(true){
            while(i<=high && a[i]<pivot)i++;
            while(j>=low && a[j]>pivot)j--;
            
            if(i<j){
                swap(a,i,j);
            }else{
                break;
            }
        }
        swap(a,low,j);
        return j;
    }
    public static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total no of elements in an array");
        int n = sc.nextInt();
        System.out.println("Enter "+n+" elements of the array");
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            int v = sc.nextInt();
            a[i] = v;
        }
        System.out.println("the original array is :");
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
        quicks(a,0,n-1);
        System.out.println("Sorted array :");
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
    }
}
