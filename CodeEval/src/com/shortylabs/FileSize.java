package com.shortylabs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jeri on 10/25/14.
 */
public class FileSize {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner();
        try {
            System.out.println(Files.readAllBytes(Paths.get(args[0])).length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
