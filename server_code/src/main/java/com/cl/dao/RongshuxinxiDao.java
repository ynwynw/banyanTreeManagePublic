package com.cl.dao;

import com.cl.entity.RongshuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RongshuxinxiView;


/**
 * 古树信息
 * 
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
public interface RongshuxinxiDao extends BaseMapper<RongshuxinxiEntity> {
	
	List<RongshuxinxiView> selectListView(@Param("ew") Wrapper<RongshuxinxiEntity> wrapper);

	List<RongshuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<RongshuxinxiEntity> wrapper);
	
	RongshuxinxiView selectView(@Param("ew") Wrapper<RongshuxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RongshuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RongshuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RongshuxinxiEntity> wrapper);



}
