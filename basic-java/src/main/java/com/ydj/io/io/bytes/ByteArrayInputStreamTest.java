package com.ydj.io.io.bytes;

import java.io.ByteArrayInputStream;

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
public class ByteArrayInputStreamTest {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{0x1,0x2,0x3,0x4,0x5,0x6,0x7};
//        System.out.println(readFromArray(bytes));

        readMarkAndReset(bytes, 2);
    }

    public static String readFromArray(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        int tmp;
        while ((tmp = bais.read()) != -1) {
            sb.append(Integer.toHexString(tmp));
        }
        return sb.toString();
    }

    public static void readMarkAndReset(byte[] bytes, int mark) {
        StringBuffer sb = new StringBuffer();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        bais.mark(mark);
        bais.skip(mark + 2);
        int tmp;
        while ((tmp = bais.read()) != -1) {
            sb.append(Integer.toHexString(tmp));
        }
        System.out.println("越过标记后的字符串");
        System.out.println(sb.toString());

        bais.reset();
        sb.setLength(0);
        int m;
        while ((m = bais.read()) != -1) {
            sb.append(Integer.toHexString(m));
        }
        System.out.println("重置之后的字符串");
        System.out.println(sb.toString());
    }

}
