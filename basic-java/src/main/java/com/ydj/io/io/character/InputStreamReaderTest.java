package com.ydj.io.io.character;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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
public class InputStreamReaderTest {

    public static void main(String[] args) throws Exception {
        readFromFile();
    }

    public static void readFromFile() throws Exception {
        try (Reader reader = new InputStreamReader(new FileInputStream("D:" + File.separator + "read_file.txt"))) {
            char[] chars = new char[1024];
            while (reader.read(chars) != -1){
                System.out.print(new String(chars));
            }
        }
    }

}
