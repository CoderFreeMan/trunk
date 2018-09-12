package com.ydj.io.io.bytes;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

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
public class ByteArrayOutPutStreamTest {

    public static void main(String[] args) throws Exception {
        writeToBytes();
    }

    public static void writeToBytes() throws Exception {
        try (InputStream is = new FileInputStream("D://read_file.txt")) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            while (is.read(bytes) != -1) {
                output.write(bytes);
            }
            String data = output.toString("UTF-8");
            System.out.println(data);
        }
    }

}
