public class FastPower {
     // a^b % M
    public int fastPower(int a, int b, int M){
        if( b== 0){
            return 1;
        }

        if(b%2==0){
            return fastPower((a*a)%M,b/2, M);
        }
        return (a * fastPower((a*a)%M, (b-1)/2, M))%M;
    }
}
