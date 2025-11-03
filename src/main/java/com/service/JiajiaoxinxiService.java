package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiajiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiajiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiajiaoxinxiView;


/**
 * 家教信息
 *
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public interface JiajiaoxinxiService extends IService<JiajiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiajiaoxinxiVO> selectListVO(Wrapper<JiajiaoxinxiEntity> wrapper);
   	
   	JiajiaoxinxiVO selectVO(@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);
   	
   	List<JiajiaoxinxiView> selectListView(Wrapper<JiajiaoxinxiEntity> wrapper);
   	
   	JiajiaoxinxiView selectView(@Param("ew") Wrapper<JiajiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiajiaoxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiajiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiajiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiajiaoxinxiEntity> wrapper);



}

