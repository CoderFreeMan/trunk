package com.ydj.controller;

import com.ydj.mapper.UserMapper;
import com.ydj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> Date             :2017/10/9 </p>
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
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/insertOneUser")
    public User insertOneUser(@RequestBody User user) {
        userMapper.insertOne(user);
        return user;
    }

    @RequestMapping(value = "/selectOneUser")
    public User selectOne(@RequestBody User user) {
        userMapper.selectOne(user);
        return user;
    }

}
