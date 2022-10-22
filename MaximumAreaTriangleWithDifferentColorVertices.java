import java.util.ArrayList;
import java.util.Arrays;

public class MaximumAreaTriangleWithDifferentColorVertices {
    public static void main(String[] args) {
    ArrayList<String> al =  new ArrayList<>(Arrays.asList("rrrrr","rrrrr","rrrrg","bbbbb"));
        //System.out.println(solve(al));
    }



    public static int solve(ArrayList<String> al){
        int m = al.size();
        int n = al.get(0).length();
        int mat[][] = new int[m][n];
        // r=0 g=1 b=2

        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                mat[i][j] = al.get(i).charAt(j);
                if(al.get(i).charAt(j) == 'r'){
                    mat[i][j]=0;
                }else if(al.get(i).charAt(j) == 'g') {
                    mat[i][j]=1;
                }else{
                    mat[i][j]=2;
                }
            }
        }
        int top[][] = new int[n][3];
        int bottom[][] = new int[n][3];

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                switch (mat[i][j]){
                    case 0:
                        bottom[j][0] = i;
                        break;
                    case 1:
                        bottom[j][1] = i;
                        break;
                    case 2:
                        bottom[j][2] = i;
                        break;
                }
                switch (mat[m-i-1][j]){
                    case 0:
                        if(m-i-1 != bottom[j][0])
                            top[j][0] = m-i-1;
                        break;
                    case 1:
                        if(m-i-1 != bottom[j][1])
                            top[j][1] = m-i-1;
                        break;
                    case 2:
                        if(m-i-1 != bottom[j][2])
                            top[j][2] = m-i-1;
                        break;
                }
            }
        }

        int max_i = -1;
        int min_i = -1;
        int column = -1;
        int maxBase =-1;
        for(int j=0;j<n; j++){
            //rg
            if(bottom[j][0] - top[j][1] > maxBase){
                max_i = bottom[j][0];
                min_i = top[j][1];
                maxBase = bottom[j][0] - top[j][1];
                column = j;
            }

            // gb
            if(bottom[j][1] - top[j][2] > maxBase){
                max_i = bottom[j][1];
                min_i = top[j][2];
                maxBase = bottom[j][1] - top[j][2];
                column = j;
            }
            //br
            if(bottom[j][2] - top[j][0] > maxBase){
                max_i = bottom[j][2];
                min_i = top[j][0];
                maxBase = bottom[j][2] - top[j][0];
                column = j;
            }

        }

        //System.out.println("("+min_i + ","+column+") , (" + max_i + " ," + column + " ),  "+ maxBase);
        int tp[] = {-1,-1};
        int height = -1;
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if( j != column && mat[i][j]  != mat[max_i][column] && mat[i][j]  != mat[min_i][column]){
                    if(column > j ){
                        height = Math.max(column-j,height);
                        tp[0] = i;
                        tp[1] =j;
                    }
                    if(column < j ){
                        height = Math.max(j-column,height);
                        tp[0] = i;
                        tp[1] =j;
                    }
                }
            }
        }
        if(height == -1) return 0;
//        System.out.println( "("+tp[0]+","+ tp[1] + ")  ,"+ height );
//        System.out.println(mat[tp[0]][tp[1]]);

        int temp = (maxBase+1)* (height+1);
        if(temp%2 == 0){
            return temp/2;
        }else{
            return ((temp/2) +1);
        }
    }
}
