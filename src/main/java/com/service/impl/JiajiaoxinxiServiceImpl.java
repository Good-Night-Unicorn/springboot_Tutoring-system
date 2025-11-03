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


import com.dao.JiajiaoxinxiDao;
import com.entity.JiajiaoxinxiEntity;
import com.service.JiajiaoxinxiService;
import com.entity.vo.JiajiaoxinxiVO;
import com.entity.view.JiajiaoxinxiView;

@Service("jiajiaoxinxiService")
public class JiajiaoxinxiServiceImpl extends ServiceImpl<JiajiaoxinxiDao, JiajiaoxinxiEntity> implements JiajiaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiajiaoxinxiEntity> page = this.selectPage(
                new Query<JiajiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<JiajiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiajiaoxinxiEntity> wrapper) {
		  Page<JiajiaoxinxiView> page =new Query<JiajiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiajiaoxinxiVO> selectListVO(Wrapper<JiajiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiajiaoxinxiVO selectVO(Wrapper<JiajiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiajiaoxinxiView> selectListView(Wrapper<JiajiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiajiaoxinxiView selectView(Wrapper<JiajiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiajiaoxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiajiaoxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiajiaoxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
