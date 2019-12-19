package main;

import part.one.ChapterTwo;

public class Main {
    public static void main(String[] args) {
        int matrix[][]={
                {1, 2, 4, 5 , 7},
                {10, 4 ,5, 8, 1},
                {2,5,4, 10, 1},
                {8, 4, 10, 2, 5},
                {1, 2, 4, 5, 7}
        };

        int[][] matrix2={
                {5,5,5,5,5},
                {1,1,1,1,1},
                {7,7,7,7,7},
                {8,8,8,10,8},
                {4,4,4,4,4}
        };

        int[][] result=ChapterTwo.task10(matrix2);
        ChapterTwo.printMatrix(result);
    }
}
