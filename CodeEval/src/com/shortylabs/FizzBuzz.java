package com.shortylabs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jeri on 10/25/14.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        String input = null;

        String F = "F";
        String B = "B";
        String FB = "FB";

        try {

            input = readFile(args[0], Charset.forName("UTF-8"));
            if (input == null) {
                return;
            }
            String[] lines = input.split("\n");

            for (String line: lines) {
                String[] xyn = line.split(" ");
                int x = Integer.parseInt(xyn[0]);
                int y = Integer.parseInt(xyn[1]);
                int n = Integer.parseInt(xyn[2]);

                StringBuffer buf = new StringBuffer();

                for (int i = 1; i <= n; i++) {
                    if (buf.length() > 0) {
                        buf.append(" ");
                    }

                    if (m(i, x) && m(i, y)) {
                        buf.append(FB);
                    }
                    else if (m(i, x)) {
                        buf.append(F);
                    }
                    else if (m(i, y)) {
                        buf.append(B);
                    }
                    else {
                        buf.append(i);
                    }
                }
                System.out.println(buf.toString());
            }


        } catch(IOException ioe) {
            System.out.println("Failed to open input file: " + ioe.getMessage());
            return;
        }
    }

    private static boolean m(int dividend, int divisor) {
        return dividend%divisor == 0;
    }


    private static String readFile(String path, Charset charset) throws  IOException {

        byte[] bytes = Files.readAllBytes( Paths.get(path));
        return new String(bytes, charset);
    }
}
