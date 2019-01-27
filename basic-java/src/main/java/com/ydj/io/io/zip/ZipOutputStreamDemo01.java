package com.ydj.io.io.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamDemo01 {
    public static void main(String[] args) throws Exception {
        File file = new File("/home/ydj/Desktop/zknamespace.jpg") ;	// 定义要压缩的文件
        File zipFile = new File("/home/ydj/Desktop/image.zip") ;	// 定义压缩文件名称
        InputStream input = new FileInputStream(file) ;	// 定义文件的输入流
        ZipOutputStream zipOut = null ;	// 声明压缩流对象
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile)) ;
        zipOut.putNextEntry(new ZipEntry(file.getName())) ;	// 设置ZipEntry对象
        zipOut.setComment("压缩流测试") ;	// 设置注释
        int temp = 0 ;
        while((temp=input.read())!=-1){	// 读取内容
            zipOut.write(temp) ;	// 压缩输出
        }
        input.close() ;	// 关闭输入流
        zipOut.close() ;	// 关闭输出流
    }
}
