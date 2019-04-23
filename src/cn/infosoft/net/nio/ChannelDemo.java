package cn.infosoft.net.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 基本通道示例
 */
public class ChannelDemo {
    public static void main(String args[]) throws IOException {
        String relativelyPath = "d:/";
        FileInputStream input = new FileInputStream(relativelyPath + "/testin.txt");
        ReadableByteChannel source = input.getChannel();
        FileOutputStream output = new FileOutputStream(relativelyPath + "/testout.txt");
        WritableByteChannel destination = output.getChannel();
        copyData(source, destination);
        source.close();
        destination.close();
        System.out.println("复制文件完成");
    }

    private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
        while (src.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
            buffer.clear();
        }
    }
}
