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
import com.utils.UserBasedCollaborativeFiltering;
import com.service.JiajiaoyuyueService;
import com.entity.JiajiaoyuyueEntity;

import com.entity.JiajiaoxinxiEntity;
import com.entity.view.JiajiaoxinxiView;

import com.service.JiajiaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 家教信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-14 21:59:27
 */
@RestController
@RequestMapping("/jiajiaoxinxi")
public class JiajiaoxinxiController {
    @Autowired
    private JiajiaoxinxiService jiajiaoxinxiService;



    @Autowired
    private JiajiaoyuyueService jiajiaoyuyueService;

    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiajiaoxinxiEntity jiajiaoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiajiao")) {
			jiajiaoxinxi.setJiajiaozhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();



		PageUtils page = jiajiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiaoxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiajiaoxinxiEntity jiajiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();

		PageUtils page = jiajiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiaoxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiajiaoxinxiEntity jiajiaoxinxi){
       	EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiajiaoxinxi, "jiajiaoxinxi")); 
        return R.ok().put("data", jiajiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiajiaoxinxiEntity jiajiaoxinxi){
        EntityWrapper< JiajiaoxinxiEntity> ew = new EntityWrapper< JiajiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiajiaoxinxi, "jiajiaoxinxi")); 
		JiajiaoxinxiView jiajiaoxinxiView =  jiajiaoxinxiService.selectView(ew);
		return R.ok("查询家教信息成功").put("data", jiajiaoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiajiaoxinxiEntity jiajiaoxinxi = jiajiaoxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiajiaoxinxi,deSens);
        return R.ok().put("data", jiajiaoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiajiaoxinxiEntity jiajiaoxinxi = jiajiaoxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiajiaoxinxi,deSens);
        return R.ok().put("data", jiajiaoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增家教信息") 
    public R save(@RequestBody JiajiaoxinxiEntity jiajiaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiajiaoxinxi);
        jiajiaoxinxiService.insert(jiajiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增家教信息")
    @RequestMapping("/add")
    public R add(@RequestBody JiajiaoxinxiEntity jiajiaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiajiaoxinxi);
        jiajiaoxinxiService.insert(jiajiaoxinxi);
        return R.ok().put("data",jiajiaoxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改家教信息")
    public R update(@RequestBody JiajiaoxinxiEntity jiajiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiajiaoxinxi);
        jiajiaoxinxiService.updateById(jiajiaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除家教信息")
    public R delete(@RequestBody Long[] ids){
        jiajiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiajiaoxinxiEntity jiajiaoxinxi, HttpServletRequest request,String pre){
        EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
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
		PageUtils page = jiajiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiaoxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,JiajiaoxinxiEntity jiajiaoxinxi, HttpServletRequest request){
        String userName = (String)request.getSession().getAttribute("username");
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<JiajiaoyuyueEntity> jiajiaoyuyueList = jiajiaoyuyueService.selectList(new EntityWrapper<JiajiaoyuyueEntity>());
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(jiajiaoyuyueList!=null && jiajiaoyuyueList.size()>0) {
            for(JiajiaoyuyueEntity jiajiaoyuyue : jiajiaoyuyueList) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(jiajiaoyuyue.getJiazhangzhanghao().toString())) {
                    userRatings = ratings.get(jiajiaoyuyue.getJiazhangzhanghao().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(jiajiaoyuyue.getJiazhangzhanghao().toString(), userRatings);
                }
                if(userRatings.containsKey(jiajiaoyuyue.getJiajiaoxingming().toString())) {
                    userRatings.put(jiajiaoyuyue.getJiajiaoxingming().toString(), userRatings.get(jiajiaoyuyue.getJiajiaoxingming().toString())+1.0);
                } else {
                    userRatings.put(jiajiaoyuyue.getJiajiaoxingming().toString(), 1.0);
                }

            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userName;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
        ew.in("jiajiaoxingming", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(jiajiaoxingming, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        PageUtils page = jiajiaoxinxiService.queryPage(params, ew);
        List<JiajiaoxinxiEntity> pageList = (List<JiajiaoxinxiEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<JiajiaoxinxiEntity>();
            ew.notIn("jiajiaoxingming", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(jiajiaoxinxiService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }






        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_jiajiaoxinxi_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
                                    if(tableName.equals("jiajiao")) {
            ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
        }
                            List<Map<String, Object>> result = jiajiaoxinxiService.selectValue(params, ew);
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
        java.nio.file.Path path = java.nio.file.Paths.get("value_jiajiaoxinxi_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
                                    if(tableName.equals("jiajiao")) {
            ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
        }
                        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = jiajiaoxinxiService.selectValue(params, ew);
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
        java.nio.file.Path path = java.nio.file.Paths.get("value_jiajiaoxinxi_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("yColumn", yColumnName);
            params.put("timeStatType", timeStatType);
            EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                if(tableName.equals("jiajiao")) {
                ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                                    List<Map<String, Object>> result = jiajiaoxinxiService.selectTimeStatValue(params, ew);
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
        java.nio.file.Path path = java.nio.file.Paths.get("value_jiajiaoxinxi_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
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
            EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                if(tableName.equals("jiajiao")) {
                ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
            }
                                                            for(int i=0;i<yColumnNames.length;i++) {
                params.put("yColumn", yColumnNames[i]);
                List<Map<String, Object>> result = jiajiaoxinxiService.selectTimeStatValue(params, ew);
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
        java.nio.file.Path path = java.nio.file.Paths.get("group_jiajiaoxinxi_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
                                    if(tableName.equals("jiajiao")) {
            ew.eq("jiajiaozhanghao", (String)request.getSession().getAttribute("username"));
        }
                            List<Map<String, Object>> result = jiajiaoxinxiService.selectGroup(params, ew);
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
    public R count(@RequestParam Map<String, Object> params,JiajiaoxinxiEntity jiajiaoxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiajiao")) {
            jiajiaoxinxi.setJiajiaozhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<JiajiaoxinxiEntity> ew = new EntityWrapper<JiajiaoxinxiEntity>();
        int count = jiajiaoxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajiaoxinxi), params), params));
        return R.ok().put("data", count);
    }



}
