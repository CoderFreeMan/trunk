package com.ydj.mapper;

import com.ydj.model.User;
import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface UserMapper {

    User selectOne(User user);

    void insertOne(User user);

}
