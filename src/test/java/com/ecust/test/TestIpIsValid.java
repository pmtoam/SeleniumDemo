package com.ecust.test;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class TestIpIsValid {

    @Test
    public void test() throws Exception {
//        URL url = new URL("http://www.baidu.com");
        URL url = new URL("http://www.baidu.com/s?wd=ip&tn=96826017_hao_pg&ch=2");
        String[] split = "114.99.31.46:18729".split(":");
        String hostname = split[0];
        int port = Integer.parseInt(split[1]);
        // 创建代理服务器
        InetSocketAddress inetSocketAddress = new InetSocketAddress(hostname, port);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, inetSocketAddress); // http 代理
        URLConnection conn = url.openConnection(proxy);
        conn.setConnectTimeout(3000);
        InputStream in = conn.getInputStream();
        // InputStream in = url.openStream();
        String s = IOUtils.toString(in, "utf-8");
        System.out.println(s);
    }

}
