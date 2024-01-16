package com.zxwcbj.ccyx.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 岗位查询实体
 * </p>
 *
 * @author syoukan
 */
@Data
@ApiModel(description = "岗位查询实体")
public class JobInfoQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "岗位标题")
    private String jobTitle;
    @ApiModelProperty(value = "企业申请人id")
    private Long companyId;
    // TODO 有点麻烦(涉及多张表的查询和修改有点慢),先完成基本功能
/*    @ApiModelProperty("发布者姓名")
    private String  entName;
    @ApiModelProperty("申请者姓名")
    private String  stuName;*/
}
