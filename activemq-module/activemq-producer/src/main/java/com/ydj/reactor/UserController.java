package com.ydj.reactor;

import com.ydj.POJOs.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p> Date             :2018/9/23 </p>
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
@RequestMapping(value = "/activemq")
public class UserController {

    @Autowired
    private UserProducer userProducer;

    @PostMapping(value = "/user")
    public String user(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return result.getAllErrors().toString();
        }

        userProducer.sendMsg(user);

        return "success";
    }

}
