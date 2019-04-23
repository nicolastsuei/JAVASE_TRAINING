package cn.infosoft.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP接收端程序
 */
public class UDP_Receive {
    public static void main(String[] args) throws IOException {
        //创建一个长度为1024的字节数组，用于接收数据
        byte [] buf = new byte[1024];
        //定义一个DatagramSocket对象，监听的端口为8954
        DatagramSocket ds = new DatagramSocket(8954);
        //定义一个DatagramPacket对象，用于接收数据
        DatagramPacket dp = new DatagramPacket(buf,1024);
        System.out.println("等待接收数据");
        //等待接收数据，如果没有数据则会阻塞
        ds.receive(dp);
        //调用DatagramPacket的方法获得接收的消息，包括内容、长度、IP地址和端口号
        String str = new String(dp.getData(),0,dp.getLength()) +"from"+dp.getAddress().getHostAddress()+":"+dp.getPort();
        //打印收到的信息
        System.out.println(str);
        //释放资源
        ds.close();
    }
}
