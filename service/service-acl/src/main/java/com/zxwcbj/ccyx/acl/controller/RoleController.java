package com.zxwcbj.ccyx.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.acl.service.RoleService;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.acl.Role;
import com.zxwcbj.ccyx.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 * @author syoukan
 **/
@RestController
@RequestMapping("/admin/acl/role")
@Api(tags = "用户管理")
@Slf4j
@CrossOrigin
public class RoleController {
    /**
     * 如果不进行依赖注入就会,报错
    * 无法从 static 上下文引用非 static 方法
    *  'selectRolePageList(com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.zxwcbj.ccyx.model.acl.Role>
    , com.zxwcbj.ccyx.vo.acl.RoleQueryVo)'
    注入service*/
    @Autowired
    RoleService roleService;
    @ApiOperation("获取角色分页列表")
    @GetMapping("{current}/{limit}")
    public Result<?>  getPageList(@PathVariable Long current,
                              @PathVariable Long limit,
                              RoleQueryVo roleQueryVo){
        //创建page对象,接收分页参数,页数和每页要多少条数据
        Page<Role> page=new Page<>(current, limit);
        IPage<Role> iPage= roleService.selectRolePageList(page,roleQueryVo);
        return Result.ok(iPage);
    }
    @ApiOperation("添加角色")
    @PostMapping("/save")
    public Result<?>  save(@RequestBody Role role){
        roleService.save(role);
        return Result.ok(null);
    }
    @ApiOperation("修改角色")
    @PutMapping ("/update")
    public Result<?>  updateById(@RequestBody Role role){
        roleService.updateById(role);
        return Result.ok(null);
    }
    @ApiOperation("根据id查询角色")
    @GetMapping("/get/{id}")
    public Result<?>  getById(@PathVariable Long id){
        Role role=roleService.getById(id);
        return Result.ok(role);
    }
    @ApiOperation("根据id删除角色")
    @DeleteMapping("/remove/{id}")
    public Result<?>  removeById(@PathVariable Long id){
        roleService.removeById(id);
        return Result.ok(null);
    }
    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public Result<?>  removeRoles(@RequestBody  List<Long> ids){
        roleService.removeByIds(ids);
        return Result.ok(null);
    }
/*    @ApiOperation("获取角色所有权限")
    @GetMapping("/toAssign/{roleId}")
    public Result getAssign(@PathVariable Long roleId){
        role
        return Result.ok(null);
    }*/

}
