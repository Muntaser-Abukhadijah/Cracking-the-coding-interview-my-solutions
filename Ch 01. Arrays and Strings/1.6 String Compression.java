package com.company;

import javax.print.attribute.standard.Compression;
import java.util.*;

// 1.6

public class Main {


    public String stringCompression(String str) {  // O(n)
        int ptr = 0, counter = 0;
        StringBuilder compressedString = new StringBuilder();
        while (ptr < str.length()) {
            counter = 0;
            compressedString.append(str.charAt(ptr++));
            counter++;
            while (ptr < str.length() && str.charAt(ptr) == compressedString.charAt(compressedString.length() - 1)) {
                counter++;
                ptr++;
            }
            compressedString.append(counter);
        }
        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }


    public static void main(String[] args) {

        Main tester = new Main();
        System.out.println(tester.stringCompression("aabcccccaaa"));
        System.out.println(tester.stringCompression("aabbccdd"));
        System.out.println(tester.stringCompression("abcd"));
        System.out.println(tester.stringCompression("aabbccddd"));
    }
}
