package com.zxwcbj.ccyx.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.sys.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService extends IService<Region> {
    //根据区域关键查询区域列表信息
    List<Region> getReginByKeyword(String keyword);
}
