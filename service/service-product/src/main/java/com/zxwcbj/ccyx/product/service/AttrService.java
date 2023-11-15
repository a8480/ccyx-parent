package com.zxwcbj.ccyx.product.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.product.Attr;

import java.util.List;

/**
 * <p>
 * 商品属性 服务类
 * </p>
 *
 * @author onsimple
 * @since 2023-11-15
 */
public interface AttrService extends IService<Attr> {

    //平台属性列表方法
    List<Attr> getAttrListByGroup(Long groupId);
}
