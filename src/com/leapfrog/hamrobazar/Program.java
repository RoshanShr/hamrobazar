/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.hamrobazar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Sagar
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("http://cdn.hamrobazaar.com/802781_0701cd7g6dh2fgg5.jpg");
            URLConnection conn = url.openConnection();
            InputStream is=conn.getInputStream();
            FileOutputStream os=new FileOutputStream("C:/Users/rosun/Desktop/xyz.jpg");
            byte[] data=new byte[1024];
            int i=0;
            while((i=is.read(data))!=-1){
                os.write(data, 0, i);
            }
            is.close();
            os.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
