package com.zxwcbj.ccyx.acl.util;


import com.zxwcbj.ccyx.model.acl.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据权限数据构建菜单数据
 **/
public class PermissionHelper {
  /**
     * 使用递归方法建菜单
     *
     * @return java.util.List<com.zxwcbj.ccyx.model.acl.Permission>
     **/
  public static List<Permission> buildPermissions(List<Permission> list) {
      List<Permission> permissionList=new ArrayList<>();
      for (Permission permission:list){
          if (permission.getPid()==0){
              permission.setLevel(1);
              permissionList.add(findChildren(permission,list));
          }
      }
      return permissionList;
  }
    /**
     * 递归查找子节点
     *
     * @param permission 权限对象
     * @param list 权限列表
     * @return com.zxwcbj.ccyx.model.acl.Permission
     **/
    private static Permission findChildren(Permission permission, List<Permission> list) {
                //遍历List所有菜单数据
//判断：当前节点id = pid是否一样，封装，递归往下找
        for (Permission per:list){
            if (per.getPid().longValue()==permission.getId().longValue()){
                per.setLevel(permission.getLevel()+1);
                if (per.getChildren()==null){
                    per.setChildren(new ArrayList<>());
                }
                //封装,查询下一层数据
                per.getChildren().add(findChildren(per,list));
            }
        }
      return permission;
    }
}
