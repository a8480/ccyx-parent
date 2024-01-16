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
  public static List<Permission> buildPermission(List<Permission> allList) {
        //创建最终数据封装List集合
        List<Permission> trees = new ArrayList<>();
        //遍历所有菜单list集合，得到第一层数据，pid=0
        for (Permission permission:allList) {
            //pid=0数据，第一层数据
            if(permission.getPid()==0) {
                permission.setLevel(1);
                //调用方法，从第一层开始往下找
                trees.add(findChildren(permission,allList));
            }
        }
        return trees;
    }
    /**
     * 递归查找子节点
     *
     * @param permission 权限对象
     * @param list 权限列表
     * @return com.zxwcbj.ccyx.model.acl.Permission
     **/
    private static Permission findChildren(Permission permission, List<Permission> list) {
        permission.setChildren(new ArrayList<Permission>());
                //遍历List所有菜单数据
//判断：当前节点id = pid是否一样，封装，递归往下找
        for (Permission it:list){
            if (permission.getId().longValue()==it.getPid().longValue()){
                int level=permission.getLevel()+1;
                it.setLevel(level);
                if (permission.getChildren()==null){
                    permission.setChildren(new ArrayList<>());
                }
                //封装,查询下一层数据
                permission.getChildren().add(findChildren(it,list));
            }
        }
      return permission;
    }
}
