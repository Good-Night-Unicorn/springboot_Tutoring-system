package com.entity.view;

import com.entity.DiscussjiajiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 家教信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-10-14 21:59:28
 */
@TableName("discussjiajiaoxinxi")
public class DiscussjiajiaoxinxiView  extends DiscussjiajiaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussjiajiaoxinxiView(){
	}
 
 	public DiscussjiajiaoxinxiView(DiscussjiajiaoxinxiEntity discussjiajiaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussjiajiaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
