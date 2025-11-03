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

import com.entity.DiscussjiajiaoxinxiEntity;
import com.entity.view.DiscussjiajiaoxinxiView;

import com.service.DiscussjiajiaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 家教信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-14 21:59:28
 */
@RestController
@RequestMapping("/discussjiajiaoxinxi")
public class DiscussjiajiaoxinxiController {
    @Autowired
    private DiscussjiajiaoxinxiService discussjiajiaoxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiajiaoxinxiEntity discussjiajiaoxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussjiajiaoxinxiEntity> ew = new EntityWrapper<DiscussjiajiaoxinxiEntity>();



		PageUtils page = discussjiajiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiajiaoxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiajiaoxinxiEntity discussjiajiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiajiaoxinxiEntity> ew = new EntityWrapper<DiscussjiajiaoxinxiEntity>();

		PageUtils page = discussjiajiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiajiaoxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiajiaoxinxiEntity discussjiajiaoxinxi){
       	EntityWrapper<DiscussjiajiaoxinxiEntity> ew = new EntityWrapper<DiscussjiajiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiajiaoxinxi, "discussjiajiaoxinxi")); 
        return R.ok().put("data", discussjiajiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiajiaoxinxiEntity discussjiajiaoxinxi){
        EntityWrapper< DiscussjiajiaoxinxiEntity> ew = new EntityWrapper< DiscussjiajiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiajiaoxinxi, "discussjiajiaoxinxi")); 
		DiscussjiajiaoxinxiView discussjiajiaoxinxiView =  discussjiajiaoxinxiService.selectView(ew);
		return R.ok("查询家教信息评论表成功").put("data", discussjiajiaoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiajiaoxinxiEntity discussjiajiaoxinxi = discussjiajiaoxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(discussjiajiaoxinxi,deSens);
        return R.ok().put("data", discussjiajiaoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiajiaoxinxiEntity discussjiajiaoxinxi = discussjiajiaoxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(discussjiajiaoxinxi,deSens);
        return R.ok().put("data", discussjiajiaoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增家教信息评论表") 
    public R save(@RequestBody DiscussjiajiaoxinxiEntity discussjiajiaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiajiaoxinxi);
        discussjiajiaoxinxiService.insert(discussjiajiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增家教信息评论表")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiajiaoxinxiEntity discussjiajiaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiajiaoxinxi);
        discussjiajiaoxinxiService.insert(discussjiajiaoxinxi);
        return R.ok().put("data",discussjiajiaoxinxi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussjiajiaoxinxiEntity discussjiajiaoxinxi = discussjiajiaoxinxiService.selectOne(new EntityWrapper<DiscussjiajiaoxinxiEntity>().eq("", username));
        return R.ok().put("data", discussjiajiaoxinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjiajiaoxinxiEntity discussjiajiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiajiaoxinxi);
        discussjiajiaoxinxiService.updateById(discussjiajiaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除家教信息评论表")
    public R delete(@RequestBody Long[] ids){
        discussjiajiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjiajiaoxinxiEntity discussjiajiaoxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjiajiaoxinxiEntity> ew = new EntityWrapper<DiscussjiajiaoxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussjiajiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiajiaoxinxi), params), params));
        return R.ok().put("data", page);
    }











}
