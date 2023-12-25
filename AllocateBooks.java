/**
 * Date: 25/12/2023:05:28
 * User: shyamlal
 * Problem Description
 * Given an array of integers A of size N and an integer B.
 * <p>
 * The College library has N books. The ith book has A[i] number of pages.
 * <p>
 * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
 * <p>
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 * <p>
 * NOTE: Return -1 if a valid assignment is not possible.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i], B <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return that minimum possible number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [12, 34, 67, 90]
 * B = 2
 * Input 2:
 * A = [12, 15, 78]
 * B = 4
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 113
 * Output 2:
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * There are two students. Books can be distributed in following fashion :
 * 1)  [12] and [34, 67, 90]
 * Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 * 2)  [12, 34] and [67, 90]
 * Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 * 3)  [12, 34, 67] and [90]
 * Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 * Explanation 2:
 * Each student has to be allocated at least one book.
 * But the Total number of books is less than the number of students.
 * Thus each student cannot be allocated to atleast one book.
 * <p>
 * Therefore, the result is -1.
 */
public class AllocateBooks {
    public static void main(String[] args) {
        int[] A = {12, 34, 67, 90};
        int B = 2;
        System.out.println(books(A, B));
    }

    public static boolean isFeasible(int[] arr, int stds, int pages) {
        int req = 1, sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] <= pages) {
                sum += arr[i];
            } else {
                req++;
                sum = arr[i];
            }
        }
        return (req <= stds);
    }

    public static int books(int[] A, int B) {
        int n = A.length;
        if (n < B) {  //edge case
            return -1;
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + A[i];
            max = Math.max(max, A[i]);
        }
        int low = max, high = sum, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(A, B, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

}
