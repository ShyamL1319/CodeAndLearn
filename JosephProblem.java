public class JosephProblem {

    int totalKilled=1;
    public void getTotalKilled(int n){
        if(totalKilled > n){
            totalKilled = totalKilled >> 1;
            return;
        }
        if(totalKilled < n){
            totalKilled = totalKilled << 1;
            getTotalKilled(n);
        }
    }


    public int getWinningPosition(int n){
        ///getTotalKilled(n);
        int totalAlive = n - totalKilled;
        int winningPostion = (2*totalAlive) + 1;
        return winningPostion;
    }
}
