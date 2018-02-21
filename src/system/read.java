package system;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class read {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("filename.txt");
            int c;
            while((c=fr.read())!= -1) System.out.println((char)c);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
