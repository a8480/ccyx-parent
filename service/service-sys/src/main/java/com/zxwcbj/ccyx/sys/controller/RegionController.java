package com.zxwcbj.ccyx.sys.controller;


import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.sys.Region;
import com.zxwcbj.ccyx.model.sys.RegionWare;
import com.zxwcbj.ccyx.sys.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/admin/sys/regionWare")
@RestController
@Api(tags = "区域接口")
/*
 * 地区表 前端控制器
 **/
public class RegionController {
    @Autowired
    RegionService regionService;
    //根据区域关键查询区域列表信息
    @ApiOperation("查询区域")
    @GetMapping("findRegionByKeyword/{keyword}")
    public Result findRegionByKeyword(@PathVariable String keyword) {
        List<Region> list = regionService.getReginByKeyword(keyword);
        return Result.ok(list);
    }


}
