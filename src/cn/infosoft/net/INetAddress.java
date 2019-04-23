package cn.infosoft.net;

import java.io.IOException;
import java.net.InetAddress;

/**
 * InetAddress类的常用方法
 */
public class INetAddress {
    public static void main(String[] args) throws IOException {
        //创建一个表示本地主机的InetAddress对象
        InetAddress localAddress = InetAddress.getLocalHost();
        //获得指定主机的InetAddress对象
        InetAddress remoteAddress = InetAddress.getByName("www.info-soft.cn");
        //得到IP地址的主机名。
        System.out.println("本机的IP地址："+localAddress.getHostName());
        //获得字符串格式的原始IP地址
        System.out.println("中科信软的IP地址："+remoteAddress.getHostAddress());
        //判断指定的时间内地址是否可以到达
        System.out.println("3秒是否可达："+remoteAddress.isReachable(3000));
        System.out.println("itcast的主机名为："+remoteAddress.getHostName());
    }
}
