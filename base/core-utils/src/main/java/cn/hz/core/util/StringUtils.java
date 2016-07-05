package cn.hz.core.util;

/**
 * 
 * @author wangxf
 * @date 2016年4月7日
 *
 */
public final class StringUtils {

	public static String joinStrings(String[] strings, String delimiter) {
		int length = strings.length;
		if (length == 0)
			return "";
		StringBuilder words = new StringBuilder(strings[0]);
		for (int i = 1; i < length; i++) {
			words.append(delimiter).append(strings[i]);
		}
		return words.toString();
	}
}
