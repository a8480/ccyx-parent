package com.zxwcbj.ccyx.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.product.JobInfo;
import com.zxwcbj.ccyx.product.service.JobInfoService;
import com.zxwcbj.ccyx.vo.product.JobInfoQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * syoukan
 **/

@Api(tags = "岗位接口")
@RestController
@RequestMapping("/admin/product/jobInfo")
@CrossOrigin
public class JobInfoController {
    @Autowired
    JobInfoService jobInfoService;
    @ApiOperation("岗位分页查询")
    @GetMapping("/{page}/{linit}")
    public Result<?> getPageList(@PathVariable Long page,
                                 @PathVariable Long linit, JobInfoQueryVo jobInfoQueryVo){
        Page<?> pageParm=new Page<>(page,linit);
        IPage<JobInfo> iPage=jobInfoService.selectUserPage(jobInfoQueryVo,pageParm);
        return  Result.ok(iPage);
    }
    @ApiOperation("添加岗位")
    @PostMapping("/save")
    public Result<?> save(@RequestBody JobInfo jobInfo){
        jobInfoService.save(jobInfo);
        return Result.ok();
    }
    // DONE 你发的 `JobInfoQueryVo` 里面没有 `jobId`
/*    @ApiOperation("毁约")
    @PostMapping("/removeId")
    public  Result<?> removeId(@RequestParam Long adminId,
                               @RequestParam Long[] jobInfoId){
        Map<String,Object> map =jobInfoService.removeId(adminId,jobInfoId);
        return Result.ok(map);
    }*/

/*    @ApiOperation("更新岗位")
    @PostMapping("/updata")
    public Result<?> updateJob(@RequestBody JobInfo jobInfo){
        jobInfoService.updateById(jobInfo);
        return Result.ok(null);
    }*/
    @ApiOperation("删除单个岗位")
    @PostMapping("/remove/{id}")
    public Result<?> deleteJob(@PathVariable Long id){
        jobInfoService.removeById(id);
        return Result.ok(null);
    }
    @ApiOperation("批量删除")
    @PostMapping("/batchRemove")
    public  Result<?> batchRemove(@RequestBody List<Long> idList){
     jobInfoService.removeByIds(idList);
     return Result.ok(null);
    }
 }
