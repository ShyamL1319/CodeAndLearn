import java.lang.reflect.Array;

public class InsertionSort {

    public int[] solve(int arr[]){
        int length = arr.length;
        int key, index;
        for(int i = 1; i< length; i++){
            key = arr[i];
            index = i;
            while(index > 0 && key < arr[index-1]) {
                arr[index] = arr[--index];
            }
            arr[index] = key;
        }
        return arr;
    }
}
