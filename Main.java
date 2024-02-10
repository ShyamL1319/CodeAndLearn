public class Main {
    public static void main(String[] args) throws Exception {
        FastPower fp = new FastPower();
        // System.out.println(fp.fastPower(-3,3,5));
//          JosephProblem jp = new JosephProblem();
//        System.out.println();
//        jp.getTotalKilled(100);
//        System.out.println(jp.totalKilled);
//          int winningPostion = jp.getWinningPosition(100);
//
//        System.out.println(winningPostion); 23,36,58,59

//       MobilesQuery mq = new MobilesQuery();
//10, 14, 46, 49, 58, 62, 94
       //ArrayList<Integer> res =  mq.solve(new ArrayList<>(Arrays.asList(23,36,58,59)),new ArrayList<>(Arrays.asList(3, 207, 62, 654, 939, 680, 760)));

//       ArrayList<Integer> res =  mq.solve(new ArrayList<>(Arrays.asList(10, 14, 46, 49, 58, 62, 94)),new ArrayList<>(Arrays.asList(620, 204, 342, 115)));
//        System.out.println(res);
       //        AreaUnderHills auh = new AreaUnderHills();
//        String area =  auh.solve(new ArrayList<>(Arrays.asList(2, 1, 3 )));
//        System.out.println(area);
        //System.out.println(res.toString());
//        InsertionSort is = new InsertionSort();
        //int arr[] = {12, 11, 13, 5, 6};//{1,2,9,10};
//        arr = is.solve(arr);
//        MergeSort ms = new MergeSort();
//       int narr[] = ms.sort(arr);
//        for( int i =0; i< narr.length; i++){
//            System.out.print(narr[i] + " ");
//        }

//        System.out.println((-1%5)+5);
//        System.out.println(1&2);
//        System.out.println(1&1);
//
//        System.out.println(4&1);


//        QuickSort qs = new QuickSort();
//        qs.sort(arr);

        SelectionSort ss = new SelectionSort();
//        ss.sort(arr);

//        BubbleSort bs = new BubbleSort();
//        //int arr[] = {14, 33, 27, 35, 10};
//        int arr[] = {1,2,3,4,5,6};
//        bs.sort(arr);
//
//        for( int i =0; i< arr.length; i++){
//            System.out.print(arr[i] + " ");
//        }
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};
        int[] arr3 = {9, 10, 11, 12};
//
//        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
//        A.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
//        A.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
//        A.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));


//
//        ArrayList<ArrayList<Integer>> B = ss.performOps(A);
//        for(int i = 0; i < B.size(); i++) {
//            for (int j = 0; j < B.get(i).size(); j++) {
//                System.out.print(B.get(i).get(j) + " ");
//            }
//        }

//        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(5,10,2,1));
//
//        ArrayList<Integer> B = ss.performOps2(C);
//
//        LargeFactorial lf = new LargeFactorial();
//        ArrayList<Integer> bigFact = lf.solve(100);
//        for (int i = bigFact.size()-1; i >=0; i--) {
//            System.out.print(bigFact.get(i) + "");
//        }

        Main m = new Main();
        m.A();

    }

    void A() throws Exception {
        int count = 0;
        try {
            count++;
            try {
                count++;
                try {
                    count++;
                    throw new Exception();
                } catch (Exception ex) {
                    count++;
                    throw new Exception();
                }
            } catch (Exception ex) {
                count++;
                System.out.println(count);
            }
        } catch (Exception ex) {
            count++;
            System.out.println(count + " in");
        }
        System.out.println(count + " out");
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


