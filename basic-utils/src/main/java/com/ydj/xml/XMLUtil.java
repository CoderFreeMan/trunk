package com.ydj.xml;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

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
public class XMLUtil {

    /**
     * 私有的构造方法，防止被实例化
     */
    private XMLUtil() {
        throw new AssertionError();
    }

    public static final String NULL_OR_BLANK_EXCEPTION = "params must be not null or blank string";

    /**
     * xml 转 bean
     * @param xml 需要转换为 bean 的 xml
     * @param cls xml 转换为 bean 的类型
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws JAXBException
     */
    public static <T> T xmlToBean(String xml, Class<T> cls) throws JAXBException {
        if (StringUtils.isBlank(xml)) {
            throw new NullPointerException(NULL_OR_BLANK_EXCEPTION);
        }
        return (T) JAXBContext.newInstance(cls).createUnmarshaller().unmarshal(new StringReader(xml));
    }

    /**
     * bean 转 xml
     * @param o 需要转换为xml的对象
     * @return 转换后的xml对象
     * @throws JAXBException
     */
    public static String beanToXml(Object o) throws JAXBException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Marshaller marshaller = JAXBContext.newInstance(o.getClass()).createMarshaller();
        //格式化输出
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //XML编码格式
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        //XML头部信息
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
        //设置根节点
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, o.getClass().getName());
        marshaller.marshal(o, baos);
        return baos.toString();
    }

}
