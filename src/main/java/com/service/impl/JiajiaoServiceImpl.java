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


import com.dao.JiajiaoDao;
import com.entity.JiajiaoEntity;
import com.service.JiajiaoService;
import com.entity.vo.JiajiaoVO;
import com.entity.view.JiajiaoView;

@Service("jiajiaoService")
public class JiajiaoServiceImpl extends ServiceImpl<JiajiaoDao, JiajiaoEntity> implements JiajiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiajiaoEntity> page = this.selectPage(
                new Query<JiajiaoEntity>(params).getPage(),
                new EntityWrapper<JiajiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiajiaoEntity> wrapper) {
		  Page<JiajiaoView> page =new Query<JiajiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiajiaoVO> selectListVO(Wrapper<JiajiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiajiaoVO selectVO(Wrapper<JiajiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiajiaoView> selectListView(Wrapper<JiajiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiajiaoView selectView(Wrapper<JiajiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
