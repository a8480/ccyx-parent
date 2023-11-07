package com.zxwcbj.ccyx.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxwcbj.ccyx.model.acl.Admin;
import com.zxwcbj.ccyx.vo.acl.AdminQueryVo;
import org.springframework.stereotype.Service;

/**
 * @author a8480
 */
@Service
public interface AdminService extends IService<Admin> {
    /**
     * 分页查询
     * @param adminQueryVo 用户对象
     * @return com.baomidou.mybatisplus.core.metadata.IPage
     **/

    IPage<Admin> selectUserPage(AdminQueryVo adminQueryVo, Page pageParams);
}
