package com.jsg.base.util;
/**
 * 
* @ClassName: PageUtil 
* @Description: TODO(生成分页节点) 
* @author duanws
* @date 2016-5-11 下午4:51:03 
*
 */
public class PageUtil {
	/**
	 * 
	* @Title: getPageInfo 
	* @Description: TODO(生成分页节点) 
	* @param @param pageTotal
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-5-11 下午4:51:32
	 */
	public static String getPageInfo(int pageTotal,int totalNum){
		 String pMessage = "<li><a href='#' onclick='setPre()'>上一页</a></li><li><a>共"+totalNum+"条</a></li>";
//		 for(int i=0;i<=pageTotal;i++){
//			 pMessage = pMessage + "<li> <a href='#' onclick='setPNum("+i+")'>"+i+"</a></li>";
//		 }
		 pMessage = pMessage + "<li><a href='#' onclick='setNext()'>下一页</a></li>";
		 return pMessage;
	}
}
