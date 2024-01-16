package com.zxwcbj.ccyx.model.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxwcbj.ccyx.model.base.JobBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "JobApplocation")
@TableName("job_application")
public class JobApplocation extends JobBaseEntity {


    @ApiModelProperty(value = "企业申请人id")
    @TableField("company_id")
    private Long companyId;
    @ApiModelProperty(value = "工作标题")
    @TableField("job_title")
    private String jobTitle;
    @ApiModelProperty(value = "工作描述")
    @TableField("job_describe")
    private String jobDescribe;
    @ApiModelProperty(value = "所需人数")
    @TableField("job_number")
    private Integer jobNumber;
    @ApiModelProperty(value = "要求")
    @TableField("requirement")
    private String requirement;
    @ApiModelProperty(value = "薪资")
    @TableField("salary")
    private Double hourlyWage;
}
