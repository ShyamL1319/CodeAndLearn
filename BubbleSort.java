public class BubbleSort {

    void sort(int arr[]){
        int size = arr.length;
        for(int i = 0; i < size; i++){
            boolean swapped = false;
            for(int k =0; k < size; k++){
                System.out.print(arr[k]+ " ");
            }
            System.out.println();
            for(int j = 1; j < (size-i); j++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
}
