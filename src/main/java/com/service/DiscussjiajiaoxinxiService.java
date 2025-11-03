package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiajiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiajiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiajiaoxinxiView;


/**
 * 家教信息评论表
 *
 * @author 
 * @email 
 * @date 2024-10-14 21:59:28
 */
public interface DiscussjiajiaoxinxiService extends IService<DiscussjiajiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiajiaoxinxiVO> selectListVO(Wrapper<DiscussjiajiaoxinxiEntity> wrapper);
   	
   	DiscussjiajiaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussjiajiaoxinxiEntity> wrapper);
   	
   	List<DiscussjiajiaoxinxiView> selectListView(Wrapper<DiscussjiajiaoxinxiEntity> wrapper);
   	
   	DiscussjiajiaoxinxiView selectView(@Param("ew") Wrapper<DiscussjiajiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiajiaoxinxiEntity> wrapper);

   	

}

