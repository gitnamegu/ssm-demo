package pers.pole.common;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

	/** 成功时返回信息
	* @return    
	* @date 2017年12月10日
	* @author guohaibing 
	*/
	public static Map<String,Object> success() {
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("code", EnumUtil.success.getCode());
		resultMap.put("desc", EnumUtil.success.getDesc());
		return resultMap;
	}
	
	/** 失败时返回信息
	* @return    
	* @date 2017年12月10日
	* @author guohaibing 
	*/
	public static Map<String,Object> error() {
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("code", EnumUtil.error.getCode());
		resultMap.put("desc", EnumUtil.error.getDesc());
		return resultMap;
	}
}
