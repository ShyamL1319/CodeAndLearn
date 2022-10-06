import java.util.ArrayList;

public class AreaUnderHills {
    public String solve(ArrayList<Integer> A) {
        int length = A.size();
        long totalA = 0;
        for(int i=0; i < length; i++){
            totalA += A.get(i);
        }
        return String.valueOf(totalA);
    }
}
