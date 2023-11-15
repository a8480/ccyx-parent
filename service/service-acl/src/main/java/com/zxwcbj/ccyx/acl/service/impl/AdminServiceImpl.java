package com.zxwcbj.ccyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.acl.mapper.AdminMapper;
import com.zxwcbj.ccyx.acl.service.AdminService;
import com.zxwcbj.ccyx.model.acl.Admin;
import com.zxwcbj.ccyx.vo.acl.AdminQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService{
    @Override
    public IPage<Admin> selectUserPage(AdminQueryVo adminQueryVo, Page pageParam) {
        String userName = adminQueryVo.getUsername();
        String name=adminQueryVo.getName();
        LambdaQueryWrapper<Admin> wrapper=new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(userName)) {
            //wrapper.like(Admin::getUsername,userName);
            wrapper.eq(Admin::getUsername, userName);
        }
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(Admin::getName, name);
        }
        return baseMapper.selectPage(pageParam,wrapper);
    }
}
