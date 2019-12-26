package com.github.wheatphp.blog.util;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    public static void main(String[] args) {
        doGet();
//        doPost();
    }

    public static String doGet() {
        StringBuilder body = new StringBuilder();
        try {
            URL url = new URL("http://www.baidu.com");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            body.append(StreamToString.ConvertToString(inputStream));
            System.out.println(body);
            return body.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body.toString();
    }

    public static String doPost() {
        StringBuilder body = new StringBuilder();
        try {
            URL url = new URL("url");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            body.append(StreamToString.ConvertToString(inputStream));
            System.out.println(body);
            return body.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body.toString();
    }
}
