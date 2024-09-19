package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhongleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongleiView;


/**
 * 种类
 *
 * @author 
 * @email 
 * @date 2024-02-28 18:05:11
 */
public interface ZhongleiService extends IService<ZhongleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhongleiView> selectListView(Wrapper<ZhongleiEntity> wrapper);
   	
   	ZhongleiView selectView(@Param("ew") Wrapper<ZhongleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhongleiEntity> wrapper);
   	

}

