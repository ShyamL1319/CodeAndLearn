import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public long power(int a, int b){
        if(b == 0) return 1;
        if(b%2 == 0) return power(a,b/2) * power(a,b/2);
        else{
            return a * power(a,b/2) * power(a,b/2);
        }
    }

    public String subArrayEnn(int arr[]){
        /*
        Problem Statement
        You are given an integer array A.
        Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.
        Return "YES" if it is possible; otherwise, return "NO" (without quotes).
         */
        int inArr[] = {978, 847, 95, 729, 778, 586, 188,
                782, 813, 870, 871, 940, 312, 693, 580, 101,
                760, 837, 564, 633, 680, 155, 241, 374, 682,
                290, 850, 601, 433, 922, 773, 959, 530, 290,
                990, 50, 516, 409, 868, 131, 664, 851, 721,
                880, 20, 450, 745, 387, 787, 823, 392, 242,
                674, 347, 65, 135, 819, 324, 651, 678, 139, 940 };
        int len = inArr.length;
        if(len % 2 != 0 ) return "NO";
        if(inArr[0] % 2 == 0 && inArr[len-1] % 2 == 0) return "YES";
        return "NO";
    }
    public static void main(String args[]){
//        System.out.println(bulbSwitch(5));
//        int a = 95;
//        int b = 1711;
//        int c[] = {68,39,12,51,52,39,58,12,74,78,49,41,25,44,49,40,41,94,37,92,15,23,6,6,85,99,34,23,94,49,94,89,65,64,53,21,24,90,22,100,34,20,73,10,14,50,75,47,79,43,93,10,72,10,20,96,11,85,47,9,39,91,68,86,4,5,72,59,37,50,62,37,64,7,96,72,64,73,67,51,8,34,24,5,28,88,100,52,82,30,28,61,88,89,42};
//
//
//        int a = 68;
//        int b = 3030;
//        int c[] = {2,89,77,40,55,7,25,62,59,83,56,23,78,77,33,89,62,77,26,47,80,37,38,74,58,76,73,30,12,84,55,36,19,71,35,62,81,74,12,39,70,31,57,85,71,45,8,73,65,94,21,22,82,1,9,71,44,94,59,7,51,55,12,11,60,24,35,79};
//        System.out.println(maxSubarray(a,b,c));

//        int arr[] = {1,2,3};
//        int resArr[][] = allSubArrays(arr);
//        for(int i=0; i< resArr.length; i++){
//            int innL = resArr[i].length;
//            for(int j =0; j<innL; j++){
//                System.out.print(resArr[i][j]+" ");
//            }
//            System.out.println();
//        }
            int A[] = {1, 0, 1, 0, 1};
            int B=1;
            int [] result =  alternatingSubarrays(A,B);
            System.out.println(Arrays.toString(result));
    }
    public static int bulbSwitch(int n) {
        int count = 1;
        while( (count * count) < n){
            count += 1;
        }
        return count-1;
    }

    public static int maxSubarray(int A, int B, int[] C) {
        int leftidx = -1;
        int maxSubSum = 0;
        int currentSum = 0;
        for(int i=0; i<A; i++){
            currentSum += C[i];
            if(currentSum <= B && currentSum >= maxSubSum){
                maxSubSum = currentSum;
                System.out.println("If i =" + i + " leftidx = "+leftidx + " currentSum = " + currentSum + " maxSubSum = " +  maxSubSum );
            }else{
                while(leftidx < i && currentSum > maxSubSum){
                    currentSum -= C[++leftidx];
                    if(currentSum <= B &&  currentSum > maxSubSum){
                        maxSubSum = currentSum;
                    }
                    System.out.println(" Else i =" + i + " leftidx = "+leftidx + " currentSum = "+ currentSum + " maxSubSum = " +  maxSubSum );
                }
            }
        }
        return maxSubSum;
    }



    public static int[][] allSubArrays(int[] A) {
        int n = A.length;
        int N = n*(n+1)/2;
        int result[][] = new int[N][];
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=i; j <n; j++){
                int resArr[] = new int[j-i+1];
                for(int k=i; k<=j; k++){
                    resArr[k-i] = A[k];
                }
                if(cnt < N){
                    result[cnt] = resArr;
                    cnt += 1;
                }
            }
        }
        return result;
    }


    public static int[] alternatingSubarrays(int[] A, int B) {
        int len = A.length;
        List<Integer> res = new ArrayList<>();
        if(B==0){
            for(int i=0; i<len; i++){
                res.add(i);
            }
            return  res.stream().mapToInt(i -> i).toArray();
        }
        int K = 2*B+1;
        for(int i=0; i<=(len-K); i++){
            int start = i;
            int end = i+K;
            boolean ulternating = true;

            for(int k = start+1; k < end; k++){
                if(A[k-1] == A[k]) ulternating = false;
            }
            if(ulternating) res.add(start+B);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
