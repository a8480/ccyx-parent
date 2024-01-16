package com.zxwcbj.ccyx.product.controller;

import com.zxwcbj.ccyx.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "岗位申请(企业)接口")
@RestController
@RequestMapping("/admin/job/jobApplication")
@CrossOrigin
public class JobApplicationController {

    @ApiOperation("岗位申请分页查询")
    @GetMapping("/{page}/{linit}")
    public Result<?> getPageList(@PathVariable Long page,
                                 @PathVariable Long linit, JobApplicationQueryVo jobApplicationQueryVo){
        return Result.ok();
    }
    @ApiOperation("申请岗位")
    @GetMapping("/save")
    public Result<?> save(){
        return Result.ok();
    }
}
