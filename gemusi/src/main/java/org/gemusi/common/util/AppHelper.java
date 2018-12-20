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

	public static String getCityShortName(String city) {
		String shortName = null;
		switch (city) {
			case "石家庄":
				shortName = "石";
				break;
			case "省公司":
				shortName = "省";
				break;
			case "秦皇岛":
				shortName = "秦";
				break;
			case "邯郸":
				shortName = "邯";
				break;
			case "保定":
				shortName = "保";
				break;
			case "张家口":
				shortName = "张";
				break;
			case "承德":
				shortName = "承";
				break;
			case "邢台":
				shortName = "邢";
				break;
			case "沧州":
				shortName = "沧";
				break;
			case "廊坊":
				shortName = "廊";
				break;
			case "唐山":
				shortName = "唐";
				break;
			case "衡水":
				shortName = "衡";
				break;
			case "雄安新区":
				shortName = "雄";
				break;
		}
		return shortName;
	}

	/**
	 * 如果类型为决算，city传null
	 *
	 * @param auditType
	 * @param city
	 * @return
	 */
	public static String createDelegateFileNum(String year, String city, String auditType, int num) {
		String cityShortName;
		if (null != city) {
			cityShortName = AppHelper.getCityShortName(city);
		} else {
			cityShortName = "";
		}
		if ("1".equals(auditType)) {
			return new StringBuilder("河北移动（")
					.append(cityShortName)
					.append("）省")
					.append("结")
					.append("（")
					.append(year)
					.append("）")
					.append(String.format("%03d", num))
					.append("号").toString();
		}
		if ("2".equals(auditType)) {
			return new StringBuilder("河北移动决（")
					.append(year)
					.append("）")
					.append(String.format("%03d", num))
					.append("号").toString();
		}
		return null;
	}

	public static String formartDate(Date date) {
		if (date == null) {
			return null;
		}
		return SDF.format(date);
	}

	public static String getPercentage(double numerator, double denominator, int num) {
		if(numerator != 0 && denominator == 0){
			return "-";
		}
		if (numerator == 0) {
			return "0%";
		}

		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(num);

		return numberFormat.format(numerator / denominator * 100)+"%";

	}

}
