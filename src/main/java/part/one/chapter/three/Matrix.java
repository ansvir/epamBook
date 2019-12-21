package part.one.chapter.three;

public class Matrix {

    private Object[][] matrix;

    public Matrix(Object[][] matrix) {
        if(!matrixIsValid(matrix)) return;
        this.matrix=matrix;
    }

    Matrix(){}

    public Object[][] getMatrix() {
        return this.getMatrix();
    }

    public void setMatrix(Object[][] matrix) {
        this.matrix = matrix;
    }

    /**
     *
     * @param matrix comparable matrix
     * @return "true" if the lengths of rows and columns of matrices are equal, "false" on the contrary
     */
    public boolean matrixEqualTo(Matrix matrix) {
        if(this.matrix.length!=matrix.getMatrix().length) return false;
        for(int i=0;i<this.matrix.length;i++) {
            for(int j=0;j<matrix.getMatrix().length;j++) {
                if(this.matrix[i].length!=matrix.getMatrix()[j].length) return false;
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
