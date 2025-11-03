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

import com.entity.JiajiaoEntity;
import com.entity.view.JiajiaoView;

import com.service.JiajiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 家教
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
@RestController
@RequestMapping("/jiajiao")
public class JiajiaoController {
    @Autowired
    private JiajiaoService jiajiaoService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		JiajiaoEntity u = jiajiaoService.selectOne(new EntityWrapper<JiajiaoEntity>().eq("jiajiaozhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"jiajiao",  "家教" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JiajiaoEntity jiajiao){
    	//ValidatorUtils.validateEntity(jiajiao);
    	JiajiaoEntity u = jiajiaoService.selectOne(new EntityWrapper<JiajiaoEntity>().eq("jiajiaozhanghao", jiajiao.getJiajiaozhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		jiajiao.setId(uId);
        jiajiaoService.insert(jiajiao);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        JiajiaoEntity u = jiajiaoService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	JiajiaoEntity u = jiajiaoService.selectOne(new EntityWrapper<JiajiaoEntity>().eq("jiajiaozhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        jiajiaoService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiajiaoEntity jiajiao,
		HttpServletRequest request){
        EntityWrapper<JiajiaoEntity> ew = new EntityWrapper<JiajiaoEntity>();



		PageUtils page = jiajiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiao), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiajiaoEntity jiajiao, 
		HttpServletRequest request){
        EntityWrapper<JiajiaoEntity> ew = new EntityWrapper<JiajiaoEntity>();

		PageUtils page = jiajiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiao), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiajiaoEntity jiajiao){
       	EntityWrapper<JiajiaoEntity> ew = new EntityWrapper<JiajiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiajiao, "jiajiao")); 
        return R.ok().put("data", jiajiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiajiaoEntity jiajiao){
        EntityWrapper< JiajiaoEntity> ew = new EntityWrapper< JiajiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiajiao, "jiajiao")); 
		JiajiaoView jiajiaoView =  jiajiaoService.selectView(ew);
		return R.ok("查询家教成功").put("data", jiajiaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiajiaoEntity jiajiao = jiajiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiajiao,deSens);
        return R.ok().put("data", jiajiao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiajiaoEntity jiajiao = jiajiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiajiao,deSens);
        return R.ok().put("data", jiajiao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增家教") 
    public R save(@RequestBody JiajiaoEntity jiajiao, HttpServletRequest request){
        if(jiajiaoService.selectCount(new EntityWrapper<JiajiaoEntity>().eq("jiajiaozhanghao", jiajiao.getJiajiaozhanghao()))>0) {
            return R.error("家教账号已存在");
        }
    	jiajiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajiao);
    	JiajiaoEntity u = jiajiaoService.selectOne(new EntityWrapper<JiajiaoEntity>().eq("jiajiaozhanghao", jiajiao.getJiajiaozhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jiajiao.setId(new Date().getTime());
        jiajiaoService.insert(jiajiao);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增家教")
    @RequestMapping("/add")
    public R add(@RequestBody JiajiaoEntity jiajiao, HttpServletRequest request){
        if(jiajiaoService.selectCount(new EntityWrapper<JiajiaoEntity>().eq("jiajiaozhanghao", jiajiao.getJiajiaozhanghao()))>0) {
            return R.error("家教账号已存在");
        }
    	jiajiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajiao);
    	JiajiaoEntity u = jiajiaoService.selectOne(new EntityWrapper<JiajiaoEntity>().eq("jiajiaozhanghao", jiajiao.getJiajiaozhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jiajiao.setId(new Date().getTime());
        jiajiaoService.insert(jiajiao);
        return R.ok().put("data",jiajiao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改家教")
    public R update(@RequestBody JiajiaoEntity jiajiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiajiao);
        if(jiajiaoService.selectCount(new EntityWrapper<JiajiaoEntity>().ne("id", jiajiao.getId()).eq("jiajiaozhanghao", jiajiao.getJiajiaozhanghao()))>0) {
            return R.error("家教账号已存在");
        }
        jiajiaoService.updateById(jiajiao);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核家教")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JiajiaoEntity> list = new ArrayList<JiajiaoEntity>();
        for(Long id : ids) {
            JiajiaoEntity jiajiao = jiajiaoService.selectById(id);
            jiajiao.setSfsh(sfsh);
            jiajiao.setShhf(shhf);
            list.add(jiajiao);
        }
        jiajiaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除家教")
    public R delete(@RequestBody Long[] ids){
        jiajiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
