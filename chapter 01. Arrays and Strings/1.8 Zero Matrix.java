package com.company;

import javax.print.attribute.standard.Compression;
import java.util.*;

// 1.8

public class Main {

    public void zeroMatrix(int[][] matrix) {  // Using HashSet O((n*m)) Time, O(n+m) Space
        int n = matrix.length;
        int m = matrix[0].length;

        HashSet<Integer> rowsSet = new HashSet<>();
        HashSet<Integer> columnsSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rowsSet.add(i);
                    columnsSet.add(j);
                }
            }
        }

        for (Integer x : rowsSet) {
            for (int i = 0; i < m; i++) {
                matrix[x][i] = 0;
            }
        }

        for (Integer x : columnsSet) {
            for (int i = 0; i < n; i++) {
                matrix[i][x] = 0;
            }
        }
    }

    public void zeroMatrixLessSpace(int[][] matrix) {  //  O((n*m)) Time, O(1) Space
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRow = false;
        boolean firstColumn = false;

        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0)
                resetRow(matrix, i);
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0)
                resetColumn(matrix, i);
        }
        if (firstRow) {
            resetRow(matrix, 0);
        }
        if (firstColumn) {
            resetColumn(matrix, 0);
        }
    }

    public void resetColumn(int[][] matrix, int index) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][index] = 0;
        }
    }

    public void resetRow(int[][] matrix, int index) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[index][i] = 0;
        }
    }


    public static void main(String[] args) {

        Main tester = new Main();

        int[][] matrix = new int[][]{{11, 11, 1, 2, 22}, {11, 0, 1, 2, 22}, {11, 11, 1, 2, 22}, {11, 0, 1, 0, 22}, {11, 11, 1, 2, 22}};

        tester.zeroMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        int[][] matrix2 = new int[][]{{11, 11, 1, 2, 22}, {11, 0, 1, 2, 22}, {11, 11, 1, 2, 22}, {11, 0, 1, 0, 22}, {11, 11, 1, 2, 22}};
        tester.zeroMatrixLessSpace(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }


    }
}
