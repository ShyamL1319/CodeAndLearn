import java.util.ArrayList;

/**
 * Date: 19/12/2023:09:11
 * User: shyamlal
 * Problem Description
 * You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= |intervals| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is the vector of intervals
 * <p>
 * second argument is the new interval to be merged
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the vector of intervals after merging
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 * Input 2:
 * <p>
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [ [1, 5], [6, 9] ]
 * Output 2:
 * <p>
 * [ [1, 9] ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * (2,5) does not completely merge the given intervals
 * Explanation 2:
 * <p>
 * (2,6) completely merges the given intervals
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {

        ArrayList<Interval> input1 = new ArrayList<>();
        input1.add(new Interval(1, 3));
        input1.add(new Interval(6, 9));
        ArrayList<Interval> res = insert(input1, new Interval(2, 5));
        for (Interval itr : res) {
            System.out.print(itr.start + " " + itr.end + ", ");
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int N = intervals.size();
        ArrayList<Interval> answer = new ArrayList();

        int s2 = newInterval.start;
        int e2 = newInterval.end;

        for (int i = 0; i < N; i++) {
            int s1 = intervals.get(i).start;
            int e1 = intervals.get(i).end;

            //For checking whether new interval can place on right side
            if (e1 < s2) {
                answer.add(new Interval(s1, e1));

                //For checking whether new interval can place on left side
            } else if (e2 < s1) {
                answer.add(new Interval(s2, e2));
                while (i < N) {
                    answer.add(intervals.get(i));
                    i++;
                }
                return answer;
            } else {
                //Intervals are overlapping
                s2 = Math.min(s1, s2);
                e2 = Math.max(e1, e2);
            }
        }

        answer.add(new Interval(s2, e2));
        return answer;
    }
}
