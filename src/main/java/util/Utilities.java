package util;

public class Utilities {

    public static <T> void printMatrix(T[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
