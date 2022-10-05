public class Main {
    public static void main(String[] args) {
//        FastPower fp = new FastPower();
//        System.out.println(fp.fastPower(3,20,11));
          JosephProblem jp = new JosephProblem();
        System.out.println();
        jp.getTotalKilled(100);
        System.out.println(jp.totalKilled);
          int winningPostion = jp.getWinningPosition(100);

        System.out.println(winningPostion);
    }
}


// foo(3,5) -> bar(3,foo(3,4))
// foo(3,4) -> bar(3,foo(3,3))
// foo(3,3) -> bar(3, foo(3,2))
// foo(3,2) -> bar(3, foo(3,1))
// foo(3,1) -> bar(3, foo(3,0))

/*
t(n) = 2t(n/2)+c
t(n/2) = 2(2t(n/2^3) + c) + c
t(n/4) = 2t(n/2^3) + c



int memo[101][101];
int findMinPath(vector<vector >& V, int r, int c) {
  int R = V.size();
  int C = V[0].size();
  if (r >= R || c >= C) return 1000000000; // Infinity
  if (r == R - 1 && c == C - 1) return 0;
  if (memo[r][c] != -1) return memo[r][c];
  memo[r][c] =  V[r][c] + min(findMinPath(V, r + 1, c), findMinPath(V, r, c + 1));
  return memo[r][c];
}

Callsite :
memset(memo, -1, sizeof(memo));
findMinPath(V, 0, 0);

// Assume R = V.size(), C = V[0].size() and V has positive elements.





 */

/* * V is sorted * V.size() = N
The function is initially called as searchNumOccurrence(V, k, 0, N-1) */

//    int searchNumOccurrence(vector &V, int k, int start, int end) {
//        if (start > end) return 0;
//        int mid = (start + end) / 2;
//        if (V[mid] < k) return searchNumOccurrence(V, k, mid + 1, end);
//        if (V[mid] > k) return searchNumOccurrence(V, k, start, mid - 1);
//        return searchNumOccurrence(V, k, start, mid - 1) + 1 + searchNumOccurrence(V, k, mid + 1, end);
//    }


