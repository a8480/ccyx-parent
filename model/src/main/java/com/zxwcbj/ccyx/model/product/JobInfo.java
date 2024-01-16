package com.zxwcbj.ccyx.model.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxwcbj.ccyx.model.base.BaseEntity;
import com.zxwcbj.ccyx.model.base.JobBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "CommentReplay")

@TableName("job_info")
public class JobInfo extends JobBaseEntity {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业id")
    @TableField("company_id")
    private Long companyId;
    @ApiModelProperty(value = "工作标题")
    @TableField("job_title")
    private String jobTitle;
    @ApiModelProperty(value = "任务id")
    @TableField("uuid")
    private String uuid;
    @ApiModelProperty(value = "部门")
    @TableField("department")
    private String department;
    @ApiModelProperty(value = "联系邮箱")
    @TableField("email")
    private String email;
    @ApiModelProperty(value = "联系电话")
    @TableField("phone_number")
    private String phoneNumber;
    @ApiModelProperty(value = "工作描述")
    @TableField("job_describe")
    private String jobDescribe;
    @ApiModelProperty(value = "工作要求")
    @TableField("requirement")
    private String requirement;
    @ApiModelProperty(value = "所需人数")
    @TableField("job_number")
    private Integer jobNumber;
    @ApiModelProperty(value = "薪资")
    @TableField("salary")
    private Double hourlyWage;

}
