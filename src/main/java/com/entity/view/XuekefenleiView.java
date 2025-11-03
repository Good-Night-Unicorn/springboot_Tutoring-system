package com.entity.view;

import com.entity.XuekefenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 学科分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
@TableName("xuekefenlei")
public class XuekefenleiView  extends XuekefenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XuekefenleiView(){
	}
 
 	public XuekefenleiView(XuekefenleiEntity xuekefenleiEntity){
 	try {
			BeanUtils.copyProperties(this, xuekefenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
