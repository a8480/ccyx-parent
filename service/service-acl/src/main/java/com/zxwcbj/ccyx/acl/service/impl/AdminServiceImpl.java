package com.zxwcbj.ccyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.acl.mapper.AdminMapper;
import com.zxwcbj.ccyx.acl.service.AdminService;
import com.zxwcbj.ccyx.commom.utils.JWTUtils;
import com.zxwcbj.ccyx.commom.utils.MD5;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.acl.Admin;
import com.zxwcbj.ccyx.vo.acl.AdminQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService{
    @Override
    public IPage<Admin> selectUserPage(AdminQueryVo adminQueryVo, Page pageParam) {
        String userName = adminQueryVo.getUsername();
        LambdaQueryWrapper<Admin> wrapper=new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(userName)) {
            wrapper.eq(Admin::getUsername, userName);
        }
        return baseMapper.selectPage(pageParam,wrapper);
    }

    @Override
    public Result<?> selectByUsername(@RequestBody Admin data) {
        LambdaQueryWrapper<Admin> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername,data.getUsername());
        Admin admin=baseMapper.selectOne(wrapper);
        Map<String,Object> map=new HashMap<>();
        if(!StringUtils.isEmpty(admin)){
            if(admin.getPassword().equals(MD5.encrypt(data.getPassword()))){
                String token = JWTUtils.getToken(admin);
                map.put("token",token);
                return Result.ok(map);
            }
        }
        return Result.fail(map);
    }


}
