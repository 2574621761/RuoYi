package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * @program: RuoYi-Vue-master
 * @description: 会议
 * @author: yqy
 * @create: 2022-05-11 11:17
 **/
@Data
public class SysMeeting extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 会议ID */
    private Long meetingId;

    /** 会议标题 */
    private String meetingTitle;

    /** 公告类型（1通知 2公告） */
    private Integer meetingType;

    /** 公告内容 */
    private String meetingContent;
    /**
     * 参会人员
     */
    private String personal;
}
