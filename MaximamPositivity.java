public class MaximamPositivity {
    public static void main(String[] args) {
        Solution<Integer> sol = new Solution<>();
        int[] A = {1};
        Integer[] res = maxPsotivity(A);


        
        sol.printOneDArray(res);
    }

    public static Integer[] maxPsotivity(int[] A) {
        int N = A.length;

        // Step 1 : Carry forword
        int count = 0, finalCount = 0;   // to count elements.
        int start = 0, finalStart = 0;   // to note index positions.

        for (int i = 0; i < N; i++) {
            if (A[i] >= 0) {               // Positive Value
                count++;
                if (finalCount < count) {  // finalCount less than count
                    finalCount = count;
                    finalStart = start;
                }
            }
            if (A[i] < 0) {                // Nagative Value
                count = 0;
                if (i + 1 != N) {            // Edge case
                    start = i + 1;
                }
            }
        }

        // Step 2 : Creating an array of size 'finalCount'.
        Integer[] out = new Integer[finalCount];
        for (int i = 0; i < finalCount; i++) out[i] = A[i + finalStart];

        return out;
    }
}
