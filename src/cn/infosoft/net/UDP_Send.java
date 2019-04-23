package cn.infosoft.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送端程序
 */
public class UDP_Send {
    public static void main(String[] args) throws Exception {
        //创建一个DatagramSocket对象
        DatagramSocket ds = new DatagramSocket(3000);
        //要发送的数据
        String str = "Hello World!";
        //创建一个要发送的数据包，包括发送数据，数据长度，接收端IP地址以及端口号
        DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(), InetAddress.getByName("localhost"),8954);
        //发送数据
        System.out.println("发送消息");
        ds.send(dp);
        //释放资源
        ds.close();
    }
}
