package com.ydj;

import com.ydj.entity.User;
import com.ydj.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> Date             :2018/3/2 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 * <p>--------------------------------------------------------------</p>
 * <p>修改历史</p>
 * <p>    序号    日期    修改人    修改原因    </p>
 * <p>    1                                     </p>
 */
@RestController
@RequestMapping("/consumer")
public class TestController {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private DemoService demoService;

    @PostMapping(value = "/test")
    public User test(@RequestBody User user) {
        LOGGER.info("入参为: " + user.toString());
        User response = demoService.sayHello(user);
        LOGGER.info("================" + response + "================");
        return response;
    }
}
