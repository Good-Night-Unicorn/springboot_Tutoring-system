package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiajiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiajiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiajiaoView;


/**
 * 家教
 *
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public interface JiajiaoService extends IService<JiajiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiajiaoVO> selectListVO(Wrapper<JiajiaoEntity> wrapper);
   	
   	JiajiaoVO selectVO(@Param("ew") Wrapper<JiajiaoEntity> wrapper);
   	
   	List<JiajiaoView> selectListView(Wrapper<JiajiaoEntity> wrapper);
   	
   	JiajiaoView selectView(@Param("ew") Wrapper<JiajiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiajiaoEntity> wrapper);

   	

}

