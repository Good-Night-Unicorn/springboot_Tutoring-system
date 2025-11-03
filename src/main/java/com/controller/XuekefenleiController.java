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

import com.entity.XuekefenleiEntity;
import com.entity.view.XuekefenleiView;

import com.service.XuekefenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学科分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
@RestController
@RequestMapping("/xuekefenlei")
public class XuekefenleiController {
    @Autowired
    private XuekefenleiService xuekefenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuekefenleiEntity xuekefenlei,
		HttpServletRequest request){
        EntityWrapper<XuekefenleiEntity> ew = new EntityWrapper<XuekefenleiEntity>();



		PageUtils page = xuekefenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuekefenlei), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuekefenleiEntity xuekefenlei, 
		HttpServletRequest request){
        EntityWrapper<XuekefenleiEntity> ew = new EntityWrapper<XuekefenleiEntity>();

		PageUtils page = xuekefenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuekefenlei), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuekefenleiEntity xuekefenlei){
       	EntityWrapper<XuekefenleiEntity> ew = new EntityWrapper<XuekefenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuekefenlei, "xuekefenlei")); 
        return R.ok().put("data", xuekefenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuekefenleiEntity xuekefenlei){
        EntityWrapper< XuekefenleiEntity> ew = new EntityWrapper< XuekefenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuekefenlei, "xuekefenlei")); 
		XuekefenleiView xuekefenleiView =  xuekefenleiService.selectView(ew);
		return R.ok("查询学科分类成功").put("data", xuekefenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuekefenleiEntity xuekefenlei = xuekefenleiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xuekefenlei,deSens);
        return R.ok().put("data", xuekefenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuekefenleiEntity xuekefenlei = xuekefenleiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xuekefenlei,deSens);
        return R.ok().put("data", xuekefenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增学科分类") 
    public R save(@RequestBody XuekefenleiEntity xuekefenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xuekefenlei);
        xuekefenleiService.insert(xuekefenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增学科分类")
    @RequestMapping("/add")
    public R add(@RequestBody XuekefenleiEntity xuekefenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xuekefenlei);
        xuekefenleiService.insert(xuekefenlei);
        return R.ok().put("data",xuekefenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改学科分类")
    public R update(@RequestBody XuekefenleiEntity xuekefenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuekefenlei);
        xuekefenleiService.updateById(xuekefenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除学科分类")
    public R delete(@RequestBody Long[] ids){
        xuekefenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
