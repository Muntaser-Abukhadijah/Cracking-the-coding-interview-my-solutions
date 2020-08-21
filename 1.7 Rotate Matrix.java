package com.company;

import javax.print.attribute.standard.Compression;
import java.util.*;

// 1.7

public class Main {

    public int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    public int[][] rotateMatrixInPlaceAntiClockwise(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=temp;
            }
        }
        return matrix;
    }

    public int[][] rotateMatrixInPlaceClockwise(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {

        Main tester = new Main();

        int[][] res0 = tester.rotateMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});

        int[][] res = tester.rotateMatrixInPlaceAntiClockwise(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        int[][] res2 = tester.rotateMatrixInPlaceClockwise(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});


        for (int i = 0; i < res0.length; i++) {
            for (int j = 0; j < res0.length; j++) {
                System.out.print(res0[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();



        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < res2.length; i++) {
            for (int j = 0; j < res2.length; j++) {
                System.out.print(res2[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
