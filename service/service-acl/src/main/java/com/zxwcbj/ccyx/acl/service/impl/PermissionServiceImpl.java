package com.zxwcbj.ccyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.acl.mapper.PermissionManager;
import com.zxwcbj.ccyx.acl.service.PermissionService;
import com.zxwcbj.ccyx.acl.service.RolePermissionService;
import com.zxwcbj.ccyx.model.acl.Permission;
import com.zxwcbj.ccyx.acl.util.PermissionHelper;

import com.zxwcbj.ccyx.model.acl.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionManager, Permission> implements PermissionService {
    @Autowired
    RolePermissionService rolePermissionService;

    /**
     * 获得所有菜单和己分配的菜单
     * 根据角色id查询角色权限
     * * 1. 根据角色id获取已选择的权限对象集合
     * * 2. 获取已选择的权限列表id(List<RolePermission>->List<Long>) 和所有权限列表id (permissionList)
     * * 3. 将权限列表的数据转为map，以id为key，数据为value
     * * 4. 先取出根节点集合，（注：一个根节点就代表一棵树）
     * * 5.为每个根节点置为层级为1
     * * 6. 遍历所有权限列表
     * *  -  为该节点的子节点属性开辟空间，若要节省空间，则在确定父节点存在后，在判断父节点的子节点属性是否开辟空间…..
     * * - 6.1 尝试以pid获取父节点，并判断
     * * - 6.2 判断父节点不为空，则设置本节点层级为父节点层级+1，并将子节点放入父节点的子节点属性中
     * * - 6.3 判断当前节点的id是否属于角色选择过的id，是则将select属性设置为true
     *
     * @param roleId 角色id
     * @return java.util.List<com.zxwcbj.ccyx.model.acl.Permission>
     **/
    @Override
    public List<Permission> getPermissionByRoleId(Long roleId) {
        //1. 根据角色id获取已选择的权限id集合
        List<RolePermission> rolePermissionIdList = rolePermissionService.lambdaQuery()
                .select(RolePermission::getPermissionId)
                .eq(RolePermission::getRoleId, roleId)
                .list();
        //2. 获取所有权限列表id(List<RolePermission>->List<Long>)
        List<Long> permissionIdList = rolePermissionIdList.stream()
                .map(RolePermission::getPermissionId)
                .collect(Collectors.toList());
        //List<Permission> permissionList = new ArrayList<>();
        List<Permission> permissionList = this.list();
        //3. 将权限列表的数据转为map，以权限id为key，权限为value
        Map<Long, Permission> map = permissionList.stream()
                .collect(Collectors.toMap(Permission::getId, v -> v));
        //4. 先取出根节点集合，（注：一个根节点就代表一棵树）
        List<Permission> result = permissionList.stream()
                .filter(i -> i.getPid().equals(0L))
                .collect(Collectors.toList());
        //5.为每个根节点置为层级为1
        result.forEach(i -> i.setLevel(1));
        //进行递归，将每个子节点分配层级
        permissionList.forEach(item -> {
                    if (permissionIdList.contains(item.getId())) {
                        //已选择的权限设置为true
                        item.setSelect(true);
                    }
                    item.setChildren(new ArrayList<>());
                    Permission superNode = map.get(item.getPid());
                    if (superNode != null) {
                        int level = superNode.getLevel() + 1;
                        item.setLevel(level);
                        superNode.getChildren().add(item);
                    }
                }
        );
        return result;
    }

    //获取所有菜单
    @Override
    public List<Permission> getPermissionList() {
         //1 查询所有菜单
        List<Permission> list = baseMapper.selectList(null);
         //2 转换要求数据格式
        return PermissionHelper.buildPermissions(list);
    }

/**
 * 递归删除菜单
 *
 * @param id 菜单根id
 **/

@Override
    public void removeChildById(Long id) {
         //1 创建List集合idList，封装所有要删除菜单id
        List<Long> list = new ArrayList<>();
         //根据当前菜单id，获取当前菜单下面所有子菜单，
//如果子菜单下面还有子菜单，都要获取到
//重点：递归找当前菜单子菜单
        this.selectChildListById(id, list);
        list.add(id);
         //调用方法根据多个菜单id删除
        baseMapper.deleteBatchIds(list);
}
    //重点：递归找当前菜单下面的所有子菜单
//第一个参数是当前菜单id
//第二个参数最终封装List集合，包含所有菜单id
    private void selectChildListById(Long id, List<Long> list) {
            //根据当前菜单认d查询下面子菜单
//select*from permission where pid=2
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Permission::getPid, id);
        List<Permission> childList = baseMapper.selectList(wrapper);
         //递归查询是否还有子菜单，有继续递归查询
        childList.forEach(item -> {
             //封装菜单id到idList集合里面
            list.add(item.getId());
            //递归
            this.selectChildListById(item.getId(), list);
        });
    }
}
