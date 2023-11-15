package com.zxwcbj.ccyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.model.product.Category;
import com.zxwcbj.ccyx.product.mapper.CategoryMapper;
import com.zxwcbj.ccyx.product.service.CategoryService;
import com.zxwcbj.ccyx.vo.product.CategoryQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Override
    public IPage<Category> selectPageCategory(Page<Category> ipage, CategoryQueryVo categoryQueryVo) {
        String categoryName = categoryQueryVo.getName();
        LambdaQueryWrapper<com.zxwcbj.ccyx.model.product.Category> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(categoryName)) {
            wrapper.like(Category::getName, categoryName);
        }
        return baseMapper.selectPage(ipage, wrapper);
    }

           //查询所有商品分类
    @Override
    public List<Category> findAllList() {
		LambdaQueryWrapper<com.zxwcbj.ccyx.model.product.Category> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.orderByAsc(com.zxwcbj.ccyx.model.product.Category::getSort);
        return this.list(queryWrapper);
    }
}
