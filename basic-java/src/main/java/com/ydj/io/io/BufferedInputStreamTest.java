package com.ydj.io.io;

import java.io.*;

/**
 * Program Name: trunk
 * <p>
 * Description:
 * <p>
 * Created by yangdejun on 2018/9/11
 *
 * @author yangdejun
 * @version 1.0
 */
public class BufferedInputStreamTest {

    public static void main(String[] args) {
            String file = "D:\\project-github\\trunk\\pom.xml";
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}