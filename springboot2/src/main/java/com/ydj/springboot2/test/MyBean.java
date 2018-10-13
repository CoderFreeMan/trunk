package com.ydj.springboot2.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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
@Order(value = 0)
public class MyBean implements CommandLineRunner {

    @Autowired
    private ApplicationArguments args;

    @Autowired
    private PropertiesRandomNum propertiesRandomNum;

    @Override
    public void run(String... args) throws Exception {
        args();
        System.out.println("-------------------------------------");
        int secret = propertiesRandomNum.getSecret();
        System.out.println("properties random number generate test -------> " + secret);
    }

    private void args(){
        boolean debug = args.containsOption("debug");
        System.out.println("2222222222222222222222" + debug);
        List<String> files = args.getNonOptionArgs();
        System.out.println("3333333333333333333333");
        files.stream().forEach(item -> {
            System.out.println(item);
        });
    }
}
