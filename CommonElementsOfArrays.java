import java.util.HashMap;

public class CommonElementsOfArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7,3 };
        int[] arr2 = new int[] { 1, 3, 5, 6, 9, 8,3 };
        findCommonElements(arr1,arr2);
    }

    public static void findCommonElements(int arr1[], int arr2[]){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            if(hashMap.containsKey(arr1[i])){
                hashMap.put(arr1[i],hashMap.get(arr1[i])+1);
            }else{
                hashMap.put(arr1[i],1);
            }
        }

        for(int i=0; i< arr2.length; i++){
            if(hashMap.containsKey(arr2[i]) && hashMap.get(arr2[i]) > 0){
                hashMap.put(arr2[i],hashMap.get(arr2[i])-1);
                System.out.print(arr2[i]+" ");
            }
        }
    }
}

/*


Minimum Lights to Activate

Bookmark
Easy
50.8% Success

524

37
Asked In:
Directi
Problem Description



There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.

All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

Initially all lights are off.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.



Problem Constraints
1 <= N <= 100000

1 <= B <= 10000



Input Format
First argument is an integer array A where A[i] is either 0 or 1.

Second argument is an integer B.



Output Format
Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.


Example Input
Input 1:

A = [ 0, 0, 1, 1, 1, 0, 0, 1].
B = 3
Input 2:

A = [ 0, 0, 0, 1, 0].
B = 3


Example Output
Output 1:

2
Output 2:

-1


Example Explanation
Explanation 1:

In the first configuration, Turn on the lights at 2nd and 7th index. Light at 2nd index covers from [ 1, 5] and light at 7th index covers [6, 8].



Explanation 2:

In the second configuration, there is no light which can light the first corridor.

 */
