package system;

import java.io.*;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("filename.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter p = new PrintWriter("filename.txt");
            p.println("test123");
            p.println("test123");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
