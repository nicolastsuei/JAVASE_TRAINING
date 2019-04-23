package cn.infosoft.net.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 通道之间数据传输实例
 */
public class TransferDemo {
    public static void main(String[] argv) throws Exception {
        String relativelyPath = "d:/";
        // Path of Input files
        String[] iF = new String[] { relativelyPath + "/input1.txt", relativelyPath + "/input2.txt",
                relativelyPath + "/input3.txt", relativelyPath + "/input4.txt" };
        // Path of Output file and contents will be written in this file
        String oF = relativelyPath + "/combine_output.txt";
        // Acquired the channel for output file
        FileOutputStream output = new FileOutputStream(new File(oF));
        WritableByteChannel targetChannel = output.getChannel();
        for (int j = 0; j < iF.length; j++) {
            // Get the channel for input files
            FileInputStream input = new FileInputStream(iF[j]);
            FileChannel inputChannel = input.getChannel();

            // The data is tranfer from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            // close an input channel
            inputChannel.close();
            input.close();
        }
        // close the target channel
        targetChannel.close();
        output.close();
        System.out.println("所有任务完成...");
    }
}
