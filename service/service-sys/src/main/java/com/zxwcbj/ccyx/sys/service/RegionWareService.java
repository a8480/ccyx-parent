package com.zxwcbj.ccyx.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.sys.RegionWare;
import com.zxwcbj.ccyx.vo.sys.RegionWareQueryVo;
import org.springframework.stereotype.Service;

@Service
public interface RegionWareService extends IService<RegionWare> {
    //开通区域列表
    IPage<RegionWare> getPageList(Page<RegionWare> pageList, RegionWareQueryVo regionWareQueryVo);
    //删除开通区域
    void updateStatus(Long id, Integer status);
    //添加开通区域
    void saveReginWare(RegionWare regionWare);
}
