public class MergeSort {

    public int [] sort(int arr[]){
        int l = 0;
        int r = arr.length-1;
        mergeSort(arr,l,r);
        return arr;
    }


    private void mergeSort( int arr[], int l, int r){
        if(l < r){
            int mid = l+(r-l)/2;
            mergeSort(arr, 0, mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    private void merge(int arr[], int l, int mid, int r){
        int size = r-l+1;
        int []temp = new int [size];

        int i =l,j=mid+1,k=0;

        while(i<=mid && j<=r){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                k++;i++;
            }else{
                temp[k] = arr[j];
                k++; j++;
            }
        }

        while(i <= mid){
            temp[k] = arr[i];
            k++;i++;
        }

        while(j <= r){
            temp[k] = arr[j];
            j++;k++;
        }

        for(i=l; i <= r; i++){
            arr[i] = temp[i-l];
        }
    }
}
