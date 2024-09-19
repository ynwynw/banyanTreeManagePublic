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

import com.cl.entity.RongshuxinxiEntity;
import com.cl.entity.view.RongshuxinxiView;

import com.cl.service.RongshuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 古树信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
@RestController
@RequestMapping("/rongshuxinxi")
public class RongshuxinxiController {
    @Autowired
    private RongshuxinxiService rongshuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RongshuxinxiEntity rongshuxinxi,
		HttpServletRequest request){
        EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();

		PageUtils page = rongshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rongshuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RongshuxinxiEntity rongshuxinxi, 
		HttpServletRequest request){
        EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();

		PageUtils page = rongshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rongshuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RongshuxinxiEntity rongshuxinxi){
       	EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( rongshuxinxi, "rongshuxinxi")); 
        return R.ok().put("data", rongshuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RongshuxinxiEntity rongshuxinxi){
        EntityWrapper< RongshuxinxiEntity> ew = new EntityWrapper< RongshuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( rongshuxinxi, "rongshuxinxi")); 
		RongshuxinxiView rongshuxinxiView =  rongshuxinxiService.selectView(ew);
		return R.ok("查询古树信息成功").put("data", rongshuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RongshuxinxiEntity rongshuxinxi = rongshuxinxiService.selectById(id);
		rongshuxinxi = rongshuxinxiService.selectView(new EntityWrapper<RongshuxinxiEntity>().eq("id", id));
        return R.ok().put("data", rongshuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RongshuxinxiEntity rongshuxinxi = rongshuxinxiService.selectById(id);
		rongshuxinxi = rongshuxinxiService.selectView(new EntityWrapper<RongshuxinxiEntity>().eq("id", id));
        return R.ok().put("data", rongshuxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        RongshuxinxiEntity rongshuxinxi = rongshuxinxiService.selectById(id);
        if(type.equals("1")) {
        	rongshuxinxi.setThumbsupnum(rongshuxinxi.getThumbsupnum()+1);
        } else {
        	rongshuxinxi.setCrazilynum(rongshuxinxi.getCrazilynum()+1);
        }
        rongshuxinxiService.updateById(rongshuxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增古树信息")
    public R save(@RequestBody RongshuxinxiEntity rongshuxinxi, HttpServletRequest request){
    	rongshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rongshuxinxi);
        rongshuxinxiService.insert(rongshuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增古树信息")
    @RequestMapping("/add")
    public R add(@RequestBody RongshuxinxiEntity rongshuxinxi, HttpServletRequest request){
    	rongshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(rongshuxinxi);
        rongshuxinxiService.insert(rongshuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改古树信息")
    public R update(@RequestBody RongshuxinxiEntity rongshuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(rongshuxinxi);
        rongshuxinxiService.updateById(rongshuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除古树信息")
    public R delete(@RequestBody Long[] ids){
        rongshuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();
        List<Map<String, Object>> result = rongshuxinxiService.selectValue(params, ew);
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

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = rongshuxinxiService.selectValue(params, ew);
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

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();
        List<Map<String, Object>> result = rongshuxinxiService.selectTimeStatValue(params, ew);
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

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = rongshuxinxiService.selectTimeStatValue(params, ew);
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

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();
        List<Map<String, Object>> result = rongshuxinxiService.selectGroup(params, ew);
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




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,RongshuxinxiEntity rongshuxinxi, HttpServletRequest request){
        EntityWrapper<RongshuxinxiEntity> ew = new EntityWrapper<RongshuxinxiEntity>();
        int count = rongshuxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rongshuxinxi), params), params));
        return R.ok().put("data", count);
    }


}
