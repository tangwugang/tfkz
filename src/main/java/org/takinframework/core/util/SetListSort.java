package org.takinframework.core.util;

import java.util.Comparator;

import org.takinframework.web.system.entity.SysFunction;


/**
* @ClassName: SetListSort 
* @Description: TODO(int比较器) 
* @date 2013-1-31 下午06:19:03 
*
 */
@SuppressWarnings("rawtypes")
public class SetListSort implements Comparator {
	/**
	 * 菜单排序比较器
	 */
	public int compare(Object o1, Object o2) {
		SysFunction c1 = (SysFunction) o1;
		SysFunction c2 = (SysFunction) o2;
		if (c1.getFuncOrder() != null && c2.getFuncOrder() != null) {
			if(c1.getFuncOrder().compareTo(c2.getFuncOrder())>0){
				return 1;
			}else{
				return -1;
			}
//			int c1order = oConvertUtils.getInt(c1.getFunctionOrder().substring(c1.getFuncOrder().indexOf("fun")+3));
//			int c2order = oConvertUtils.getInt(c2.getFunctionOrder().substring(c2.getFuncOrder().indexOf("fun"))+3);
//			if (c1order > c2order) {
//				return 1;
//			} else {
//				return -1;
//			}
		} else {
			return 1;
		}
	}
}