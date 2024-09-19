class MaxAbsoluteDifference {
    public static void main(String[] args) {
        int arr[] = {1,3,-1};
        System.out.println(maxAbsoluteDifference(arr));
    }

    static int maxAbsoluteDifference(int arr[]){
        int n = arr.length;
        int max1 = arr[0],max2=arr[0], min1=arr[0], min2=arr[0];
        for(int i=0; i < n; i++){
            int x = arr[i]+i;
            int y = arr[i]-i;
            max1 = Math.max(max1,x);
            max2 = Math.max(max2,y);
            min1 = Math.min(min1,x);
            min2 = Math.min(min2,y);
        }
        return Math.max(max1-min1,max2-min2);
    }
}