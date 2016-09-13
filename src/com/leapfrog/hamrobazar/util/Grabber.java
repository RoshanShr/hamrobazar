/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.hamrobazar.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Sagar
 */
public class Grabber {
    
    public String grab(String link,String param) throws IOException {
        URL url = new URL(link);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        if(param!=null){
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.getOutputStream().write((param).getBytes());
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }
    
}
