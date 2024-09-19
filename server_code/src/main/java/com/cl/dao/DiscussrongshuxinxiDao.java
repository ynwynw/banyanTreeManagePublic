package com.cl.dao;

import com.cl.entity.DiscussrongshuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussrongshuxinxiView;


/**
 * 古树信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
public interface DiscussrongshuxinxiDao extends BaseMapper<DiscussrongshuxinxiEntity> {
	
	List<DiscussrongshuxinxiView> selectListView(@Param("ew") Wrapper<DiscussrongshuxinxiEntity> wrapper);

	List<DiscussrongshuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussrongshuxinxiEntity> wrapper);
	
	DiscussrongshuxinxiView selectView(@Param("ew") Wrapper<DiscussrongshuxinxiEntity> wrapper);
	

}
