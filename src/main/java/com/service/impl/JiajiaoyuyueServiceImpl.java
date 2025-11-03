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


import com.dao.JiajiaoyuyueDao;
import com.entity.JiajiaoyuyueEntity;
import com.service.JiajiaoyuyueService;
import com.entity.vo.JiajiaoyuyueVO;
import com.entity.view.JiajiaoyuyueView;

@Service("jiajiaoyuyueService")
public class JiajiaoyuyueServiceImpl extends ServiceImpl<JiajiaoyuyueDao, JiajiaoyuyueEntity> implements JiajiaoyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiajiaoyuyueEntity> page = this.selectPage(
                new Query<JiajiaoyuyueEntity>(params).getPage(),
                new EntityWrapper<JiajiaoyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiajiaoyuyueEntity> wrapper) {
		  Page<JiajiaoyuyueView> page =new Query<JiajiaoyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiajiaoyuyueVO> selectListVO(Wrapper<JiajiaoyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiajiaoyuyueVO selectVO(Wrapper<JiajiaoyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiajiaoyuyueView> selectListView(Wrapper<JiajiaoyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiajiaoyuyueView selectView(Wrapper<JiajiaoyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiajiaoyuyueEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiajiaoyuyueEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiajiaoyuyueEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
