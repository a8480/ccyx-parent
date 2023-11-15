package com.zxwcbj.ccyx.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.product.AttrGroup;
import com.zxwcbj.ccyx.product.service.AttrGroupService;
import com.zxwcbj.ccyx.vo.product.AttrGroupQueryVo;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性分组 前端控制器
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
@RestController
@RequestMapping("/admin/product/attrGroup")
@CrossOrigin
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    //分页查询
    @ApiOperation("分页查询")
    @GetMapping("/{page}/{limit}")
    public Result<?> getPageList(@PathVariable Long page,
                                 @PathVariable Long limit,
                                 AttrGroupQueryVo attrGroupQueryVo) {
        Page<AttrGroup> apget = new Page<>(page, limit);
        IPage<AttrGroup> iPage = attrGroupService.selectPageAttrGroup(apget, attrGroupQueryVo);
        return Result.ok(iPage);
    }

    @ApiOperation("查询所有平台属性分组列表")
    @GetMapping("findAllList")
    public Result<?> findAllList() {
        List<AttrGroup> list = attrGroupService.findAllListAttrGroup();
        return Result.ok(list);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result<AttrGroup> get(@PathVariable Long id) {
        AttrGroup attrGroup = attrGroupService.getById(id);
        return Result.ok(attrGroup);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result<Null> save(@RequestBody AttrGroup attrGroup) {
        attrGroupService.save(attrGroup);
        return Result.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result<?> updateById(@RequestBody AttrGroup attrGroup) {
        attrGroupService.updateById(attrGroup);
        return Result.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result<?> remove(@PathVariable Long id) {
        attrGroupService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result<?> batchRemove(@RequestBody List<Long> idList) {
        attrGroupService.removeByIds(idList);
        return Result.ok();
    }
}

