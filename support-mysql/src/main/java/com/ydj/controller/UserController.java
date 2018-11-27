package com.ydj.controller;

import com.dajia.util.http.HttpClientUtil;
import com.ydj.mapper.UserMapper;
import com.ydj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public User selectOne(User user) {
        userMapper.selectOne(user);
        return user;
    }

    @PostMapping(value = "/test")
    public List<User> test() {
        List<User> userList = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        User u2 = new User();
        u2.setId(2);
        userList.add(u1);
        userList.add(u2);
        return userList;
    }

    @RequestMapping(value = "/aaa")
    public void test1 () throws Exception {
        String s = HttpClientUtil.doPost("localhost:9999/user/test", null);
        System.out.println(s);
    }

    @PostMapping(value = "/test9")
    public void test9(user user) {
        System.out.println(user.getName() + "-----" + user.getAge());
    }

    @PostMapping(value = "/test19")
    public void test9(@RequestParam String name) {
        System.out.println(name);
    }
}

class user{
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
