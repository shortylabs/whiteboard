package com.shortylabs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jeri on 10/26/14.
 */
public class Multiples {

    public static void main(String[] args) {

        String[] lines = readFileLines(args[0]);

        for (String line : lines) {
            String[] xn = line.split(",");
            int x = Integer.parseInt(xn[0]);
            int n = Integer.parseInt(xn[1]);


            int total = 0;
            while (total < x) {
                total += n;
            }
            System.out.println(total);
        }


    }

    private static String[] readFileLines(String path)  {
        byte[] bytes = null;
        String input = null;

        try {
            bytes = Files.readAllBytes(Paths.get(path));
            input = new String(bytes, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input.split("\n");
    }
}
