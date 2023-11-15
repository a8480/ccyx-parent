package com.zxwcbj.ccyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.product.Category;
import com.zxwcbj.ccyx.vo.product.CategoryQueryVo;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
public interface CategoryService extends IService<Category> {


    IPage<Category> selectPageCategory(Page<Category> ipage, CategoryQueryVo categoryQueryVo);

    //查询所有商品分类
    List<Category> findAllList();
}
