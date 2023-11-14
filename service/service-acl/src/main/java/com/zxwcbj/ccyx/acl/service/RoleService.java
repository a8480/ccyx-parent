package com.zxwcbj.ccyx.acl.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.acl.Role;
import com.zxwcbj.ccyx.vo.acl.RoleQueryVo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author a8480
 */
@Service
public interface RoleService extends IService<Role> {
        /**
     * 角色列表(条件分页拆查询)
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.zxwcbj.ccyx.model.acl.Role>
     **/
    IPage<Role> selectRolePageList(Page<Role> page, RoleQueryVo roleQueryVo);

    /**
     * 分配角色权限
     * @param  adminId 用户管理员的ID
     * @param roleId 包含要分配的角色权限的ID
     **/
    void saveAdminRole(Long adminId, Long[] roleId);

    /**
     * 获取所有角色，和根据用户id查询用户分配角色列表
     * @param  adminId 用户id
     * */
    Map<String, Object> getRoleByAdminId(Long adminId);
}
