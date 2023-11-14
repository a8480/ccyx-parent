package com.zxwcbj.ccyx.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.sys.RegionWare;
import com.zxwcbj.ccyx.sys.service.RegionWareService;
import com.zxwcbj.ccyx.vo.sys.RegionWareQueryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  城市仓库关联表 前端控制器
 **/
@CrossOrigin
@RestController
@RequestMapping("/admin/sys/regionWare")
public class RegionWareController {
    @Autowired
    RegionWareService regionWareService;
    //开通区域列表
    @ApiOperation("开通区域列表")
    @GetMapping("/{page}/{limit}")
    public Result<?> getPageList(@PathVariable Long page,
                                                    @PathVariable Long limit,
                            RegionWareQueryVo regionWareQueryVo) {
        Page<RegionWare> pageList = new Page<>(page, limit);
        IPage<RegionWare> ipage=regionWareService.getPageList(pageList, regionWareQueryVo);
        return Result.ok(ipage);
    }
    ///添加开通区域
    @ApiOperation("添加开通区域")
    @PostMapping("save}")
    public Result addRegionWare(@RequestBody RegionWare regionWare) {
        regionWareService.saveReginWare(regionWare);
        return Result.ok(null);
    }
        //删除开通区域
    @ApiOperation("删除开通区域")
    @DeleteMapping("remove/{id}")
    public Result<?> removeById(@PathVariable Long id) {
        regionWareService.removeById(id);
        return Result.ok(null);
    }
        //取消开通区域
    @ApiOperation("取消开通区域")
    @PostMapping("updateStatus/{id}/{status}")
    public Result<?> updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        regionWareService.updateStatus(id, status);
        return Result.ok(null);
    }
}
