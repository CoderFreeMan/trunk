package com.ydj.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Optional;

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
public class Base64DecoderTest {

    /**
     * 对需要解密的字符串进行基本的 base64 解密
     * @param decodeStr 需要解密的字符串
     * @return 解密字符串不为空则返回解密后的字符串; 为空返回""
     */
    public static String baseDecoder(String decodeStr) throws UnsupportedEncodingException {
        if(Optional.ofNullable(decodeStr).isPresent()) {
            return Base64.getDecoder().decode(decodeStr.getBytes("utf-8")).toString();
        }
        return "";
    }

    /**
     * 对需要解密的 URL 或 文件名 进行的 base64 解密
     * @param decodeStr
     * @return
     */
    public static String URLDecoder(String decodeStr) throws UnsupportedEncodingException {
        if(Optional.ofNullable(decodeStr).isPresent()) {
            return Base64.getUrlDecoder().decode(decodeStr.getBytes("utf-8")).toString();
        }
        return "";
    }

    /**
     * 对需要解密的字符串进行 base64 解密
     * @param decodeStr
     * @return
     */
    public static String MIMEDecoder(String decodeStr) throws UnsupportedEncodingException {
        if(Optional.ofNullable(decodeStr).isPresent()) {
            return Base64.getMimeDecoder().decode(decodeStr.getBytes("utf-8")).toString();
        }
        return "";
    }

}
