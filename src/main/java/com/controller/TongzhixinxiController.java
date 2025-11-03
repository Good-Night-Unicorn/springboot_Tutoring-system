package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.TongzhixinxiEntity;
import com.entity.view.TongzhixinxiView;

import com.service.TongzhixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 通知信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
@RestController
@RequestMapping("/tongzhixinxi")
public class TongzhixinxiController {
    @Autowired
    private TongzhixinxiService tongzhixinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TongzhixinxiEntity tongzhixinxi,
		HttpServletRequest request){
        EntityWrapper<TongzhixinxiEntity> ew = new EntityWrapper<TongzhixinxiEntity>();



		PageUtils page = tongzhixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongzhixinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TongzhixinxiEntity tongzhixinxi, 
		HttpServletRequest request){
        EntityWrapper<TongzhixinxiEntity> ew = new EntityWrapper<TongzhixinxiEntity>();

		PageUtils page = tongzhixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongzhixinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TongzhixinxiEntity tongzhixinxi){
       	EntityWrapper<TongzhixinxiEntity> ew = new EntityWrapper<TongzhixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tongzhixinxi, "tongzhixinxi")); 
        return R.ok().put("data", tongzhixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TongzhixinxiEntity tongzhixinxi){
        EntityWrapper< TongzhixinxiEntity> ew = new EntityWrapper< TongzhixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tongzhixinxi, "tongzhixinxi")); 
		TongzhixinxiView tongzhixinxiView =  tongzhixinxiService.selectView(ew);
		return R.ok("查询通知信息成功").put("data", tongzhixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TongzhixinxiEntity tongzhixinxi = tongzhixinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(tongzhixinxi,deSens);
        return R.ok().put("data", tongzhixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TongzhixinxiEntity tongzhixinxi = tongzhixinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(tongzhixinxi,deSens);
        return R.ok().put("data", tongzhixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增通知信息") 
    public R save(@RequestBody TongzhixinxiEntity tongzhixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tongzhixinxi);
        tongzhixinxiService.insert(tongzhixinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增通知信息")
    @RequestMapping("/add")
    public R add(@RequestBody TongzhixinxiEntity tongzhixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tongzhixinxi);
        tongzhixinxiService.insert(tongzhixinxi);
        return R.ok().put("data",tongzhixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改通知信息")
    public R update(@RequestBody TongzhixinxiEntity tongzhixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tongzhixinxi);
        tongzhixinxiService.updateById(tongzhixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除通知信息")
    public R delete(@RequestBody Long[] ids){
        tongzhixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
