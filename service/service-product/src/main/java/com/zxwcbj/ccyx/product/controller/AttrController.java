package com.zxwcbj.ccyx.product.controller;


import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.product.Attr;
import com.zxwcbj.ccyx.product.service.AttrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 * 商品属性 前端控制器
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
@RestController
@RequestMapping("/admin/product/attr")
@CrossOrigin
public class AttrController {
    @Autowired
    private AttrService attrService;

    //平台属性列表方法
//根据平台属性分组id香询
    @ApiOperation("根据平台属性分组id香询")
    @GetMapping("/{groupId}")
    public Result<?> getList(@PathVariable Long groupId) {
        List<Attr> list = attrService.getAttrListByGroup(groupId);
        return Result.ok(list);
    }

    @ApiOperation(value = "获取")
    @GetMapping("/get/{id}")
    public Result<Attr> get(@PathVariable Long id) {
        Attr attr = attrService.getById(id);
        return Result.ok(attr);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result<?> save(@RequestBody Attr attr) {
        attrService.save(attr);
        return Result.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result<?> updateById(@RequestBody Attr attr) {
        attrService.updateById(attr);
        return Result.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result<?> remove(@PathVariable Long id) {
        attrService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("/batchRemove")
    public Result<?> batchRemove(@RequestBody List<Long> idList) {
        attrService.removeByIds(idList);
        return Result.ok();
    }
}

