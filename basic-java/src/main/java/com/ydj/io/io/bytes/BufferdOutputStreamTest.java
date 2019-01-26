package com.ydj.io.io.bytes;

import java.io.BufferedOutputStream;
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
public class BufferdOutputStreamTest {

    public static void main(String[] args) throws Exception {
        writeToFile();
    }

    public static void writeToFile() throws Exception {
        String separator = File.separator;
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:" + separator + "write_file" +
                ".txt"))) {
            for(int i = 0; i < 1000; i++) {
                String str = i + "";
                bos.write(str.getBytes(Charset.forName("UTF-8")));
                System.out.println("写入第" + i + "次");
                bos.write("\r\n".getBytes());
                bos.flush();
            }
        }
    }

}
