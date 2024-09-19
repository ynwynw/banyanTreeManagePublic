package com.cl.dao;

import com.cl.entity.RongshuziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RongshuziyuanView;


/**
 * 古树资源
 * 
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
public interface RongshuziyuanDao extends BaseMapper<RongshuziyuanEntity> {
	
	List<RongshuziyuanView> selectListView(@Param("ew") Wrapper<RongshuziyuanEntity> wrapper);

	List<RongshuziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<RongshuziyuanEntity> wrapper);
	
	RongshuziyuanView selectView(@Param("ew") Wrapper<RongshuziyuanEntity> wrapper);
	

}
