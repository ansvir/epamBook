package part.one.chapter.three;

public class BoolMatrix extends Matrix {

    private Boolean[][] boolMatrix;

    public BoolMatrix(Boolean[][] boolMatrix) {
        if(!matrixIsValid(boolMatrix)) return;
        this.boolMatrix=boolMatrix;
    }

    /**
     *
     * @param bm matrix to logical disjunction with this.boolMatrix
     * @return result matrix
     */
    public BoolMatrix disjunction(BoolMatrix bm) {
        Boolean[][] newBoolMatrix=new Boolean[this.boolMatrix.length][this.boolMatrix[0].length];
        for(int i=0;i<this.boolMatrix.length;i++) {
            for(int j=0;j<this.boolMatrix[0].length;j++) {
                newBoolMatrix[i][j]=this.boolMatrix[i][j]|bm.boolMatrix[i][j];
            }
        }
        return new BoolMatrix(newBoolMatrix);
    }

    /**
     *
     * @param bm matrix to logical conjunction with this.boolMatrix
     * @return result matrix
     */
    public BoolMatrix conjunction(BoolMatrix bm) {
        Boolean[][] newBoolMatrix=new Boolean[this.boolMatrix.length][this.boolMatrix[0].length];
        for(int i=0;i<this.boolMatrix.length;i++) {
            for(int j=0;j<this.boolMatrix[0].length;j++) {
                newBoolMatrix[i][j]=this.boolMatrix[i][j]&bm.boolMatrix[i][j];
            }
        }
        return new BoolMatrix(newBoolMatrix);
    }

    /**
     * inverses matrix
     */
    public void inversion() {
        for(int i=0;i<this.getBoolMatrix().length;i++) {
            for(int j=0;j<this.getBoolMatrix()[0].length;j++) {
                this.boolMatrix[i][j]=!this.boolMatrix[i][j];
            }
        }
    }

    /**
     * method counts ones in boolean matrix
     * @return amount of ones in matrix
     */
    public int countOnes() {
        int ones=0;
        for(int i=0;i<this.boolMatrix.length;i++) {
            for(int j=0;j<this.boolMatrix[0].length;j++) {
                if(this.boolMatrix[i][j]) ones++;
            }
        }

        return ones;
    }

    public Boolean[][] getBoolMatrix() {
        return this.boolMatrix;
    }

    public void setBoolMatrix(Boolean[][] boolMatrix) {
        this.boolMatrix=boolMatrix;
    }

}
