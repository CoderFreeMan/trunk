package com.ydj.bean;

import com.ydj.testEntity.Book;
import com.ydj.testEntity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> Date             :2018/9/24 </p>
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
public class BeanUtilTest {

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(BeanUtilTest.class);

    /**
     * 测试Java对象转换为Map集合
     * BeanUtil.beanToMap
     */
    @Test
    public void beanToMap() {
        User user = new User();
        user.setName("ydj");
        user.setPhoneNum("87654678765");
        user.setAge(25);
        user.setHeight(170.5);
        user.setWeight(54.5);
        Book book = new Book();
        book.setBookName("《Java 开发手册》");
        book.setBookPrice(25.5);
        Book book1 = new Book();
        book1.setBookName("《Java 开发手册》");
        book1.setBookPrice(25.5);
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        user.setBooks(books);
        Map<String, Object> userMap = BeanUtil.beanToMap(user);
        userMap.forEach((k, v) -> {
            logger.info(k + "=" + v);
        });
    }

    /**
     * 测试Map集合转换为Java对象
     */
    @Test
    public void mapToBean() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ydj");
        map.put("age", 25);
        Book book = new Book();
        book.setBookName("《Java 开发手册》");
        book.setBookPrice(25.5);
        Book book1 = new Book();
        book1.setBookName("《Java 开发手册》");
        book1.setBookPrice(25.5);
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        map.put("books", books);
        User user = BeanUtil.mapToBean(map, new User().getClass());
        System.out.println(user.toString());
    }
}