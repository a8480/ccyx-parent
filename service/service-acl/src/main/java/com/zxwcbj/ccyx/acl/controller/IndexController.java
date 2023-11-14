package com.zxwcbj.ccyx.acl.controller;

import com.zxwcbj.ccyx.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
/**
 * 登录接口
 *
 * @author a8480
 */
@RestController
@Api(tags = "登录接口")
//访问路径
@RequestMapping("/admin/acl/index")
/*
 * 允许跨域调用
 * 跨域。当访问协议IP地址端口号 与访问时不一致时
 * 游览器会报错(Ensure CORS response header values are valid) 如果不写就会出现跨域问题
 * 本质：浏览器对ajax请求一种限制
 * */
@CrossOrigin
public class IndexController {
    /**
     * 登录
     **/
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<?>  login() {
        Map<String, String> map = new HashMap<>();
        map.put("token", "token-admin");
        return Result.ok(map);
    }

    /**
     * 用户信息
     **/
    @ApiOperation("获取信息")
    @GetMapping("/info")
    public Result<?>  info() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "admin");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);
    }
    /**
     *  退出登录
     * */
    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public Result<?>  logout() {
        return Result.ok(null);
    }

}
