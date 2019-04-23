package cn.infosoft.net.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 基本FileLock示例
 */
public class FileLockDemo {
    public static void main (String [] args)  throws IOException {
        String input = "* end of the file.";
        System.out.println("向文件结尾输入： " + input);
        ByteBuffer buf = ByteBuffer.wrap(input.getBytes());
        String fp = "d:/testout-file.txt";
        Path pt = Paths.get(fp);
        FileChannel fc = FileChannel.open(pt, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        System.out.println("文件通道打开，获取锁...");
        // 文件结尾所处位置
        fc.position(fc.size() - 1);
        FileLock lock = fc.lock();
        System.out.println("共享锁: " + lock.isShared());
        fc.write(buf);
        //释放锁
        fc.close();
        System.out.println("文件内容操作完成，关闭通道、释放锁。");
        PrintFile.print(fp);
    }
}
