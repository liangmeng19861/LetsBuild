package com.letsbuild.base.exception;


/**
 * 业务异常类.<br>
 * 捕捉业务级错误的异常类
 * @version Version1.0
 *
 */
public class BusinessException extends GenericException {

    private static final long serialVersionUID = 1L;

    /**
     * 构造器
     * @param errorCode 异常代码
     * @param errorMessage 异常信息
     * @ServiceMethod
     */
    public BusinessException(String errorCode, String errorMessage) {
    	super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
