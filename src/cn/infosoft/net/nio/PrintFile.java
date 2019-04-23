package cn.infosoft.net.nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintFile {
    public static void print(String path) throws IOException {
        FileReader filereader = new FileReader(path);
        BufferedReader bufferedreader = new BufferedReader(filereader);
        String tr = bufferedreader.readLine();
        System.out.println("testout-file.txt文件内容是： ");
        while (tr != null) {
            System.out.println("    " + tr);
            tr = bufferedreader.readLine();
        }
        filereader.close();
        bufferedreader.close();
    }
}
