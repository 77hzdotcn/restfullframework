package cn.hz.core.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 集合相关的工具类
 * 
 * @author wangxf
 *
 */
public class CollectionsUtils {

	/**
	 * 创建HashMap较为优雅的方法
	 * 
	 * @return
	 */
	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	/**
	 * 将map对应关系反转
	 * 
	 * @param map
	 * @return
	 */
	public static <K, V> Map<V, K> reverseMap(Map<K, V> map) {
		if (map != null) {
			Map<V, K> retMap = new HashMap<V, K>();
			for (Entry<K, V> entry : map.entrySet()) {
				retMap.put(entry.getValue(), entry.getKey());
			}
			return retMap;
		}
		return null;
	}

}
