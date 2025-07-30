import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Date: 27/12/2023:09:12
 * User: shyamlal
 * Problem Description
 * Determine the "GOOD"ness of x given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters. The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
 * <p>
 * Your task is to return an integer representing the "GOOD"ness of string A.
 * <p>
 * Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size(A) <= 106
 * <p>
 * String consists of lowerCase,upperCase characters and digits are also present in the string A.
 * <p>
 * <p>
 * <p>
 * Input Format
 * Single Argument representing string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the maximum possible length of substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abcabcbb"
 * Input 2:
 * <p>
 * A = "AaaA"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Substring "abc" is the longest substring without repeating characters in string A.
 * Explanation 2:
 * <p>
 * Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String A = "pwwkew";
        int []arr1 = new int[]{1,2};
        int []arr2 = new int[]{3};
//        [1,2,3,4,5,6,7]
//        3
//                [-1,-100,3,99]
//        2
//        System.out.println(threeSum(new int []{-1,0,1,2,-1,-4}));
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.<Integer>asList(new Integer[]{1,2,3,5}));
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.<Integer>asList(new Integer[]{1,2,3,5}));
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>(Arrays.<Integer>asList(new Integer[]{1,2,3,5}));
        Set<ArrayList<Integer>> set = new HashSet<>();
        set.add(arrayList);
        set.add(arrayList2);
