import java.util.ArrayList;
import java.util.Arrays;

public class MinBulbsToLoghtUp {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(0,1,1,0,0,1)),3));
    }
    static int solve(ArrayList<Integer> al, int B){
        int count = 0;
        int n = al.size();
        int i=0;
        while (i<n){
            int right = Integer.min(i+B-1,n-1);
            int left = Integer.max(i-B+1,0);
            boolean lightBulb = false;
            while (right >= left){
                if(al.get(right) == 1){
                    lightBulb = true;
                    break;
                }
                right--;
            }
            count++;
            if (!lightBulb) return -1;
            i = right+B;
        }
        return count;
    }
}
