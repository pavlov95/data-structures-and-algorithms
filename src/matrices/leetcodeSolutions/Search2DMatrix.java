package matrices.leetcodeSolutions;

//74. Search a 2D Matrix

//You are given an m x n integer matrix matrix with the following two properties:
//
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.
//
//You must write a solution in O(log(m * n)) time complexity.

public class Search2DMatrix {
    //Time complexity is O(log m + log n) = O(log(m * n))
    //Space complexity O(1)
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        //Find the candidate row
        //Time complexity: O(log m)
        while (top <= bottom) {
            int midRow = top + (bottom - top) / 2;

            if (target < matrix[midRow][0]) {
                bottom = midRow - 1;
            } else if (target > matrix[midRow][cols - 1]) {
                top = midRow + 1;
            } else {

                //Target must be in this row
                int left = 0;
                int right = cols - 1;
                //Time complexity: O(log n)
                while (left <= right) {
                    int midCol = left + (right - left) / 2;

                    if (matrix[midRow][midCol] == target) {
                        return true;
                    } else if (matrix[midRow][midCol] < target) {
                        left = midCol + 1;
                    } else {
                        right = midCol - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
