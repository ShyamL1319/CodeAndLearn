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
/*

public class Solution {

    public int solve(ArrayList<Integer> A, int B) {

        //Condition where size of array is less than the power range of the bulb

        //We have to check whether there is a single bulb working or not

        // if working simply by greedy method we return 1

        if(A.size()<B){

            for(int i=0; i<A.size(); i++){

                if(A.get(i)==1)

                    return 1;

            }

            return -1;

        }

        // Now we start checking for the scenario where size of array is greater than the power range of the bulb

        int count = B-1; //Checking from the left if bulbs are present to light leftmost part

        int revCount = B-1; //Checking from the right if bulbs are present to light rightmost part

        for(int i=0; i<A.size(); i++){

            if(A.get(i)==0){

                count++;

            }

            if(A.get(i)==1){

                count = 0;

            }

            if(A.get(A.size()-i-1)==0){

                revCount++;

            }

            if(A.get(A.size()-i-1)==1){

                revCount = 0;

            }

            // If bulb is not working to light the leftmost or rightmost part of the corridor

            if(count>(2*(B-1)) || revCount>(2*(B-1))){

                return -1;

            }

        }

        // Simple mathematical forula for calculating the no of buls required to light the whole corridor

        return (A.size()/((2*B)-1))+1;

    }

}



 */
