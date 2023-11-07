package com.zxwcbj.ccyx.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.acl.service.AdminService;
import com.zxwcbj.ccyx.acl.service.RoleService;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.acl.Admin;
import com.zxwcbj.ccyx.vo.acl.AdminQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author a8480
 */
@Api(tags = "用户接口")
@RestController
@CrossOrigin
@RequestMapping("/admin/acl/user")
public class AdminController {
    @Autowired
    RoleService roleService;
    @Autowired
    AdminService adminService;
    @ApiOperation("为用户分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestParam  Long adminId,
                           @RequestParam Long[] roleId){
        roleService.saveAdmin(adminId, roleId);
        return Result.ok(null);
    }
    @ApiOperation("分页查询")
    @GetMapping("/{page}/{linit}")
    public Result getPageList(@PathVariable Long page, @PathVariable Long linit,
                                                    AdminQueryVo adminQueryVo){
        Page pageParam = new Page(page,linit);
        IPage<Admin> iPage=adminService.selectUserPage(adminQueryVo,pageParam);
        return  Result.ok(null);

    }
}
