package org.gemusi.common.util;

import javax.servlet.http.HttpServletRequest;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AppHelper {

//	private AppHelper(){}

	private String uuid;
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	public String getUuid() {
		return getUUID();
	}

	/**
	 * 生成随机的UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 统一错误处理
	 */
	public static String getExceptionUrl(HttpServletRequest request, Exception ex, int status, String url) {
		if (isAjaxRequest(request)) {
			request.setAttribute("ex", ex);
			request.setAttribute("status", status);
			return "forward:/error/isAjaxRequest";
		} else {
			return url;
		}
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		return (request.getHeader("accept").contains("application/json")
				|| (request.getHeader("X-Requested-With") != null
				&& request.getHeader("X-Requested-With").contains("XMLHttpRequest")));
	}

	public static String formartDate(Date date) {
		if (date == null) {
			return null;
		}
		return SDF.format(date);
	}

}
