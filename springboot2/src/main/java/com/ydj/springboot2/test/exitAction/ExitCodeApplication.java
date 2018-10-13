package com.ydj.springboot2.test.exitAction;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;
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
public class ExitCodeApplication {


    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }


}
