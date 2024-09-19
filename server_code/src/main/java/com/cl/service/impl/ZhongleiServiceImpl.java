package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZhongleiDao;
import com.cl.entity.ZhongleiEntity;
import com.cl.service.ZhongleiService;
import com.cl.entity.view.ZhongleiView;

@Service("zhongleiService")
public class ZhongleiServiceImpl extends ServiceImpl<ZhongleiDao, ZhongleiEntity> implements ZhongleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhongleiEntity> page = this.selectPage(
                new Query<ZhongleiEntity>(params).getPage(),
                new EntityWrapper<ZhongleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhongleiEntity> wrapper) {
		  Page<ZhongleiView> page =new Query<ZhongleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhongleiView> selectListView(Wrapper<ZhongleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhongleiView selectView(Wrapper<ZhongleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
