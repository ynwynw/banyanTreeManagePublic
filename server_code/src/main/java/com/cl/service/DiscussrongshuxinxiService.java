package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussrongshuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussrongshuxinxiView;


/**
 * 古树信息评论表
 *
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
public interface DiscussrongshuxinxiService extends IService<DiscussrongshuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussrongshuxinxiView> selectListView(Wrapper<DiscussrongshuxinxiEntity> wrapper);
   	
   	DiscussrongshuxinxiView selectView(@Param("ew") Wrapper<DiscussrongshuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussrongshuxinxiEntity> wrapper);
   	

}

