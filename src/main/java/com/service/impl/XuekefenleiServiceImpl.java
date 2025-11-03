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


import com.dao.XuekefenleiDao;
import com.entity.XuekefenleiEntity;
import com.service.XuekefenleiService;
import com.entity.vo.XuekefenleiVO;
import com.entity.view.XuekefenleiView;

@Service("xuekefenleiService")
public class XuekefenleiServiceImpl extends ServiceImpl<XuekefenleiDao, XuekefenleiEntity> implements XuekefenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuekefenleiEntity> page = this.selectPage(
                new Query<XuekefenleiEntity>(params).getPage(),
                new EntityWrapper<XuekefenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuekefenleiEntity> wrapper) {
		  Page<XuekefenleiView> page =new Query<XuekefenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XuekefenleiVO> selectListVO(Wrapper<XuekefenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuekefenleiVO selectVO(Wrapper<XuekefenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuekefenleiView> selectListView(Wrapper<XuekefenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuekefenleiView selectView(Wrapper<XuekefenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
