package part.one.chapter.three;

public class StringMatrix extends Matrix{

    private String[][] stringMatrix;

    public StringMatrix(String[][] stringMatrix) {
        if(!matrixIsValid(stringMatrix)) return;
        this.stringMatrix=stringMatrix;
    }

    public void sortAlphabetically() {
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
    }

    public String[][] getStringMatrix() {
        return stringMatrix;
    }

    public void setStringMatrix(String[][] stringMatrix) {
        this.stringMatrix = stringMatrix;
    }
}
