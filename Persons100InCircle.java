/**
 * One hundred people are standing in a circle in an order 1 to 100.
 * <p>
 * No.1 has a sword. He kills the next person (i.e., no. 2) and gives the sword to the next (i.e., no. 3). All person does the same until only one survives.
 * <p>
 * Which number survives at last?
 * <p>
 * Answer is an integer. Just put the number without any decimal places if it's an integer. If the answer is Infinity, output Infinity.
 * <p>
 * Feel free to get in touch with us if you have any questions
 */

public class Persons100InCircle {
    public static void main(String[] args) {
        System.out.println(findLastManAlive(8));
    }

    public static int findLastManAlive(int N) {
        int res = 1;
        int n = (int) Math.sqrt(N);
        FastPower fp = new FastPower();
        int start = 1;
        for (int i = 1; i < N; i++) {
            int num = fp.fastPower(2, i, 100000007);
            if (num <= N) {
                start = num;
            } else {
                break;
            }
        }
        for (int i = start; i < N; i++) {
            res += 2;
        }
        return res;
    }
}
