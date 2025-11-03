package com.dao;

import com.entity.JiajiaoyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiajiaoyuyueVO;
import com.entity.view.JiajiaoyuyueView;


/**
 * 家教预约
 * 
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public interface JiajiaoyuyueDao extends BaseMapper<JiajiaoyuyueEntity> {
	
	List<JiajiaoyuyueVO> selectListVO(@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);
	
	JiajiaoyuyueVO selectVO(@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);
	
	List<JiajiaoyuyueView> selectListView(@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);

	List<JiajiaoyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);

	
	JiajiaoyuyueView selectView(@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);



}
