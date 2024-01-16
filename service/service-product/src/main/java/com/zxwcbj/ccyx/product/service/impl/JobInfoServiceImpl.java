package com.zxwcbj.ccyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.model.acl.Admin;
import com.zxwcbj.ccyx.model.acl.Enterprise;
import com.zxwcbj.ccyx.model.product.JobInfo;
import com.zxwcbj.ccyx.product.mapper.JoinfoMapper;
import com.zxwcbj.ccyx.product.service.JobInfoService;
import com.zxwcbj.ccyx.vo.product.JobInfoQueryVo;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JobInfoServiceImpl extends ServiceImpl<JoinfoMapper, JobInfo> implements JobInfoService {
    @Override
    public IPage<JobInfo> selectUserPage(JobInfoQueryVo jobInfoQueryVo, Page pageParm) {
        //工作标题
        String jobTitle = jobInfoQueryVo.getJobTitle();
        Long companyId=jobInfoQueryVo.getCompanyId();
        //TODO  有点麻烦(涉及多张表的查询和修改有点慢),先完成基本功能,看`JobInfoQueryVo` 最后是怎么写的
     /*   //通过员工姓名获取发布者id
        String EntName = jobInfoQueryVo.getEntName();
        //通过员工姓名获取申请者id
        String stuName = jobInfoQueryVo.getStuName();*/
        LambdaQueryWrapper<JobInfo> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtil.isEmpty(jobTitle)) {
            wrapper.like(JobInfo::getJobTitle, jobTitle);
        }
        //判断Long jobId 是否为空)
        if (companyId != null) {
            wrapper.eq(JobInfo::getCompanyId, companyId);
        }
        return baseMapper.selectPage(pageParm, wrapper);
    }

    @Override
    public Map<String, Object> saveJobId(Long adminId) {
        return null;
    }

/*    @Override
    public Map<String, Object> saveJobId(Long adminId) {
        //TODO 未完成,(在申请岗位有毁约的可能)
        //1 删除用户已经分配过的角色数据
        //根据用户id删除admin_role表里面对应数据

        return null;
    }*/


}
