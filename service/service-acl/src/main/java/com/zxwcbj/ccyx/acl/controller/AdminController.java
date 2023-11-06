package com.zxwcbj.ccyx.acl.controller;

import com.zxwcbj.ccyx.acl.service.RoleService;
import com.zxwcbj.ccyx.common.result.Result;
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
    @ApiOperation("为用户分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestParam  Long adminId,
                           @RequestParam Long[] roleId){
        roleService.saveAdmin(adminId, roleId);
        return Result.ok(null);
    }

}
