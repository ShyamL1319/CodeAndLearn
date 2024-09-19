import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.*;

class  Parent<T>{
    Parent(T t){

    }
}

class  ThreadTwice implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+" is executing");
    }
}
@FunctionalInterface
interface  StringValidator {
    boolean test(String s);
    default  boolean initialTest(String s){
        return !s.isEmpty();
    }
}


public  class GenericClass {
//    public int getResult(){
//        return 0;
//    }
//
//    public long getResult(){
//        return 1L;
//    }
//    public void main(String[] args) {
//        System.out.println("I am cool");
//    }
//
//    public void main(String[] args, String arg1, String arg2) {
//        System.out.println("I am cool Happ");
//    }

//
//    public  static Boolean returnsNull(){
//        return null;
//    }


    private static  int i;
    static {
        i=10;
        System.out.println("Static Block");

    }
//    synchronized(GenericClass.class){
//        System.out.println("Synchronixgg block");
//    }
    public static void main(String[] args) {
//        Object [] myObjects = {
//                new Integer(12),
//                new String("foo"),
//                        new Integer(5),
//                new Boolean(true)
//        };


        i=i++;
        System.out.println("Main Method ::: "+i);
//
//        Arrays.sort(myObjects);
//
//        for(int i=0; i<myObjects.length; i++){
//            System.out.print(myObjects[i].toString());
//            System.out.println(" ");
////        }
//Boolean b = true ? returnsNull() : false;
//        System.out.println(b);





//
//        String s = "JAVA";
//        s+="rocks";
//        s= s.substring(4,8);
//        s.toUpperCase();
//        System.out.println(s);
//        Thread th1 = new Thread(new ThreadTwice(), "th1");
//        th1.start();
//        th1.start();
//        GenericClass obj = new GenericClass();
//        System.out.println(obj.getResult());

//          ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3, 9, 15, 16));
//
          //System.out.println("Hey");

//          System.out.println(al);
//          System.out.println(solve(al));

//          int matrix[][] = {
//                  {1,3,5,7},
//                  {10,11,16,20},
//                  {23,30,34,60}
//          };

        //System.out.println(searchMatrix(matrix,13));
//
//        try{
//            badMethod();
//            System.out.print("A");
//        }catch (Exception ex){
//            System.out.print("B");
//        }
//        finally {
//            System.out.print("C");
//        }
//
//        System.out.print("D");
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rl = 0;
        int rr = matrix.length - 1;
        int flag =0;
        while (rl <= rr) {
            int rowMid = rl + (rr - rl) / 2;
            int lc = 0;
            int rc = matrix[rowMid].length - 1;
            if (matrix[rowMid][lc] <= target && matrix[rowMid][rc] >= target) {
                flag=1;
                while (lc <= rc) {
                    int colMid = lc + (rc - lc) / 2;
                    if (matrix[rowMid][colMid] == target) return true;
                    else if (matrix[rowMid][colMid] > target) rc = colMid - 1;
                    else lc = colMid + 1;
                }
            } else if (matrix[rowMid][rc] < target) {
                rl = rowMid + 1;
            } else rr = rowMid - 1;

            if(flag ==1) return false;
        }
        return false;
    }


    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int arr[] = new int[101];
        for(int ele : A){
            arr[ele]+=1;
        }
        for(int i=0; i<n; i++){
            A.set(i,arr[A.get(i)]);
        }
        return A;
    }


    public static void badMethod(){
        throw new Error();
    }


    public static int insertionPoint(ArrayList<Integer> list,int key){
        int left = 0;
        int right = list.size()-1;
        int mid =0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int val = list.get(mid);
            if (val == key) return mid;
            else if (val > key) right = mid - 1;
            else left = mid + 1;
        }

        if(list.get(mid) > key){
            list.add(mid,key);
        }else{
            list.add(mid+1,key);
        }

        System.out.println(list);
        return mid;
    }
}
//
//public class GenericClass<N extends Integer> {
//    private N min, max;
//
//    public N getMin() {
//        return min;
//    }
//
//    public void setMin(N min) {
//        this.min = min;
//    }
//
//    public N getMax() {
//        return max;
//    }
//
//    public void setMax(N max) {
//        this.max = max;
//    }
//
//    public void add(N added){
//        if(min == null || added.doubleValue() < min.doubleValue()){
//            min = added;
//        }
//        if(max == null || added.doubleValue() < max.doubleValue()){
//            max = added;
//        }
//
//    }
//
//    public static void main(String[] args) {
////         List<Parent> p = new ArrayList<Child>();
////
////         List<Child> c = new ArrayList<Child>();
////        List<Parent> p1 = new ArrayList<Parent>();
////        List<Child> c1 = new ArrayList<Parent>();
//
//
//
//    }
//}
