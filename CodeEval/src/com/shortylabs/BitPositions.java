package com.shortylabs;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

/**
 * Created by Jeri on 10/27/14.
 */
public class BitPositions {


    /**
     * 86,2,3
     * 125,1,2
     * @param args
     */
    public static void main(String[] args)  {

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(args[0]) );
            String input = new String(bytes, Charset.forName("UTF-8"));

            String[] testCases = input.split("\n");

            BigInteger bi = null;
            for (String testCase : testCases)  {
                String[] params = testCase.split(",");
                bi = new BigInteger(params[0]);

//                System.out.println(bi.testBit(Integer.parseInt(params[1])-1));
//                System.out.println(bi.testBit(Integer.parseInt(params[2])-1));

                System.out.println(bi.testBit(Integer.parseInt(params[1])-1) ==
                        bi.testBit(Integer.parseInt(params[2])-1));

            }

        } catch (IOException ioe) {

        }
    }
}
