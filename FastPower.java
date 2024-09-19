public class FastPower {
     // a^b % M
    public int fastPower(int a, int b, int M){
        if( a == 0){
            return 0;
        } else if (a<0) {
            a = a%M+M;
        }else{
            a = a%M;
        }
        if( b== 0){
            return 1;
        }
        if((b&1) == 0){
            return fastPower((a*a)%M,b/2, M);
        }
        return (a * fastPower((a*a)%M, (b-1)/2, M))%M;
    }
}
