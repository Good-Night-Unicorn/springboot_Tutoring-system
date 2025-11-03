package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuekefenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuekefenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuekefenleiView;


/**
 * 学科分类
 *
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
public interface XuekefenleiService extends IService<XuekefenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuekefenleiVO> selectListVO(Wrapper<XuekefenleiEntity> wrapper);
   	
   	XuekefenleiVO selectVO(@Param("ew") Wrapper<XuekefenleiEntity> wrapper);
   	
   	List<XuekefenleiView> selectListView(Wrapper<XuekefenleiEntity> wrapper);
   	
   	XuekefenleiView selectView(@Param("ew") Wrapper<XuekefenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuekefenleiEntity> wrapper);

   	

}

