package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiajiaoyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiajiaoyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiajiaoyuyueView;


/**
 * 家教预约
 *
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public interface JiajiaoyuyueService extends IService<JiajiaoyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiajiaoyuyueVO> selectListVO(Wrapper<JiajiaoyuyueEntity> wrapper);
   	
   	JiajiaoyuyueVO selectVO(@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);
   	
   	List<JiajiaoyuyueView> selectListView(Wrapper<JiajiaoyuyueEntity> wrapper);
   	
   	JiajiaoyuyueView selectView(@Param("ew") Wrapper<JiajiaoyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiajiaoyuyueEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiajiaoyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiajiaoyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiajiaoyuyueEntity> wrapper);



}

