package com.zxwcbj.ccyx.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.product.SkuInfo;
import com.zxwcbj.ccyx.product.service.SkuInfoService;
import com.zxwcbj.ccyx.vo.product.SkuInfoQueryVo;
import com.zxwcbj.ccyx.vo.product.SkuInfoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * sku信息 前端控制器
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
@RestController
@RequestMapping("/admin/product/skuInfo")
@CrossOrigin
public class SkuInfoController {
    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation("SKU列表")
    @GetMapping("{page}/{limit}")
    public Result<?> getPageList(@PathVariable Long page,
                              @PathVariable Long limit,
                              SkuInfoQueryVo skuInfoQueryVo) {
        Page<SkuInfo> pagelist = new Page<>(page, limit);
        IPage<SkuInfo> iPage = skuInfoService.selectPageSkuinfo(pagelist, skuInfoQueryVo);
        return Result.ok(iPage);
    }

    //添加商品sku信息
    @ApiOperation("添加商品sku信息")
    @PostMapping("save")
    public Result save(@RequestBody SkuInfoVo skuInfoVo) {
        skuInfoService.saveSkuInfo(skuInfoVo);
        return Result.ok();
    }

    //根据skuId获取sku基本信息
    @GetMapping("get/{id}")
    @ApiOperation("根据skuId获取sku基本信息")
    public Result getById(@PathVariable Long id) {
        SkuInfoVo skuInfoVo = skuInfoService.getSkuInfo(id);
        return Result.ok(skuInfoVo);
    }

    @ApiOperation("修改sku")
    @PutMapping("update")
    public Result<?> updateById(@RequestBody SkuInfoVo skuInfoVo) {
        skuInfoService.updateSkuInfo(skuInfoVo);
        return Result.ok();
    }

    //根据skuId 删除sku
    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result<?> remove(@PathVariable Long id) {
        skuInfoService.removeById(id);
        return Result.ok();
    }

    //根据id列表删除,批量删除
    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result<?> batchRemove(@RequestBody List<Long> idList) {
        skuInfoService.removeByIds(idList);
        return Result.ok();
    }

     //商品审核
    @ApiOperation(value = "商品审核")
    @GetMapping("check/{id}/{status}")
    public Result<?> check(@PathVariable Long id,
                        @PathVariable Integer status){
        skuInfoService.check(id,status);
        return Result.ok();
    }
    //商品上架
    @ApiOperation("商品上下 架")
    @GetMapping("publish/{id}/{status}")
    public Result<?> publish(@PathVariable Long id,
                          @PathVariable Integer status){
        skuInfoService.publish(id,status);
        return Result.ok();
    }

    //新人专享
    @ApiOperation("新人专享")
    @GetMapping("isNewPerson/{id}/{status}")
    public Result isNewPerson(@PathVariable Long id,
                              @PathVariable Integer status){
        skuInfoService.isNewPerson(id,status);
        return Result.ok();
    }
}

