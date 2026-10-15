public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxCnt = 0;

        for (int n : nums) {
            if (n == 0) {
                maxCnt = Math.max(cnt, maxCnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        maxCnt = Math.max(cnt, maxCnt);
        return maxCnt;
    }
}
