package com.ydj.bean;

import com.ydj.testentity.Book;
import com.ydj.testentity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanMapUtilTest {

    @Test
    public void beanToMap() {
        User user = new User();
        user.setName("ydj");
        user.setAge(25);
        user.setPhoneNum("34567890987654");
        user.setHeight(170.05);
        user.setWeight(54.05);
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setBookName("Effective Java");
        Book b2 = new Book();
        b2.setBookPrice(128.00);
        books.add(b1);
        books.add(b2);
        user.setBooks(books);
        Map<String, Object> beanMap = BeanMapUtil.beanToMap(user);
        beanMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }

    @Test
    public void mapToBean() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ydj");
        map.put("age", 25);
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setBookName("Effective Java");
        Book b2 = new Book();
        b2.setBookPrice(128.00);
        books.add(b1);
        books.add(b2);
        map.put("books", books);
        User user = BeanMapUtil.mapToBean(map, User.class);
        System.out.println(user.toString());
    }
}