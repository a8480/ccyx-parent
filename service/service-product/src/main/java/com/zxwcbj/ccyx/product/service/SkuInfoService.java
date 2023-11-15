package com.zxwcbj.ccyx.product.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.product.SkuInfo;
import com.zxwcbj.ccyx.vo.product.SkuInfoQueryVo;
import com.zxwcbj.ccyx.vo.product.SkuInfoVo;

import java.util.List;

/**
 * <p>
 * sku信息 服务类
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
public interface SkuInfoService extends IService<SkuInfo> {
//分页查询
    IPage<SkuInfo> selectPageSkuinfo(Page<SkuInfo> pagelist, SkuInfoQueryVo skuInfoQueryVo);

    //新增
    void saveSkuInfo(SkuInfoVo skuInfoVo);

    //根据skuId获取sku基本信息
    SkuInfoVo getSkuInfo(Long id);

    //修改
    void updateSkuInfo(SkuInfoVo skuInfoVo);

    //商品审核
    void check(Long id, Integer status);

     //商品上架
    void publish(Long id, Integer status);

    //新人专享
    void isNewPerson(Long id, Integer status);


//根据skuId列表得到sku信息列表
    List<SkuInfo> findSkuInfoList(List<Long> skuIdList);

    List<SkuInfo> findSkuInfoByKeyword(String keyword);
}
