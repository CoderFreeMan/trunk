package com.ydj.io.io.character;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
public class OutputStreamWriterTest {

    public static void main(String[] args) throws Exception {
        writeToFile();
    }

    public static void writeToFile() throws Exception {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream("D:" + File.separator + "write_file.txt"))) {
            for(int i = 0; i < 1000; i++) {
                writer.write("我是中国人");
                writer.write("\r\n");
            }
        }
    }

}
