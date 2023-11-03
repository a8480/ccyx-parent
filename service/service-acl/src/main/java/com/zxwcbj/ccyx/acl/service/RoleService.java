package com.zxwcbj.ccyx.acl.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.acl.Role;
import com.zxwcbj.ccyx.vo.acl.RoleQueryVo;
import org.springframework.stereotype.Service;

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
}
