package com.ydj.design_patterns.singleton;

import org.junit.Assert;
import org.junit.Test;
import com.ydj.design_patterns.singleton.SingletonOfEnum;

import java.io.*;

/**
 * <p> Date             :2018/9/25 </p>
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
public class SingletonOfEnumTest {

    @Test
    public void getConnection() throws IOException, ClassNotFoundException {
//        SingletonOfEnum.DBConnection s1 = null;
//        SingletonOfEnum.DBConnection s = SingletonOfEnum.INSTANCE.getConnection();
//        FileOutputStream fos = new FileOutputStream("a.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(s);
//        oos.flush();
//        oos.close();
//        FileInputStream fis = new FileInputStream("a.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        s1 = (SingletonOfEnum.DBConnection) ois.readObject();
//
//        System.out.println(s.equals(s));
//        Assert.assertEquals(s, s1);

        SingletonOfEnum.DBConnection con1 = SingletonOfEnum.INSTANCE.getConnection();
        SingletonOfEnum.DBConnection con2 = SingletonOfEnum.INSTANCE.getConnection();
        Assert.assertEquals(con1, con2);
    }
}