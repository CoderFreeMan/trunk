package com.ydj.build.buildfromjavaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;

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
public class DataSourceFactory {


    public static DataSource getDataSource() {
        DataSource ds = new PooledDataSource();
        ((PooledDataSource) ds).setDriver("com.mysql.jdbc.Driver");
        ((PooledDataSource) ds).setUrl("jdbc:mysql://127.0.0.1:3306/mytest?serverTimezone=GMT%2B8");
        ((PooledDataSource) ds).setUsername("root");
        ((PooledDataSource) ds).setPassword("123456");
        return ds;
    }
}
