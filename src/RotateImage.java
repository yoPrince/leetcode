public class RotateImage {
    public static void main(String[] args){
        int[][] matrix = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}};
        new Solution().rotate(matrix);
        for( int[] i : matrix){
            for( int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}

class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for( int i = 0; i < len; i++){
            for( int j = i + 1; j < len; j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        int len2 = len/2;
        for( int i = 0; i < len; i++){
            for( int j = 0; j < len2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = tmp;
            }
        }
    }
}