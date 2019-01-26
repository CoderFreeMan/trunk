package com.ydj.io.io.bytes;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Program Name: trunk
 * <p>
 * Description:
 * <p>
 * Created by yangdejun on 2018/9/12
 *
 * @author yangdejun
 * @version 1.0
 */
public class BufferdInputStreamTest {

    public static void main(String[] args) throws Exception {
        readFromFile();
    }

    public static void readFromFile() throws Exception {
        String separator = File.separator;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:" + separator + "read_file.txt"))) {
            byte[] bytes = new byte[1024];
            while (bis.read(bytes) != -1) {
                String str = new String(bytes);
                System.out.println(str);
            }
        }
    }

}
