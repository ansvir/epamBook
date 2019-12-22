package part.one.chapter.three;

public class StringMatrix extends Matrix{

    private String[][] stringMatrix;

    public StringMatrix(String[][] stringMatrix) {
        if(!matrixIsValid(stringMatrix)) return;
        this.stringMatrix=stringMatrix;
    }

    /**
     * sorts matrix with strings horizontally alphabetically
     * for example next
     * {
     *         {"Philip","Vitalij","Boris","Nikolaj"},
     *         {"Ilya","Oleg","Vasilij","Mikhail"},
     *         {"Vyacheslav","Roman","Ivan","Oleg"},
     *         {"Grigorij","Anton","Ibragim","Petr"}
     * }
     *
     * gives
     *
     * {
     *         {"Anton", "Boris", "Grigorij", "Ibragim"},
     *         {"Ilya", "Ivan", "Mikhail", "Nikolaj"},
     *         {"Oleg", "Oleg", "Petr", "Philip"},
     *         {"Roman", "Vasilij", "Vitalij", "Vyacheslav"}
     * }
     *
     * @return sorted matrix
     */
    public StringMatrix sortAlphabetically() {
        for(int i=0;i<this.stringMatrix.length;i++) {
            for(int j=0;j<this.stringMatrix[0].length;j++) {
                for(int m=0;m<this.stringMatrix.length;m++) {
                    for(int k=0;k<this.stringMatrix[0].length;k++) {
                        if(this.stringMatrix[i][j].compareTo(this.stringMatrix[m][k])<0) {
                            String temp=this.stringMatrix[i][j];
                            this.stringMatrix[i][j]=this.stringMatrix[m][k];
                            this.stringMatrix[m][k]=temp;
                        }
                    }
                }
            }
        }

        return new StringMatrix(this.stringMatrix);
    }

    /**
     * compares string matrices for elements similarity
     * @param sm comparable matrix
     * @return "true" if matrices are similar by elements, "false" on the contrary
     */
    public boolean matrixEqualTo(StringMatrix sm) {
        if(!Matrix.matricesSizesEqual(this.getStringMatrix(),sm.getStringMatrix())) return false;
        for(int i=0;i<this.stringMatrix.length;i++) {
            for(int j=0;j<this.stringMatrix[0].length;j++) {
                if(!this.stringMatrix[i][j].equals(sm.stringMatrix[i][j])) return false;
            }
        }
        return true;
    }

    public String[][] getStringMatrix() {
        return stringMatrix;
    }

    public void setStringMatrix(String[][] stringMatrix) {
        this.stringMatrix = stringMatrix;
    }
}
