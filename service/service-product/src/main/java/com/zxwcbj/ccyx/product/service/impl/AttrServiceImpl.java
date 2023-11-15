package com.zxwcbj.ccyx.product.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.model.product.Attr;
import com.zxwcbj.ccyx.product.mapper.AttrMapper;
import com.zxwcbj.ccyx.product.service.AttrService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品属性 服务实现类
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements AttrService {
    //平台属性列表方法
    @Override
    public List<Attr> getAttrListByGroup(Long groupId) {
        LambdaQueryWrapper<Attr> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getId,groupId);
        return baseMapper.selectList(wrapper);
    }
}
