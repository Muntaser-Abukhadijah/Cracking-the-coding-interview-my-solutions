package com.company;

import java.util.*;

// 1.4

public class Main {

    public boolean isPalindromePermutation(String str) {  // O(n)
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            temp = Character.toLowerCase(temp);
            if (str.charAt(i) == ' ')
                continue;
            freq[temp]++;
        }

        int oddCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            oddCounter += freq[str.charAt(i)] % 2;
            if (oddCounter > 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Main tester = new Main();
        System.out.println(tester.isPalindromePermutation("Tact Coass"));
        System.out.println(tester.isPalindromePermutation("A man, a plan, a canal, panama"));
        System.out.println(tester.isPalindromePermutation("Lleve"));
        System.out.println(tester.isPalindromePermutation("asda"));

    }
}
