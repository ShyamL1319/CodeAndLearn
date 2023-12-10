import java.util.Arrays;

public class Solution<T> {
    public static void main(String[] args) {
        String str = "01010101";
        char[] strarr = str.toCharArray();
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
