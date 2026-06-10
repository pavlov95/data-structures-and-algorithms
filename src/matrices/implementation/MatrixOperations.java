package matrices.implementation;


public class MatrixOperations {


    public void printMatrix(int[][] matrix) {
        validateMatrix(matrix);
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    public boolean isMatrixSquare(int[][] matrix) {
        validateMatrix(matrix);
        return matrix.length == matrix[0].length;
    }

    //For a squared matrix
    public Integer sumDiagonals(int[][] matrix) {
        if (!isMatrixSquare(matrix)) {
            throw new IllegalArgumentException("Matrix must be square");
        }

        int sum = 0;
        int size = matrix.length;
        int lastIndex = size - 1;

        for (int row = 0; row < size; row++) {
            sum += matrix[row][row];
            sum += matrix[row][lastIndex - row];
        }

        if (size % 2 == 1) {
            sum -= matrix[size / 2][size / 2];
        }

        return sum;
    }

    public static void validateMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix can not be null");
        }
        MatrixCreation.validateDimensions(matrix.length, matrix[0].length);
    }

}


