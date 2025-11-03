package com.entity.view;

import com.entity.JiajiaoyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 家教预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
@TableName("jiajiaoyuyue")
public class JiajiaoyuyueView  extends JiajiaoyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiajiaoyuyueView(){
	}
 
 	public JiajiaoyuyueView(JiajiaoyuyueEntity jiajiaoyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, jiajiaoyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
