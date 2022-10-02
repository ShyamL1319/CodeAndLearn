import java.lang.*;
import java.util.ArrayList;

public class Fibonacci {

    public  static ArrayList<Integer> dp = new ArrayList<Integer>();
    public static void main(String[] args){
        int num = 5;
        Fibonacci.dp.add(0);
        Fibonacci.dp.add(1);
        int val = nextFibonacci2(6);
        System.out.println(val);

        System.out.println(8%-15);
    }


    /***
     * basic Appproach  to fibbonacci timecomplexity O(2^n) space O(n)
     */
    public static int bascicFibonacci(int n){
        if(n==0 || n==1){
            return 1;
        }
        return bascicFibonacci(n-1)+bascicFibonacci(n-2);
    }

    /**
     * Next Fibonacci space O(n) time (n)
     */
    public static int nextFibonacci(int n){
        int fib[] = new int[n+1];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < n; i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n-1];
    }


    /**
     * Next Fibonacci space O(n) time (n)
     */
    public static int nextFibonacci2(int n){
        int first = 1, second = 1;
        int sum = 0;
        for(int i = 2; i < n; i++){
            sum = first+second;
            first = second;
            second = sum;
        }
        return sum;
    }



}

//a = {1,2,3,4,5}
//b = 2;
//
//rem [] = {0,1};
//
//rem[0] = {2,4}
//rem[1] = {1,3,5}
//        (2,4), (1,3), (1,5), (3,5)
//
//        i = 0 => 2 * 1
//        i = 1 => c[1] * c[2-1] => 3 * 3;
//
//a = 2,7,5,10,8,4,6,11
//b = 5,
//
//0 => 5,10
//1 => 6,11
//2 => 2,7
//3 => 8,
//4 => 4,
//        i= 1     (c[1] * c[b-1]) = 2 * 1
//i =2       (c[2] * c[b-2]) = 2 * 1
//i =3       (c[3] * c[b-3] )= 1 * 2
//i = 4      (c[4] * c[1]) = 1 * 2
//i=0        c[0] * (c[0]-1) = 2 * 1

