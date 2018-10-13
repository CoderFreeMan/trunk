package com.ydj.springboot2.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *  * 
 *  * <p> Date             : 2018/10/13 </p >
 *  * <p> Module           : </p >
 *  * <p> Description      : </p >
 *  * <p> Remark           : </p >
 *  *
 *  * @author yangdejun
 *  * @version 1.0
 *  * <p>--------------------------------------------------------------</p >
 *  * <p>修改历史</p >
 *  * <p>    序号    日期    修改人    修改原因    </p >
 *  * <p>    1                                     </p >
 *  
 */
@Component
public class PropertiesRandomNum {

    @Value(value = "${my.secret}")
    private int secret;

    public int getSecret() {
        return secret;
    }

    public void setSecret(int secret) {
        this.secret = secret;
    }
}
