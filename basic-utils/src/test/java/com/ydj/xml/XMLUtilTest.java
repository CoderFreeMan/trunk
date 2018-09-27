package com.ydj.xml;

import com.ydj.testentity.xmlentity.User;
import org.junit.Test;

import javax.xml.bind.JAXBException;

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
public class XMLUtilTest {

    @Test
    public void xmlToBean() throws IllegalAccessException, JAXBException, InstantiationException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"com.ydj.testentity.xmlentity.User\"><name>ydj</name></user>";
        User user = XMLUtil.xmlToBean(xml, User.class);
        System.out.println(user.toString());
    }

    @Test
    public void beanToXml() throws JAXBException {
        User user = new User();
        user.setName("ydj");
        String s = XMLUtil.beanToXml(user);
        System.out.println(s);
    }
}