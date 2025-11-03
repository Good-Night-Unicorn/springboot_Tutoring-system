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

import com.entity.TousujianyiEntity;
import com.entity.view.TousujianyiView;

import com.service.TousujianyiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 投诉建议
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
@RestController
@RequestMapping("/tousujianyi")
public class TousujianyiController {
    @Autowired
    private TousujianyiService tousujianyiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TousujianyiEntity tousujianyi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiajiao")) {
			tousujianyi.setJiajiaozhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			tousujianyi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhang")) {
			tousujianyi.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TousujianyiEntity> ew = new EntityWrapper<TousujianyiEntity>();



		PageUtils page = tousujianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousujianyi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TousujianyiEntity tousujianyi, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiajiao")) {
			tousujianyi.setJiajiaozhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			tousujianyi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhang")) {
			tousujianyi.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TousujianyiEntity> ew = new EntityWrapper<TousujianyiEntity>();

		PageUtils page = tousujianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousujianyi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TousujianyiEntity tousujianyi){
       	EntityWrapper<TousujianyiEntity> ew = new EntityWrapper<TousujianyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tousujianyi, "tousujianyi")); 
        return R.ok().put("data", tousujianyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TousujianyiEntity tousujianyi){
        EntityWrapper< TousujianyiEntity> ew = new EntityWrapper< TousujianyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tousujianyi, "tousujianyi")); 
		TousujianyiView tousujianyiView =  tousujianyiService.selectView(ew);
		return R.ok("查询投诉建议成功").put("data", tousujianyiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TousujianyiEntity tousujianyi = tousujianyiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(tousujianyi,deSens);
        return R.ok().put("data", tousujianyi);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TousujianyiEntity tousujianyi = tousujianyiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(tousujianyi,deSens);
        return R.ok().put("data", tousujianyi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增投诉建议") 
    public R save(@RequestBody TousujianyiEntity tousujianyi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tousujianyi);
        tousujianyiService.insert(tousujianyi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增投诉建议")
    @RequestMapping("/add")
    public R add(@RequestBody TousujianyiEntity tousujianyi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tousujianyi);
    	tousujianyi.setUserid((Long)request.getSession().getAttribute("userId"));
        tousujianyiService.insert(tousujianyi);
        return R.ok().put("data",tousujianyi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改投诉建议")
    public R update(@RequestBody TousujianyiEntity tousujianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousujianyi);
        tousujianyiService.updateById(tousujianyi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核投诉建议")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TousujianyiEntity> list = new ArrayList<TousujianyiEntity>();
        for(Long id : ids) {
            TousujianyiEntity tousujianyi = tousujianyiService.selectById(id);
            tousujianyi.setSfsh(sfsh);
            tousujianyi.setShhf(shhf);
            list.add(tousujianyi);
        }
        tousujianyiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除投诉建议")
    public R delete(@RequestBody Long[] ids){
        tousujianyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
