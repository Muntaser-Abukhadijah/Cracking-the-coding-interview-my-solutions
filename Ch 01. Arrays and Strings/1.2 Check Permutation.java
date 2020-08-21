package com.company;

import java.util.*;

// 1.2

public class Main {

    public boolean frequencyMap(String p1, String p2) { // O(n)
        if (p1.length() != p2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p1.length(); i++) {
            char temp = p1.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        for (int i = 0; i < p2.length(); i++) {
            char temp = p2.charAt(i);
            if (!map.containsKey(temp))
                return false;
            map.put(temp, map.get(temp) - 1);
            if (map.get(temp) < 0)
                return false;

        }
        return true;
    }


    public boolean frequencyArray(String p1, String p2) {  // O(n)
        if (p1.length() != p2.length())
            return false;

        int[] freq = new int[256];

        for (int i = 0; i < p1.length(); i++) {
            char temp = p1.charAt(i);
            freq[temp]++;
        }

        for (int i = 0; i < p2.length(); i++) {
            char temp = p2.charAt(i);
            freq[temp]--;
            if (freq[temp] < 0)
                return false;
        }
        return true;
    }

    public boolean sortingSolution(String p1, String p2){ // O(nlog(n))
        if(p1.length()!=p2.length())
            return false;
        char[] p1Temp = p1.toCharArray();
        char[] p2Temp = p2.toCharArray();
        Arrays.sort(p1Temp);
        Arrays.sort(p2Temp);
        return Arrays.equals(p1Temp,p2Temp);
    }


    public static void main(String[] args) {

        Main tester = new Main();

        List<String[]> testCases = new ArrayList<>();
        testCases.add(new String[]{"abced", "decba"});
        testCases.add(new String[]{"eeee", "eeee"});
        testCases.add(new String[]{"abceda", "fdecba"});
        testCases.add(new String[]{"hello", "hallo"});
        testCases.add(new String[]{"goodbey", "beygood"});
        testCases.add(new String[]{"1236", "6321"});
        testCases.add(new String[]{"....", "123."});
        testCases.add(new String[]{"assva", "####"});
        testCases.add(new String[]{"@#$!", "!@#$"});
        testCases.add(new String[]{"apple", "papel"});
        testCases.add(new String[]{"carrot", "tarroc"});
        testCases.add(new String[]{"hello", "llloh"});

        for (int i = 0; i < testCases.size(); i++) {
            System.out.println(
                    tester.frequencyMap(testCases.get(i)[0], testCases.get(i)[1]) + " " +
                            tester.frequencyArray(testCases.get(i)[0], testCases.get(i)[1]) + " " +
                            tester.sortingSolution(testCases.get(i)[0], testCases.get(i)[1]));
        }

    }
}