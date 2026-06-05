package matrices.leetcodeSolutions;

//59. Spiral Matrix II

//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

public class SpiralMatrixII {
    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int count = 1;

        while(top<=bottom && left<=right){
            //Left to Right
            for (int i = left; i <= right ; i++) {
                matrix[top][i] = count++;
            }
            top++;
            //Top to Bottom
            for (int i = top; i <= bottom ; i++) {
                matrix[i][right] = count++;
            }
            right--;
            //Right to left
            for (int i = right; i >=left  ; i--) {
                matrix[bottom][i] = count++;
            }
            bottom--;
            //Bottom to top
            for (int i = bottom; i >= top ; i--) {
                matrix[i][left] = count++;
            }
            left++;
        }

        return matrix;
    }
}
