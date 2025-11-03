package com.dao;

import com.entity.DiscussjiajiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiajiaoxinxiVO;
import com.entity.view.DiscussjiajiaoxinxiView;


/**
 * 家教信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-10-14 21:59:28
 */
public interface DiscussjiajiaoxinxiDao extends BaseMapper<DiscussjiajiaoxinxiEntity> {
	
	List<DiscussjiajiaoxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussjiajiaoxinxiEntity> wrapper);
	
	DiscussjiajiaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussjiajiaoxinxiEntity> wrapper);
	
	List<DiscussjiajiaoxinxiView> selectListView(@Param("ew") Wrapper<DiscussjiajiaoxinxiEntity> wrapper);

	List<DiscussjiajiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiajiaoxinxiEntity> wrapper);

	
	DiscussjiajiaoxinxiView selectView(@Param("ew") Wrapper<DiscussjiajiaoxinxiEntity> wrapper);
	

}
