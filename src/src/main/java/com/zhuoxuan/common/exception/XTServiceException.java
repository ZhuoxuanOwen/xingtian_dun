package com.zhuoxuan.common.exception;

/**
 * <p>
 * JQ产品业务处理异常
 * </p>
 * 
 * @author 高江涛
 * @创建时间：2012-5-2 下午02:09:58
 * @产品: JQDevPlateform
 * @version： V1.0
 */
public class XTServiceException extends RuntimeException {

	/**
	 * <p>
	 * </p>
	 */
	private static final long serialVersionUID = 1L;

	public XTServiceException() {
		// TODO Auto-generated constructor stub
	}

	public XTServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public XTServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public XTServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
