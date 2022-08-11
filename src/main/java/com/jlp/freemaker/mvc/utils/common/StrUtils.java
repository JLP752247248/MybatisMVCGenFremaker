package com.jlp.freemaker.mvc.utils.common;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.jlp.freemaker.mvc.common.configuration.GenerateConfiguration;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 处理字符串的工具类
 * @date 2018年7月1日 下午12:55:35
 * @see:
 * <p>
 * www.aixuegao.cn
 * </p>
 * @since 1.0.0
 */
public class StrUtils {

	public final static String FILE_SEPARATOR = File.separator;

	public final static String DOT = ".";

	/**
	 * 替换下划线和把首字母转成大写
	 * 
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str) {
		String result = replaceUnderLine(str);
		return StringUtils.capitalize(result);
	}

	/**
	 * 转化将下划线
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceUnderLine(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		int count = sb.indexOf("_");
		while (count != 0) {
			int num = sb.indexOf("_", count);
			count = num + 1;
			if (num != -1) {
				char ss = sb.charAt(count);
				char ia = (char) (ss - 32);
				sb.replace(count, count + 1, ia + "");
			}
		}
		String result = sb.toString().replaceAll("_", "");
		return result;
	}

	/**
	 * 获取当前的工程的绝对路径
	 * 
	 * @return
	 */
	public static String getAbsolutePath() {
		String str = StrUtils.class.getClassLoader().getResource("").toString();
		return str.substring("file:/".length(),
				str.indexOf(GenerateConfiguration.PROJECT_PATH) + GenerateConfiguration.PROJECT_PATH.length());
	}

	/**
	 * 将包名转换成路径
	 * 
	 * @param packagePath
	 * @return
	 */
	public static String package2path(String packagePath) {
		return packagePath.replaceAll("\\.", "\\\\");
	}

	
	/**
	 * 大写字母转下划线
	 * @param param
	 * @return
	 */
	public static String upperCharToUnderLine(String param) {
		Pattern p = Pattern.compile("[A-Z]");
		if (param == null || param.equals("")) {
			return "";
		}
		StringBuilder builder = new StringBuilder(param);
		Matcher mc = p.matcher(param);
		int i = 0;
		while (mc.find()) {
			builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
			i++;
		}

		if ('_' == builder.charAt(0)) {
			builder.deleteCharAt(0);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		// String a = getAbsolutePath();
		// a = a.substring(0, a.indexOf("/generatecode")+"/generatecode".length());
		// System.out.println(a);
//		String a = "com.jlp.freemaker.mvc.";
//		String b = a.replaceAll("\\.", "\\\\");
//		System.out.println(b);
//		System.out.println(FILE_SEPARATOR);
		String s = "TestUpName";
		
		String v = upperCharToUnderLine(s);
		System.out.println(v);
	}

}
