package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RongshuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RongshuxinxiView;


/**
 * 古树信息
 *
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
public interface RongshuxinxiService extends IService<RongshuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RongshuxinxiView> selectListView(Wrapper<RongshuxinxiEntity> wrapper);
   	
   	RongshuxinxiView selectView(@Param("ew") Wrapper<RongshuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RongshuxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<RongshuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<RongshuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<RongshuxinxiEntity> wrapper);



}

