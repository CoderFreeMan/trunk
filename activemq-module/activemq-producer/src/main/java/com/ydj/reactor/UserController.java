package com.ydj.reactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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

class User implements Serializable {

    @NotNull(message = "001001001")
    private String userName;

    private String realName;

    @NotNull(message = "001001002")
    private String phoneNum;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
