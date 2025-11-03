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

import com.entity.JiajiaoyuyueEntity;
import com.entity.view.JiajiaoyuyueView;

import com.service.JiajiaoyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 家教预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
@RestController
@RequestMapping("/jiajiaoyuyue")
public class JiajiaoyuyueController {
    @Autowired
    private JiajiaoyuyueService jiajiaoyuyueService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiajiaoyuyueEntity jiajiaoyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiajiao")) {
			jiajiaoyuyue.setJiajiaozhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jiajiaoyuyue.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhang")) {
			jiajiaoyuyue.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();



		PageUtils page = jiajiaoyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiaoyuyue), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiajiaoyuyueEntity jiajiaoyuyue, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiajiao")) {
			jiajiaoyuyue.setJiajiaozhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jiajiaoyuyue.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhang")) {
			jiajiaoyuyue.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();

		PageUtils page = jiajiaoyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiaoyuyue), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiajiaoyuyueEntity jiajiaoyuyue){
       	EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiajiaoyuyue, "jiajiaoyuyue")); 
        return R.ok().put("data", jiajiaoyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiajiaoyuyueEntity jiajiaoyuyue){
        EntityWrapper< JiajiaoyuyueEntity> ew = new EntityWrapper< JiajiaoyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiajiaoyuyue, "jiajiaoyuyue")); 
		JiajiaoyuyueView jiajiaoyuyueView =  jiajiaoyuyueService.selectView(ew);
		return R.ok("查询家教预约成功").put("data", jiajiaoyuyueView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiajiaoyuyueEntity jiajiaoyuyue = jiajiaoyuyueService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiajiaoyuyue,deSens);
        return R.ok().put("data", jiajiaoyuyue);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiajiaoyuyueEntity jiajiaoyuyue = jiajiaoyuyueService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiajiaoyuyue,deSens);
        return R.ok().put("data", jiajiaoyuyue);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增家教预约") 
    public R save(@RequestBody JiajiaoyuyueEntity jiajiaoyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiajiaoyuyue);
        jiajiaoyuyueService.insert(jiajiaoyuyue);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增家教预约")
    @RequestMapping("/add")
    public R add(@RequestBody JiajiaoyuyueEntity jiajiaoyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiajiaoyuyue);
    	jiajiaoyuyue.setUserid((Long)request.getSession().getAttribute("userId"));
        jiajiaoyuyueService.insert(jiajiaoyuyue);
        return R.ok().put("data",jiajiaoyuyue.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改家教预约")
    public R update(@RequestBody JiajiaoyuyueEntity jiajiaoyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiajiaoyuyue);
        jiajiaoyuyueService.updateById(jiajiaoyuyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核家教预约")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JiajiaoyuyueEntity> list = new ArrayList<JiajiaoyuyueEntity>();
        for(Long id : ids) {
            JiajiaoyuyueEntity jiajiaoyuyue = jiajiaoyuyueService.selectById(id);
            jiajiaoyuyue.setSfsh(sfsh);
            jiajiaoyuyue.setShhf(shhf);
            list.add(jiajiaoyuyue);
        }
        jiajiaoyuyueService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除家教预约")
    public R delete(@RequestBody Long[] ids){
        jiajiaoyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_jiajiaoyuyue_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
                        if(tableName.equals("jiajiao")) {
            ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
        }
                                            if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
                    if(tableName.equals("jiazhang")) {
            ew.eq("jiazhangzhanghao", (String)request.getSession().getAttribute("username"));
        }
                                            List<Map<String, Object>> result = jiajiaoyuyueService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
        }
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_jiajiaoyuyue_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
                        if(tableName.equals("jiajiao")) {
            ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
        }
                                            if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
                    if(tableName.equals("jiazhang")) {
            ew.eq("jiazhangzhanghao", (String)request.getSession().getAttribute("username"));
        }
                                        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = jiajiaoyuyueService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
}
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_jiajiaoyuyue_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("yColumn", yColumnName);
            params.put("timeStatType", timeStatType);
            EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                                                            if(tableName.equals("jiajiao")) {
                ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                                                    if(tableName.equals("xuesheng")) {
                ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
            }
                                            if(tableName.equals("jiazhang")) {
                ew.eq("jiazhangzhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                                                    List<Map<String, Object>> result = jiajiaoyuyueService.selectTimeStatValue(params, ew);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            return R.ok().put("data", result);
        }
    }
    
        /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        java.nio.file.Path path = java.nio.file.Paths.get("value_jiajiaoyuyue_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            String[] yColumnNames = yColumnNameMul.split(",");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("timeStatType", timeStatType);
            List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                                                            if(tableName.equals("jiajiao")) {
                ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                                                    if(tableName.equals("xuesheng")) {
                ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
            }
                                            if(tableName.equals("jiazhang")) {
                ew.eq("jiazhangzhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                                            for(int i=0;i<yColumnNames.length;i++) {
                params.put("yColumn", yColumnNames[i]);
                List<Map<String, Object>> result = jiajiaoyuyueService.selectTimeStatValue(params, ew);
                for(Map<String, Object> m : result) {
                    for(String k : m.keySet()) {
                        if(m.get(k) instanceof Date) {
                            m.put(k, sdf.format((Date)m.get(k)));
                        }
                    }
                }
                result2.add(result);
            }
            return R.ok().put("data", result2);
        }
    }
    
        /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("group_jiajiaoyuyue_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
                        if(tableName.equals("jiajiao")) {
            ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
        }
                                            if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
                    if(tableName.equals("jiazhang")) {
            ew.eq("jiazhangzhanghao", (String)request.getSession().getAttribute("username"));
        }
                                            List<Map<String, Object>> result = jiajiaoyuyueService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
        }
    }    
    
    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,JiajiaoyuyueEntity jiajiaoyuyue, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiajiao")) {
            jiajiaoyuyue.setJiajiaozhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            jiajiaoyuyue.setXuehao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiazhang")) {
            jiajiaoyuyue.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<JiajiaoyuyueEntity> ew = new EntityWrapper<JiajiaoyuyueEntity>();
        int count = jiajiaoyuyueService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiaoyuyue), params), params));
        return R.ok().put("data", count);
    }



}
