package com.cl.controller;

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
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
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
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.DiscussrongshuxinxiEntity;
import com.cl.entity.view.DiscussrongshuxinxiView;

import com.cl.service.DiscussrongshuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 古树信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
@RestController
@RequestMapping("/discussrongshuxinxi")
public class DiscussrongshuxinxiController {
    @Autowired
    private DiscussrongshuxinxiService discussrongshuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussrongshuxinxiEntity discussrongshuxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussrongshuxinxiEntity> ew = new EntityWrapper<DiscussrongshuxinxiEntity>();

		PageUtils page = discussrongshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussrongshuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussrongshuxinxiEntity discussrongshuxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussrongshuxinxiEntity> ew = new EntityWrapper<DiscussrongshuxinxiEntity>();

		PageUtils page = discussrongshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussrongshuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussrongshuxinxiEntity discussrongshuxinxi){
       	EntityWrapper<DiscussrongshuxinxiEntity> ew = new EntityWrapper<DiscussrongshuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussrongshuxinxi, "discussrongshuxinxi")); 
        return R.ok().put("data", discussrongshuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussrongshuxinxiEntity discussrongshuxinxi){
        EntityWrapper< DiscussrongshuxinxiEntity> ew = new EntityWrapper< DiscussrongshuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussrongshuxinxi, "discussrongshuxinxi")); 
		DiscussrongshuxinxiView discussrongshuxinxiView =  discussrongshuxinxiService.selectView(ew);
		return R.ok("查询古树信息评论表成功").put("data", discussrongshuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussrongshuxinxiEntity discussrongshuxinxi = discussrongshuxinxiService.selectById(id);
		discussrongshuxinxi = discussrongshuxinxiService.selectView(new EntityWrapper<DiscussrongshuxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussrongshuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussrongshuxinxiEntity discussrongshuxinxi = discussrongshuxinxiService.selectById(id);
		discussrongshuxinxi = discussrongshuxinxiService.selectView(new EntityWrapper<DiscussrongshuxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussrongshuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增古树信息评论表")
    public R save(@RequestBody DiscussrongshuxinxiEntity discussrongshuxinxi, HttpServletRequest request){
    	discussrongshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussrongshuxinxi);
        discussrongshuxinxiService.insert(discussrongshuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增古树信息评论表")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussrongshuxinxiEntity discussrongshuxinxi, HttpServletRequest request){
    	discussrongshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussrongshuxinxi);
        discussrongshuxinxiService.insert(discussrongshuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussrongshuxinxiEntity discussrongshuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussrongshuxinxi);
        discussrongshuxinxiService.updateById(discussrongshuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除古树信息评论表")
    public R delete(@RequestBody Long[] ids){
        discussrongshuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussrongshuxinxiEntity discussrongshuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussrongshuxinxiEntity> ew = new EntityWrapper<DiscussrongshuxinxiEntity>();
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
		PageUtils page = discussrongshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussrongshuxinxi), params), params));
        return R.ok().put("data", page);
    }








}
