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

import com.cl.entity.RongshuziyuanEntity;
import com.cl.entity.view.RongshuziyuanView;

import com.cl.service.RongshuziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 古树资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
@RestController
@RequestMapping("/rongshuziyuan")
public class RongshuziyuanController {
    @Autowired
    private RongshuziyuanService rongshuziyuanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RongshuziyuanEntity rongshuziyuan,
		HttpServletRequest request){
        EntityWrapper<RongshuziyuanEntity> ew = new EntityWrapper<RongshuziyuanEntity>();

		PageUtils page = rongshuziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rongshuziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RongshuziyuanEntity rongshuziyuan, 
		HttpServletRequest request){
        EntityWrapper<RongshuziyuanEntity> ew = new EntityWrapper<RongshuziyuanEntity>();

		PageUtils page = rongshuziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rongshuziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RongshuziyuanEntity rongshuziyuan){
       	EntityWrapper<RongshuziyuanEntity> ew = new EntityWrapper<RongshuziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( rongshuziyuan, "rongshuziyuan")); 
        return R.ok().put("data", rongshuziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RongshuziyuanEntity rongshuziyuan){
        EntityWrapper< RongshuziyuanEntity> ew = new EntityWrapper< RongshuziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( rongshuziyuan, "rongshuziyuan")); 
		RongshuziyuanView rongshuziyuanView =  rongshuziyuanService.selectView(ew);
		return R.ok("查询古树资源成功").put("data", rongshuziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RongshuziyuanEntity rongshuziyuan = rongshuziyuanService.selectById(id);
		rongshuziyuan = rongshuziyuanService.selectView(new EntityWrapper<RongshuziyuanEntity>().eq("id", id));
        return R.ok().put("data", rongshuziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RongshuziyuanEntity rongshuziyuan = rongshuziyuanService.selectById(id);
		rongshuziyuan = rongshuziyuanService.selectView(new EntityWrapper<RongshuziyuanEntity>().eq("id", id));
        return R.ok().put("data", rongshuziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增古树资源")
    public R save(@RequestBody RongshuziyuanEntity rongshuziyuan, HttpServletRequest request){
    	rongshuziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rongshuziyuan);
        rongshuziyuanService.insert(rongshuziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增古树资源")
    @RequestMapping("/add")
    public R add(@RequestBody RongshuziyuanEntity rongshuziyuan, HttpServletRequest request){
    	rongshuziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rongshuziyuan);
        rongshuziyuanService.insert(rongshuziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改古树资源")
    public R update(@RequestBody RongshuziyuanEntity rongshuziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(rongshuziyuan);
        rongshuziyuanService.updateById(rongshuziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除古树资源")
    public R delete(@RequestBody Long[] ids){
        rongshuziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
