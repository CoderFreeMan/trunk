package com.ydj.io.io.character;

import java.io.BufferedWriter;
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
public class BufferedWriterTest {

    public static void main(String[] args) throws Exception {
        writeToFile();
    }

    /**
     * 写文件
     * @throws Exception
     */
    public static void writeToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:" + File.separator + "write_file.txt"))) {
            for(int i = 0; i < 1000; i++) {
                String str = "安静地方卡接口圣诞节覅而你就发";
                bw.write(str);
                bw.newLine();
            }
        }
    }

}
