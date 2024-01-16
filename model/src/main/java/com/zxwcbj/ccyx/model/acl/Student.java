package com.zxwcbj.ccyx.model.acl;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

public class Student extends Admin {
    @ApiModelProperty(value = "学生号")
    @TableField("user_id")
    private String userId;
    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;
    @ApiModelProperty(value = "所在年级")
    @TableField("grade")
    private String grade;

    @ApiModelProperty(value = "专业")
    @TableField("major")
    private String major;


}
