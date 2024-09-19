/**
 * Problem Description
 * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an
 * element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 * Sum of all elements of A <= 109
 * <p>
 * <p>
 * Input Format
 * First argument contains an array A of integers of size N
 * <p>
 * <p>
 * Output Format
 * Return the count of array indices such that removing an element from these indices makes the
 * sum of even-indexed and odd-indexed array elements equal.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [2, 1, 6, 4]
 * Input 2:
 * <p>
 * A = [1, 1, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
 * Therefore, the required output is 1.
 * Explanation 2:
 * <p>
 * Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Therefore, the required output is 3.
 */
public class SpecialIndex {
    public static void main(String[] args) {
        int[] A = {2, 1, 6, 4};
        System.out.println(solve(A));


    }

    public static int solve(int[] A) {
        int result = 0;
        int evenSum = 0, oddSum = 0, tempEvenSum = 0, tempOddSum = 0;

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                evenSum += A[i];
            } else {
                oddSum += A[i];
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                evenSum -= A[i];
                if ((evenSum + tempOddSum) == (oddSum + tempEvenSum)) {
                    result += 1;
                }
                tempEvenSum += A[i];
            } else {
                oddSum -= A[i];
                if ((evenSum + tempOddSum) == (oddSum + tempEvenSum)) {
                    result += 1;
                }
                tempOddSum += A[i];
            }

        }

        // for(int i=0; i< A.length; i++){
        //     int evenSum = 0;
        //     int oddSum = 0;
        //     for(int j=0; j< A.length; j++){
        //         if(j != i){
        //             if( j > i && j % 2 == 0 ){
        //                 oddSum += A[j];
        //             }else if ( j < i && j % 2 == 0 ){
        //                 evenSum += A[j];
        //             }else if (j > i && j % 2 != 0){
        //                 evenSum += A[j];
        //             }else{
        //                 oddSum += A[j];
        //             }
        //         }
        //     }
        //     if(oddSum == evenSum){
        //         result += 1;
        //     }
        // }
        return result;


    }

}
