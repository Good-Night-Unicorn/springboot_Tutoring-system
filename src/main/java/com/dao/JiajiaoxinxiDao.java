package com.dao;

import com.entity.JiajiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiajiaoxinxiVO;
import com.entity.view.JiajiaoxinxiView;


/**
 * 家教信息
 * 
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public interface JiajiaoxinxiDao extends BaseMapper<JiajiaoxinxiEntity> {
	
	List<JiajiaoxinxiVO> selectListVO(@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);
	
	JiajiaoxinxiVO selectVO(@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);
	
	List<JiajiaoxinxiView> selectListView(@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);

	List<JiajiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);

	
	JiajiaoxinxiView selectView(@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);



}
