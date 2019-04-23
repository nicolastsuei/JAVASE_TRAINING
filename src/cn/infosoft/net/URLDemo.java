package cn.infosoft.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL baidu =new URL("http://www.baidu.com");
        //？表示参数，#表示锚点
        URL url =new URL(baidu,"/index.html?username=tom#test");
        //获取协议
        System.out.println(url.getProtocol());
        //获取主机
        System.out.println(url.getHost());
        //如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
        System.out.println( url.getPort());
        //获取文件路径
        System.out.println( url.getPath());
        //文件名，包括文件路径+参数
        System.out.println(url.getFile());
        //相对路径，就是锚点，即#号后面的内容
        System.out.println(url.getRef());
        //查询字符串，即参数
        System.out.println(url.getQuery());
    }
}
