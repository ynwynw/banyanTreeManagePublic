package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RongshuziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RongshuziyuanView;


/**
 * 古树资源
 *
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
public interface RongshuziyuanService extends IService<RongshuziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RongshuziyuanView> selectListView(Wrapper<RongshuziyuanEntity> wrapper);
   	
   	RongshuziyuanView selectView(@Param("ew") Wrapper<RongshuziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RongshuziyuanEntity> wrapper);
   	

}

