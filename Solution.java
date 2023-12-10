import java.util.Arrays;

public class Solution<T> {
    public static void main(String[] args) {

    }

    public void printOneDArray(T[] A) {
        System.out.println(Arrays.toString(A));
    }

    public void printTwoDArray(T[][] A) {
        for (T[] arrEle : A) {
            System.out.println(Arrays.toString(arrEle));
        }
    }
}
