package com.shortylabs;

/**
 * Created by Jeri on 10/25/14.
 */
public class PrimePalindrome {

    public static void main(String[] args) {
        for (int i = 1000; i > 0; i--) {
            if (isPrime(i) && isPalindrome(i))    {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int n)  {
        if (n > 99 && n < 1000) {
            char[] chars = ("" + n).toCharArray();
            return chars[0] == chars[2];
        }
        return false;
    }
}
