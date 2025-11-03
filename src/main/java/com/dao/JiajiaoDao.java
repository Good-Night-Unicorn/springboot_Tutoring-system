package com.dao;

import com.entity.JiajiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiajiaoVO;
import com.entity.view.JiajiaoView;


/**
 * 家教
 * 
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public interface JiajiaoDao extends BaseMapper<JiajiaoEntity> {
	
	List<JiajiaoVO> selectListVO(@Param("ew") Wrapper<JiajiaoEntity> wrapper);
	
	JiajiaoVO selectVO(@Param("ew") Wrapper<JiajiaoEntity> wrapper);
	
	List<JiajiaoView> selectListView(@Param("ew") Wrapper<JiajiaoEntity> wrapper);

	List<JiajiaoView> selectListView(Pagination page,@Param("ew") Wrapper<JiajiaoEntity> wrapper);

	
	JiajiaoView selectView(@Param("ew") Wrapper<JiajiaoEntity> wrapper);
	

}
