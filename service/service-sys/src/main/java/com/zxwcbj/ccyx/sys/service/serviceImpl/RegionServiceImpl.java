package com.zxwcbj.ccyx.sys.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.model.sys.Region;
import com.zxwcbj.ccyx.sys.mapper.RegionMapper;
import com.zxwcbj.ccyx.sys.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
    //根据区域关键查询区域列表信息
    @Override
    public List<Region> getReginByKeyword(String keyword) {
        LambdaQueryWrapper<Region> wrapper=new LambdaQueryWrapper<>();
        wrapper.like(Region::getName,keyword);
        return baseMapper.selectList(wrapper);
    }
}
