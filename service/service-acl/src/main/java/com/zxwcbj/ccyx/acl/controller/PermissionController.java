package com.zxwcbj.ccyx.acl.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.zxwcbj.ccyx.acl.service.PermissionService;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.acl.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/acl/permission")
@Api(tags = "菜单管理")
@CrossOrigin
public class PermissionController {

    @ApiOperation("获得所有菜单和己分配的菜单")
    @GetMapping("/toAssign/{roleId}")
    public  Result toAssign(@PathVariable Long roleId){
        List<Permission> list= permissionService.getPermissionByRoleId(roleId);
        return  Result.ok(list);
    }
    @Autowired
    PermissionService permissionService;
    @ApiOperation("查询所有菜单")
    @GetMapping
    public Result getPermissionList(){
       List<Permission> list = permissionService.getPermissionList();
       return null;
   }
    @ApiOperation("新增菜单")
    @PostMapping("save")
    public Result addPermission(@RequestBody Permission permission){
       permissionService.save(permission);
       return Result.ok(null);
      }
    @ApiOperation(" 更新权限")
      @PutMapping("/update")
    public Result updatePermission(@RequestBody Permission permission){
       permissionService.updateById(permission);
       return Result.ok(null);
      }

      @ApiOperation("递归删除菜单")
    @DeleteMapping("/remove/{id}")
    public Result removePermission(@PathVariable Long id){
        permissionService.removeChildById(id);
        return Result.ok(null);
      }
}
