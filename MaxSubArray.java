public class MaxSubArray {
    /*
Problem Description
You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.


Problem Constraints
1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106


Input Format
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.


Output Format
Return a single integer which denotes the maximum sum.


Example Input
Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
Input 2:

A = 3
B = 1
C = [2, 2, 2]


Example Output
Output 1:
12
Output 2:
0
 */


    public static void main(String[] args) {
//        int a = 95;
//        int b = 1711;
//        int c[] = {68,39,12,51,52,39,58,12,74,78,49,41,25,44,49,40,41,94,37,92,15,23,6,6,85,99,34,23,94,49,94,89,65,64,53,21,24,90,22,100,34,20,73,10,14,50,75,47,79,43,93,10,72,10,20,96,11,85,47,9,39,91,68,86,4,5,72,59,37,50,62,37,64,7,96,72,64,73,67,51,8,34,24,5,28,88,100,52,82,30,28,61,88,89,42};

        int a = 68;
        int b = 3030;
        int[] c = {2, 89, 77, 40, 55, 7, 25, 62, 59, 83, 56, 23, 78, 77, 33, 89, 62, 77, 26, 47, 80, 37, 38, 74, 58, 76, 73, 30, 12, 84, 55, 36, 19, 71, 35, 62, 81, 74, 12, 39, 70, 31, 57, 85, 71, 45, 8, 73, 65, 94, 21, 22, 82, 1, 9, 71, 44, 94, 59, 7, 51, 55, 12, 11, 60, 24, 35, 79};


        System.out.println(maxSubarray(a, b, c));
    }


    public static int maxSubarray(int A, int B, int[] C) {
        int leftidx = -1;
        int maxSubSum = 0;
        int currentSum = 0;
        for (int i = 0; i < A; i++) {
            currentSum += C[i];
            if (currentSum <= B && currentSum >= maxSubSum) {
                maxSubSum = currentSum;
                System.out.println("If i =" + i + " leftidx = " + leftidx + " currentSum = " + currentSum + " maxSubSum = " + maxSubSum);
            } else {
                while (leftidx < i && currentSum > maxSubSum) {
                    currentSum -= C[++leftidx];
                    if (currentSum <= B && currentSum > maxSubSum) {
                        maxSubSum = currentSum;
                    }
                    System.out.println(" Else i =" + i + " leftidx = " + leftidx + " currentSum = " + currentSum + " maxSubSum = " + maxSubSum);
                }
            }
        }
        return maxSubSum;
    }

}
