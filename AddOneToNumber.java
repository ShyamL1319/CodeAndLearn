import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

;

public class AddOneToNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,0,0,0,0,1);
        System.out.println(solve(new ArrayList<>(list)));
    }

    public static List<Integer> solve(ArrayList<Integer> list){
        int size = list.size();
        int carry = 1;
        for(int i = size-1; i >= 0; i--){
            int sum = carry+list.get(i);
            carry = 0;
            if(sum == 10){
                carry = 1;
                list.set(i,0);
            }else{
                list.set(i,sum);
            }
        }

        if(carry == 1){
            list.add(0,1);
        }
        List<Integer> res = new ArrayList<>();
        for(int ele : list){
            if(ele == 0 && res.size() == 0){
                continue;
            }

            
            res.add(ele);
        }

        return res;
    }
}
