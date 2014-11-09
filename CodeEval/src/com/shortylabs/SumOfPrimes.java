package com.shortylabs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeri on 10/25/14.
 */
public class SumOfPrimes {

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<Integer>();


        int i = 2;
        int count = 0;

        while(count < 1000) {

            if (isPrime(i)) {
                //System.out.println(i);
                primes.add(i);
                count++;
            }
            i++;

        }

        int sum = 0;
        for(Integer intgr : primes) {
            sum += intgr;
        }

        System.out.println(sum);
    }


    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

}
