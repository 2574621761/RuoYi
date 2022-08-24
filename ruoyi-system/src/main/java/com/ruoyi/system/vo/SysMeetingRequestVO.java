package com.ruoyi.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @program: RuoYi-Vue-master
 * @description:
 * @author: yqy
 * @create: 2022-05-12 14:08
 **/
@Data
@ApiModel(value = "会议请求体")
public class SysMeetingRequestVO {
    /** 会议标题 */
    @ApiModelProperty(value="会议标题")
    private String meetingTitle;

    /** 公告类型（1通知 2公告） */
    @ApiModelProperty(value="公告类型（1通知 2公告）")
    private Integer meetingType;

    /** 公告内容 */
    @ApiModelProperty(value = "公告内容")
    private String meetingContent;
    /**
     * 参会人员
     */
    @ApiModelProperty(value="参会人员")
    private String personal;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "备注")
    private String remark;
}
