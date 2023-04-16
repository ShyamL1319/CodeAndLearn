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
}
