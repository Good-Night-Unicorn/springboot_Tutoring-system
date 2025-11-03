package com.entity.vo;

import com.entity.JiajiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 家教信息
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public class JiajiaoxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 学科分类
	 */
	
	private String xuekefenlei;
		
	/**
	 * 教授年级
	 */
	
	private String jiaoshounianji;
		
	/**
	 * 小时价格
	 */
	
	private Integer xiaoshijiage;
		
	/**
	 * 可约时间
	 */
	
	private String keyueshijian;
		
	/**
	 * 家教账号
	 */
	
	private String jiajiaozhanghao;
		
	/**
	 * 家教姓名
	 */
	
	private String jiajiaoxingming;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：学科分类
	 */
	 
	public void setXuekefenlei(String xuekefenlei) {
		this.xuekefenlei = xuekefenlei;
	}
	
	/**
	 * 获取：学科分类
	 */
	public String getXuekefenlei() {
		return xuekefenlei;
	}
				
	
	/**
	 * 设置：教授年级
	 */
	 
	public void setJiaoshounianji(String jiaoshounianji) {
		this.jiaoshounianji = jiaoshounianji;
	}
	
	/**
	 * 获取：教授年级
	 */
	public String getJiaoshounianji() {
		return jiaoshounianji;
	}
				
	
	/**
	 * 设置：小时价格
	 */
	 
	public void setXiaoshijiage(Integer xiaoshijiage) {
		this.xiaoshijiage = xiaoshijiage;
	}
	
	/**
	 * 获取：小时价格
	 */
	public Integer getXiaoshijiage() {
		return xiaoshijiage;
	}
				
	
	/**
	 * 设置：可约时间
	 */
	 
	public void setKeyueshijian(String keyueshijian) {
		this.keyueshijian = keyueshijian;
	}
	
	/**
	 * 获取：可约时间
	 */
	public String getKeyueshijian() {
		return keyueshijian;
	}
				
	
	/**
	 * 设置：家教账号
	 */
	 
	public void setJiajiaozhanghao(String jiajiaozhanghao) {
		this.jiajiaozhanghao = jiajiaozhanghao;
	}
	
	/**
	 * 获取：家教账号
	 */
	public String getJiajiaozhanghao() {
		return jiajiaozhanghao;
	}
				
	
	/**
	 * 设置：家教姓名
	 */
	 
	public void setJiajiaoxingming(String jiajiaoxingming) {
		this.jiajiaoxingming = jiajiaoxingming;
	}
	
	/**
	 * 获取：家教姓名
	 */
	public String getJiajiaoxingming() {
		return jiajiaoxingming;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
			
}
