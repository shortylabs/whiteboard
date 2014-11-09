package com.shortylabs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeri on 10/26/14.
 */
public class SumOfIntegers {


    public static void main(String[] args) {

        List<Integer> ints = readIntegers(args[0]);
        Integer sum = 0;
        for (Integer i : ints) {
            sum += i;
        }
        System.out.println(sum);

    }

    private static List<Integer> readIntegers(String path)  {
        List<Integer> ints = new ArrayList<Integer>();
        try {

            byte[] bytes = Files.readAllBytes(Paths.get(path));
            String input = new String(bytes, Charset.forName("UTF-8"));
            String[] lines = input.split("\n");
            for (String line: lines) {

                ints.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ints;
    }
}
