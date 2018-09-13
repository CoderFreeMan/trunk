package com.ydj.buffer;

/**
 * Program Name: trunk
 * <p>
 * Description:
 * <p>
 * Created by yangdejun on 2018/9/13
 *
 * @author yangdejun
 * @version 1.0
 */
public class StringBufferTeset {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("14456788756");
        sb.append("<br>" + "18937671061");
        System.out.println(sb.toString());
        System.out.println(sb.length());
    }

}
