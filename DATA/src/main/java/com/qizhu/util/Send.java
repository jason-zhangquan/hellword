package com.qizhu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 *	微网通联短彩信接口文档
 * @author Administrator
 */
public class Send {

    public static String SMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
    
    
    public static void main(String[] args) {
//    	String PostData = "sname=DL-fanchong&spwd=fanchong1&scorpid=&sprdid=1012888&sdst=17751455704&smsg="+"您的验证码是：15123。请不要把验证码泄露给其他人。【微网通联】";
    	String PostData = "sname=dlshqz00&spwd=BeTjtE66&scorpid=&sprdid=1012888&sdst=17751455704&smsg="+"您的验证码是：123456。请不要把验证码泄露给其他人。【运势日历】";
        //out.println(PostData);
        String ret = SMS(PostData,"http://cf.51welink.com/submitdata/Service.asmx/g_Submit");
        System.out.println(ret);
	}
}
