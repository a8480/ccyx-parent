package com.zxwcbj.ccyx.search.controller;

import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/search/sku")
public class SkuApiController {
    @Autowired
    private SkuService skuService;
    //上架
    @GetMapping("inner/uppersku/skuId")
    public Result upperSku(@PathVariable Long skuId){
        skuService.upperSku(skuId);
        return Result.ok();
    }
    //下架
    @GetMapping("inner/lowerSku/(skuId}")
    public Result lowerSku(@PathVariable Long skuId){
        skuService.lowerSku(skuId);
        return Result.ok();
    }
}
