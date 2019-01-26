package com.ydj.base64;

import java.io.UnsupportedEncodingException;

/**
 * Program Name: daily-test
 * <p>
 * Description:
 * <p>
 * Created by yangdejun on 2018/9/7
 *
 * @author yangdejun
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encoderStr = "asddsa";

        String afterBase64Encoder = Base64EncoderTest.baseEncoder(encoderStr);
        System.out.println(afterBase64Encoder);
        String afterBase64Decoder = Base64DecoderTest.baseDecoder(afterBase64Encoder);
        System.out.println(afterBase64Decoder);

        String url = "https://www.baidu.com/";
        String afterURLEncoder = Base64EncoderTest.URLEncoder(url);
        System.out.println(afterURLEncoder);
        String afterURLDecoder = Base64DecoderTest.URLDecoder(afterURLEncoder);
        System.out.println(afterURLDecoder);
    }

}
