package com.cl.dao;

import com.cl.entity.ZhongleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongleiView;


/**
 * 种类
 * 
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
public interface ZhongleiDao extends BaseMapper<ZhongleiEntity> {
	
	List<ZhongleiView> selectListView(@Param("ew") Wrapper<ZhongleiEntity> wrapper);

	List<ZhongleiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhongleiEntity> wrapper);
	
	ZhongleiView selectView(@Param("ew") Wrapper<ZhongleiEntity> wrapper);
	

}
