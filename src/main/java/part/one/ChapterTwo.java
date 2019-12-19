package part.one;

public class ChapterTwo {

    public static int[][] task10(int[][] matrix) {

        if(matrix.length<=0) return new int[][] {};

        int max=matrix[0][0];
        // 1  2 4  5  7
        // 10 4 5  8  1
        // 2  5 4  10 1
        // 8  4 10 2  5
        // 1  2 4  5  7

        int newRowsSize=matrix.length;
        int newColumnsSize=matrix[0].length;
        boolean maxExists=false;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(max<matrix[i][j]) {
                    max=matrix[i][j];
                }
            }
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(max==matrix[i][j]) {
                    newRowsSize--;
                    newColumnsSize--;
                }
            }
        }

        int newMatrix[][] = new int[newRowsSize][newColumnsSize];

        int l=0;
        int p=0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for(int m=0;m<matrix[0].length;m++) {
                    if(matrix[i][m]==max) {
                        maxExists=true;
                        break;
                    }
                }
                if(!maxExists) {
                    for(int k=0;k<matrix.length;k++) {
                        if(matrix[k][j]==max) {
                            maxExists=true;
                            break;
                        }
                    }
                }
                if(!maxExists) {
                    newMatrix[l][p]=matrix[i][j];
                    p++;
                    if(p==newColumnsSize) {
                        p=0;
                        l++;
                    }
                } else {
                    maxExists=false;
                }
            }
        }
        return newMatrix;
    }
}
