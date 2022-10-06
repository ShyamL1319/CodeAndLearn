import java.util.ArrayList;

public class MobilesQuery {



    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int lena = A.size(), lenb = B.size();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> total = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < lena; i++){
            sum = sum + A.get(i);
            total.add(sum);
        }
        for(int i = 0; i < lenb; i++){
            int X = B.get(i);
            if(A.get(0) > X){
                res.add(0);
                continue;
            }
            int l = 0, r = lena-1, mid, curr, temp=0;
            while (l<=r){
                mid = l+(r-l)/2;
                curr = total.get(mid);
                if(curr <= X) {
                    l = mid+1;
                    temp = mid;
                }else{
                    r = mid - 1;
                }
            }
            if(temp == 0){
                res.add(l);
            }else{
                res.add(temp+1);
            }
        }
        return res;
    }
    // not done yet
}
