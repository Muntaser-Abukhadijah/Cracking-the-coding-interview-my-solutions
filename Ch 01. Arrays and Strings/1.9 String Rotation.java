package com.company;

import javax.print.attribute.standard.Compression;
import java.util.*;

// 1.9

public class Main {

    public boolean isSubstring(String s1, String s2) {
        if (s1.indexOf(s2) > 0)
            return true;
        return false;
    }

    public boolean StringRotation(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() != 0) {
            return isSubstring(s1 + s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {

        Main tester = new Main();
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = tester.StringRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}