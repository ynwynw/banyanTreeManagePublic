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

import com.cl.entity.ZhongleiEntity;
import com.cl.entity.view.ZhongleiView;

import com.cl.service.ZhongleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 种类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
@RestController
@RequestMapping("/zhonglei")
public class ZhongleiController {
    @Autowired
    private ZhongleiService zhongleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhongleiEntity zhonglei,
		HttpServletRequest request){
        EntityWrapper<ZhongleiEntity> ew = new EntityWrapper<ZhongleiEntity>();

		PageUtils page = zhongleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhonglei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhongleiEntity zhonglei, 
		HttpServletRequest request){
        EntityWrapper<ZhongleiEntity> ew = new EntityWrapper<ZhongleiEntity>();

		PageUtils page = zhongleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhonglei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhongleiEntity zhonglei){
       	EntityWrapper<ZhongleiEntity> ew = new EntityWrapper<ZhongleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhonglei, "zhonglei")); 
        return R.ok().put("data", zhongleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhongleiEntity zhonglei){
        EntityWrapper< ZhongleiEntity> ew = new EntityWrapper< ZhongleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhonglei, "zhonglei")); 
		ZhongleiView zhongleiView =  zhongleiService.selectView(ew);
		return R.ok("查询种类成功").put("data", zhongleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhongleiEntity zhonglei = zhongleiService.selectById(id);
		zhonglei = zhongleiService.selectView(new EntityWrapper<ZhongleiEntity>().eq("id", id));
        return R.ok().put("data", zhonglei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhongleiEntity zhonglei = zhongleiService.selectById(id);
		zhonglei = zhongleiService.selectView(new EntityWrapper<ZhongleiEntity>().eq("id", id));
        return R.ok().put("data", zhonglei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增种类")
    public R save(@RequestBody ZhongleiEntity zhonglei, HttpServletRequest request){
    	zhonglei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhonglei);
        zhongleiService.insert(zhonglei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增种类")
    @RequestMapping("/add")
    public R add(@RequestBody ZhongleiEntity zhonglei, HttpServletRequest request){
    	zhonglei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhonglei);
        zhongleiService.insert(zhonglei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改种类")
    public R update(@RequestBody ZhongleiEntity zhonglei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhonglei);
        zhongleiService.updateById(zhonglei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除种类")
    public R delete(@RequestBody Long[] ids){
        zhongleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
