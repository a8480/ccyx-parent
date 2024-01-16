package com.zxwcbj.ccyx.vo.product;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class JobApplicationQueryVo implements Serializable {
    private  static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "企业申请人id")
    @TableField("company_id")
    private Long companyId;
    @ApiModelProperty(value = "工作标题")
    @TableField("job_title")
    private String jobTitle;
    @ApiModelProperty(value = "所需人数")
    @TableField("job_number")
    private Integer jobNumber;
    @ApiModelProperty(value = "薪资")
    @TableField("salary")
    private Double hourlyWage;
    @ApiModelProperty(value = "是否通过")
    @TableField("approval_status")
    private Integer approvalStatus;
}
