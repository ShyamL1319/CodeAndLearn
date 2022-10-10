import java.util.ArrayList;

public class LargeFactorial {

    ArrayList<Integer> solve(int num){
        ArrayList<Integer> al = new ArrayList<>(1);
        al.add(1);
        for(int i=2; i<=num; i++){
            multiply(al,i);
        }
        return al;
    }

    private void multiply(ArrayList<Integer> al, int i) {
        int carry = 0;
        for(int j = 0; j<al.size();  j++){
            int prod = al.get(j) * i + carry;
            al.set(j,prod%10);
            carry = prod/10;
        }
        if(carry!=0)
            al.add(carry);
    }
}
