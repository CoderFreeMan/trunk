package com.ydj.io.io.character;

import java.io.File;
import java.io.FileReader;

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
public class FileReaderTest {

    public static void main(String[] args) throws Exception {
        readFromFile();
    }

    public static void readFromFile() throws Exception {
        try (FileReader reader = new FileReader("D:" + File.separator + "read_file.txt")) {
            char[] chars = new char[1024];
            while (reader.read(chars) != -1) {
                System.out.println(chars);
            }
        }
    }

}
