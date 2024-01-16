package com.zxwcbj.ccyx.activity.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.activity.ActivityInfo;
import com.zxwcbj.ccyx.model.product.SkuInfo;
import com.zxwcbj.ccyx.vo.activity.ActivityRuleVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-11-16
 */
public interface ActivityInfoService extends IService<ActivityInfo> {
//列表
    IPage<ActivityInfo> selectPage(Page<ActivityInfo> pageParam, Object o);


    Map<String, Object> findActivityRuleList(Long id);

    //新增活动规则
    void saveActivityRule(ActivityRuleVo activityRuleVo);

    List<SkuInfo> findSkuInfoByKeyword(String keyword);
}
