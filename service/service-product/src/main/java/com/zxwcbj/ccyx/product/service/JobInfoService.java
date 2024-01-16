package com.zxwcbj.ccyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.product.JobInfo;
import com.zxwcbj.ccyx.vo.product.JobInfoQueryVo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface JobInfoService extends IService<JobInfo> {
    /*
     * 查看所有岗位分页列表(带搜索)
     **/
    IPage<JobInfo> selectUserPage(JobInfoQueryVo jobInfoQueryVo, Page<?> pageParm);
    /*
     *为用户分配岗位
     *
     * @param adminId
     * @return java.util.Map<java.lang.String, java.lang.Object>
     **/

    Map<String, Object> saveJobId(Long adminId);

}
