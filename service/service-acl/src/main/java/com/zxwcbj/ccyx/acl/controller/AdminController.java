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
import com.zxwcbj.ccyx.commom.utils.MD5;
import java.util.List;
import java.util.Map;

/**
 *
 * @author a8480
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/admin/acl/user")
@CrossOrigin
public class AdminController {
    @Autowired
    RoleService roleService;
    @Autowired
    AdminService adminService;
    /**
     *  获取所有角色，和根据用户id查询用户分配角色列表
     * @param adminId 用户id
     * @return com.zxwcbj.ccyx.common.result.Result
     **/

    @ApiOperation(value = "根据用户id获取角色数据")
@GetMapping("/toAssign/{adminId}")
    public Result<?>  getRoles(@PathVariable Long adminId){
        Map<String,Object> map=roleService.getRoleByAdminId(adminId);
    return Result.ok(map);
    }
    @ApiOperation("为用户分配角色")
    @PostMapping("/doAssign")
    public Result<?>  doAssign(@RequestParam  Long adminId,
                           @RequestParam Long[] roleId){
        roleService.saveAdminRole(adminId, roleId);
        return Result.ok(null);
    }
    @ApiOperation("分页查询")
    @GetMapping("/{page}/{linit}")
    public Result<?>  getPageList(@PathVariable Long page, @PathVariable Long linit,
                                                    AdminQueryVo adminQueryVo){
        Page<?>  pageParam = new Page<>(page,linit);
        IPage<Admin> iPage=adminService.selectUserPage(adminQueryVo,pageParam);
        return  Result.ok(iPage);

    }
    @ApiOperation("根据id查询用户`")
    @GetMapping("/get/{id}")
    public Result<?>  getById(@PathVariable Long id){
        Admin admin = adminService.getById(id);
        return Result.ok(admin);
    }
    @ApiOperation("保存用户")
    @PostMapping("/save")
    public Result<?>  save(@RequestBody Admin admin){
                String password = admin.getPassword();
        String passqordMD5 = MD5.encrypt(password);
        admin.setPassword(passqordMD5);
        adminService.save(admin);
        return  Result.ok(null);
    }
    @ApiOperation("更新用户")
    @PutMapping("/update")
    public Result<?>  update(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return Result.ok(null);
    }
    @ApiOperation("删除用户")
    @GetMapping("/remove/{id}")
    public  Result<?>  delete(@PathVariable Long id){
        adminService.removeById(id);
        return  Result.ok(null);
    }
    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public Result<?>  batchRemove(@RequestBody List<Long> list){
        adminService.removeByIds(list);
        return  Result.ok(null);
    }

}









