import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

    public static void main(String[] args) {
        int arr[] = {-1,0,-1,1,2,-4};
        System.out.println(threeSum(arr));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(n<3) return result;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            int target = -nums[i];
            int low = i+1;
            int high = n-1;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while(low < high){
                int sum = nums[low]+nums[high];
                if(target == sum){
                    result.add(new ArrayList(Arrays.asList(nums[i],nums[low],nums[high])));
                    while(low < high && nums[low]==nums[low+1]) low++;
                    while(low < high && nums[high]==nums[high-1]) high--;
                    low++;



                    high--;
                }else if(sum > target){
                    high--;
                }else{
                    low++;
                }
            }
        }

        return result;

    }
}
