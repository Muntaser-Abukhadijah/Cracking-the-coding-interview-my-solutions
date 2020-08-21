package com.company;

import java.util.*;

// 1.3

public class Main {

    public char[] URLify(char[] str, int len) {
        int ptr1 = len - 1, ptr2 = str.length - 1;

        while (ptr1 > 0) {
            while (ptr1 > 0 && str[ptr1] != ' ') {
                str[ptr2--] = str[ptr1--];
            }
            if (ptr1 >= 0) {
                str[ptr2--] = '0';
                str[ptr2--] = '2';
                str[ptr2--] = '%';
                ptr1--;
            }
        }
        return str;
    }

    public static void main(String[] args) {

        Main tester = new Main();
        char [] test ={' ','M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ','x','x',' ',' ',' ',' ',' ',' ',' ',' '};
        System.out.println(tester.URLify(test,17));
    }
}
