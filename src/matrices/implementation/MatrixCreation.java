package matrices.implementation;

public class MatrixCreation {
    public static  int[][] createEmptyMatrix(int rows, int columns){
        validateDimensions(rows, columns);
        return new int[rows][columns];

    }


    public static int[][] createFilledMatrix(int rows, int columns){
        validateDimensions(rows, columns);
        int[][] matrix = createEmptyMatrix(rows, columns);

        int element = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] =  element++;
            }
        }
        return matrix;
    }

    public static void validateDimensions(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException(
                    "Rows and columns must be positive integers");
        }
    }
}
