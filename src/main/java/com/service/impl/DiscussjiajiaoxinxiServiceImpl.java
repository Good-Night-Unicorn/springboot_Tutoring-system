package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussjiajiaoxinxiDao;
import com.entity.DiscussjiajiaoxinxiEntity;
import com.service.DiscussjiajiaoxinxiService;
import com.entity.vo.DiscussjiajiaoxinxiVO;
import com.entity.view.DiscussjiajiaoxinxiView;

@Service("discussjiajiaoxinxiService")
public class DiscussjiajiaoxinxiServiceImpl extends ServiceImpl<DiscussjiajiaoxinxiDao, DiscussjiajiaoxinxiEntity> implements DiscussjiajiaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiajiaoxinxiEntity> page = this.selectPage(
                new Query<DiscussjiajiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussjiajiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiajiaoxinxiEntity> wrapper) {
		  Page<DiscussjiajiaoxinxiView> page =new Query<DiscussjiajiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussjiajiaoxinxiVO> selectListVO(Wrapper<DiscussjiajiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiajiaoxinxiVO selectVO(Wrapper<DiscussjiajiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiajiaoxinxiView> selectListView(Wrapper<DiscussjiajiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiajiaoxinxiView selectView(Wrapper<DiscussjiajiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
