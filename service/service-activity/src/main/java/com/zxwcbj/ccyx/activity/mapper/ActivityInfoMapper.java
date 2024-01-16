package com.zxwcbj.ccyx.activity.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxwcbj.ccyx.model.activity.ActivityInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 活动表 Mapper 接口
 * </p>
 *
 * @author atguigu
 * @since 2023-11-16
 */
@Repository
public interface ActivityInfoMapper extends BaseMapper<ActivityInfo> {

    List<Long> selectExistSkuIdList(List<Long> skuIdList);
}
