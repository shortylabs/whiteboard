package com.shortylabs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jeri on 10/25/14.
 */
public class ReverseWords {

    public static void main(String[] args) {
        String input = readFile(args[0]);
        String[] lines = input.split("\n");


        for (String line : lines) {
            String[] words = line.split(" ");
            int size = words.length;

            StringBuffer buf = new StringBuffer();
            for (int j = size-1; j >= 0; j--) {
                if (buf.length() > 0) {
                    buf.append(" ");
                }
                buf.append(words[j]);
            }
            System.out.println(buf.toString());
        }
    }


    private static String readFile(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(bytes, Charset.forName("UTF-8"));
    }
}
