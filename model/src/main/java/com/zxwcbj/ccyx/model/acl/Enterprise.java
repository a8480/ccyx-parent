package com.zxwcbj.ccyx.model.acl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "企业用户")
@TableName("enterprise")
@Data
public class Enterprise extends Admin {
    @ApiModelProperty(value = "企业号")
    @TableField("user_id")
    private Long userId;
    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;
    @ApiModelProperty(value = "所属企业")
    @TableField("company")
    private String company;

    @ApiModelProperty(value = "所属部门")
    @TableField("department")
    private String department;

}
