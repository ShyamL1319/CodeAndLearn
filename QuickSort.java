public class QuickSort {
    void sort(int arr[]){
            quickSort(arr,0, arr.length-1);
    }

    void quickSort(int arr[], int low, int high){

        if(low < high){
            int pivot = partition(arr,low,high);
            System.out.println(" <<<<<<<<<==================>>>>>>>>  "+pivot);
            quickSort(arr,low,pivot-1);
            quickSort(arr, pivot+1, high);
        }
        return;
    }

    int partition(int arr[], int low, int high){
        int j=low-1;
        int pivot = arr[high];

        for(int i = low; i < high; i++){
            if(arr[i] <= pivot ){
                j++;
                swap(arr,j,i);
            }
        }

        swap(arr,j+1,high);
        return j+1;
    }

    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
