package com.zxwcbj.ccyx.acl.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.acl.mapper.RoleMapper;
import com.zxwcbj.ccyx.acl.service.RoleService;
import com.zxwcbj.ccyx.model.acl.Role;
import com.zxwcbj.ccyx.vo.acl.RoleQueryVo;

/**
 * @author a8480
 */
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {
    /**
     * 1 角色列表(分页查询)
     * */
    @Override
    public IPage<Role> selectRolePageList(Page<Role> page, RoleQueryVo roleQueryVo) {

        return null;
    }
}
