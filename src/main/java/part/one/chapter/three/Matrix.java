package part.one.chapter.three;

public class Matrix {

    private Object[][] matrix;

    public Matrix(Object[][] matrix) {
        if(!matrixIsValid(matrix)) return;
        this.matrix=matrix;
    }

    Matrix(){}

    public Object[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(Object[][] matrix) {
        this.matrix = matrix;
    }

    /**
     *
     * @param matrix comparable matrix
     * @return "true" if the lengths of rows and columns of matrices are equal, "false" on the contrary
     */
    public static <T> boolean matricesSizesEqual(T[][] matrix, T[][] matrix2) {
        if(matrix.length!=matrix2.length) return false;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix2.length;j++) {
                if(matrix[i].length!=matrix2[j].length) return false;
            }
        }

        return true;
    }

    /**
     *
     * @param matrix subject of validation
     * @return validation of matrix, what means matrix is valid if it has same length rows and same length columns
     * for example next matrix is not valid:
     * {
     *      {1,2,4,5,7},
     *      {1,2,4},
     *      {1,2,4,5}
     * }
     */
    public static <T> boolean matrixIsValid(T[][] matrix) {
        if(matrix.length<=0) return false;
        for(int i=0;i<matrix.length;i++) {
            if(matrix[0].length!=matrix[i].length) return false;
        }
        return true;
    }

    /**
     *
     * @return size of a matrix calculated by multiplying it's rows and columns sizes
     * for example matrix:
     * {
     *     {1,2,4},
     *     {1,2,4},
     *     {1,2,4},
     *     {1,2,4}
     * }
     * has size 12
     */

    public int matrixSize() {
        return this.matrix.length*this.matrix[0].length;
    }

    /**
     *
     * @param matrix printable matrix
     * @param <T> type of matrix
     * prints matrix to console
     */
    public static <T> void printMatrix(T[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean matrixEqualTo(Matrix m) {
        if(!matricesSizesEqual(this.getMatrix(),m.getMatrix())) return false;
        for(int i=0;i<this.matrix.length;i++) {
            for(int j=0;j<this.matrix[0].length;j++) {
                if(!this.matrix[i][j].equals(m.matrix[i][j])) return false;
            }
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder result=new StringBuilder("matrix:\n");
        StringBuilder matrixResult=new StringBuilder("");
        for(int i=0;i<this.matrix.length;i++) {
            for(int j=0;j<this.matrix[0].length;j++) {
                matrixResult.append(this.matrix[i][j]);
            }
            matrixResult.append("\n");
        }
        result.append(matrixResult);
        return result.toString();
    }
}
