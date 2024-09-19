import java.util.HashMap;
import java.util.Map;

;

public class PairSumDivisibleBy60 {
    public static void main(String[] args) {
        //int nums[] = {30,20,150,100,40};
        int nums[] = {
                60,60,60,60,
        };
        System.out.println(numPairsDivisibleBy60(nums));
    }
    public static int  numPairsDivisibleBy60(int[] time) {
        // int c[]  = new int[60], res = 0;
        //  for (int t : time) {
        //      res += c[(600 - t) % 60];
        //      c[t % 60] += 1;
        //  }s
        //  return res;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0; i < time.length; i++){
            int rem = time[i]%60;
            if(m.containsKey(rem)){
                m.put(rem,m.get(rem)+1);
            }else{
                m.put(rem,1);
            }
            System.out.println(rem+ ",  " +m.get(rem) + "  "+ m.size());
        }
        int count = 0;

        for(Map.Entry<Integer,Integer> mpele : m.entrySet()){
            int value = mpele.getValue();
            int key = mpele.getKey();
            if(key == 0 || key == 30){
                count += (value * (value-1))/2;
            }else if(key < 30 && m.get(60-key) != null){
                count += (value * m.get(60-key));
            }
        }

        return count;
    }
}
