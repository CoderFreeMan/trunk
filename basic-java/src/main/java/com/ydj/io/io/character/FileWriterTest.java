package com.ydj.io.io.character;

import java.io.File;
import java.io.FileWriter;

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
public class FileWriterTest {

    public static void main(String[] args) throws Exception {
        writeToFile();
    }

    public static void writeToFile() throws Exception {
        try (FileWriter writer = new FileWriter("D:" + File.separator + "write_file.txt")) {
            for(int i = 0; i < 1000; i++) {
                writer.write("aj安洁科技的疯狂的了解佛IE老卡机的看法 \n");
          }
        }
    }

}
