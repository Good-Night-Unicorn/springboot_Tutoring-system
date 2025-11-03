package com.dao;

import com.entity.XuekefenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuekefenleiVO;
import com.entity.view.XuekefenleiView;


/**
 * 学科分类
 * 
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public interface XuekefenleiDao extends BaseMapper<XuekefenleiEntity> {
	
	List<XuekefenleiVO> selectListVO(@Param("ew") Wrapper<XuekefenleiEntity> wrapper);
	
	XuekefenleiVO selectVO(@Param("ew") Wrapper<XuekefenleiEntity> wrapper);
	
	List<XuekefenleiView> selectListView(@Param("ew") Wrapper<XuekefenleiEntity> wrapper);

	List<XuekefenleiView> selectListView(Pagination page,@Param("ew") Wrapper<XuekefenleiEntity> wrapper);

	
	XuekefenleiView selectView(@Param("ew") Wrapper<XuekefenleiEntity> wrapper);
	

}
