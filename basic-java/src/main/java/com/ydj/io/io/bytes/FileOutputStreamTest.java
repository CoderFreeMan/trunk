package com.ydj.io.io.bytes;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

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
public class FileOutputStreamTest {

    public static void main(String[] args) throws Exception {
        writeToFile();
    }

    public static void writeToFile() throws Exception {
        String separator = File.separator;
        try (FileOutputStream fos = new FileOutputStream("D:" + separator + "write_file.txt")) {
            for(int i = 0; i < 10; i++) {
                String str = i + "";
                fos.write(str.getBytes(Charset.forName("UTF-8")));
                fos.write("\r\n".getBytes());
                fos.flush();
            }
        }
    }

}
