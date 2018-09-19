package com.ydj.controller;

import com.alibaba.fastjson.JSONObject;
import com.ydj.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> Date             :2018/9/20 </p>
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
@RequestMapping(value = "/kafka/producer")
public class KafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/test")
    public User send(@RequestBody User user) {
        String topic = "test";
        String userStr = JSONObject.toJSONString(user);
        kafkaProducer.send(topic, userStr);
        return user;
    }

}

class User{

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
