package com.zxwcbj.ccyx.sys.controller;


import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.sys.Ware;
import com.zxwcbj.ccyx.sys.service.WareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/sys/ware")
@CrossOrigin
@Api(tags = "仓库接口")
public class WareController {
    @Autowired
    WareService wareService;

    @ApiOperation("查询所有仓库")
    @GetMapping("findAllList")
    public Result findAllList() {
        List<Ware> list = wareService.list();
        return Result.ok(list);
    }

}
