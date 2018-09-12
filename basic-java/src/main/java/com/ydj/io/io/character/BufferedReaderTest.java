package com.ydj.io.io.character;

import java.io.BufferedReader;
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
public class BufferedReaderTest {

    public static void main(String[] args) throws Exception {
        readFromFile();
    }

    /**
     * 读取文件
     * @throws Exception
     */
    public static void readFromFile() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:" + File.separator + "read_file.txt"))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        }
    }
}