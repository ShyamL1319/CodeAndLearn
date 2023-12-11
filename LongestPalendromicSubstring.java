public class LongestPalendromicSubstring {
    public static void main(String[] args) {
        char s [] = {'a','b','a','c','a','b'};
        int ans = 1;

        for(int i=0; i<s.length; i++){
            ans = Math.max(ans, getPalendromicLength(s,i,i));
            if(i > 0){
                ans = Math.max(ans, getPalendromicLength(s,i-1,i));
            }
        }
        System.out.println(ans);
    }


    public static int getPalendromicLength(char [] s, int i, int j ){
        int len =0;
        int N = s.length;
        if(i==j) {
            len++;
            i--;
            j++;
        }
        while(i>=0 && j < N && s[i]==s[j]){
            len+=2;
            i--;
            j++;
        }
        return len;
    }
}
