package com.ydj.POJOs;

import java.math.BigDecimal;

/**
 * Program Name: trunk
 * <p>
 * Description:
 * <p>
 * Created by yangdejun on 2018/9/11
 *
 * @author yangdejun
 * @version 1.0
 */
public class Apple {

    private Integer id;
    private int code;
    private String name;
    private BigDecimal money;
    private Integer num;
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Apple() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", num=" + num +
                '}';
    }
}
