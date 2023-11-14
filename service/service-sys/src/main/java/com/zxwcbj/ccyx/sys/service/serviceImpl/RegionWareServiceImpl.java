package com.zxwcbj.ccyx.sys.service.serviceImpl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.model.sys.RegionWare;
import com.zxwcbj.ccyx.sys.mapper.RegionWareMapper;
import com.zxwcbj.ccyx.sys.service.RegionWareService;
import com.zxwcbj.ccyx.vo.sys.RegionWareQueryVo;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class RegionWareServiceImpl extends ServiceImpl<RegionWareMapper, RegionWare> implements RegionWareService {
        /**
     * 开通区域列表
     *
     * @param pageList 分页数据
     * @param regionWareQueryVo 关键字
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.zxwcbj.ccyx.model.sys.RegionWare>
     **/
    @Override
    public IPage<RegionWare> getPageList(Page<RegionWare> pageList, RegionWareQueryVo regionWareQueryVo) {
        //获取条件值
        String keyword = regionWareQueryVo.getKeyword();
        //2 判断条件值是否为空，不为空封装条件
        LambdaQueryWrapper<RegionWare> wrapper = new LambdaQueryWrapper<>();
        //根据区域名称或者仓库名称香询
        if (!StringUtil.isEmpty(regionWareQueryVo.getKeyword())) {
            wrapper.like(RegionWare::getRegionName, keyword)
                    .or().like(RegionWare::getWareName, keyword);
        }
        //3调用方法实现条件分贞香询,并返回
        return baseMapper.selectPage(pageList, wrapper);
    }
/**
 * 取消区域开通
 * */
    @Override
    public void updateStatus(Long id, Integer status) {
        RegionWare regionWare=baseMapper.selectById(id);
        regionWare.setStatus(status);
        baseMapper.updateById(regionWare);
    }
}
