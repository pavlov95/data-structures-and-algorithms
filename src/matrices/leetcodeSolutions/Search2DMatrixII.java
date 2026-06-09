package matrices.leetcodeSolutions;

//240. Search a 2D Matrix II

//Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
//This matrix has the following properties:

//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.

public class Search2DMatrixII {
    //Time complexity: O(m + n)
    //Space complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current > target) {
                //Move left
                col--;
            } else {
                //Move down
                row++;
            }
        }
        return false;
    }
}
