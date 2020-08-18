package com.company;

//1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structures?

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public boolean usingSorting(String string) {   // O(nlog(n))
        char[] temp = string.toCharArray();
        Arrays.sort(temp);
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == temp[i - 1])
                return false;
        }
        return true;
    }

    public boolean bruteForce(String string) {  // O(n^2)
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public boolean frequencyArray(String string) {   // O(n)
        boolean[] freq = new boolean[256];
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (freq[currentChar])
                return false;
            freq[currentChar] = true;
        }
        return true;
    }

    public boolean frequencyMap(String string) { // O(n)
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            if (map.containsKey(temp))
                return false;
            map.put(temp, 1);
        }
        return true;
    }

    public boolean bitMarking(String string) {  // O(n)
        int vis = 0;
        for (int i = 0; i < string.length(); i++) {
            int index = string.charAt(i) - 'a';
            if ((vis & (1 << index)) > 0)
                return false;
            vis |= (1 << index);
        }
        return true;
    }


    public static void main(String[] args) {
        Main test = new Main();
        String[] testCases = {"abcdefga", "sabhew", "lkjhgfdsa", "hello","abcde", "apple", "kite", "padle"};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println(
                    test.usingSorting(testCases[i]) + " " +
                            test.bruteForce(testCases[i]) + " " +
                            test.frequencyArray(testCases[i]) + " " +
                            test.frequencyMap(testCases[i]) + " " +
                            test.bitMarking(testCases[i]));
        }
    }
}
