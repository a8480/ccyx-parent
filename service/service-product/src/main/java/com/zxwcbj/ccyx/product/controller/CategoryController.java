package com.zxwcbj.ccyx.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.product.Category;
import com.zxwcbj.ccyx.product.service.CategoryService;
import com.zxwcbj.ccyx.vo.product.CategoryQueryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
@RestController
@RequestMapping("/admin/product/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("获取商品分类分页列表")
    @GetMapping("{page}/{limit}")
    public Result<?> getPageList(@PathVariable Long page,
                                 @PathVariable Long limit,
                                 CategoryQueryVo categoryQueryVo) {
        Page<Category> ipage = new Page<>(page, limit);
        IPage<Category> categoryIPage = categoryService.selectPageCategory(ipage, categoryQueryVo);
        return Result.ok(categoryIPage);
    }

    @ApiOperation(value = "获取商品分类信息")
    @GetMapping("get/{id}")
    public Result<?> get(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        categoryService.save(category);
        return Result.ok(category);
    }

    @ApiOperation(value = "新增商品分类")
    @PostMapping("save")
    public Result<?> save(@RequestBody Category category) {
        categoryService.save(category);
        return Result.ok(null);
    }

    @ApiOperation(value = "修改商品分类")
    @PutMapping("update")
    public Result<?> updateById(@RequestBody Category category) {
        categoryService.updateById(category);
        return Result.ok(null);
    }

    @ApiOperation(value = "删除商品分类")
    @DeleteMapping("remove/{id}")
    public Result<?> remove(@PathVariable Long id) {
        categoryService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation(value = "根据id列表删除商品分类")
    @DeleteMapping("batchRemove")
    public Result<?> batchRemove(@RequestBody List<Long> idList) {
        categoryService.removeByIds(idList);
        return Result.ok(null);
    }

    @ApiOperation(value = "获取全部商品分类")
    @GetMapping("findAllList")
    public Result<?> findAllList() {
        return Result.ok(categoryService.findAllList());
    }

}

