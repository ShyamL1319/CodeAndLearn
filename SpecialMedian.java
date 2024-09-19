import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Date: 14/01/2024:13:21
 * User: shyamlal
 * Problem Description
 * You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:
 * <p>
 * There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
 * There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
 * The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.
 * <p>
 * Return 1 if the array is special else return 0.
 * <p>
 * NOTE:
 * <p>
 * Do not neglect decimal point while calculating the median
 * For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
 * For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000000.
 * A[i] is in the range of a signed 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if the given array is special else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [4, 6, 8, 4]
 * Input 2:
 * <p>
 * A = [2, 7, 3, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explantion 1:
 * <p>
 * Here, 6 is equal to the median of [8, 4].
 * Explanation 2:
 * <p>
 * No element satisfies any condition.
 */
public class SpecialMedian {
    public static void main(String[] args) {
        int[] A = {4, 6, 8, 4};

        ArrayList<Integer> al = new ArrayList<>();
        al.add(4);
        al.add(6);
        al.add(8);
        al.add(4);
        System.out.println(solve(al));
    }

    public static int solve(ArrayList<Integer> A) {
        //Create a MaxHeap to keep track of min elements < Heap Max
        //Create a MinHeap to keep track of max elements > Heap Max

        if (RunningMedian(A) == 1) {
            return 1;
        }
        Collections.reverse(A);
        return RunningMedian(A);
    }

    public static int RunningMedian(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> MinHeap = new PriorityQueue<>();
        int n = A.size();
        maxHeap.add(A.get(0));
        double median = A.get(0); //Median variable to keep track of middle element when every element is getting included
        for (int i = 1; i < n; i++) {
            if (median == A.get(i)) { //If Median is equal to A[i], then it means the median of elements from {0 to i-1} is equal to current element
                return 1;
            }
            if (A.get(i) < maxHeap.peek()) {
                maxHeap.add(A.get(i));
            } else {
                MinHeap.add(A.get(i));
            }
            if (maxHeap.size() - MinHeap.size() > 1) { //Make sure MaxHeap size doesnt keep on increasing
                int val = maxHeap.poll();
                MinHeap.add(val);
            } else if (maxHeap.size() - MinHeap.size() < 0) { //Make sure MinHeap size doesnt keep on increasing
                int val = MinHeap.poll();
                maxHeap.add(val);
            }
            if (MinHeap.size() == maxHeap.size()) { //If both heap size are same then it has even no of elements in it
                median = (MinHeap.peek() + maxHeap.peek()) / 2.0;
            } else {// Else take the middle element as Median
                median = maxHeap.peek();
            }
        }
        return 0;
    }
}
