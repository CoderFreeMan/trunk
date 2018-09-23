package com.ydj.common.activemq.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * <p> Date             :2018/9/23 </p>
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
public class MQException extends RuntimeException {

    private static final long serialVersionUID = 5603499492608004859L;

    //定义保存异常信息
    private Throwable cause;

    public MQException() {
    }

    public MQException(String message) {
        super(message);
    }

    public MQException(String message, Throwable cause) {
        super(message, cause);
        this.cause = cause;
    }

    public MQException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    /**
     * 重写 getCause() 方法
     *
     * @return Throwable 对象
     */
    @Override
    public Throwable getCause() {
        return null == this.cause ? null : this.cause;
    }

    /**
     * 重写父类的  getMessage()方法
     *
     * @return String
     */
    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder(super.getMessage());
        if (cause != null) {
            message.append("; MQ Exception is ").append(cause);
        }
        return message.toString();
    }

    /**
     * 重写父类的  printStackTrace 方法
     */
    @Override
    public void printStackTrace(PrintStream printStream) {
        if (null == getCause()) {
            super.printStackTrace(printStream);
        } else {
            printStream.println(this);
            getCause().printStackTrace(printStream);
        }
    }

    /**
     * 重写父类的  printStackTrace 方法
     */
    @Override
    public void printStackTrace(PrintWriter printWriter) {
        if (null == getCause()) {
            super.printStackTrace(printWriter);
        } else {
            printWriter.println(this);
            getCause().printStackTrace(printWriter);
        }
    }
}
