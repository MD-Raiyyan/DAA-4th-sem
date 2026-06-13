class MergeSort {

    static void mergeSort(int arr[], int low, int high) {

        if (low < high) {

            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    static void merge(int arr[], int low, int mid, int high) {

        // Easy to remember for lab exam
        int temp[] = new int[arr.length];

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= high)
            temp[k++] = arr[j++];

        for (i = low; i <= high; i++)
            arr[i] = temp[i];
    }

    public static void main(String args[]) {

        int arr[] = {78, 91, 65, 83, 70, 95, 69, 88};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
