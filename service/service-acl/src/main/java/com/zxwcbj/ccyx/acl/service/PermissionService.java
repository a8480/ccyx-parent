package com.zxwcbj.ccyx.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.acl.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService extends IService<Permission> {
    /**
     * 查询所有菜单
     *
     * @return java.util.List<com.zxwcbj.ccyx.model.acl.Permission>
     **/

    List<Permission> getPermissionList();
    //递归删除
    void removeChildById(Long id);

    //获得所有菜单和己分配的菜单
         List<Permission> getPermissionByRoleId(Long roleId);
}
