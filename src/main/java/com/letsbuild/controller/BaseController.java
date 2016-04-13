package com.letsbuild.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

public class BaseController {
	
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession session;
	/**
	 * 响应客户端结果 成功、失败、错误
	 */
	private static final String RES_RESULT = "res_result";
	/**
	 * 响应客户端结果描述
	 */
	private static final String RES_MSG = "res_msg";
	/**
	 * 响应客户端数据
	 */
	private static final String RES_DATA = "res_data";
	/**
	 * Exception Stack
	 */
	private static final String RES_ES = "res_es";
	/**
	 * 响应客户端结果 成功
	 */
	private static final String SUCCESS = "success";
	/**
	 * 响应客户端结果 失败
	 */
	private static final String FAILED = "failed";
	/**
	 * 响应客户端结果 错误
	 */
	private static final String ERROR = "error";

	/**
	 * json响应客户端成功
	 */
	protected void responseSuccess(HttpServletResponse response, String msg, Object data) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(RES_RESULT, SUCCESS);
			jsonObject.put(RES_MSG, msg);
			jsonObject.put(RES_DATA, data);
			printWriter.write(jsonObject.toString());
			printWriter.flush();
		} catch (Exception e) {
			logger.error("重大异常，responseSuccess报错！", e);
		} finally {
			printWriter.close();
		}
	}

	/**
	 * json响应客户端失败
	 */
	protected void responseFailed(HttpServletResponse response, String msg, JSONObject data) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(RES_RESULT, FAILED);
			jsonObject.put(RES_MSG, msg);
			jsonObject.put(RES_DATA, data);
			printWriter.write(jsonObject.toString());
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error("重大异常，responseFailed报错！", e);
		} finally {
			printWriter.close();
		}
	}

	/**
	 * json响应客户端错误信息
	 */
	protected void responseError(HttpServletResponse response, String msg, Exception stackException) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(RES_RESULT, ERROR);
			jsonObject.put(RES_MSG, msg);
			jsonObject.put(RES_ES, stackException.getStackTrace());
			jsonObject.put(RES_DATA, stackException.getMessage());
			printWriter.write(jsonObject.toString());
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error("重大异常，responseError报错！", e);
		} finally {
			printWriter.close();
		}
	}

	/**
	 * json响应客户端true
	 */
	protected void responseTrue(HttpServletResponse response) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			printWriter.write("true");
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error("重大异常，responseTrue报错！", e);
		} finally {
			printWriter.close();
		}
	}

	/**
	 * json响应客户端false
	 */
	protected void responseFalse(HttpServletResponse response) {
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			printWriter = response.getWriter();
			printWriter.write("false");
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			logger.error("重大异常，responseFalse报错！", e);
		} finally {
			printWriter.close();
		}
	}

	/**
	 * 页面记录异常信息
	 */
	protected void markException(String msg, Exception e) {
		request.setAttribute("es", msg);
		request.setAttribute("exception", e);
	}
}
