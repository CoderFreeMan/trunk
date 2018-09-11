package com.ydj.io.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Program Name: trunk
 * <p>
 * Description:
 * <p>
 * Created by yangdejun on 2018/9/11
 *
 * @author yangdejun
 * @version 1.0
 */
public class FileReaderTest {

    public static void main(String[] args) {
        String file = "D:\\project-github\\trunk\\pom.xml";
        try (FileReader fr = new FileReader(file)) {
            while (fr.read() > -1) {

            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException 文件没有找到");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException IO异常");
            e.printStackTrace();
        }
    }

}