//        set.add(arrayList3);
//        System.out.println(set.contains(arrayList3));
//        System.out.println(Math.abs(9-101));

        LongestSubstringWithoutRepeat runner = new LongestSubstringWithoutRepeat();
        System.out.println(runner.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, 0));
    }

    public static int lengthOfLongestSubstring(String A) {
        int N = A.length();
        int ans = 0;
        //int c = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        for (int i = 0; i < N; i++) {
            char ch = A.charAt(i);
            if (hm.containsKey(ch)) {
               left =  Math.max(hm.get(ch) + 1, left);
            }
            hm.put(ch, i);
            ans = Math.max(ans, i-left+1) ;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        char [] chstr = s.toCharArray();
        Queue<Character> q = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        int size = 0;
        for(char chr : chstr){
            if(set.contains(chr)){
                size = Math.max(size, set.size());
                char chrt = q.poll();
                while(!q.isEmpty() && chr != chrt ){
                    set.remove(chrt);
                    chrt = q.poll();
                }
            }
            q.add(chr);
            set.add(chr);
        }
        return Math.max(size, set.size());
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums2.length + nums1.length;
        int []newArr = new int[len];
        int idx = 0;
        int nidx1 = 0;
        int nidx2 = 0;
        while(nums1.length > nidx1 && nums2.length > nidx2){
            newArr[idx++] = nums1[nidx1] < nums2[nidx2] ? nums1[nidx1++] : nums2[nidx2++];
        }

        while (nums1.length > nidx1){
            newArr[idx++] = nums1[nidx1++];
        }

        while (nums2.length > nidx2){
            newArr[idx++] = nums2[nidx2++];
        }
        System.out.println(Arrays.toString(newArr));
        System.out.println(len/2);
        System.out.println((len/2)+1);
        return len % 2 == 0 ? ((double) (newArr[len / 2] + newArr[(len / 2) - 1]) / 2.0) : newArr[len/2];
    }

    public static double findMedianSortedArrays2(int []nums1, int[] nums2){
        int low = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays2(nums2, nums1);

        if(n1 == 0){
            return n2 % 2 == 0 ? nums2[n2/2] + nums2[n2/2 - 1] : nums2[n2 / 2];
        }

        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;
        int high = n1;
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                }
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);     // Odd-length
            int len2 = expand(s, i, i + 1); // Even-length
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            if (currRow == 0 || currRow == numRows - 1)
                goingDown = !goingDown;

            currRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static int reverse(int x) {
        int num = 0;
        while(x != 0){
            // if((num > Integer.MAX_VALUE/10) || (num == Integer.MAX_VALUE/10 &&  x%10 > 7)) return 0;
            // if((num < Integer.MIN_VALUE/10) || (num == Integer.MIN_VALUE/10 &&  x%10 < -8)) return 0;
            // or
            int temp = num*10+x%10;
            if(temp/10 != num){
                return 0;
            }
            num = temp;
            x /= 10;
        }

        return num;
    }

    public static int myAtoi(String str) {
        final int len = str.length();
        if (len == 0){
            return 0;
        }
        int index = 0;
        while (index < len && str.charAt(index) == ' '){
            ++index;
        }
        boolean isNegative = false;
        if (index < len) {
            if (str.charAt(index) == '-') {
                isNegative = true;
                ++index;
            } else if (str.charAt(index) == '+'){
                ++index;
            }
        }
        int result = 0;
        while (index < len && isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && digit > 7)){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result * 10) + digit;
            ++index;
        }
        return isNegative ? -result : result;
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isPalindrome(int x) {
        if(x < 0 || x%10 == 0) return false;

        int pal = x;
        int num = 0;
        while(pal != 0 ){
            num = num * 10+ ((pal % 10));
            pal /= 10;
        }
        System.out.println(num);
        return num == x;
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int times = k%n;
        int left = 0;
        int right = n-times-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        left = n-times;
        right = n-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        left =0;
        right = n-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        for(int num : nums){
            System.out.print(num + ", ");
        }

    }

    public static String longestCommonPrefix(String[] strs) {
        String lcp = strs[0];
        int minN = strs[0].length();
        for(int i=1; i<strs.length; i++){
            String curstr = strs[i];
            String newlcp = "";
            minN = Math.min(curstr.length(), lcp.length());
            for(int j =0; j<minN; j++){
                if(lcp.length() > 0 && curstr.charAt(j) == lcp.charAt(j)){
                    newlcp += (curstr.charAt(j) + "");
                }else{
                    break;
                }
            }
            lcp = newlcp;
        }
        return lcp;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n-2; i++){
            for(int j =0; (i!=j) && (j < n-1); j++){
                for(int k =0; (i!=k) && (j!= k) && (k<n); k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                       ArrayList<Integer> tempRes =  new ArrayList<Integer>();
                       tempRes.add(nums[i]);
                       tempRes.add(nums[j]);
                       tempRes.add(nums[k]);
                       res.add(tempRes);
                    }
                }
            }
        }
        return  res;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<n-1; i++){
            int firstNum = nums[i];
            int left = 0;
            int right = n-1;
            while(left < right){
                if(firstNum + nums[left] + nums[right] == 0){
                    ArrayList<Integer> tempRes =  new ArrayList<Integer>();
                    tempRes.add(nums[i]);
                    tempRes.add(nums[left]);
                    tempRes.add(nums[right]);
                    res.add(tempRes);
                }
                left++;
                right--;
            }
        }
        return  res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList();
        int MOD = 1000000007;
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i =0; i<n-3; i++){
            for(int j =i+1; j<n-2; j++){
                int low = j+1;
                int high = n-1;
                while(low < high){
                    int sum = ((nums[i]%MOD+nums[j]%MOD)%MOD+(nums[low]%MOD+nums[high]%MOD)%MOD)%MOD;
                    if(sum == target){
                        int[] new_res_array = {nums[i],nums[j],nums[low],nums[high]};
                        List<Integer> new_res_list = Arrays.stream(new_res_array)
                                .boxed()
                                .collect(Collectors.toList());
                        if(!set.contains(new_res_list)){
                            res.add(new_res_list);
                            set.add(new_res_list);
                        }
                        low++;
                        high--;
                    }else if(sum < target){
                        low += 1;
                    }else{
                        high -= 1;
                    }
                }
            }
        }
        return res;
    }

    public void nextPermutaion(int nums[]) {
        int n = nums.length;
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(0, n - 1, nums);
            return;
        }
        for (int j = n - 1; j > ind; j--) {
            if (nums[ind] < nums[j]) {
                int t = nums[j];
                nums[j] = nums[ind];
                nums[ind] = t;
                break;
            }
        }

        reverse(ind+1, n-1, nums);

        for (int num : nums) {
            System.out.print(num + ", ");
        }
        return;
    }

    public void reverse(int low, int high, int nums[]) {
        while (low < high) {
            int t = nums[low];
            nums[low] = nums[high];
            nums[high] = t;
            low++;
            high--;
        }
    }

    public int[][] pascalTriangle(int num) {
        int[][] matrix = new int[num][];
        for (int i = 0; i < num; i++) {
            matrix[i] = new int[i + 1];
        }
        matrix[0][0] = 1;

        for (int i = 1; i < num; i++) {
            matrix[i][0] = 1;
            for (int j = 1; j < i; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
            matrix[i][i] = 1;
        }
        return matrix;
    }

    public int[][] setMatrixZero(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }

    public int maxSubarraySum(int[] arr) {
        int sum = 0;
        int mx = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            mx = Math.max(mx, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return mx;
    }

    public int longestConsecutiveOnes2(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int zeros = 0;
        int n = arr.length - 1;
        while (r <= n) {
            if (arr[r] == 0) {
                zeros += 1;
            }
            if (zeros > k) {
                if (arr[l] == 0)
                    zeros -= 1;
                l += 1;
            }

            if (zeros <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }

            r++;
        }
        return maxlen;
    }
    public int longestConsecutiveOnes(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int zeros = 0;
        int n = arr.length-1;
        while (r <= n) {
            if (arr[r] == 0) {
                zeros += 1;
            }
            while (zeros > k) {
                if(arr[l] == 0) zeros -= 1;
                l += 1;
            }
            if (zeros <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }
        return maxlen;
    }
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pos = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                pos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }
    public int findUpperOccurence(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int last = -1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] == x) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
    public int findLowerOccurence(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }
    public int[] searchRange(int nums[], int target) {
        int first = findLowerOccurence(nums, target);
        if(first == -1)
            return new int[] { -1, -1 };
        return new int[] {first, findUpperOccurence(nums, target)};
    }
    public int searchInRotatedSortedArray(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + (high - low)) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[low] <= arr[mid]) {
                if (target <= arr[mid] && arr[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        // Special handling for the most negative number to avoid overflow when doing -n
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2; // n is now -1073741824, which is safe to negate
        }
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }

        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }

    }
    public int binarySearchInMatrix(int matrix[][], int target) {
        int low = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int high = n * m - 1;
        while (low<=high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid / m][mid % m] == target) {
                return matrix[mid / m][mid % m];
            } else if(target < matrix[mid / m][mid % m]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int inversionOfArray(int []arr) {
        int cnt = mergeSort(arr, 0, arr.length - 1);
        // for (int i : arr) {
        //     System.out.print(i + ", ");
        // }
        return cnt;
    }

    public int merge(int []arr, int low, int mid, int high) {
        int size = high - low + 1;
        int temp[] = new int[size];
        int left = low;
        int right = mid+1;
        int idx = 0;
        int cnt = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                cnt += mid - left +1;
                temp[idx++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[idx++] = arr[left++];
        }
        while (right <= high) {
            temp[idx++] = arr[right++];
        }
        idx = 0;
        while (idx < size) {
            arr[low + idx] = temp[idx];
            idx++;
        }
        return cnt;
    }

    public int mergeSort(int arr[], int low, int high) {
        int cnt = 0;
        if (low < high) {
            int mid = (low + (high - low) / 2);
            cnt += mergeSort(arr, low, mid);
            cnt += mergeSort(arr, mid + 1, high);
            cnt += merge(arr, low, mid, high);
            return cnt;
        }
        return cnt;
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length * grid.length;
        long expectedSum = n * (n + 1) / 2;
        long expectedSqSum = n * (n + 1) * (2 * n + 1) / 6;
        long actualSum = 0;
        long actualSqSum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                actualSum += grid[i][j];
                actualSqSum += (long)(grid[i][j] * grid[i][j]);
            }
        }

        long sumDiff = actualSum - expectedSum;
        long sqSumDiff = actualSqSum - expectedSqSum;

        long sumPlus = sqSumDiff / sumDiff; // R + M

        // Solve for R and M
        long repeatNumber = (sumPlus + sumDiff) / 2;
        long missingSumber = sumPlus - repeatNumber;

        return new int[] { (int)repeatNumber, (int)missingSumber };

    }

    public int findDuplicate(int nums[]) {
        int s = 0;
        int f = 0;
        while (true) {
            s = nums[s];
            f = nums[nums[f]];
            if (f == s) {
                break;
            }
        }
        s = 0;
        while (s != f) {
            s = nums[s];
            f = nums[f];
        }
        return s;
    }
    public int[][] mergeInterval(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] == b[0] && a[1] < b[1]) {
                return -1;
            } else if(a[0] == b[0] && a[1] == b[1]){
                return 0;
            }
            return 1;
        });
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int start_i = intervals[i][0];
            int end_i = intervals[i][1];
            if (intervals[cnt][1] >= start_i) {
                intervals[cnt][1] = Math.max(end_i, intervals[cnt][1]);
            } else {
                cnt++;
                intervals[cnt][0] = intervals[i][0];
                intervals[cnt][1] = intervals[i][1];
            }
        }
        return Arrays.copyOfRange(intervals, 0, cnt + 1);
    }
    public int nBy2MajorityEle(int[] arr) {
        int cnt = 0;
        int ans = 0;
        for (int el : arr) {
            if (cnt == 0)
                ans = el;
            if (el == ans)
                cnt++;
            else
                cnt--;
        }
        return ans;
    }

    public int countUniquePath(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        return uniquePathHelper(grid, 0,0,grid.length-1,grid[0].length-1,dp);
    }

    public int uniquePathHelper(int grid[][], int i, int j, int n, int m, int dp [][]) {
        if (i == n && j == m && grid[i][j] == 0) {
            return 1;
        }
        if (i == n && j == m && grid[i][j] == 1)
            return -1;

        if (i > n || j > m) {
            return 0;
        } else {
            if (grid[i][j] == 1) {
                return 0;
            } else {

                if (dp[i][j] != 0) {
                    return dp[i][j];
                } else {
                    int paths = uniquePathHelper(grid, i, j + 1, n, m, dp) + uniquePathHelper(grid, i + 1, j, n, m, dp);
                    dp[i][j] = paths;
                    return paths;
                }
            }
        }
    }


}
