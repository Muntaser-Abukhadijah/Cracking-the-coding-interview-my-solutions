package com.company;

import java.util.*;

// 1.5

public class Main {

    public static int[][] mem;

    public boolean oneAway(String s1, String s2) {
        mem = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                mem[i][j] = -1;
            }
        }
        return editDistance(s1, s2, 0, 0) <= 1;
    }

    public int editDistance(String s1, String s2, int i, int j) {  //Edit Distance Top-down approach
        if (i >= s1.length())                                      // O(n^2)
            return s2.length() - j;

        if (j >= s2.length())
            return s1.length() - i;

        if (mem[i][j] != -1)
            return mem[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return mem[i][j] = editDistance(s1, s2, i + 1, j + 1);
        return mem[i][j] = 1 +
                Math.min(editDistance(s1, s2, i + 1, j),
                        Math.min(editDistance(s1, s2, i, j + 1),
                                editDistance(s1, s2, i + 1, j + 1)));
    }

    public boolean adhockSolution(String s1, String s2) { // O (n)
        int len1 = s1.length(), len2 = s2.length();
        if (Math.abs(len1 - len2) > 1)
            return false;
        int count = 0, ptr1 = 0, ptr2 = 0;
        while (ptr1 < len1 && ptr2 < len2) {
            if (s1.charAt(ptr1) != s2.charAt(ptr2)) {
                if (len1 > len2) {
                    ptr1++;
                } else if (len2 > len1) {
                    ptr2++;
                } else {
                    ptr1++;
                    ptr2++;
                }
                count++;
            } else {
                ptr1++;
                ptr2++;
            }
        }
        if (ptr1 < len1 || ptr2 < len2)
            count++;
        return count <= 1;
    }


    public static void main(String[] args) {

        Main tester = new Main();
        System.out.println(tester.oneAway("pale", "ple"));
        System.out.println(tester.oneAway("pales", "pale"));
        System.out.println(tester.oneAway("pale", "bale"));
        System.out.println(tester.oneAway("pale", "bake"));
        System.out.println(tester.oneAway("geek", "gesek"));
        System.out.println(tester.oneAway("cat", "cut"));
        System.out.println(tester.oneAway("sunday", "saturday"));

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(tester.adhockSolution("pale", "ple"));
        System.out.println(tester.adhockSolution("pales", "pale"));
        System.out.println(tester.adhockSolution("pale", "bale"));
        System.out.println(tester.adhockSolution("pale", "bake"));
        System.out.println(tester.adhockSolution("geek", "gesek"));
        System.out.println(tester.adhockSolution("cat", "cut"));
        System.out.println(tester.adhockSolution("sunday", "saturday"));

    }
}
