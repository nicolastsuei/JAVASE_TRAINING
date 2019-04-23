package cn.infosoft.net.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * 基本缓冲区示例
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {
        Path file = null;
        BufferedReader bufferedReader = null;
        String relativelyPath = "d:/";
        try {
            file = Paths.get(relativelyPath + "/testout.txt");
            InputStream inputStream = Files.newInputStream(file);

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("读取testout.txt文件: \n" + bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
