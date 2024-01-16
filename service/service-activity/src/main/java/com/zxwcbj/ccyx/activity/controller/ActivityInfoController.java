package com.zxwcbj.ccyx.activity.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxwcbj.ccyx.activity.service.ActivityInfoService;
import com.zxwcbj.ccyx.common.result.Result;
import com.zxwcbj.ccyx.model.activity.ActivityInfo;
import com.zxwcbj.ccyx.model.product.SkuInfo;
import com.zxwcbj.ccyx.vo.activity.ActivityRuleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-11-16
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/activity/activityInfo")
@Api(tags = "活动表 前端控制器")
public class ActivityInfoController {
    @Autowired
    private ActivityInfoService activityInfoService;
    @GetMapping("/{page}/{limit}")
    @ApiOperation("分页查询活动列表")
    public Result getPageList(@PathVariable Long page,
                              @PathVariable Long limit){
        Page< ActivityInfo> pageParam = new Page<>(page,limit);
        activityInfoService.page(pageParam,null);
        IPage<ActivityInfo> iPage=activityInfoService.selectPage(pageParam,null);
        return  Result.ok(iPage);
    }

    @ApiOperation(value = "根据id获取活动列表")
	@GetMapping("get/{id}")
	public Result get(@PathVariable Long id) {
        ActivityInfo activityInfo = activityInfoService.getById(id);
        activityInfo.setActivityTypeString(activityInfo.getActivityType().getComment());
        return Result.ok(activityInfo);
    }
    @ApiOperation("添加活动")
    @PostMapping("/save")
    public  Result save(@RequestBody ActivityInfo activityInfo){
        activityInfo.setCreateTime(new Date());
        activityInfoService.save(activityInfo);
        return Result.ok();
    }
    @ApiOperation(value = "修改活动")
	@PutMapping("update")
	public Result updateById(@RequestBody ActivityInfo activityInfo) {
			activityInfoService.updateById(activityInfo);
		return Result.ok();
	}

	@ApiOperation(value = "删除活动")
	@DeleteMapping("remove/{id}")
	public Result remove(@PathVariable Long id) {
			activityInfoService.removeById(id);
		return Result.ok();
	}

    @ApiOperation(value="根据id列表删除活动")
	@DeleteMapping("batchRemove")
	public Result batchRemove(@RequestBody List<String> idList){
        activityInfoService.removeByIds(idList);
        return Result.ok();
    }

  //  营销活动规则相关接口
//1根据活动d获取活动规则数据
    //2在活动里面添加规则数据
//3根据关键字查询匹配sku信息
    @ApiOperation(value = "获取活动规则")
	@GetMapping("findActivityRuleList/{id}")
    public Result findActivityRuleList(@PathVariable Long id) {
        Map<String,Object>activityRuleMap=activityInfoService.findActivityRuleList(id);
        return Result.ok(activityRuleMap);
    }
    @ApiOperation(value = "新增活动规则")
	@PostMapping("saveActivityRule")
	public Result saveActivityRule(@RequestBody ActivityRuleVo activityRuleVo) {
		activityInfoService.saveActivityRule(activityRuleVo);
		return Result.ok();
	}
	/**
	 * 根据关键字获取sku列表，活动使用
	 * @param keyword
	 * @return
	 */
	@GetMapping("findSkuInfoByKeyword/{keyword}")
	public Result findSkuInfoByKeyword(@PathVariable("keyword") String keyword) {
        List<SkuInfo> skuInfoList=activityInfoService.findSkuInfoByKeyword(keyword);
		return Result.ok(skuInfoList);
	}
}

