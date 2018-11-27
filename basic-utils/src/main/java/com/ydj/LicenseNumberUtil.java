package com.ydj;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  
 *  <p> Date             : 2018/11/27 </p >
 *  <p> Module             : </p >
 *  <p> Description             : 证件号大码 </p >
 *  <p> Remark             : </p >
 *  @author yangdj
 *  @version 1.0
 *  <p>--------------------------------------------------------------</p >
 *  <p>修改历史</p >
 *  <p>    序号    日期    修改人    修改原因    </p >
 *  <p>    1                           </p >
 *  
 */
public class LicenseNumberUtil {

    private static final Logger logger = LoggerFactory.getLogger(LicenseNumberUtil.class);

    private static final String EXCEPTION_MSG = "截取长度不能大于证件号长度,证件号 [{}], 截取长度[{}]";

    private static final String EXCEPTION_MSG1 = "截取长度不能小于0, 证件号 [{}], 开头保留位数 [{}], 末尾保留位数[{}]" ;

    /**
     * 给证件号打码
     * @param originalCardNum 原始证件号码
     * @param frontRemained   开头保留位数
     * @param endRemained     末尾保留位数
     * @return                  打码后的证件号码
     */
    public static String addMosaic(String originalCardNum, int frontRemained, int endRemained) throws Exception {
        // 证件号码不能为空
        if (StringUtils.isEmpty(originalCardNum)) {
            return null;
        }
        // 需要截取的长度不能大于身份证号长度
        if ((frontRemained + endRemained) > originalCardNum.length()) {
            logger.info(EXCEPTION_MSG, originalCardNum, (frontRemained + endRemained));
            throw new Exception(EXCEPTION_MSG);
        }
        //需要截取的不能小于0
        if (frontRemained < 0 || endRemained < 0) {
            logger.info(EXCEPTION_MSG1, originalCardNum, frontRemained, endRemained);
            throw new Exception(EXCEPTION_MSG1);
        }
        //计算 * 的数量
        int asteriskCount = originalCardNum.length() - (frontRemained + endRemained);
        StringBuffer asteriskStr = new StringBuffer();
        for (int i = 0; i < asteriskCount; i++) {
            asteriskStr.append("*");
        }
        String regex = "(\\w{" + String.valueOf(frontRemained) + "})(\\w+)(\\w{" + String.valueOf(endRemained) + "})";
        return originalCardNum.replaceAll(regex, "$1" + asteriskStr + "$3");
    }

}
