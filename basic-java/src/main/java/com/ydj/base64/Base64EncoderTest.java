package com.ydj.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Optional;

/**
 * Program Name: daily-test
 * <p>
 * Description:
 * <p>
 * Created by yangdejun on 2018/9/6
 *
 * @author yangdejun
 * @version 1.0
 */
public class Base64EncoderTest {

    /**
     * 对字符串进行 base64 基本加密
     * RFC4648
     * @param encodeStr 需要加密的字符串
     * @return 加密字符串不为空则返回加密后的字符串; 为空返回""
     */
    public static String baseEncoder(String encodeStr) throws UnsupportedEncodingException {
        if(Optional.ofNullable(encodeStr).isPresent()) {
            return Base64.getEncoder().encodeToString(encodeStr.getBytes("utf-8"));
        }
        return "";
    }

    /**
     * 对 URL 或 文件名进行 base64 进行加密
     * RFC4648_URLSAFE
     * @param encodeStr 需要加密的字符串
     * @return 加密字符串不为空则返回加密后的字符串; 为空返回""
     */
    public static String URLEncoder(String encodeStr) throws UnsupportedEncodingException {
        if(Optional.ofNullable(encodeStr).isPresent()) {
            return Base64.getUrlEncoder().encodeToString(encodeStr.getBytes("utf-8"));
        }
        return "";
    }

    /**
     * MIME 方案进行 base64 进行加密
     * RFC2045
     * @param encodeStr
     * @return 加密字符串不为空则返回加密后的字符串; 为空返回""
     */
    public static String MIMEEncoder(String encodeStr) throws UnsupportedEncodingException {
        if(Optional.ofNullable(encodeStr).isPresent()) {
            return Base64.getMimeEncoder().encodeToString(encodeStr.getBytes("utf-8"));
        }
        return "";
    }

    /**
     * mime 指定长度和分隔符的方法进行 base64 加密
     * @param encodeStr
     * @return 加密字符串不为空则返回加密后的字符串; 为空返回""
     */
    public static String MIMIEncoder02(String encodeStr) throws UnsupportedEncodingException {
        if(Optional.ofNullable(encodeStr).isPresent()) {
            return Base64.getMimeEncoder(1, " ".getBytes("utf-8")).encodeToString(encodeStr.getBytes());
        }
        return "";
    }

}
