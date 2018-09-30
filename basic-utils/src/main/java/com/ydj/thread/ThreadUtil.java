package com.ydj.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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
public class ThreadUtil {

    private ThreadUtil(){
    }

    private static Logger logger = LoggerFactory.getLogger(ThreadUtil.class);
    private static ThreadLocal<Map> threadLocal = new ThreadLocal<>();

    public static void putThreadVariable(String key, Object obj) {
        Map vm = threadLocal.get();
        if (null == vm) {
            vm =  new HashMap();
            threadLocal.set(vm);
        }
        vm.put(key, obj);
    }

    public static Object getThreadVariable(String key) {
        Map vm = threadLocal.get();
        if (null == vm) {
            if (logger.isDebugEnabled()) {
                logger.debug("The Object Map in threadLocal is null");
            }
            return null;
        } else {
            return vm.get(key);
        }
    }

    public static Object removeThreadVariable(String key) {
        Map vm = threadLocal.get();
        if (null == vm) {
            if (logger.isDebugEnabled()) {
                logger.debug("The Object Map in threadLocal is null");
            }
            return null;
        } else {
            return vm.remove(key);
        }
    }

    public static void clearThreadVariable() {
        Map vm = threadLocal.get();
        if (null != vm) {
            vm.clear();
            vm = null;
        }
    }

}
