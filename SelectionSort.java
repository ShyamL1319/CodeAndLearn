import java.util.ArrayList;

public class SelectionSort {
    void sort(int arr[]){
        for (int i = 0; i< arr.length; i++){
            int min_idx = i;
            for(int j = i+1; j < arr.length; j++ ){
                if(arr[min_idx] > arr[j]){
                    min_idx = j;
                }
            }
            if(i != min_idx){
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }
        }
    }


    ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    // Lets say performOps was called with A : [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]] .

    //What would be the output of the following call :


    ArrayList<Integer> performOps2(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }
//
//    Lets say performOps was called with A : [5, 10, 2, 1].
//    What would be the output of the following call :


}
