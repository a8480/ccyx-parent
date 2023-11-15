package com.zxwcbj.ccyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.model.product.AttrGroup;
import com.zxwcbj.ccyx.product.mapper.AttrGroupMapper;
import com.zxwcbj.ccyx.product.service.AttrGroupService;
import com.zxwcbj.ccyx.vo.product.AttrGroupQueryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 属性分组 服务实现类
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements AttrGroupService {

    @Override
    public IPage<AttrGroup> selectPageAttrGroup(Page<AttrGroup> apget, AttrGroupQueryVo attrGroupQueryVo) {
        String name=attrGroupQueryVo.getName();
        LambdaQueryWrapper<AttrGroup> wrapper=new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(AttrGroup::getName, name);
        }
        return baseMapper.selectPage(apget, wrapper);
    }

  //查询所有平台属性分组列表
    @Override
    public List<AttrGroup> findAllListAttrGroup() {
        QueryWrapper<AttrGroup> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return baseMapper.selectList(wrapper);
    }
}
