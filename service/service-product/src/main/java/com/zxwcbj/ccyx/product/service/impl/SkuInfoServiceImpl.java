package com.zxwcbj.ccyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.model.product.SkuInfo;

import com.zxwcbj.ccyx.product.mapper.SkuInfoMapper;
import com.zxwcbj.ccyx.product.service.SkuInfoService;
import com.zxwcbj.ccyx.vo.product.SkuInfoQueryVo;
import com.zxwcbj.ccyx.vo.product.SkuInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * sku信息 服务实现类
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {

    @Override
    public IPage<SkuInfo> selectPageSkuinfo(Page<SkuInfo> pagelist, SkuInfoQueryVo skuInfoQueryVo) {
        String name = skuInfoQueryVo.getKeyword();
        Long categoryId = skuInfoQueryVo.getCategoryId();
        String skuType = skuInfoQueryVo.getSkuType();
        LambdaQueryWrapper<SkuInfo> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(SkuInfo::getSkuName, name);
        }
        if (!StringUtils.isEmpty(skuType)) {
            wrapper.eq(SkuInfo::getSkuType, skuType);
        }
        if (categoryId != null) {
            wrapper.like(SkuInfo::getCategoryId, categoryId);
        }
        IPage<SkuInfo> iPage = baseMapper.selectPage(pagelist, wrapper);
        return iPage;
    }
//添加商品sku信息
    @Override
    public void saveSkuInfo(SkuInfoVo skuInfoVo) {

    }

    @Override
    public SkuInfoVo getSkuInfo(Long id) {
        return null;
    }

    @Override
    public void updateSkuInfo(SkuInfoVo skuInfoVo) {

    }

    @Override
    public void check(Long id, Integer status) {

    }

    @Override
    public void publish(Long id, Integer status) {

    }

    @Override
    public void isNewPerson(Long id, Integer status) {

    }

    @Override
    public List<SkuInfo> findSkuInfoList(List<Long> skuIdList) {
        return null;
    }

    @Override
    public List<SkuInfo> findSkuInfoByKeyword(String keyword) {
        return null;
    }
}
