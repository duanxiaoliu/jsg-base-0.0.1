package com.jsg.base.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 
* @ClassName: DataUtil 
* @Description: TODO(开发帮助类) 
* @author duanws
* @date 2017-3-12 下午03:09:29 
*
 */
public class DataUtil {
	/**
	 * 
	* @Title: strIsNull 
	* @Description: TODO(判断是字符串是否为空) 
	* @param @param str
	* @param @return
	* @return boolean
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午2:46:55
	 */
	public static boolean strIsNull(String str){
		return (str == null) || (str.trim().length() == 0);
	}
	
	/**
	 * 
	* @Title: strIsNotNull 
	* @Description: TODO(判断字符串不为空) 
	* @param @param str
	* @param @return
	* @return boolean
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午2:48:22
	 */
	public static boolean strIsNotNull(String str){
		return !strIsNull(str);
	}
	
	/**
	 * 
	* @Title: ObjIsNotNull 
	* @Description: TODO(判断对象不为空) 
	* @param @param obj
	* @param @return
	* @return boolean
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午2:55:47
	 */
	public static boolean objIsNotNull(Object obj){
		if(obj != null){
			return !strIsNull(obj.toString());
		}
		return false;
	}
	/**
	 * 
	* @Title: strToLong 
	* @Description: TODO(字符串转long型) 
	* @param @param str
	* @param @return
	* @return long
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午2:57:50
	 */
	public static long strToLong(String str){
		int r = 0;
		if(strIsNull(str)){
			return r;
		}
		return Long.parseLong(str.trim());
	}
	/**
	 * 
	* @Title: strToDouble 
	* @Description: TODO(字符串转Double型) 
	* @param @param str
	* @param @return
	* @return double
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午3:00:32
	 */
	public static double strToDouble(String str){
		double r = 0.0D;
		if(strIsNull(str)){
			return r;
		}
		return Double.parseDouble(str.trim());
	}
	/**
	 * 
	* @Title: strToFloat 
	* @Description: TODO(字符串转Float型) 
	* @param @param str
	* @param @return
	* @return float
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午3:03:25
	 */
	public static float strToFloat(String str){
		float r = 0.0F;
		if(strIsNull(str)){
			return r;
		}
		return Float.parseFloat(str.trim());
	}
	/**
	 * 
	* @Title: strToInt 
	* @Description: TODO(字符串转int型) 
	* @param @param str
	* @param @return
	* @return int
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午3:08:58
	 */
	public static int strToInt(String str){
		if(strIsNull(str)){
			return 0;
		}
		try{
			Integer r = new Integer(str);
			return r.intValue();
		}catch(Exception e){
		}
		return 0;
		
	}
	/**
	 * 
	* @Title: strSplit 
	* @Description: TODO(字符串截取到数组中，二维) 
	* @param @param str
	* @param @param flag1
	* @param @param flag2
	* @param @return
	* @return String[][]
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午3:44:19
	 */
	public static String [][] strSplit(String str,String flag1,String flag2){
		String [] s = strSplit(str,flag1);
		String [][] res = (String[][])null;
		if(s !=null){
			res = new String[s.length][];
			for(int i=0;i<s.length;++i){
				String[] s1 = strSplit(s[i],flag2);
				res[i] = s1;
			}
		}
		return res;
	}
	/**
	 * 
	* @Title: strSplit 
	* @Description: TODO(字符串截取到数组中，一维) 
	* @param @param str
	* @param @param flag
	* @param @return
	* @return String[]
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午3:43:56
	 */
	public static String [] strSplit(String str,String flag){
		if(strIsNull(str)){
			return null;
		}
		if(str.indexOf(flag) == -1){
			return new String [] {str};
		}
		
		ArrayList res = new ArrayList();
		int sIndex = 0;
		int eIndex = 0;
		while(true){
			eIndex = str.indexOf(flag,sIndex);
			if(eIndex == -1){
				break;
			}
			if(eIndex == 0){
				res.add("");
			}else{
				res.add(str.substring(sIndex,eIndex).trim());
			}
			sIndex = eIndex + str.lastIndexOf(flag);
		}
		int lastIndex = str.lastIndexOf(flag);
		if(lastIndex >= 0){
			res.add(str.substring(lastIndex + flag.length()).trim());
		}else if(lastIndex == str.length() - 1){
			res.add("");
		}
		String [] data = toArray(res);
		
		return data;
	}
	/**
	 * 
	* @Title: toArray 
	* @Description: TODO(列表转数组) 
	* @param @param res
	* @param @return
	* @return String[]
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午3:43:09
	 */
    private static String[] toArray (ArrayList res){
    	if(!objIsNotNull(res)){
    		return null;
    	}
    	String [] ary = new String[res.size()];
    	res.toArray(ary);
    	return ary;
    }
	/**
	 * 
	* @Title: strIsNumber 
	* @Description: TODO(判断字符中是否都为数字) 
	* @param @param str
	* @param @return
	* @return boolean
	* @throws 
	* @author duanws
	* @date 2016-3-17 下午3:49:14
	 */
	public static boolean strIsNumber(String str){
		if(strIsNull(str)){
			return false;
		}
		String strNumber = "0123456789";
		
		String oneStr = str.substring(0, 1);
		if((oneStr.equals("-")) || (oneStr.equals("+"))){
			str = str.substring(1);
		}
		
		String [] aStr = strSplit(str,".");
		if(aStr.length>2){
			return false;
		}
		for(int i=0;i<aStr.length;++i){
			for(int j=0;j<aStr[i].length();++j){
				if(strNumber.indexOf(aStr[i].substring(j,j+1))==-1){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * 
	* @Title: getRandomInt 
	* @Description: TODO(获得整数随机数) 
	* @param @param start
	* @param @param end
	* @param @return
	* @return int
	* @throws 
	* @author duanws
	* @date 2016-3-18 上午10:33:27
	 */
	public static int getRandomInt(int start,int end){
		Random r = new Random();
		int n = 0;
		while(n<start){
			n = r.nextInt(end);
		}
		return n;
	}
	/**
	 * 
	* @Title: getRandomString 
	* @Description: TODO(获得随机字符串) 
	* @param @param leng  字符串长度
	* @param @param letters 如果为true则包含字母
	* @param @param numbers 如果为true则包含数字
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-3-18 上午10:45:07
	 */
	public static String getRandomString(int leng,boolean letters,boolean numbers){
		return RandomStringUtils.random(leng, letters, numbers);
	}
	/**
	 * 
	* @Title: getUUID 
	* @Description: TODO(获得32位随机id) 
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-3-18 下午2:23:11
	 */
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	/**
	 * 
	* @Title: arrayToJson 
	* @Description: TODO(list转成json字符串) 
	* @param @param list
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-3-18 下午2:40:28
	 */
	public static String arrayToJson(List list){
		return JSONArray.fromObject(list).toString();
	}
	/**
	 * 
	* @Title: arrayToJson 
	* @Description: TODO(数组转json字符串) 
	* @param @param array
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-3-18 下午2:46:25
	 */
	public static String arrayToJson(Object[] array){
		return JSONArray.fromObject(array).toString();
	}
	/**
	 * 
	* @Title: beanToJson 
	* @Description: TODO(bean转json字符串) 
	* @param @param obj
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-3-18 下午2:47:25
	 */
	public static String beanToJson(Object obj){
		return JSONObject.fromObject(obj).toString();
	}
	/**
	 * 
	* @Title: mapToJson 
	* @Description: TODO(map转json字符) 
	* @param @param map
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-3-18 下午2:49:50
	 */
	public static String mapToJson(Map map){
		return beanToJson(map);
	}
	/**
	 * 
	* @Title: getDataFormatStr 
	* @Description: TODO(返回直指格式的日期字符串) 
	* @param @param d
	* @param @param format  日期格式
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-3-18 下午3:18:11
	 */
	public static String getDataFormatStr(Date d,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(!objIsNotNull(d)){
			Date today = new Date();
			return sdf.format(today);
		}
		return sdf.format(d);
	}
	/**
	 * 
	* @Title: getCharFormStr 
	* @Description: TODO(返回字符串指定位置的字符) 
	* @param @param str
	* @param @param index
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-3-28 上午10:21:29
	 */
	public static String getCharFormStr(String str,int index){
		if(str.length()<1){
			return str;
		}
		return String.valueOf(str.charAt(index));
	}
	/**
	 * 
	* @Title: changeMapToStr 
	* @Description: TODO(map转成字符串) 
	* @param @param map
	* @param @return 
	* @return String
	* @author duanws
	* @throws
	 */
	public static String changeMapToStr(Map<Object,Object> map){
		if(map.size()<1){
			return null;
		}
		
		StringBuilder mapStr = new StringBuilder();
		for(Object key:map.keySet()){
			mapStr.append(key+":"+map.get(key)+",");
		}
		return mapStr.toString().substring(0,mapStr.length()-1);
	}
	/**
	 * 
	* @Title: main 
	* @Description: TODO(工具类实验) 
	* @param @param args 
	* @return void
	* @author duanws
	* @throws
	 */
	public static void main(String [] args){
		Map map = new TreeMap();
		map.put(1, 1);
		map.put(5, 1);

		
		System.out.print(DataUtil.changeMapToStr(map));
		
	}
}
